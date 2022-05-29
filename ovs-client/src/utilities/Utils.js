import {toast} from "react-toastify";
import {getToken} from "../localStorage";
import AdminService from "../services/adminService";
import CandidateService from "../services/candidateService";
import VoterService from "../services/voterService";

export const handleCatch = (error) => {
    const resp = error.response
    /*console.log(error)
    console.log(resp)*/
    if (!resp || !resp.data) {
        toast.error("Something went wrong 🙁")
        return false;
    }
    if (resp.data.data) {
        Object.entries(resp.data.data).forEach((prop) => toast.warning(String(prop[1].message)))
        return true;
    }
    if (resp.data.message) {
        toast.warning(resp.data.message)
        return true;
    }
    return false;
}

export const changePropInList = (propId, newProp, propList) => {
    const index = propList.findIndex(prop => prop.id === propId)
    propList[index] = newProp
    return propList
}

export const getByFieldName = (object, fieldName) => {
    if (!fieldName) return object
    return Object.values(object)[Object.keys(object).indexOf(String(fieldName))]
}

export const timestampToDateTimeLocal = (timestamp) => {
    return timestamp?.replace(" ", "T").substring(0, timestamp.length - 3);
}

export const isAdmin = (user) => user && user.authorities?.find(auth => auth.name === "ROLE_ADMIN") !== undefined;
export const isCandidate = (user) => user && user.authorities?.find(auth => auth.name === "ROLE_CANDIDATE") !== undefined;
export const isVoter = (user) => user && user.authorities?.find(auth => auth.name === "ROLE_VOTER") !== undefined;
export const isLoggedIn = () => getToken() !== null;

export const getUserServiceByRole = (role) => {
    if (role === "ROLE_ADMIN") return new AdminService();
    if (role === "ROLE_CANDIDATE") return new CandidateService();
    if (role === "ROLE_VOTER") return new VoterService();
    return undefined;
}
