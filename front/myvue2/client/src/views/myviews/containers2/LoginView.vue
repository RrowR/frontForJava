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
import { resetRouter } from "@/router/022dynamicRouter.js";
const options = {
  data() {
    return {
      username: "admin",
    };
  },
  methods: {
    async login() {
      resetRouter(); // 用于重置路由
      const resp = await axios.get("/api/menu/" + this.username);
      const array = resp.data.data;
      console.log(array);
      console.log(this.$router.getRoutes());
      for (const { id, path, component } of array) {
        // 判断一下是否为空
        if (component != null) {
          this.$router.addRoute("c", {
            path: path,
            name: id,
            // 这里要用反引号,才能解析到变量
            component: () =>
              import(`@/views/myviews/containers2/pages/${component}`),
          });
        }
      }
      console.log(this.$router.getRoutes());
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
