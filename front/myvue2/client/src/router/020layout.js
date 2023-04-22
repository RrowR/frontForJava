import Vue from "vue";
import VueRouter from "vue-router";
// @ 是绝对路径的写法
// import ContainerView from '@/views/myviews/containers/ContainerView'
// import LoginView from '@/views/myviews/containers/LoginView'
// import NotFoundView from '@/views/myviews/containers/NotFoundView'

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    component: () => import("@/views/020页面布局.vue"),
    children: [
      {
        path: "c/p1",
        component: () =>
          import("@/views/myviews/containers/nesting/P1View.vue"),
      },
      {
        path: "c/p2",
        component: () =>
          import("@/views/myviews/containers/nesting/P2View.vue"),
      },
    ],
  },
];

const router = new VueRouter({
  routes,
});

export default router;
