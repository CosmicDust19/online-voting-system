import axios from "axios"
import {getToken} from "../localStorage";

export default class VoterService {

    signup(values) {
        return axios.post(`http://localhost:8080/voter/create`, values)
    }

    update(values) {
        return axios.put(`http://localhost:8080/voter/update`, values, {headers: {'Authorization': getToken()}})
    }

}