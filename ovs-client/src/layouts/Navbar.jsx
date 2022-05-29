import React from "react";
import {Link} from "react-router-dom";
import logo from "../assets/images/ovs_logo.svg";
import {useDispatch, useSelector} from "react-redux";
import {signOut} from "../store/actions/userActions";
import {removeToken} from "../localStorage";
import {toast} from "react-toastify";
import {isAdmin, isLoggedIn} from "../utilities/Utils";
import FancyText from "../components/FancyText";

export default function Navbar() {

    const dispatch = useDispatch();

    const user = useSelector(state => state?.user.userProps.user);

    const handleLogOutClick = () => {
        dispatch(signOut());
        removeToken();
        toast.info("Logged Out");
    }

    return (
        <nav>
            <ul>

                <li><img className={"ovs-logo"} width={33} src={logo} alt={"OVS"}/></li>
                <li><Link to={"/"} className={"fill-color-container"}>
                    <FancyText color={"purple"} content={"Home"}/></Link></li>

                {/* Admin */}
                {isAdmin(user) ?
                    <li><Link to={"/election/list/admin"} className={"fill-color-container"}>
                        <FancyText color={"yellow"} content={"Manage Elections"}/>
                    </Link></li> : null}
                {isAdmin(user) ?
                    <li><Link to={"/election/save/0"} className={"fill-color-container"}>
                        <FancyText color={"green"} content={"Create Election"}/>
                    </Link></li> : null}
                {isAdmin(user) ?
                    <li><Link to={"/signup/admin"} className={"fill-color-container"}>
                        <FancyText color={"orange"} content={"Create Admin"}/>
                    </Link></li> : null}

                {/* Logged Out */}
                {!isLoggedIn() ?
                    <li className="dropdown">
                        <span className={"dropbtn fill-color-container"}>
                            <FancyText color={"yellow"} content={"Sign Up"}/>
                        </span>
                        <div className="dropdown-content">
                            <Link to={"/signup/voter"} className={"fill-color-container"}>
                                <FancyText color={"green"} content={"Voter"}/>
                            </Link>
                            <Link to={"/signup/candidate"} className={"fill-color-container"}>
                                <FancyText color={"red"} content={"Candidate"}/>
                            </Link>
                        </div>
                    </li> : null}
                {!isLoggedIn() ?
                    <li><Link to={"/login"} className={"fill-color-container"}>
                        <FancyText color={"blue"} content={"Login"}/></Link></li> : null}

                {/* Logged In */}
                {isLoggedIn() ?
                    <li><Link to={"/account"} className={"fill-color-container"}>
                        <FancyText color={"blue"} content={"Account"}/></Link></li> : null}
                {isLoggedIn() ?
                    <li>
                        <span onClick={handleLogOutClick}><Link to={"/"} className={"fill-color-container"}>
                            <FancyText color={"red"} content={"Logout"}/></Link></span>
                    </li> : null}

            </ul>
        </nav>
    )

}
