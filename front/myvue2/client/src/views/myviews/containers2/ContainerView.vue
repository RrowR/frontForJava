<template>
  <div class="container">
    <el-container>
      <el-header> 我是头 </el-header>
      <el-container>
        <el-aside width="200px">
          <el-menu router background-color="#545c64" text-color="#fff" active-text-color="#ffd04b" :unique-opened="true">
            <template v-for="m1 in top"> 
                <el-submenu v-if="m1.children" :key="m1.id" :index="m1.path">
                    <span slot="title">
                        <i :class="m1.icon"></i> {{ m1.name }}
                    </span> 
                    <el-menu-item v-for="m2 in m1.children" :key="m2.id" :index="m2.path">
                        <span slot="title">
                        <i :class="m2.icon"></i> {{ m2.name }}
                    </span>
                    </el-menu-item>
                </el-submenu>
                <el-menu-item v-else :key="m1.id" :index="m1.path">
                    <span slot="title">
                        <i :class="m1.icon"></i> {{ m1.name }}
                    </span>
                </el-menu-item>
            </template>
          </el-menu>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
const options = {
  // 渲染页面之后执行
  mounted() {
    const sessionRoutes = sessionStorage.getItem("sessionRoutes");
    const array = JSON.parse(sessionRoutes);
    // console.log(array);

    // 封装带有层级属性的菜单
    const map = new Map();
    const top = [];
    for (const obj of array) {
      // 将对象放到map集合里
      map.set(obj.id, obj);
    }
    for (const obj of array) {
      const parent = map.get(obj.pid);
      if (parent) {
        // 下面是判断是否有children属性,如果没有就创建一个
        parent.children ??= [];
        parent.children.push(obj);
      } else {
        top.push(obj);
      }
    }
    console.log(top);
    this.top = top;
  },
  data() {
    return {
      top: [],
    };
  },
};
export default options;
</script>

<style scoped>
.container {
  height: 100%;
  background-color: cornsilk;
  background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg'%3E%3Ctext x='15' y='10' font-size='14' font-family='system-ui, sans-serif' text-anchor='middle' dominant-baseline='middle'%3E主页%3C/text%3E%3C/svg%3E");
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
