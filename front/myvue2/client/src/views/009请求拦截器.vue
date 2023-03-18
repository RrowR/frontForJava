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
            // 请求拦截器
            _axios.interceptors.request.use(function (config) {
                // 在发送请求之前做些什么
                config.headers = {
                    Authorization: "Bearer 11111",
                }
                return config;
            }, function (error) {
                // 对请求错误做些什么
                return Promise.reject(error);
            });
            let resp = _axios.post("/api/student01post");
            console.log(resp);
        }
    },
}
export default options;
</script>