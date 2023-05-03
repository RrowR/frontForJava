import Vue from 'vue'
// import App from './App.vue'
// 以这个页面作为基础页面
import e1 from './views/019Router嵌套.vue'
// import e1 from './views/020页面布局.vue'
// import router from './router'
// import router from './router/myrouter'
// import router from './router/dynamicRouter'
// import router from './router/020layout'
import router from './router/021navigationMenu'
import store from './store'
// elementui导入
import Element from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false
// elementui使用
Vue.use(Element);

new Vue({
  router,
  store,
  render: h => h(e1)
}).$mount('#app')
