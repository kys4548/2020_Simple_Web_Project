'use strict'

class Person {
    
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    speak() {
        console.log(`${this.name} : hello!`);
        
    }
}

const p1 = new Person(`youngsil`, 27);
console.log(p1.age);
console.log(p1.name);


class User {
    //변수는 firstName, lastName, _age가 존재
    constructor(firstName, lastName, age) {
        this.firstName= firstName;
        this.lastName = lastName;
        this.age = age;
    }

    get age() {
        return this._age;
    }

    set age(value) {
        this._age = value < 0 ? 0 : value;
    }
}

const u1 = new User('youngsil', 'kim', -1);
console.log(u1.age);


//public private

class Experiment {
    publicField = 2;
    #privateField = 0;
}

const experiment = new Experiment();
console.log(experiment.publicField);
//console.log(experiment.#privateField);


class Article {
    static publisher = 'Dream Coding';
    constructor(article) {
        this.article = article;
    }

    static print() {
        console.log(Article.publisher);       
    }
}

const art1 = new Article(3);
const art2 = new Article(3);
