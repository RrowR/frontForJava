// 使用export可以把js的变量、函数、类等暴露出去，供其他模块使用(单个导出)
// export const a = 10;
// export let b = 20;
// export function c() {
//     console.log('c');
// }

// // 一齐导出
// const a = 10;
// let b = 20;
// function c() {
//     console.log('c');
// }
// export {a, b, c};

const a = 10;
let b = 20;
function c() {
    console.log('c');
}
export {a, b, c};
// 默认不能用解构赋值来进行导入,而且导入的值可以随意取
export default b;