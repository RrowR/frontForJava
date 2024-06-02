const user = {
    name: '张三',
    age: 20,
}


function isAdult(age){
    if(age > 18){
        return "成年人";
    }else{
        return "未成年";
    }
}

// 到处方法
export {user,isAdult}