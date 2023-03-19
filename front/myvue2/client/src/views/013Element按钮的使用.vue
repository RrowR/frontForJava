<template>
    <div>
        <el-button type="warning" icon="el-icon-star-off" circle></el-button>
        <el-button type="danger" icon="el-icon-delete" circle></el-button>
    </div>
</template>
<script>
import axios from '../utils/myaxios';
const options = {
    async mounted() {
        // 编写一下axios的使用
        const resp = await axios.get("/api/student01");
        console.log(resp.data.data);
    },
}
export default options;
</script>