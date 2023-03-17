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

            /**
             * 这里会多一个请求,这个请求是用来获取服务器的cookie的
             * baseURL会自动把地址拼接到前面
             * 这里会出现跨域,后端需要设置允许跨域
             */
            // const resp = await _axios.post('/api/json02',{
            //     name:'猫羽雫',
            //     age:16
            // });
            // console.log(resp);
            
            await _axios.post("/api/axset",{});
            await _axios.post("/api/axget",{});

        }
    },
}
export default options;
</script>