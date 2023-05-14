import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

import axios from "@/utils/myaxios";

// 这个store文件里来定义共享数据
export default new Vuex.Store({
  // 定义共享变量名 目前的 name age
  state: {
    name: "",
    age: 18,
  },
  getters: {},
  mutations: {
    updateName(state, name) {
      state.name = name;
    },

    updateServerName(state,user) {
      // const resp = await axios.get("/api/user");
      // const { name, age } = resp.data.data;
      const {name,age} = user;
      state.name = name;
      state.age = age;
    },
  },
  actions: {
    async updateServerName(context) {
      const resp = await axios.get("/api/user"); 
      context.commit('updateServerName',resp.data.data);
    }
  },
  modules: {},
});
