<template>
  <div class="container">
    <el-container>
      <el-aside width="200px">Aside</el-aside>
      <el-container>
        <el-header>Header</el-header>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>
const options = {
  methods: {
    jump(url) {
      this.$router.push(url);
    },
  },
};
export default options;
</script>
<style scoped>
.container {
  height: 800px;
  background-color: cornsilk;
  padding: 20px;
  box-sizing: border-box;
}

.el-container {
  height: 100%;
}

.el-header {
  background-color: aquamarine;
}

.el-aside {
  background-color: gold;
}

.el-main {
  background-color: dodgerblue;
}

a {
  text-decoration: none;
  display: block;
  margin: 10px 10px 0 10px;
  padding: 3px;
  font-size: 13px;
}

.router-link-active {
  color: #fff;
  background-color: darkslateblue;
}

.el-button {
  margin-top: 15px;
}
</style>
