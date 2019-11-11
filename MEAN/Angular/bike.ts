class Bike{
    price: number;
    max_speed: string;
    miles: number;

    constructor(price: number, max_speed: string){
        this.price = price;
        this.max_speed = max_speed;
    }
    displayInfo= ()=>{
        return console.log('Price is $' + this.price + ', max speed is '+ this.max_speed + ', miles is '+ this.miles);
    }
    ride= () => {
        this.miles = this.miles + 10;
        console.log('Riding');
        return this;
    }
    reverse = ()=>{
        if(this.miles >= 5){
            this.miles = this.miles - 5;
        }
        console.log("Reversing");
        return this;
    }
}

let firstBike = new Bike(250, '25mph');
firstBike.ride().ride().ride().reverse().displayInfo();

let secondBike = new Bike(300, '20mph');
secondBike.ride().ride().reverse().reverse().displayInfo();

let thirdBike = new Bike(350, '50mph')
thirdBike.reverse().reverse().reverse().displayInfo();