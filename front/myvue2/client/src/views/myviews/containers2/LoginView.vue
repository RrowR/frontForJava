<template>
  <div class="login">
    <el-input
      v-model="username"
      placeholder="请输入用户名"
      size="mini"
    ></el-input>
    <el-button type="primary" size="mini" @click="login()">登录</el-button>
  </div>
</template>
<script>
// 使用自己封装的带有代理的axios
import axios from "@/utils/myaxios.js";
import { resetRouter,addRoutes } from "@/router/022dynamicRouter.js";
const options = {
  data() {
    return {
      username: "admin",
    };
  },
  methods: {
    async login() {
      // 因为vue2没有这种写法
      resetRouter(); // 用于重置路由
      const resp = await axios.get("/api/menu/" + this.username);
      // 从服务器里返回的信息,并取值
      const array = resp.data.data;
      addRoutes(array); // 用于添加路由的方法
    },
  },
};
export default options;
</script>
<style scoped>
.login {
  height: 100%;
  background-color: darkseagreen;
  background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg'%3E%3Ctext x='15' y='10' font-size='14' font-family='system-ui, sans-serif' text-anchor='middle' dominant-baseline='middle'%3E%3C/text%3E%3C/svg%3E");
}

.el-input--mini {
  width: 200px;
  margin: 10px 10px 0 10px;
}
</style>
