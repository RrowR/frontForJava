import Vue from 'vue'
import VueRouter from 'vue-router'
// @ 是绝对路径的写法
// import ContainerView from '@/views/myviews/containers/ContainerView'
// import LoginView from '@/views/myviews/containers/LoginView'
// import NotFoundView from '@/views/myviews/containers/NotFoundView'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: () => import('@/views/myviews/containers/ContainerView'),
  },
  {
    path: '/login',
    component: () => import('@/views/myviews/containers/LoginView'),
  },
  {
    path: '/404',
    component: () => import('@/views/myviews/containers/NotFoundView'),
  }

]

const router = new VueRouter({
  routes
})

export default router
