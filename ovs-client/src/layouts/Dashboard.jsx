import {Route} from "react-router-dom";
import Navbar from "./Navbar";
import Footer from "./Footer";
import {ToastContainer} from "react-toastify";
import Login from "../pages/Login";
import ElectionListPublic from "../pages/ElectionListPublic";
import ElectionDetail from "../pages/ElectionDetail";
import ElectionListAdmin from "../pages/ElectionListAdmin";
import ElectionSave from "../pages/ElectionSave";
import UserSave from "../pages/UserSave";

export default function Dashboard() {

    return (
        <div>
            <Navbar/>
            <ToastContainer position={"bottom-left"} pauseOnFocusLoss={false} closeButton={null}/>
            <div>
                <Route exact path="/" component={ElectionListPublic}/>
                <Route path="/login" component={Login}/>
                <Route path="/signup/candidate" component={() => <UserSave role={"ROLE_CANDIDATE"}/>}/>
                <Route path="/signup/voter" component={() => <UserSave role={"ROLE_VOTER"}/>}/>
                <Route path="/signup/admin" component={() => <UserSave role={"ROLE_ADMIN"}/>}/>
                <Route path="/account" component={() => <UserSave/>}/>
                <Route path="/election/list/public" component={ElectionListPublic}/>
                <Route path="/election/list/admin" component={ElectionListAdmin}/>
                <Route path="/election/detail/:eid" component={ElectionDetail}/>
                <Route path="/election/save/:eid" component={ElectionSave}/>
            </div>
            <Footer/>
        </div>
    )
}

