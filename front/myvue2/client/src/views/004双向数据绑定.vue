<template>
    <div>
        <div>
            <label for="">请输入用户名</label>
            <input type="text" v-model="name">
        </div>
        <div>
            <label for="">请输入年龄</label>
            <input type="text" v-model="age">
        </div>
        <div>
            <label for="">请输入性别</label>
            男:<input type="radio" v-model="sex" value="男">
            女:<input type="radio" v-model="sex" value="女">
        </div>
        <div>
            <label for="">请选择爱好</label><br>
            吃饭:<input type="checkbox" value="吃饭" v-model="fav">
            睡觉:<input type="checkbox" value="睡觉" v-model="fav">
            游戏:<input type="checkbox" value="游戏" v-model="fav">
        </div>
    </div>
</template>

<script>
const options = {
    data: function () {
        return {
            name: '猫羽雫', age: 20, sex:'女',fav:['吃饭']
        };
    }
};
export default options;
</script>