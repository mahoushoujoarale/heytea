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
    isLogin: false,
    addrNum: -1,
}

axios.get('./store/list')
.then((res) => {
    state.place = res.data.data.store;
    // console.log(res.data);
})
.catch((err) => {
    console.log(err);
})

const store = createStore({
    state,
    getters,
    mutations,
    actions
})

export default store;