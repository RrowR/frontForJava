import Vue from "vue";
import VueRouter from "vue-router";
// import ContainerView from '@/views/example14/ContainerView.vue'
// import LoginView from '@/views/example14/LoginView.vue'
// import NotFoundView from '@/views/example14/NotFoundView.vue'

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    id: "c",
    component: () => import("@/views/myviews/containers2/ContainerView.vue"),
    redirect: "/login",
    children: [
      {
        path: "c1/p1",
        component: () =>
          import("@/views/myviews/containers2/nesting/P1View.vue"),
      },
      {
        path: "c1/p2",
        component: () =>
          import("@/views/myviews/containers2/nesting/P2View.vue"),
      },
      {
        path: "c1/p3",
        component: () =>
          import("@/views/myviews/containers2/nesting/P3View.vue"),
      },
    ],
  },
  {
    path: "/login",
    component: () => import("@/views/myviews/containers2/LoginView.vue"),
  },
  {
    path: "/p1",
    component: () => import("@/views/myviews/containers2/NotFoundView.vue"),
  },
  {
    path: "/404",
    component: () => import("@/views/myviews/containers2/NotFoundView.vue"),
  },
  {
    path: "*",
    redirect: "/404",
  },
];

const router = new VueRouter({
  routes,
});

export function resetRouter() {
  // reset router
  router.matcher = new VueRouter({ routes }).matcher;
}

export default router;
