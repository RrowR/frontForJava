import { login, logout, getInfo } from '@/api/user'
import { getToken, setToken, removeToken } from '@/utils/auth'
import router, { resetRouter } from '@/router'

const state = {
  // token: getToken(),
  name: '',
  avatar: '',
  introduction: '',
  roles: []
}

const mutations = {
  // SET_TOKEN: (state, token) => {
  //   // mutations将令牌存到了state里(这里是共享变量)
  //   state.token = token
  // },
  SET_INTRODUCTION: (state, introduction) => {
    state.introduction = introduction
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar
  },
  SET_ROLES: (state, roles) => {
    state.roles = roles
  }
}

const actions = {
  // user login 方法,commit其实就是context.commit 结构出来了而已
  // login({ commit }, userInfo) {
  //   const { username, password } = userInfo
  //   return new Promise((resolve, reject) => {
  //     login({ username: username.trim(), password: password })
  //       .then(body => {
  //         //  结构一次,又取了一次data,之前响应拦截器已经取了一次data,这次是已经彻底取完,可以直接拿数据了
  //         const { data } = body
  //         // 调用mutations中的方法,传入参数,这里是一个共享变量,所以可以直接调用
  //         // commit('SET_TOKEN', data.token)
  //         // 将后端返回的token存到cookie中
  //         setToken(data.token)
  //         resolve()
  //       }).catch(error => {
  //         reject(error)
  //       })
  //   })
  // },

  // 修改上面的方法
  async login({ commit }, userInfo) {
    const { username, password } = userInfo
    const body = await login({ username: username.trim(), password: password })
    setToken(body.data.token)
  },

  // // get user info
  // getInfo({ commit, state }) {
  //   return new Promise((resolve, reject) => {
  //     // 根据token令牌返回用户信息,jwt里有带用户信息
  //     getInfo(getToken()).then(response => {
  //       // 从响应的resp里结构data
  //       const { data } = response

  //       if (!data) {
  //         // 如果为空,则返回错误
  //         reject('Verification failed, please Login again.')
  //       }

  //       // 继续结构data里的其他属性
  //       const { roles, name, avatar, introduction } = data

  //       // roles must be a non-empty array
  //       if (!roles || roles.length <= 0) {
  //         reject('getInfo: roles must be a non-null array!')
  //       }

  //       // commit都是用来调用mutations里的方法,间接存储到state里
  //       commit('SET_ROLES', roles)
  //       commit('SET_NAME', name)
  //       commit('SET_AVATAR', avatar)
  //       commit('SET_INTRODUCTION', introduction)
  //       // 将数据返回出去
  //       resolve(data)
  //     }).catch(error => {
  //       reject(error)
  //     })
  //   })
  // },

  // 自己修改成同步的方法
  async getInfo({ commit, state }) {
    const { data } = await getInfo(getToken())
    const { roles, name, avatar, introduction } = data
    if (!roles || roles.length <= 0) {
      throw '查询的权限不存在'
    }

    commit('SET_ROLES', roles)
    commit('SET_NAME', name)
    commit('SET_AVATAR', avatar)
    commit('SET_INTRODUCTION', introduction)

    // return
    return roles
  },

  // user logout
  logout({ commit, state, dispatch }) {
    return new Promise((resolve, reject) => {
      logout(getToken()).then(() => {
        // commit('SET_TOKEN', '')
        commit('SET_ROLES', [])
        removeToken()
        resetRouter()

        // reset visited views and cached views
        // to fixed https://github.com/PanJiaChen/vue-element-admin/issues/2485
        dispatch('tagsView/delAllViews', null, { root: true })

        // return
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  //
  resetToken({ commit }) {
    return new Promise(resolve => {
      // commit('SET_TOKEN', '')
      commit('SET_ROLES', [])
      removeToken()
      resolve()
    })
  },

  // dynamically modify permissions
  async changeRoles({ commit, dispatch }, role) {
    const token = role + '-token'

    // commit('SET_TOKEN', token)
    setToken(token)

    const { roles } = await dispatch('getInfo')

    resetRouter()

    // generate accessible routes map based on roles
    const accessRoutes = await dispatch('permission/generateRoutes', roles, { root: true })
    // dynamically add accessible routes
    router.addRoutes(accessRoutes)

    // reset visited views and cached views
    dispatch('tagsView/delAllViews', null, { root: true })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
