//async & await



//1. async

function fetchUser() {
    //do network request in 10 sec...
    return new Promise((resolve, reject) => {
        console.log('test4-1');
        console.log('test4-2');
        console.log('test4-3');
        console.log('test4-4');
        setTimeout(() => {
            //console.log('test5');
            //resolve('youngsil');
            //console.log('test6');
        }, 0);
        console.log('test5');
    });
}
console.log('test1');

const result = fetchUser();
console.log('test2');
result.then(console.log);
console.log('test3');

console.clear();


function delay(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function getApple() {
    await delay(5000);
    return '사과';
}

async function getBanana() {
    await delay(5000);
    return '바나나';
}

// async function pickFruits() {
//     console.log('test1');
//     const apple = await getApple();
//     console.log('test2');
//     const banana = await getBanana();
//     console.log('test3');
//     console.log('test3');
//     return `${apple} ${banana}`;  
// }

async function pickFruits() {
    console.log('test1');
    const apple = await getApple();
    console.log('test2');
    const banana = await getBanana();
    console.log('test3');
    console.log('test3');
    return `${apple} ${banana}`;  
}

console.log('test4');
pickFruits().then(console.log);
console.log('test5');


function pickAllFruit() {
    return Promise.all([getApple(), getBanana()])
    .then(fruites => fruites.join(' + '));
}

pickAllFruit().then(console.log);

// console.log('t');

// async function test() {
//     await delay(5000);
//     console.log('test!!!!');
//     console.log('test!!!!');
//     console.log('test!!!!');
//     console.log('test!!!!');
//     console.log('test!!!!');
//     console.log('test!!!!');
//     console.log('test!!!!');
//     console.log('test!!!!');
//     return 'hi'
// }
// test().then(console.log);
// console.log('tt');