var obj = {
    someProb: 'some val',
    someOtherProp: 'some other val',
}

console.log("this is the prototype of an object literal " + obj.prototype);

var keyName = 'someProb';

console.log(obj[keyName])

/////////////////////////////
function HumanContructor(first,last,color){
    return {
        firstName: first,
        lastName: last,
        favoriteColor: color,
        sayName: function(){
            console.log("Hi, my name is " +this.firstName + " " + this.lastName);
        }
    };
}

var tom = HumanContructor("Tom", "Nguyen", "yellow");

console.log(tom)

tom.sayName();

function Human(first,last,color){
    this.firstName = first;
    this.lastName = last;
    this.color = color;
    this.sayName = function(){
        console.log("inside the object itself");
    }
}

Human.prototype.sayName = function(){
    console.log("Hi, my name is " +this.firstName + " " + this.lastName);
}

//telling what type of object
var anthony = new Human("Anthony", "Mendoza", "purple")

// console.log(anthony)
anthony.sayName()

function HumanClass(first,last,color){
    this.first_name = first;
    this.last_name = last;
    this.color = color;
}

var miguel = new HumanClass("Miguel", "Martinez", "black");

console.log(miguel);
// miguel.sayName();

class Wizard extends HumanClass{
    constructor(first,last,color,wand){
        super(first,last,color);
        this.wand=wand;
    }

    sayMyWand(){
        console.log("My wand is " + this.wand)
    }
}

var ryan = new Wizard('Ryan', 'Billings', 'black', 'Harry Potter');

ryan.sayMyWand();
// ryan.sayName();