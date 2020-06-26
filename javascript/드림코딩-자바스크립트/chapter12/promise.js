'use strict'

//promise는 만들어지는 순간 바로 실행된다.
//state : pending(수행중) -> fulfilled(완료) or rejected(실패)
//Producer vs Consumer

//1. Producer
// when new Promise is created, the executor runs automatically.
const promise = new Promise((resolve, reject) => {
    //doing some heacy work(network, read files);
    console.log('doing something...');
    // setTimeout(() => {
    //     //성공시
    //     //resolve('youngsil');
    //     //실패시
    //     reject(new Error('no network'));
    // }, 2000);
    resolve('youngsil');
    console.log('test2');
});

console.log('test');

//2. Consumers: then, catch, finally
//promise가 잘 수행되었다면
promise
    .then((value) => {
        console.log(value);
    })
    .catch(error => {
        console.log(error);
    })

console.clear();


//4. Error Handling
const getHen = () => 
    new Promise((resolve, reject) => {
        setTimeout(() => resolve('hen'), 1000);
    });

const getEgg = hen =>
    new Promise((resolve, reject) => {
        setTimeout( ()=> resolve(`${hen} => egg`), 1000);
        //setTimeout( () => reject(new Error('egg Error')), 1000);
    });

const cook = egg => 
    new Promise((resolve, reject) => {
        setTimeout(() => resolve(`${egg} => meal`), 1000);
    });


// getHen()
//     .then(hen => getEgg(hen))
//     .then(egg => cook(egg))
//     .then(meal => console.log(meal));
    

getHen()
    .then(getEgg)
    .catch(error => 'bread')
    .then(cook)
    .catch(error => 'bake')
    .then(console.log)
    .catch(console.log);

class Storage {
    loginUser(id, password) {
        return new Promise((resolve, reject) => {
            
            setTimeout(() => {
                if(id === 'youngsil' && password ==='1234') {
                    resolve(id);
                } else {
                    reject(new Error('not exist user'));
                }
            }, 0);
        });
    }

    getRole(id) {
        return new Promise((resolve, reject) => {
            
            setTimeout(() => {
                if(id ==='youngsil') {
                    resolve({name : id, role : 'member'});
                } else {
                    reject(new Error('bad access'));
                }
            }, 1000);
        });
    }
}

const storage = new Storage();
const id = prompt('enter id');
const password = prompt('enter password');

storage.loginUser(id, password)
        .catch(console.log)
        .then(storage.getRole)
        .catch(console.log)
        .then(user => alert(`${user.name}, ${user.role}`));