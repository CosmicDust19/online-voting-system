import {useEffect, useState} from "react";
import placeholder from "../assets/images/election-placeholder.png"
import {Link} from "react-router-dom";
import AdminService from "../services/adminService";
import {useSelector} from "react-redux";
import {isAdmin} from "../utilities/Utils";

export default function ElectionListAdmin () {

    const [elections, setElections] = useState([]);
    const user = useSelector(state => state?.user.userProps.user);

    useEffect(() => {
        if (!isAdmin(user)) return;
        const adminService = new AdminService();
        adminService.getResponsibilities(user.uid).then((result) => setElections(result.data.data));
    }, [user]);

    if (!isAdmin(user))
        return <h2>Unauthorized</h2>

    if (!elections || elections.length === 0) return <h2 style={{textAlign: "center"}}>You Have No Responsibilities Yet !</h2>

    return (
        <div className={"p-sm-30px"}>
            <div className={"container-fluid"}>
                <h2 style={{margin: 20}}>The Elections That You Are Executive Of</h2>
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
                                <Link to={`/election/save/${election.eid}`}><button>Update</button></Link>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    )

}