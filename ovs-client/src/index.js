import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import {configureStore} from "./store/configureStore";
import {saveState} from "./localStorage";
import {throttle} from "lodash";
import {Provider} from "react-redux";
import {BrowserRouter} from "react-router-dom";
import App from "./App";
import "./App.css"
import "react-toastify/dist/ReactToastify.min.css"

const store = configureStore();

store.subscribe(throttle(() => {
    saveState({
        user: store.getState().user
    });
}, 1000))

ReactDOM.createRoot(document.getElementById("root")).render(
    <Provider store={store}>
        <BrowserRouter>
            <App/>
        </BrowserRouter>
    </Provider>
);

reportWebVitals();
