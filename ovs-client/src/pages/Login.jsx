import {toast} from "react-toastify";
import {login} from "../store/actions/userActions";
import * as Yup from "yup";
import {useFormik} from "formik";
import {useHistory} from "react-router-dom";
import {useDispatch} from "react-redux";
import UserService from "../services/userService";
import {useEffect, useState} from "react";
import {setToken} from "../localStorage";
import {handleCatch} from "../utilities/Utils";

export default function Login() {

    const userService = new UserService();

    const dispatch = useDispatch();
    const history = useHistory();
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        return () => {
            setLoading(undefined)
        };
    }, []);

    const formik = useFormik({
        initialValues: {
            email: "", password: ""
        },
        validationSchema: Yup.object().shape({
            email: Yup.string().required("Required"),
            password: Yup.string().required("Required")
        }),
        onSubmit: (values) => {
            setLoading(true)
            userService.login(values.email, values.password)
                .then(result => {
                    setToken(result.data.message)
                    dispatch(login(result.data.data))
                    /*history.push("/")*/
                    toast(`Welcome ${result.data.data.fname}`, {autoClose: 2500})
                }).catch(handleCatch).finally(() => {
                setLoading(false)
            })
        }
    });

    return (
        <div className={"container-flex"}>
            <div className={"w-250 text-center"}>
                <h2>Login</h2>
                <form onSubmit={formik.handleSubmit} className={"text-left"}>
                    <label htmlFor="email">Email</label>
                    <input id="email" type="text" name={"email"} onChange={formik.handleChange}
                           value={formik.values.email} placeholder="Your Email.."/>
                    <label htmlFor="password">Password</label>
                    <input id="password" type="password" name={"password"} onChange={formik.handleChange}
                           value={formik.values.password} placeholder="Your password.."/>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
        </div>
    )
}

