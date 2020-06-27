//JSON


//1. Object to JSON

//pri
let json = JSON.stringify(true);
console.log(`value : ${json}, type : ${typeof json}`);
console.log(`value : ${true}, type : ${typeof true}`);

//array
json = JSON.stringify(['apple', 'banana']);
console.log(`value : ${json}, type : ${typeof json}`);

//object
const rabbit = {
    name : 'tori',
    color : 'white',
    size : null,
    birthDay : new Date(),
    jump : () => console.log(`${name} can jump`)
};

json = JSON.stringify(rabbit, ['name', 'color']);
console.log(`value : ${json}, type : ${typeof json}`);

json = JSON.stringify(rabbit, (key, value) => {
    console.log(`'key : ${key}, value : ${value}`);
    return key === 'name' ? 'youngsil' : value;
});
console.log(`value : ${json}, type : ${typeof json}`);

//2. JSON to Object
console.clear();

json = JSON.stringify(rabbit);
const obj = JSON.parse(json);
console.log(obj);
rabbit.jump();

console.log(rabbit.birthDay.getDate());

console.clear();
// JSON에는 Date타입이 String 값으로 반환이 되고
// JSON으로 받아간 값을 다시 Object로 변환시킬때 약간의 작업을 해주어야 한다.
const obj2 = JSON.parse(json, (key, value) => {
    console.log(`key : ${key}, value : ${value}`);
    return key =='birthDay' ? new Date(value) : value;
    return value;
});

console.log(rabbit.birthDay.getDate());

console.log(obj2.birthDay.getDate());