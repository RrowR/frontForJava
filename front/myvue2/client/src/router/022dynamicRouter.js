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
  },
  {
    path: "/login",
    component: () => import("@/views/myviews/containers2/LoginView.vue"),
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

const sessionRoutes =  sessionStorage.getItem('sessionRoutes');
const array = JSON.parse(sessionRoutes);
// 不需要使用表达式,可以直接判断是否为空
if (array) {
  addRoutes(array);
}


// 抽取方法,添加服务器返回的路由信息
export function addRoutes(array) {
  // console.log(array);
      // console.log(router.getRoutes());
      for (const { id, path, component } of array) {
        // 判断一下是否为空
        if (component != null) {
          // 这里router就在这里,不需要使用this,不然会报错
          router.addRoute("c", {
            path: path,
            name: id,
            // 这里要用反引号,才能解析到变量
            component: () =>
              import(`@/views/myviews/containers2/pages/${component}`),
          });
        }
      }
      console.log(router.getRoutes());
}

export default router;
