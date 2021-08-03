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
        })
        .catch((err) => {
            console.log(err);
        })
        axios.get('/address/list')
        .then((res) => {
            state.user.address = res.data.data;
        })
        .catch((err) => {
            console.log(err);
        })
    },
    LOGOUT(state) {
        localStorage.removeItem('token');
        state.user = {};
        state.isLogin = true;
    },
    SELECTADDRNUM(state, num) {
        state.addrNum = num;
    }
}

export default mutations