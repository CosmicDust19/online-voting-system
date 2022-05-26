import React from "react";
import {Link} from "react-router-dom";
import logo from "../assets/images/ovs_logo.svg";

export default function Navbar() {
    return (
        <nav>
            <ul>
                <li><img className={"ovs-logo"} width={33} src={logo} alt={"OVS"}/></li>
                <li><Link to={"/elections"}>Home</Link></li>
                <li><Link to={"/elections"}>Elections</Link></li>
                <li><Link to={"/login"}>Login</Link></li>
                <li className="dropdown">
                    <span className={"dropbtn"}>Sign Up</span>
                    <div className="dropdown-content">
                        <Link to={"/signup/voter"}>Voter</Link>
                        <Link to={"/signup/candidate"}>Candidate</Link>
                        <Link to={"/signup/admin"}>Admin</Link>
                    </div>
                </li>
            </ul>
        </nav>
    )

}
