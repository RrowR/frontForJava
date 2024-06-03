<script setup>
let name = "张三";
let aa = {
    price:199
}


let msg = "<p style='color:red'>你好</p>";

function buy(){
    alert("购买成功");
}

let price = 25;

let fruits = ['苹果','香蕉', '橙子'];

</script>


<template>
    <div>
        <h2>{{name}}</h2>
        <h2>{{aa.price}}</h2>
        <div v-html="msg"></div>
        <div v-text="msg"></div>
        <button @click.once="buy">购买</button>
        <span style="color:green" v-if="price<100">很便宜</span>
        <span style="color: red;" v-if="price>=100">太贵了</span>
        <li v-for="(item,index) in fruits">{{ item }} ====> {{ index }}</li>
    </div>
</template>

<style scoped>

</style>
