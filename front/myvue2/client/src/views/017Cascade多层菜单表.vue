<template>
    <el-cascader :options="options">
    </el-cascader>
</template>
  
<script>
import axios from 'axios';
export default {
    async mounted() {
        let resp = await axios.get('/api/menu');
        const array = resp.data;
        const map = new Map();

        for (const { id, name, pid } of array) {
            map.set(id, { value: id, label: name, pid: pid })
        }

        const top = [];
        for (const obj of map.values()) {
            // 获取根节点
            const parent = map.get(obj.pid);
            if (parent !== undefined) {
                parent.children ??= [];
                parent.children.push(obj);
            } else {
                // 最顶层节点
                top.push(obj);
            }
        }
        console.log(top);
        this.options = top;
    },
    data() {
        return {
            options: [

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