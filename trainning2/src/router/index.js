/*
 * @Author: your name
 * @Date: 2021-06-04 14:58:24
 * @LastEditTime: 2021-11-30 10:07:30
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \demo\src\router\index.js
 */
import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [{
        path: '/login',
        name: 'Login',
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/login/Login.vue')
    },
    {
        path: '/',
        name: 'Index',
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/page/index.vue')
    },
    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/About.vue')
    }
]

const router = new VueRouter({
    routes
})

export default router