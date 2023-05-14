import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'c',
    // redirect: '/p2',
    component: () => import('@/views/myviews/myviewx/ContainerView.vue'),
    children: [
      {
        path: 'p1',
        component: () => import('@/views/myviews/myviewx/container/P1View.vue')
      },
      {
        path: 'p2',
        component: () => import('@/views/myviews/myviewx/container/P2View.vue')
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
