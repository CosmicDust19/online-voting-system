import ElectionService from "../services/electionService";
import {Link, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {useSelector} from "react-redux";
import placeholder from "../assets/images/election-placeholder.png";
import {getByFieldName, handleCatch, isCandidate, isVoter} from "../utilities/Utils";
import UserPlaceHolder from "../assets/images/user-placeholder.png"
import {toast} from "react-toastify";
import VoteService from "../services/voteService";

export default function ElectionDetail() {

    const electionService = new ElectionService();
    const voteService = new VoteService();

    let {eid} = useParams();
    eid = parseInt(eid);
    const [voted, setVoted] = useState({});
    const [election, setElection] = useState({});
    const [voteCounts, setVoteCounts] = useState([]);
    const user = useSelector(state => state?.user.userProps.user);

    useEffect(() => {
        const electionService = new ElectionService();
        const voteService = new VoteService();
        electionService.getById(eid).then((result) => setElection(result.data.data));
        voteService.getVoteCountsByElection(eid).then(result => setVoteCounts(result.data.data))
        if (isVoter(user))
            voteService.getByElectionAndVoter(eid, user.uid).then(result => setVoted(result.data.data ? result.data.data : {}));
    }, [eid, user])

    const attended = () => {
        if (!isCandidate(user)) return false;
        return election.attenders?.find(attender => attender.uid === user.uid) !== undefined
    }

    const handleAddAttender = () => {
        electionService.addAttender(election.eid, user.uid)
            .then(result => {
                setElection(result.data.data)
                toast("Attended")
            }).catch(handleCatch)
    }

    const handleRemoveAttender = () => {
        electionService.removeAttender(election.eid, user.uid)
            .then(result => {
                setElection(result.data.data)
                toast("Resigned")
            }).catch(handleCatch)
    }

    const vote = (candId) => {
        console.log(voted.voteId)
        if (voted.voteId) return;
        voteService.cast({candidateId: candId, electionId: election.eid, voterId: user.uid})
            .then((result => {
                setVoted(result.data.data)
                setVoteCounts(Object.assign(voteCounts, {[candId] : getByFieldName(voteCounts, candId) + 1}))
                toast.info("Voted")
            })).catch(handleCatch)
    }

    const takeBack = () => {
        voteService.delete(voted.voteId)
            .then((() => {
                setVoted({})
                setVoteCounts(Object.assign(voteCounts, {[voted.candidate.uid] : getByFieldName(voteCounts, voted.candidate.uid) - 1}))
                toast.error("Taken Back")
            })).catch(handleCatch)
    }

    return (
        <div className={"container-flex"}>
            <div className={"segment p-sm-30px rounded"}>
                <div className={"navigator"} >
                    <Link to={`/election/detail/${eid - 1}`} className={"forward"}/>
                    <Link to={`/election/detail/${eid + 1}`} className={"backward"}/>
                </div>
                <div className={"row"}>
                    <div className="election-card card container-glass rounded col-3 election-detail-fixed-card" >
                        <div className="election-tumb">
                            <img src={placeholder} alt="Placeholder"/>
                        </div>
                        <div className="eleciton-details">
                            <span className="election-creator">By {election.creator?.email}</span>
                            <h4>{election.title}</h4>
                            <p>Created at {election.creationDate?.replaceAll("-", "/")}</p>
                            <div className="election-bottom-details">
                                <div>{`Start: ${election.start?.replaceAll("-", "/")}`}</div><br/>
                                <div>{`End: ${election.end?.replaceAll("-", "/")}`}</div>
                                {isCandidate(user) ? !attended() ?
                                    <button className={"rounded create"} onClick={handleAddAttender} style={{marginTop: 30}}>Attend</button> :
                                    <button className={"rounded danger"} onClick={handleRemoveAttender} style={{marginTop: 30}}>Resign</button> : null}
                            </div>
                        </div>
                    </div>
                    <div className={"col-8"} style={{float: "right"}}>
                        <h2 style={{marginLeft: 20}}>Attenders ({election.attenders?.length})</h2>
                        {election.attenders && election.attenders.length !== 0 ? election.attenders.map(attender => (
                            <div className={"card profile-card"} key={attender.uid}>
                                <img src={UserPlaceHolder} alt={"Placeholder"} className={"container-fluid"}/>
                                <h2>{`${attender.fname}${attender.mname ? ` ${attender.mname}` : ""} ${attender.lname}`}</h2>
                                <p className="title">{attender.intro}</p>
                                <p>{attender.email}</p>
                                <p>Voted {getByFieldName(voteCounts, attender.uid)} time(s)</p>
                                <p>{isVoter(user) ? attender.uid !== voted.candidate?.uid ?
                                    <button className={"primary rounded"} onClick={() => vote(attender.uid)}>Vote</button> :
                                    <button className={"danger rounded"} onClick={takeBack}>Take Back</button> : null}
                                </p>
                            </div>
                        )) : <h2>There is no attender in this election</h2>}
                    </div>
                </div>
            </div>
        </div>
    )

}