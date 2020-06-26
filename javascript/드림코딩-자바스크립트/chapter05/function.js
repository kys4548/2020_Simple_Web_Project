'use strict'
function printHello() {
    console.log('hello');
}

printHello();



//2. type script -> java script 

function test(message) {
    return 0;
}

/*

function test(meassage : string): number {
    return 0;
}
*/


//3. Default parameter (added in ES6)
function showMessage(message, from) {
    //console.log(`${massage} by ${from}`);
}
showMessage('hi');


//4. Rest parameter (added in ES6)
function printAll(...args) {
    for(let i=0; i<args.length; i++) {
        console.log(args[i]);
    }

    for(const arg of args) {
        console.log(arg);
        
    }
    args.forEach((arg) => console.log(arg));
}

printAll('dream', 'coding', 'ellie');

let globalMessage = 'global';
function printMessage() {
    let message = 'hello';
    console.log(message);
    console.log(globalMessage);
    function printAnother() {
        console.log(message);
        let childMessage = 'child';
    }
    
    
}