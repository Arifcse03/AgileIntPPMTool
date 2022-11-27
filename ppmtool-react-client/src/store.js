import {createStore,applyMiddleware,compose} from "redux"
import thunk from "redux-thunk"
import rootReducer from "./reducers"
const initalState ={};
const meddleware =[thunk];
let store;

if(window.navigator.userAgent.includes("Chrome")){
    store =createStore(rootReducer,initalState,compose(applyMiddleware(...meddleware),
    window.__REDUX_DEVTOOLS_EXTENTION__&&window.__REDUX_DEVTOOLS_EXTENTION__()));
}
else{
    store =createStore(rootReducer,initalState,compose(applyMiddleware(...meddleware))); 
}
export default store;