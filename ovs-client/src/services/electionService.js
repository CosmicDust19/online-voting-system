import axios from "axios"
import {getToken} from "../localStorage";

export default class ElectionService {

    getAll() {
        return axios.get(`http://localhost:8080/election/get/all`)
    }

    getById(eid) {
        return axios.get(`http://localhost:8080/election/get/id?eid=${eid}`, {headers: {'Authorization': getToken()}})
    }

    create(values) {
        return axios.post(`http://localhost:8080/election/create`, values, {headers: {'Authorization': getToken()}})
    }

    update(values) {
        return axios.put(`http://localhost:8080/election/update`, values, {headers: {'Authorization': getToken()}})
    }

    addAttender(eid, candId) {
        return axios.patch(`http://localhost:8080/election/patch/attender/add?candId=${candId}&eid=${eid}`, undefined, {headers: {'Authorization': getToken()}})
    }

    removeAttender(eid, candId) {
        return axios.patch(`http://localhost:8080/election/patch/attender/remove?candId=${candId}&eid=${eid}`, undefined,{headers: {'Authorization': getToken()}})
    }

    delete(eid) {
        return axios.delete(`http://localhost:8080/election/delete?eid=${eid}`, {headers: {'Authorization': getToken()}})
    }

}