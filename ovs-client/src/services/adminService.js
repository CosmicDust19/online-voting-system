import axios from "axios"
import {getToken} from "../localStorage";

export default class AdminService {

    getResponsibilities(adminId) {
        return axios.get(`http://localhost:8080/election/get/admin-responsibilities?adminId=${adminId}`)
    }

    signup(values) {
        return axios.post(`http://localhost:8080/admin/create`, values)
    }

    update(values) {
        return axios.put(`http://localhost:8080/admin/update`, values, {headers: {'Authorization': getToken()}})
    }

}