const getters = {
    cartList(state) {
        return state.cartList;
    },
    getSum(state) {
        let sum = 0;
        for (let item of state.cartList) sum += item.checked * item.count;
        return sum;
    },
    getAllPrice(state) {
        let sum = 0;
        for (let item of state.cartList) sum += item.checked * item.count * item.info.price;
        return sum;
    },
    getUser(state) {
        return state.user;
    },
    getPlace(state) {
        return state.place;
    },
    getStorage(state) {
        if (!state.token) 
            state.token = JSON.parse(localStorage.getItem(key));
        return state.token;
    },
    getAddrNum(state) {
        return state.addrNum;
    }
}

export default getters