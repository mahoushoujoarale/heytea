import axios from '/src/request/index.js';

const mutations = {
    ADDCART(state, info) {
        let goods = state.cartList.find(item => item.info.name === info.info.name);
        if (goods) {
            goods.count += info.info.addCount;
        } else {
            info.count = info.info.addCount;
            info.checked = true;
            state.cartList.push(info);
        }
    },
    DELETECART(state) {
        state.cartList = [];
    },
    LOGIN(state, value) {
        state.token = value;
        localStorage.setItem('token', value);
        axios.get('/user/info')
        .then((res) => {
            state.user.info = res.data.data;
            state.isLogin = true;
            localStorage.setItem('info', state.user.info);
        })
        .catch((err) => {
            console.log(err);
        })
        axios.get('/address/list')
        .then((res) => {
            state.user.address = res.data.data;
            localStorage.setItem('address', state.user.address);
        })
        .catch((err) => {
            console.log(err);
        })
    },
    LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('info');
        localStorage.removeItem('address');
        state.user = {};
        state.isLogin = false;
    },
    SELECTADDRNUM(state, num) {
        state.addrNum = num;
    },
    SELECTORDERNUM(state, num) {
        state.orderNum = num;
    }
}

export default mutations