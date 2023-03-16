<template>
    <div>
        <input type="text" v-bind:value="age">
        <input type="date" v-bind:value="birthday">
        <!-- :value简化的数据绑定 -->
        <input type="text" :value="name">
    </div>
</template>

<script>
const options = {
    data: function () {
        return {
            name: '猫羽雫', age: 19, birthday: '1999-01-01'
        };
    }
};
export default options;
</script>