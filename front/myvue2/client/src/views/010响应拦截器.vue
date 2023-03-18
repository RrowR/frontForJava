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

            _axios.interceptors.response.use(function (response) {
                // 对响应数据做点什么
                return response;
            }, function (error) {
                // 对响应错误做点什么
                if (error.response.status == 401) {
                    console.log("进入了401");
                } else if (error.response.status == 403) {
                    console.log("进入了403");
                } else if (error.response.status == 404) {
                    console.log("进入了404");
                }
                return Promise.reject(error);
            });

            await _axios.post("/api/student01post2");
        }
    },
}
export default options;
</script>