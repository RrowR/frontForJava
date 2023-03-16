<template>
    <div>
        <h1>{{ name }}</h1>
        <h1>{{ age > 18 ? '成年' : '未成年' }}</h1>
    </div>
</template>

<script>
const options = {
    data: function () {
        return {
            name: '猫羽雫',
            age: 19
        };
    }
};
export default options;
</script>