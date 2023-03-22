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


        <el-pagination layout="prev, pager, next, sizes,->, total" :total="100" :page-sizes="[5, 10, 15, 20]"
            :page-size="queryDao.pageSize" :current-page="queryDao.page" @current-change="currentChange"
            @size-change="sizeChange"
            >
            </el-pagination>
    </div>
</template>
<script>
import axios from '../utils/myaxios';
const options = {
    mounted() {
        // 编写一下axios的使用
        // const resp = await axios.get("/api/student01/q", {
        //     params: this.queryDao
        // });
        this.query();
        // console.log(resp.data.data);
    },
    // 定义了vue里的data数据
    data() {
        return {
            students: [],
            queryDao: {
                page: 1,
                pageSize: 5
            }
        }
    },
    methods: {
        currentChange(page) {
            this.queryDao.page = page;
            this.query();
        },
        sizeChange(size){
            this.queryDao.pageSize = size;
            this.query();
        },
        async query() {
            const resp = await axios.get("/api/student01/q",{
                params: this.queryDao
            });
            this.students = resp.data.data;
        }   
    },
}
export default options;
</script>