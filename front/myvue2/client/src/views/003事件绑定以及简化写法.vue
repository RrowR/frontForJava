<template>
    <div>
        <input type="button" value="点我" v-on:click="m2">
        <!-- @click简写的事件绑定 -->
        <input type="button" value="点我" @click="m1">
        <input type="text" :value="key">
    </div>
</template>

<script>
const options = {
    data: function () {
        return {
            key: 1
        };
    },
    methods: {
        m1() {
            this.key ++;
        },
        m2() {
            this.key --;         
        }
    },
};
export default options;
</script>