<template>
    <div class="p">
        <el-input placeholder="请修改用户姓名" 
            size="mini" v-model="name"></el-input>
        <el-button type="primary" size="mini" @click="updateName(name)">修改</el-button>
    </div>
</template>
<script>
import {mapMutations} from 'vuex'
// console.log(mapMutations(['updateName']))
const options = {
    methods: {
        /* update(){
            // 修改共享数据
            this.$store.commit('updateName', this.name);
        } */
        ...mapMutations(['updateName'])
    },
    data () {
        return {
            name:''
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