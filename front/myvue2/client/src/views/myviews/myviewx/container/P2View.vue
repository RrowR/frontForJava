<template>
    <div class="p">
        <el-button type="primary" size="mini"
            @click="updateServerName()">从服务器获取数据,存入store</el-button>
    </div>
</template>
<script>
// 使用 mapActions 调用 actions
/* import { mapActions } from 'vuex'
const options = {
    methods: {
        ...mapActions(['updateServerName'])
    }
} */

const options = {
    methods: {
        updateServerName() {
            this.$store.dispatch('updateServerName')
            // 返回 Promise
        }
    }
}
export default options;
</script>
<style scoped>
.p {
    background-color: yellowgreen;
    background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg'%3E%3Ctext x='15' y='10' font-size='14' font-family='system-ui, sans-serif' text-anchor='middle' dominant-baseline='middle'%3EP1%3C/text%3E%3C/svg%3E");
    height: 100%;
}

.el-input--mini,
.el-select--mini {
    width: 163px;
    margin: 20px 10px 0 10px;
}
</style>