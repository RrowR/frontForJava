<template>
    <div>
        <h1>{{ info() }}</h1>
        <h1>{{ info() }}</h1>
        <h1>{{ info() }}</h1>
        <h1>{{ info2 }}</h1>
    </div>
</template>
<script>
const options = {
    data: function () {
        return {
            name: '猫羽雫',
            age: 19
        };
    },
    methods: {
        info() {
            console.log(this.name + '今年' + this.age + '岁');
            return this.name + '今年' + this.age + '岁';
        }
    },
    // computed方法调用的时候不需要加括号,并且操作的数据会被缓存下载
    computed: {
        info2() {
            console.log("info2" + this.name + '今年' + this.age + '岁');
            return this.name + '今年' + this.age + '岁';
        }
    }
};
export default options;
</script>