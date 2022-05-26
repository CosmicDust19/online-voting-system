import axios from "axios"

export default class VoterService {

    signup(values) {
        return axios.post(`http://localhost:8080/voter/create`, values)
    }

}