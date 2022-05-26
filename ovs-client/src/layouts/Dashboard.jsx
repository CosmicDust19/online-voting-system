import {Route} from "react-router-dom";
import Navbar from "./Navbar";
import Footer from "./Footer";
import {ToastContainer} from "react-toastify";
import Login from "../pages/Login";
import Elections from "../pages/Elections";
import ElectionDetail from "../pages/ElectionDetail";
import ElectionManagement from "../pages/ElectionManagament";
import "./layout.css";
import CandidateService from "../services/candidateService";
import SignUp from "../pages/SignUp";
import AdminService from "../services/adminService";
import VoterService from "../services/voterService";

export default function Dashboard() {
    return (
        <div>
            <Navbar/>
            <ToastContainer position={"bottom-left"} pauseOnFocusLoss={false} style={{width: "24em"}}
                            closeButton={null}/>
            <div className={"p-20"}>
                <Route exact path="/" component={Login}/>
                <Route path="/login" component={Login}/>
                <Route path="/signup/candidate"
                       component={() => <SignUp signupService={new CandidateService()} userType={"Candidate"}/>}/>
                <Route path="/signup/voter"
                       component={() => <SignUp signupService={new VoterService()} userType={"Voter"}/>}/>
                <Route path="/signup/admin"
                       component={() => <SignUp signupService={new AdminService()} userType={"Admin"}/>}/>
                <Route path="/elections" component={Elections}/>
                <Route path="/election-detail" component={ElectionDetail}/>
                <Route path="/election-management" component={ElectionManagement}/>
            </div>
            <Footer/>
        </div>
    )
}

