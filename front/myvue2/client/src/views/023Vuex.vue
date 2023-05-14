<template>
    <div class="all">
        <router-view></router-view>
    </div>
</template>
<style scoped>
.all {
    height: 100%;
    background-color: darksalmon;
    background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg'%3E%3Ctext x='22' y='10' font-size='14' font-family='system-ui, sans-serif' text-anchor='middle' dominant-baseline='middle'%3E最外层%3C/text%3E%3C/svg%3E");
    padding: 20px;
    box-sizing: border-box;
}
</style>