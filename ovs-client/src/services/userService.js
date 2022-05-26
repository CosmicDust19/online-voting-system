import axios from "axios"

export default class UserService {

    login(email, password) {
        return axios.post(`http://localhost:8080/login`, {username: email, password: password})
    }

}