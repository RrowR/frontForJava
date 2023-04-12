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
    component: () => import("@/views/myviews/containers/ContainerView"),
    redirect: "c/p2", // 这里会在访问首页的时候自动跳转到c/p2
    children: [
      {
        path: "c/p1",
        component: () =>
          import("@/views/myviews/containers/nesting/P1View.vue"),
      },
    ],
  },
  {
    path: "/login",
    component: () => import("@/views/myviews/containers/LoginView"),
    children: [
      {
        path: "c/p2",
        component: () =>
          import("@/views/myviews/containers/nesting/P2View.vue"),
      },
    ],
  },
  {
    path: "/404",
    component: () => import("@/views/myviews/containers/NotFoundView"),
    children: [
      {
        path: "c/p3",
        component: () =>
          import("@/views/myviews/containers/nesting/P3View.vue"),
      },
    ],
  },
  // {
  //   path: "/020",
  //   component: () => import("@/views/020页面布局.vue"),
  // },
  // {
  //   // 访问到其他页面直接404,这样写可以直接让url跳转到404
  //   path: "*",
  //   redirect: "/404",
  // },
];

const router = new VueRouter({
  routes,
});

export default router;
