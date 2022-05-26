import rootReducer from "./rootReducer"
import {devToolsEnhancer} from "redux-devtools-extension";
import {loadState} from "../localStorage";
import {createStore} from "redux";

export function configureStore(options){
    const persistedState = loadState();
    return createStore(rootReducer, persistedState, devToolsEnhancer(options))
}