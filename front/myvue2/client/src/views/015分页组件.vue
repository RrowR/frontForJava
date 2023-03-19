<template>
    <div>
        <el-table :data="students" style="width: 100%">
            <el-table-column prop="id" label="标识" width="180">
            </el-table-column>
            <el-table-column prop="name" label="姓名" width="180">
            </el-table-column>
            <el-table-column prop="sex" label="性别">
            </el-table-column>
            <el-table-column prop="age" label="年龄">
            </el-table-column>
            <el-table-column prop="photo" label="相册">
            </el-table-column>
        </el-table>


        <el-pagination background layout="prev, pager, next, jumper,sizes,->, total" :total="100" :page-sizes="[5,10,15,20]"
            :current-page="3">
        </el-pagination>
    </div>
</template>
<script>
import axios from '../utils/myaxios';
const options = {
    async mounted() {
        // 编写一下axios的使用
        const resp = await axios.get("/api/student01");
        this.students = resp.data.data;
        // console.log(resp.data.data);
    },
    // 定义了vue里的data数据
    data() {
        return {
            students: []
        }
    }
}
export default options;
</script>