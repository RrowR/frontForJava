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
            const _axios = axios.create({
                baseURL: 'http://localhost:8080',
                withCredentials: true,  // 允许跨域携带cookie ,这里允许携带cookie后,后端也要设置 allowCredentials = "true" 才可以
            });
            // 这里如果报错,是取不到值得
            try {
                const resp = await _axios.post("/api/student01");
                console.log("正常运行");
                console.log(resp);
            } catch (error) {
                console.log("进入了错误方法");
                console.log(error.response);
            }
        }
    },
}
export default options;
</script>