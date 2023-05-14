<template>
    <div class="container">
        <el-container>
            <el-header>
                <div class="t">欢迎您：{{ name }},{{ age }}</div>
            </el-header>
            <el-container>
                <el-aside width="200px">
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
    computed:{
        name(){
            return this.$store.state.name;
        },
        age(){
            return this.$store.state.age;
        }

    }
}
export default options;
</script>
<style scoped>
.t {
    margin-top: 5px;
    font-size: 14px;
}

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
    background-color: gold;
    border-bottom: 1px solid black;
}

.el-aside {
    background-color: gold;
    border-right: 1px solid black;
}

.el-main {
    background-color: gold;
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