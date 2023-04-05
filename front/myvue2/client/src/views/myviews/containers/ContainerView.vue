<template>
    <div class="container">
        这个是默认的主页
    </div>
</template>
<script>
console.log("11111");
const options = {
    methods: {
        jump(url) {
            this.$router.push(url);
        }
    }
}
export default options;
</script>
<style scoped>
.container {
    height: 100%;
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