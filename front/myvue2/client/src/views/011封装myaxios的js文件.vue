<template>
    <div>
        <input type="button" value="获取远程数据" @click="sendReq()">
    </div>
</template>
<script>
// 使用自己封装的axios
import axios from '../utils/myaxios'
const options = {
    methods: {
        async sendReq() {
            await axios.post("/api/student01post2");
        }
    },
}
export default options;
</script>