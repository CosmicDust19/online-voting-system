import {toast} from "react-toastify";
import {useFormik} from "formik";
import {useSelector} from "react-redux";
import {useEffect, useState} from "react";
import {handleCatch, isAdmin, timestampToDateTimeLocal} from "../utilities/Utils";
import {useHistory, useParams} from "react-router-dom";
import ElectionService from "../services/electionService";

export default function ElectionSave() {

    const electionService = new ElectionService();

    let {eid} = useParams();
    eid = parseInt(eid);
    const history = useHistory();
    const [election, setElection] = useState({});
    const user = useSelector(state => state?.user.userProps.user);

    useEffect(() => {
        if (isAdmin(user) && !!eid && eid !== 0) {
            const electionService = new ElectionService();
            electionService.getById(eid).then((result) => setElection(result.data.data));
        }
    }, [eid, user])

    const electionValues = {
        creatorAdminId: user?.uid, eid: election.eid,
        endDate: timestampToDateTimeLocal(election.end),
        startDate: timestampToDateTimeLocal(election.start),
        title: election.title
    }

    const emptyValues = {
        creatorAdminId: user?.uid, eid: undefined,
        endDate: "",
        startDate: "",
        title: ""
    }

    const handleDelete = () => {
        electionService.delete(election.eid)
        .then(() => {
            history.push("/election/list/admin")
            toast("Deleted")
        }).catch(handleCatch)
    }

    const onSubmit = (values) => {
        (!election.eid ? electionService.create(values) :
            electionService.update(values))
            .then(() => {
                history.push("/election/list/admin")
                toast("Updated")
            }).catch(handleCatch)
    }

    const formik = useFormik({
        initialValues: election.eid ? electionValues : emptyValues,
        onSubmit: onSubmit,
        enableReinitialize: true
    });

    useEffect(() => {
        if (!eid || eid === 0) {
            setElection({})
        }
    }, [eid])

    if (!isAdmin)
        return <h2>Unauthorized</h2>

    return (
        <div className={"s-form"}>
            <form onSubmit={formik.handleSubmit} className={"container-glass rounded"}>
                <h3>{!election.eid ? "Create" : "Update"} Election</h3>
                <label htmlFor="title">Title</label>
                <input id="title" type="text" name={"title"} onChange={formik.handleChange}
                       value={formik.values.title} placeholder="Title.."/>
                <label htmlFor="startDate">Start Date</label>
                <input id="startDate" type="datetime-local" name={"startDate"} onChange={formik.handleChange}
                       value={formik.values.startDate} placeholder="Start Date.."/>
                <label htmlFor="endDate">End Date</label>
                <input id="endDate" type="datetime-local" name={"endDate"} onChange={formik.handleChange}
                       value={formik.values.endDate} placeholder="End Date.."/>
                <button type={"submit"}>{election.eid ? "Save Changes" : "Create"}</button>
                {election.eid ? <button type={"button"} className={"danger"} onClick={handleDelete}>Delete</button> : null}
            </form>
            <div style={{height: election.eid ? 900 : 800}} className="background">
                <div className="shape"/>
                <div className="shape"/>
            </div>
        </div>
    )
}
