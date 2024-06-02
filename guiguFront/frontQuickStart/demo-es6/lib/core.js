// 1、let  规范作用域
// var a = 1;
// let b = 1;


// {
//     var a = 1;
//     let b = 1;
// }

// console.log(a);
// console.log(b);

// ==========    1.2  重复声明
// var a = 1;
// var a = 2;
// var a = 3;
// var a = 4;
// console.log(a);
// let b = 1;
// console.log(b);
// const c = 1;
// c = 2;
// console.log(c);  //Assignment to constant variable.


// =========== 1.3 解构赋值
// let arr = [1,2,3];

// let [x,y,z] = arr;

// console.log(x,y,z);

// let person = {
//     name:'张三',
//     age:20,
//     sex:'男'
// }

// let {name,age,sex} = person;

// console.log(name,age,sex);

// 结构复制方法
// function fn({name,age,sex}){
//     console.log(name,age,sex);
// }

// fn(person);


// =========== 1.4 链判断
// let message = null;

// // ?. 用于判断后面是否有值 
// let data = message?.data?.user?.name || 'default';

// console.log(data);

// ===========  1.5 参数默认值
// 括号里的b=5直接设置为默认值，这样就可以下面调用方法的时候可以不传都可以
// 但是要注意，默认值的参数必须放到最后面
// function add(a,b=5){
//     return a+b;
// }

// console.log(add(1,2));

// =========== 1.6 箭头函数
// 不需要再写function了
// let sum = (a,b) => a+b;

// console.log(sum(13,2));

// ========= 1.7 模板字符串
// 用 ${取值},整个字符串用 ` 来 包裹

// let user = {
//     name:'张三',
//     age:20,
//     sex:'男'
// }

// let {name,age,sex} = user;

// let info =  `用户为${name},年龄为${age},性别为${sex}`
// console.log(info);

// =========== 1.8 Promise  异步请求对象
// let url = "https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json";   // 网络数据
// console.log(1);
// let promise = fetch(url);
// console.log(2);
// // promise.then 获取正常结果
// promise.then(resp => {
//     console.log("响应数据",resp);
//     // 需要调用 .then 才能获取到里面的数据
//     resp.json().then(data => {
//         console.log(data);
//     })
// });
// // promise.catch 获取异常结果
// promise.catch(err => {
//     console.log("错误为：",err);    // Failed to fetch
// });

// async 可以将一个方法封装成一个异步代码
async function func1(){
    let x = 101;
    if(x%2 === 0){
        return x;
    }else{
        throw new Error(`${x}不是偶数`);
    }
}

func1().then(data => {
    console.log("data",data);
}).catch(err => {
    console.log("err",err);
})


