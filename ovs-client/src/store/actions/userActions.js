export const LOGIN = "LOGIN"
export const SIGN_OUT = "SIGN_OUT"
export const SYNC_USER = "SYNC_USER"

export function login(user) {
    return {
        type: LOGIN,
        payload: user
    }
}

export function signOut() {
    return {
        type: SIGN_OUT
    }
}

export function syncUser(user, synced) {
    return {
        type: SYNC_USER,
        payload: {user, synced}
    }
}
