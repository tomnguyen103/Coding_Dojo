class Ninja{
    constructor(name){
        this._name = name;
        this._health = 100;
        this._speed = 3;
        this._strength= 3;
    }

    sayName(){
        console.log(`My ninja name is ${this._name}!`);
    }
    showStats(){
        console.log(`Name: ${this._name} Heal: ${this._health}, Speed: ${this._speed}, Strength: ${this._strength}`);
    }
    drinkSake(){
        this._health += 10;
        // console.log(`Name: ${this._name}, Heal: ${this._health}, Speed: ${this._speed}, Strength: ${this._strength}`);
    }
}

class Sensei extends Ninja{
    constructor(name){
        super(name);
        this._health=200;
        this._speed=10;
        this._strength=10;
        this._wisdom = 10;
    }
    speakWisdom(){
        return super.drinkSake() + console.log("What one programmer can do in one month, two programmers can do in two months.")
    }
}

// example output
const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
// -> "What one programmer can do in one month, two programmers can do in two months."
superSensei.showStats();
// -> "Name: Master Splinter, Health: 210, Speed: 10, Strength: 10"
