<template>
  <div>
    div
    <el-container>
      <el-header>header</el-header>
      <el-container>
        <el-aside width="200px">
          <router-link to="/c/p1">p1</router-link>
          <hr>
          <router-link to="/c/p2">p2</router-link>
        </el-aside>
        <el-main>
          <router-view></router-view>
          <!-- main -->
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>
console.log("020页面布局.vue");
</script>
<style>
.el-header,
.el-footer {
  background-color: #f5890e;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #f1ee0a;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #5fddee;
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}

.router-link-active {
    color: #fff;
    background-color: darkslateblue;
}


</style>
