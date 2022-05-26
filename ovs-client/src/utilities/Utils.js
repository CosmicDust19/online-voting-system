import {toast} from "react-toastify";

export const handleCatch = (error) => {
    const resp = error.response
    console.log(error)
    console.log(resp)
    if (!resp || !resp.data) {
        toast.error("Something went wrong 🙁")
        return false;
    }
    if (resp.data.data) {
        Object.entries(resp.data.data).forEach((prop) => toast.warning(String(prop[1].message)))
        return true;
    }
    if (resp.data.message) {
        toast.warning(resp.data.message)
        return true;
    }
    return false;
}
