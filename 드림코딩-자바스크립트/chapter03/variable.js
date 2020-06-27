//1. Use strict
//added in ES 5
//use this for Valina javascript
'use strict';

//2 variable
// let (added in ES 6)
let globalName = 'global name';

{
    let name = 'ellie';
    console.log(name);
    name = 'hello';
    console.log(name);
    console.log(globalName);
}
console.log(name);
console.log(globalName);

//var hoisting 문제 때문에 var을 사용하지 않는다.


// 3. Contants
// -security
// -thread safety
// -reduce numan mistakes
const dayInWeek = 7;
const maxNumber =5;


// 4. Variable type
// - primitive, single item : number, string, boolean, null, undefind, symbol
// - single 여러개가 묶인 형태 :  Object(box container)
// - function(first-class function) : 이 언어에서는 function도 데이터 타입처럼 사용 가능하다.
//    변수에 할당, 파라미터 인자, 리턴 타입 가능

//number
const count = 17;
const size = 17.1;
console.log(`value : ${count}, type : ${typeof count}`);
console.log(`value : ${size}, type : ${typeof size}`);


//number exception
const infinity = 1/0;
const negativeInfinity = -1/0;
const nAn = 'not a number' / 2;
console.log(infinity);
console.log(negativeInfinity);
console.log(nAn);

//bigInt
const bigInt = 12345678901234567890123456789012345678901234567890n;
console.log(`value : ${bigInt}, type : ${typeof bigInt}`);

//string
const char = 'c';
const brendan = 'brendan';
const greeting = 'hello' + brendan;
console.log(`value : ${greeting}, type : ${typeof greeting}`);
const helloBob = `hi ${brendan}!`;
console.log(`value : ${helloBob}, type : ${typeof helloBob}`);


///boolean
const canRead = true;
const test = 3 < 1;
console.log(`value : ${canRead}, type : ${typeof canRead}`);
console.log(`value : ${test}, type : ${typeof test}`);


//null, undifind (사용자가 일부러 null을 준것과 기본의 차이)
let nothing = null;
let x;

//symbol : 고유한 식별자가 필요한 경우, 우선순위를 주고 싶을 때 사용
const symbol1 = Symbol('id');
const symbol2 = Symbol('id');
console.log(symbol1 == symbol2);

const symbol3 = Symbol.for('id');
const symbol4 = Symbol.for('id');
console.log(symbol3 == symbol4);
console.log(`value : ${symbol1.description}, type : ${typeof symbol1}`);

//Object
const youngsil = {name : 'youngsi', age : 27};

// 5.Dynamic typing : 타입이 할당된 값에 따라서 동적으로 변환
let text = 'hello';
console.log(`value : ${text}, type : ${typeof text}`);
text = 1;
console.log(`value : ${text}, type : ${typeof text}`);
text = '7' + 5;
console.log(`value : ${text}, type : ${typeof text}`);
text = '8' / '2';
console.log(`value : ${text}, type : ${typeof text}`);