import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

// 这个store文件里来定义共享数据
export default new Vuex.Store({
  // 定义共享变量名 目前的 name age
  state: {
    name: '',
    age: 18
  },
  getters: {
  },
  mutations: {
    updateName(state, name) {
      state.name = name
    }
  },
  actions: {
  },
  modules: {
  }
})
