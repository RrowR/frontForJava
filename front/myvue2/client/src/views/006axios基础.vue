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
            // 1.get请求
            // const resp = await axios.get('/api/get01');

            // 2.Post请求e=xxx
            // const resp = await axios.post('/api/post01');
            // 3.发送请求头('url',data,config)
            // const resp = await axios.post('/api/post02',{},{
            //     headers:{
            //         Authorization:'abc'
            //     }
            // });

            // 3.Post发送携带查询参数的请求  ?name=xxx&ag  
            // 如果前端传的名字是特殊字符,那么这个字符串将不能被解析
            // const name = "&&&";
            // const name = encodeURIComponent("&&&");         // 通过url编码之后就可以传入特殊字符了
            // const age = 16;
            // const resp = await axios.post(`/api/post03?name=${name}&age=${age}`);
            // 通过请求头携带参数  这种方式的参数会自动被编码并自动拼接
            // const resp = await axios.post('/api/post03',{},{
            //     params:{
            //         name:'&&&',
            //         age:16
            //     }
            // });

            // 4.使用请求体里发送请求参数 使用参数的形式,默认形式为json
            // const resp = await axios.post('/api/post03',{  // 这种方式默认的请求方式是json格式,所以不行,如果后端不是json格式来接收的话
            //     name:'&&&',
            //     age:16
            // });
            /* 这个时候就需要使用请求头来指定请求体的格式 URLSearchParams 这个是js原生的对象,
               可以将对象转换为url编码的字符串,这个字符串就可以被后端解析,
               请求格式为  multipart
            */
            // let params = new URLSearchParams();
            // params.append('name','&&&');
            // params.append('age',16);
            // const resp = await axios.post('/api/post03',params);

            // 5.使用请求体来发送,请求格式为 multipart
            // const param = new FormData();
            // param.append('name','猫羽雫');
            // param.append('age',16);
            // const resp = await axios.post('/api/post04',param);    // 这里后端也可以用对象来进行接收

            // 6.使用json来发送数据,因为默认就是json,所以什么东西都不需要创建
            const resp = await axios.post('/api/json01',{
                name:'猫羽雫',
                age:16
            });
            console.log(resp);
        }
    },
}
export default options;
</script>