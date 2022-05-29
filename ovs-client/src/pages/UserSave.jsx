import UserService from "../services/userService";
import {useDispatch, useSelector} from "react-redux";
import {useHistory} from "react-router-dom";
import {useFormik} from "formik";
import {setToken} from "../localStorage";
import {syncUser} from "../store/actions/userActions";
import {toast} from "react-toastify";
import {getUserServiceByRole, handleCatch, isLoggedIn} from "../utilities/Utils";
export default function UserSave({role}) {

    const userService = new UserService();

    const dispatch = useDispatch();
    const history = useHistory();
    const user = useSelector(state => state?.user.userProps.user);
    role = user ? user.authorities[0].name : role;

    const userValues = !user ? null : {
        uid: user.uid,
        email: user.email,
        password: "",
        firstName: user.fname,
        lastName: user.lname,
        middleName: user.mname ? user.mname : "",
        birthDate: user.birthDate
    }

    const initialValues = {
        email: "", password: "", firstName: "", lastName: "", middleName: "", address: "", nationalityId: "",
        birthDate: new Date().toISOString().split('T')[0]
    }

    const onSignUp = (values) => {
        values = {...values, middleName: values.middleName.trim() === "" ? undefined : values.middleName}
        getUserServiceByRole(role).signup(values)
            .then(() => {
                userService.login(values.email, values.password).then(result => {
                    setToken(result.data.message)
                    dispatch(syncUser(result.data.data))
                    history.push("/")
                    toast(`Welcome ${result.data.data.fname}`, {autoClose: 2500})
                })
            }).catch(handleCatch)
    }

    const onUpdate = (values) => {
        values = {...values, middleName: values.middleName.trim() === "" ? undefined : values.middleName}
        getUserServiceByRole(role).update(values).then(result => {
            dispatch(syncUser(result.data.data))
            toast("Updated")
        }).catch(handleCatch)
    }

    const formik = useFormik({
        initialValues: user ? userValues : initialValues,
        onSubmit: user ? onUpdate : onSignUp,
        enableReinitialize: true
    });

    return (
        <div className={"s-form"}>
            <form onSubmit={formik.handleSubmit} className={"container-glass rounded"}>
                <h3>{user ? "Account" : "Sign Up"}</h3>
                <label htmlFor="email">Email</label>
                <input id="email" type="email" name={"email"} onChange={formik.handleChange}
                       value={formik.values.email} placeholder="Email" required/>
                <label htmlFor="password">Password</label>
                <input id="password" type="password" name={"password"} onChange={formik.handleChange}
                       value={formik.values.password} placeholder="Password" required/>
                <label htmlFor="firstName">First Name</label>
                <input id="firstName" type="text" name={"firstName"} onChange={formik.handleChange}
                       value={formik.values.firstName} placeholder="First Name" required/>
                <label htmlFor="middleName">Middle Name</label>
                <input id="middleName" type="text" name={"middleName"} onChange={formik.handleChange}
                       value={formik.values.middleName} placeholder="Middle Name"/>
                <label htmlFor="lastName">Last Name</label>
                <input id="lastName" type="text" name={"lastName"} onChange={formik.handleChange}
                       value={formik.values.lastName} placeholder="Last Name" required/>
                <label htmlFor="lastName">Birth Date</label>
                <input id="birthDate" type="date" name={"birthDate"} onChange={formik.handleChange}
                       value={formik.values.birthDate} placeholder="Birth Date"/>
                {role === "ROLE_CANDIDATE" && !user ?
                    <div>
                        <label htmlFor="address">Address</label>
                        <input id="address" type="text" name={"address"} onChange={formik.handleChange}
                               value={formik.values.address} placeholder="Location" required/>
                        <label htmlFor="nationalityId">Nationality ID</label>
                        <input id="nationalityId" type="number" name={"nationalityId"} onChange={formik.handleChange}
                               value={formik.values.nationalityId} placeholder="Nationality ID" required/>
                    </div> : null}
                <button type="submit">{user ? "Save Changes" : "Sign Up"}</button>
            </form>
            <div style={{height: role === "ROLE_CANDIDATE" ? isLoggedIn() ? 1123 : 1323 : 1110}} className="background">
                <div className="shape"/>
                <div className="shape"/>
            </div>
        </div>
    )

}