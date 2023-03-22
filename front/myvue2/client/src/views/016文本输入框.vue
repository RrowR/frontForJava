<template>
    <div>
        <el-input v-model="queryDao.name" placeholder="请输入姓名" clearable></el-input>
        <el-select v-model="queryDao.sex" filterable placeholder="请选择性别">
            <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
            </el-option>
        </el-select>
        <el-button type="primary" @click="query()">搜索</el-button>

        <div class="block">
            <span class="demonstration">默认</span>
            <el-slider v-model="queryDao.age"></el-slider>
        </div>

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
            @size-change="sizeChange">
        </el-pagination>
    </div>
</template>
<script>
import axios from '../utils/myaxios';
const options = {
    mounted() {
        this.query();
    },
    // 定义了vue里的data数据
    data() {
        return {
            students: [],
            queryDao: {
                page: 1,
                pageSize: 5,
                sex: '',
                age: 1,
                name: ''
            },
            options: [{
                value: '男',
                label: '男'
            }, {
                value: '女',
                label: '女'
            }],
        }
    },
    methods: {
        currentChange(page) {
            this.queryDao.page = page;
            this.query();
        },
        sizeChange(size) {
            this.queryDao.pageSize = size;
            this.query();
        },
        async query() {
            const resp = await axios.get("/api/student01/q2", {
                params: this.queryDao
            });
            this.students = resp.data.data;
        }
    },
}
export default options;
</script>