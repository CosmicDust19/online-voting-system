import axios from "axios"

export default class CandidateService {

    signup(values) {
        return axios.post(`http://localhost:8080/candidate/create`, values)
    }

}