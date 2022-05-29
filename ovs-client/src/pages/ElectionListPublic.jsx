import ElectionService from "../services/electionService";
import {useEffect, useState} from "react";
import placeholder from "../assets/images/election-placeholder.png"
import {Link} from "react-router-dom";

export default function ElectionListPublic () {

    const [elections, setElections] = useState();

    useEffect(() => {
        const electionService = new ElectionService();
        electionService.getAll().then((result) => setElections(result.data.data));
    }, []);

    if (!elections || elections.length === 0) return <h2 style={{textAlign: "center"}}>There is no election to show :(</h2>

    return (
        <div className={"p-sm-30px"}>
            <div className={"container-fluid"}>
                {elections.map((election) => (
                    <div className="election-card card container-glass rounded" key={election.eid}>
                        <div className="election-tumb">
                            <img src={placeholder} alt="Placeholder"/>
                        </div>
                        <div className="eleciton-details">
                            <span className="election-creator">By {election.creator?.email}</span>
                            <h4>{election.title}</h4>
                            <p>Created at {election.creationDate.replaceAll("-", "/")}</p>
                            <div className="election-bottom-details">
                                <Link to={`/election/detail/${election.eid}`}><button>See</button></Link>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    )

}