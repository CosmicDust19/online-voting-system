import {userProps} from "../initialStates/userProps";
import {LOGIN, SIGN_OUT, SYNC_USER} from "../actions/userActions";

const initialState = {
    userProps: userProps
}

export default function userReducer(state = initialState, {type, payload}) {

    switch (type) {
        case LOGIN:
            return {
                ...state,
                userProps: {
                    ...state.userProps,
                    user: {...payload}
                }
            }
        case SIGN_OUT:
            return {
                ...state,
                userProps: {
                    ...state.userProps,
                    user: null
                }
            }
        case SYNC_USER:
            return {
                ...state,
                userProps: {
                    ...state.userProps,
                    user: {...payload}
                }
            }
        default:
            return state
    }
}