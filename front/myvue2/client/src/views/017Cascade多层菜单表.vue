<template>
    <el-cascader :options="options">
    </el-cascader>
</template>
  
<script>
export default {
    mounted() {

    },
    data() {
        return {
            options: [
                {
                    value: 100, label: '主页', children: [
                        {
                            value: 101, label: '菜单1', children: [
                                { value: 105, label: '子项1' },
                                { value: 106, label: '子项2' }
                            ]
                        },
                        {
                            value: 102, label: '菜单2', children: [
                                { value: 107, label: '子项3' },
                                { value: 108, label: '子项4' },
                                { value: 109, label: '子项5' }
                            ]
                        },
                        {
                            value: 103, label: '菜单3', children: [
                                { value: 110, label: '子项6' },
                                { value: 111, label: '子项7' }
                            ]
                        },
                        { value: 104, label: '菜单4' }
                    ]
                }
            ]
        }
    },
    methods: {
        handleChange(value) {
            console.log(value);
        }
    }
};
</script>