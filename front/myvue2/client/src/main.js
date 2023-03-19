import Vue from 'vue'
// import App from './App.vue'
import e1 from './views/015分页组件.vue'
import router from './router'
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
