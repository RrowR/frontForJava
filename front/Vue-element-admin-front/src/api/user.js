import axios from '@/utils/request'

export function login(data) {
  return axios({
    url: '/user/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return axios({
    url: '/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return axios({
    url: '/user/logout',
    method: 'post'
  })
}
