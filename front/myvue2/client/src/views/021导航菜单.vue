<template>
  <div>
    div
    <el-container>
      <el-header>
        <el-button type="primary" size="mini" @click="jump('/c/p1')"
          >页面P1</el-button
        >
        <el-button type="success" size="mini" @click="jump('/c/p2')"
          >页面P2</el-button
        >
      </el-header>
      <el-container>
        <el-aside width="200px">
          <!-- <router-link to="/c/p1">p1</router-link>
          <hr />
          <router-link to="/c/p2">p2</router-link> -->
          <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
          >
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>导航一</span>
              </template>
              <el-menu-item-group>
                <template slot="title">分组一</template>
                <el-menu-item index="1-1">选项1</el-menu-item>
                <el-menu-item index="1-2">选项2</el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="分组2">
                <el-menu-item index="1-3">选项3</el-menu-item>
              </el-menu-item-group>
              <el-submenu index="1-4">
                <template slot="title">选项4</template>
                <el-menu-item index="1-4-1">选项1</el-menu-item>
              </el-submenu>
            </el-submenu>
            <el-menu-item index="2">
              <i class="el-icon-menu"></i>
              <span slot="title">导航二</span>
            </el-menu-item>
            <el-menu-item index="3" disabled>
              <i class="el-icon-document"></i>
              <span slot="title">导航三</span>
            </el-menu-item>
            <el-menu-item index="4">
              <i class="el-icon-setting"></i>
              <span slot="title">导航四</span>
            </el-menu-item>
          </el-menu>
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
const options = {
  methods: {
    jump(url) {
      // 拿到router对象, 调用push方法, 跳转到指定的页面
      this.$router.push(url);
    },
  },
};
export default options;
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
