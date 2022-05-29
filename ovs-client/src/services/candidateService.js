import axios from "axios"
import {getToken} from "../localStorage";

export default class CandidateService {

    signup(values) {
        return axios.post(`http://localhost:8080/candidate/create`, values)
    }

    update(values) {
        return axios.put(`http://localhost:8080/candidate/update`, values, {headers: {'Authorization': getToken()}})
    }

}