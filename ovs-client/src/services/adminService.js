import axios from "axios"

export default class AdminService {

    signup(values) {
        return axios.post(`http://localhost:8080/admin/create`, values)
    }

}