'use strict';

//자바 스크립트는 동기적 언어이다.
//호이스팅이 된 이후로 우리가 작성한 코드부터 하나하나 동기적으로 실행된다.
//호이스팅이란? var변수와 함수선언이 제일위로 올라가는 것


console.log('1');
setTimeout(() => console.log('2')
, 1000);
console.log('3');


//동기 콜백 : 즉각 실행 -> 함수의 선언은 호이스팅되어
//                        가장 위로 올라간다.
function printImmediately(print) {
    print();
}
printImmediately(() => console.log('hello'));
// 1 -> 3 -> hello -> 3



//비동기 콜백 : 나중에 실행 -> 브라우저에게 넘김
function printWithDelay(print, timeout) {
    setTimeout(print, timeout);
}

printWithDelay(() => console.log('async callback'), 2000);


console.clear();

// //Callback Hell example
// class UserStorage {
//     loginUser(id, password, onSuccess, onError) {
//         setTimeout(() => {
//             if(
//                 (id ==='youngsil' && password ==='1234') ||
//                 (id ==='admin' && password =='admin')
//             ) {
//                 onSuccess(id);
//             } else {
//                 onError(new Error('not found'));
//             }
//         }, 2000);
//     }

//     getRoles(user, onSuccess, onError) {
//         setTimeout(() => {
//             if(user ==='youngsil') {
//                 onSuccess({name : 'youngsil', role : 'member'});
//             } else {
//                 onError(new Error('no access'));
//             }
//         }, 2000);
//     }
// }

// //사용자에게 id,password를 입력받아온다.
// //로그인 시도
// //역할 요청

// const storage = new UserStorage();
// const id = prompt('enter your id');
// const password = prompt('enter your password');
// const user = storage.loginUser(
//     id, 
//     password, 
//     user => {
//         storage.getRoles(
//             user,
//             userWithRole => {
//                 alert(`Hello ${userWithRole.name}, role : ${userWithRole.role}`)
//             },
//             error => console.log(error)
//             )
//     },
//      error => console.log(error)
//      );
// //const inf = storage.getRoles(user, ({}) =>  )


class Backend {
    login(id, password, onSuccess, onError) {
        //비동기 실행
        setTimeout(function() {
            if(id==='youngsil' && password ==='1234') {
                onSuccess(id);
            } else {
                onError(new Error('not found'));
            }
        }, 2000);
    };
    
    getRole(id, onSuccess, onError) {
        setTimeout(function() {
            if(id === 'youngsil') {
                onSuccess({name : id, role : 'member'});
            } else {
                onError(new Error('no access'));
            }
        }, 2000);
    }
}

const backend = new Backend();
const id = prompt('enter your id');
const password = prompt('enter your password');

backend.login(
    id, 
    password,
    id => {
        backend.getRole(
            id,
            (idWithRole) => {
                alert(`name : ${idWithRole.name}, role : ${idWithRole.role}`);
            },
            error => console.log(error)
        )
    },
    error => console.log(error)
);