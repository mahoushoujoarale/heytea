import {createRouter, createWebHistory} from 'vue-router'

const Home = () => import('./../pages/home/Home.vue');
const Food = () => import('./../pages/food/Food.vue');
const Shop = () => import('./../pages/shop/Shop.vue');
const Order = () => import('./../pages/order/Order.vue');
const Mine = () => import('./../pages/mine/Mine.vue');

const routes = [
    {path: '/', redirect: '/home'},
    {path: '/home', component: Home},
    {path: '/food', component: Food},
    {path: '/shop', component: Shop},
    {path: '/order', component: Order},
    {path: '/mine', component: Mine},
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;