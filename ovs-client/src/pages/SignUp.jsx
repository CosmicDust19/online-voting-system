import UserService from "../services/userService";
import {useDispatch} from "react-redux";
import {useHistory} from "react-router-dom";
import {useEffect, useState} from "react";
import {useFormik} from "formik";
import {setToken} from "../localStorage";
import {login} from "../store/actions/userActions";
import {toast} from "react-toastify";
import {handleCatch} from "../utilities/Utils";

export default function SignUp({signupService, userType}) {

    const userService = new UserService();

    const dispatch = useDispatch();
    const history = useHistory();
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        return () => {
            setLoading(undefined)
        };
    }, []);

    const initialValues = {
        email: "", password: "", firstName: "", lastName: "", middleName: "", address: "", nationalityId: "",
        birthDate: new Date().toISOString().split('T')[0]
    }

    const onSubmit = (values) => {
        setLoading(true)
        signupService.signup({...values, middleName: values.middleName.trim() === "" ? undefined : values.middleName})
            .then(() => {
                userService.login(values.email, values.password).then(result => {
                    setToken(result.data.message)
                    dispatch(login(result.data.data))
                    history.push("/")
                    toast(`Welcome ${result.data.data.fname}`, {autoClose: 2500})
                })
            }).catch(handleCatch).finally(() => {
            setLoading(false)
        })
    }

    const formik = useFormik({
        initialValues: initialValues,
        onSubmit: onSubmit
    });

    return (
        <div className={"container-flex"}>
            <div className={"w-250 text-center"}>
                <h2>Sign Up</h2>
                <h6>{userType}</h6>
                <form onSubmit={formik.handleSubmit} className={"text-left"}>
                    <label htmlFor="email">Email</label>
                    <input id="email" type="text" name={"email"} onChange={formik.handleChange}
                           value={formik.values.email} placeholder="Your Your Email.."/>
                    <label htmlFor="password">Password</label>
                    <input id="password" type="password" name={"password"} onChange={formik.handleChange}
                           value={formik.values.password} placeholder="Your Your Password.."/>
                    <label htmlFor="firstName">First Name</label>
                    <input id="firstName" type="text" name={"firstName"} onChange={formik.handleChange}
                           value={formik.values.firstName} placeholder="Your First Name.."/>
                    <label htmlFor="middleName">Middle Name</label>
                    <input id="middleName" type="text" name={"middleName"} onChange={formik.handleChange}
                           value={formik.values.middleName} placeholder="Your Middle Name.."/>
                    <label htmlFor="lastName">Last Name</label>
                    <input id="lastName" type="text" name={"lastName"} onChange={formik.handleChange}
                           value={formik.values.lastName} placeholder="Your Last Name.."/>
                    <label htmlFor="lastName">Birth Date</label><br/>
                    <input id="birthDate" type="date" name={"birthDate"} onChange={formik.handleChange}
                           value={formik.values.birthDate} placeholder="Your Birth Date.."/>
                    {userType === "Candidate" ?
                        <div>
                            <label htmlFor="address">Address</label>
                            <input id="address" type="text" name={"address"} onChange={formik.handleChange}
                                   value={formik.values.address} placeholder="Your Address.."/>
                            <label htmlFor="nationalityId">SSN</label>
                            <input id="nationalityId" type="text" name={"nationalityId"} onChange={formik.handleChange}
                                   value={formik.values.nationalityId} placeholder="Your SSN.."/>
                        </div> : null}
                    <input type="submit" value={`Submit${loading ? " ⏳" : ""}`}/>
                </form>
            </div>
        </div>
    )

}