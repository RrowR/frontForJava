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
          <!-- 这里一定要加上router,不然不会跳转 -->
          <el-menu router
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
          >
            <el-submenu index="1">
              <span slot="title">
                <i class="el-icon-location"></i>
                菜单1
              </span>
              <el-menu-item index="/c/p1">
                  子项1
              </el-menu-item>
              <el-menu-item index="/c/p2">
                  子项2
              </el-menu-item>
            </el-submenu>

            <el-menu-item>
              <span slot="title">
                <i class="el-icon-setting"></i>
                菜单2
              </span>
            </el-menu-item>
            <el-menu-item>
              <span slot="title">
                <i class="el-icon-document"></i>
                菜单3
              </span>
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
