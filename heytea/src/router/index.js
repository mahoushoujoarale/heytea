import {createRouter, createWebHistory} from 'vue-router'

const Home = () => import('./../pages/home/Home.vue');
const Food = () => import('./../pages/food/Food.vue');
const Shop = () => import('./../pages/shop/Shop.vue');
const Order = () => import('./../pages/order/Order.vue');
const Mine = () => import('./../pages/mine/Mine.vue');
const Forget = () => import('./../pages/forget/Forget.vue');
const Register = () => import('./../pages/register/Register.vue');

const routes = [
    {path: '/', redirect: '/home'},
    {path: '/home', component: Home},
    {path: '/food', component: Food},
    {path: '/shop', component: Shop},
    {path: '/order', component: Order},
    {path: '/mine', component: Mine},
    {path: '/forget', component: Forget},
    {path: '/register', component: Register},
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;