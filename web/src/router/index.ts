
import { createRouter, createWebHashHistory,createWebHistory } from 'vue-router'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import { staticRoutes, adminBaseRoute } from '@/router/static'
import { loading } from '@/utils/loading'


import { useConfig } from '@/stores/config'
import { isAdminApp } from '@/utils/common'
import { uniq } from 'lodash-es'

const router = createRouter({
    history: createWebHashHistory(),
    routes: staticRoutes,
    scrollBehavior(to, from, savedPosition) {

        // return {left:0,top:1000};
        // return {
        //     // 也可以这么写
        //     // el: document.getElementById('main'),
        //     el: '#about',
        //      behavior: 'smooth',
        //     top: -10,
        //   }

        if (to.hash) {
            return { el: to.hash ,behavior: 'smooth',} 
        } else if (savedPosition) {
            return savedPosition;
        } else {
            return { left: 0, top: 0  ,behavior: 'smooth',} 
        }
    }
})
let loadingType = "";
router.beforeEach((to, from, next) => {
    NProgress.configure({ showSpinner: false })
    NProgress.start()
    loadingType = to.fullPath;
    if (!window.existLoading) {
        loading.show(loadingType.indexOf("admin") > 0?"backend":"")
        window.existLoading = true
    }

    next()
})

// 路由加载后
router.afterEach(() => {
    if (window.existLoading) {
        loading.hide(loadingType.indexOf("admin") > 0?"backend":"")
    }

    NProgress.done()
})

export default router


