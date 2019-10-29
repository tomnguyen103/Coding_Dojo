class Ninja {
    constructor(name, health = 100, speed = 3, strength = 3) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.strength = strength;
        this.sayName = function () {
            console.log("My ninja name is " + this.name);
        };
        this.showStats = function () {
            console.log("Name: " + this.name + ", Heal: " + this.health + ", Speed: " + this.speed + ", Strength: " + this.strength);
        };
        this.drinkSake = function () {
            this.health = health + 10;
            console.log("Name: " + this.name + ", Heal: " + this.health + ", Speed: " + this.speed + ", Strength: " + this.strength);
        };
        this.punch = function (n) {
            if (n instanceof Ninja) {
                this.health = health - 5;
                console.log(n.name + " was punched by " + this.name + " and lost 5 Health!");
            }
        };
        this.kick = function (ni) {
            if (ni instanceof Ninja) {
                var damage = ni.strength*15;
                this.health -= damage;
                console.log(ni.name + " was kicked by " + this.name + " and lost "+ this.health + " Health!");
            }
        };
    }
}


var ninja1 = new Ninja("Tom");
ninja1.sayName();
ninja1.showStats();
ninja1.drinkSake();

var blueNinja = new Ninja("Goemon");
var redNinja = new Ninja("Bill Gates");
var thirdNinja = new Ninja("Tom")

// redNinja.punch(blueNinja);
// -> "Goemon was punched by Bill Gates and lost 5 Health!"

// blueNinja.kick(redNinja);
// -> "Bill Gates was kicked by Goemon and lost 15 Health!"
// In this case, redNinja Bill Gates lost 15 health because blueNinja Goemon has 1 point of strength
blueNinja.punch(thirdNinja);