import axios from "axios"
import {getToken} from "../localStorage";

export default class VoteService {

    getVoteCountByElectionAndCand(eid, candId) {
        return axios.get(`http://localhost:8080/vote/get/vote_count/election_candidate?eid=${eid}&candId=${candId}`, {headers: {'Authorization': getToken()}})
    }

    getVoteCountsByElection(eid) {
        return axios.get(`http://localhost:8080/vote/get/vote_counts/election?eid=${eid}`, {headers: {'Authorization': getToken()}})
    }

    getByElectionAndVoter(eid, voterId) {
        return axios.get(`http://localhost:8080/vote/get/election_voter?eid=${eid}&voterId=${voterId}`, {headers: {'Authorization': getToken()}})
    }

    cast(values) {
        return axios.post(`http://localhost:8080/vote/cast`, values, {headers: {'Authorization': getToken()}})
    }

    delete(voteId) {
        return axios.delete(`http://localhost:8080/vote/delete?voteId=${voteId}`, {headers: {'Authorization': getToken()}})
    }

}