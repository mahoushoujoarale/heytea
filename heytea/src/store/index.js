import {createStore} from 'vuex'
import getters from './getters'
import mutations from './mutations'
import actions from './actions'
import axios from '/src/request/index.js'

const state = {
    cartList: [],
    user: {},
    place: [],
    token: localStorage.getItem('token') ? localStorage.getItem('token') : '',
    isLogin: localStorage.getItem('token') ? true : false,
    addrNum: 0,
    orderNum: 0,
}

state.user.info = state.isLogin ? localStorage.getItem('info') : {};
state.user.address = state.isLogin ? localStorage.getItem('address') : {};
setTimeout(() => {
    axios.get('./store/list')
    .then((res) => {
        state.place = res.data.data.store;
        // console.log(res.data);
    })
    .catch((err) => {
        console.log(err);
    })
}, 1000);

const store = createStore({
    state,
    getters,
    mutations,
    actions
})

export default store;