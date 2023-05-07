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
const options = {
  data() {
    return {
      username: "admin",
    };
  },
  methods: {
    async login() {
      const resp = await axios.get("/api/menu/" + this.username);
      console.log(resp.data.data);
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
