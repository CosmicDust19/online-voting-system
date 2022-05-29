import {toast} from "react-toastify";
import {syncUser} from "../store/actions/userActions";
import {useFormik} from "formik";
import {useDispatch} from "react-redux";
import UserService from "../services/userService";
import {setToken} from "../localStorage";
import {useHistory} from "react-router-dom";

export default function Login() {

    const userService = new UserService();

    const dispatch = useDispatch();
    const history = useHistory();

    const formik = useFormik({
        initialValues: {
            email: "", password: ""
        },
        onSubmit: (values) => {
            userService.login(values.email, values.password)
                .then(result => {
                    setToken(result.data.message)
                    dispatch(syncUser(result.data.data))
                    history.push("/")
                    toast(`Welcome ${result.data.data.fname}`, {autoClose: 2500})
                }).catch(() => toast.error("Please check your email & password."))
        }
    });

    return (
        <div className={"s-form"}>
            <form onSubmit={formik.handleSubmit} className={"container-glass rounded"}>
                <h3>Login Here</h3>
                <label htmlFor="email">Email</label>
                <input id="email" type="text" name={"email"} onChange={formik.handleChange}
                       value={formik.values.email} placeholder="Email" required/>
                <label htmlFor="password">Password</label>
                <input id="password" type="password" name={"password"} onChange={formik.handleChange}
                       value={formik.values.password} placeholder="Password" required/>
                <button type={"submit"}>Log In</button>
            </form>
            <div style={{height: 684}} className="background">
                <div className="shape"/>
                <div className="shape"/>
            </div>
        </div>
    )
}

