<template>
    <div>
        <input type="button" value="获取远程数据" @click="sendReq()">
    </div>
</template>
<script>
import axios from 'axios'
const options = {
    methods: {
        async sendReq() {
            const resp = await axios.get('/api/getStudent');
            console.log(resp);
        }
    },
}
export default options;
</script>