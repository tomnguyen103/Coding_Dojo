//Chapter 1 PAGE 16
//Setting and Swapping
// Set myNumber to 42. Set myName to your name.
// Now swap myNumber into myName & vice versa.
var myNumber = 42;
var myName = 'John';
console.log('myNumber = '+myNumber);
console.log('myName = '+myName);

var temp = myNumber
var myNumber = myName;
var myName = temp;
console.log('myName now is ' + myName);
console.log('myNumber now is ' + myNumber);

//Print -52 to 1066. Print integers from - 52 to 1066 using a FOR loop.
for(var i=-52; i<1067; i++){
    console.log(i);
}

//Create beCheerful(). Within it, console.log
// string "good morning!"
// Call it 98 times.
function beCheerfull(){
    for(var i=1; i<99;i++){
        console.log("good morning");
    }    
}
console.log(beCheerfull());


//Using FOR, print multiples of 3 from -300 to 0.
// Skip - 3 and - 6
for(var i=-300;i<0;i++){
    if(i%3===0){
        if (i == -3 || i == -6) {
            continue;
        }
        console.log(i);
    }
}

//Print integers from 2000 to 5280, using a WHILE.
var i=2000;
while(i<5281){
    console.log(i);
    i++;
}

//If 2 given numbers represent your birth month and day in either order, log "How did you know ? ", else log "Just another day...."
var birthMonth = Math.floor((Math.random()*12)+1);
var birthDate = Math.floor((Math.random()*31)+1);
if(birthDate==10 || birthMonth==3){
    console.log("How did you know?");
}
else{
    console.log("Just another day...");
}

//Write a function that determines whether a given year is a leap year.If a year is divisible by four, it is a leap year, unless it is divisible by 100. However,if it is divisible by 400, then it is.
function leafYear(x){
    if((x%4==0) && (x%100==0) || (x%400==0)){
        console.log("This year is Leaf Year");
    }
    else{
        console.log("This is not a Leaf Year");
    }
}
console.log(leafYear(4000));

// Print all integer multiples of 5, from 512 to 4096.
// Afterward, also log how many there were.

for(var i = 512; i<4097; i++){
    if(i%5==0){
        console.log(i);
    }
}

//Print multiples of 6 up to 60,000, using a WHILE.
var i=0;
while(i<=60000){
    i++;
    if(i%6==0){
        console.log(i);
    }
}

// Print integers 1 to 100. If divisible by 5, print
// "Coding" instead. If by 10, also print " Dojo".

for(var i=1;i<101;i++){
    if(i%5==0 && i%10!=0){
        console.log("Coding");
    }
    if(i%10==0){
        console.log("Dojo");
        continue;
    }
    console.log(i);
}

// Your function will be given an input parameter
// incoming. Please console.log this value. 

function parameterValue(incoming){
    sum=0;
    for(var i=1;i<10;i++){
        sum+=i;
    }
    return sum;
}
console.log(parameterValue(111));

// Add odd integers from -300,000 to 300,000, and
// console.log the final sum. Is there a shortcut?
var sum;
for(var i=-300000;i<=300001; i++){
    if(i%2==1){
        sum+=i;
    }
}
console.log(sum);

// Log positive numbers starting at 2016, counting
// down by fours(exclude 0), without a FOR loop.
var i = 2016;
while(i>0){
    console.log(i);
    i = i - 4;
}

// Based on earlier “Countdown by Fours”, given
// lowNum, highNum, mult, print multiples of mult
// from highNum down to lowNum, using a FOR.
//     For(2, 9, 3), print 9 6 3(on successive lines).

function CountDown(lowNum,highNum,mult){
    for(var i=lowNum;i<highNum+1;i++){
        if(i%mult==0){
            console.log(i);
        }
    }
}
CountDown(2,9,3);

// This is based on “Flexible Countdown”.The parameter names are not as helpful, but the problem is
// essentially identical; don’t be thrown off! Given 4 parameters(param1, param2, param3, param4),
//     print the multiples of param1, starting at param2 and extending to param3.One exception: if a
// multiple is equal to param4, then skip(don’t print) it.Do this using a WHILE.Given(3, 5, 17, 9), print
// 6, 12, 15(which are all of the multiples of 3 between 5 and 17, and excluding the value 9).

function Countdown2(mult1,low,high,num1){
    while(low<high){
        if(low % mult1==0 && low!=num1){
            console.log(low);
        }
        low+=1;
    }
}

Countdown2(3,5,17,9);


//PAGE 20
// Create a function that accepts a number as an input.Return a new array that counts down by one, from
// the number(as array’s ‘zeroth’ element) down to 0(as the last element).How long is this array ? 
function countDown(number1){
    var result = [];
    for(var i=number1;i>=0;i--){
        result.push(i);
    }
    return result;
}

countDown(5);

//Your function will receive an array with two numbers. Print the first value, and return the second. 

function Array1(first,second){
    console.log(first);
    return second;
}

Array1(5,6);

// Given an array, return the sum of the first value in the array, plus the array’s length.What happens if
// the array’s first value is not a number, but a string(like "what?") or a boolean(like false). 

function Sum1(Array2){
    if(typeof Array2[0]!='number'){
        Array2[0] = 0 + Array2.length;
    }
    else{
        Array2[0] = Array2[0] + Array2.length;
    }
    console.log(Array2[0]);
    return Array2;
}

Sum1([true,2,3,5,6]);
Sum1([10,3,3]);
Sum1(['what', 29,55,33]);

//For[1, 3, 5, 7, 9, 13], print values that are greater than its 2nd value.Return how many values this is. 

function GreaterSecond(arr){
    var count = 0;
    for(var i=0;i<arr.length+1;i++){
        if(arr[i]>arr[1]){
            console.log(arr[i]);
            count++;
        }
    }
    return count;
}

GreaterSecond([1, 19, 12, 22, 33, 51, 3, 5, 7, 8]);

// Write a function that accepts any array, and returns a new array with the array values that are greater
// than its 2nd value.Print how many values this is.What will you do if the array is only one element long?

function Array1(arr){
    var arr2 =[];
    var count = 0;
    for(var i=0;i<arr.length+1;i++){
        if(arr[i]>arr[1]){
            count++;
            arr2.push(arr[i]);
        }
    }
    console.log(arr2);
    return count;
}

Array1([1, 19, 12, 22, 33, 51, 3, 5, 7, 8]);
Array1([1]);

//Given two numbers, return array of length num1 with each value num2. Print "Jinx!" if they are same.
function Array2(num1,num2){
    var newArr =[];
    if(num1 === num2){
        console.log("Jinx!");
    }
    else{
        for(i=0; i< num1.toString().length;i++){
            newArr.push(num2);
        }
    }
    return newArr;
}

Array2(33,33);
Array2(22,589);

// Your function should accept an array.If value at[0] is greater than array’s length, print "Too big!";
// if value at[0] is less than array’s length, print "Too small!"; otherwise print "Just right!". 

function Array3(arr){
    if(arr[0] > arr.length){
        console.log("Too Big!");
    }

    else if (arr[0] < arr.length) {
        console.log("Too Small!");
    }

    else{
        console.log("Just Right!");
    }
}

Array3([2,1,23]);
Array3([4,1,23,33]);
Array3([4,1,23]);

// Kelvin wants to convert between temperature scales.Create fahrenheitToCelsius(fDegrees)
// that accepts a number of degrees in Fahrenheit, and returns the equivalent temperature as expressed
//     in Celsius degrees.For review, Fahrenheit = (9 / 5 * Celsius) + 32.

function fahrenheitToCelsius(fDegrees){
    var cDegrees = 0;
    cDegrees = Math.floor((fDegrees-32)*5/9);
    return cDegrees;
}

fahrenheitToCelsius(82);

// Create celsiusToFahrenheit(cDegrees) that accepts number of degrees Celsius, and returns
// the equivalent temperature expressed in Fahrenheit degrees

function CelsiusToF(num1){
    var fDegree = 0;

    fDegree = Math.floor((num1*9/5)+32);
    return fDegree;
}

CelsiusToF(27);

// PAGE 22
// Given an array, write a function that changes all
// positive numbers in the array to “big”.Example:
// makeItBig([-1, 3, 5, -5]) returns that same
// array, changed to[-1, "big", "big", -5].

function makeItBig(arr){
    for(var i=0;i<arr.length+1;i++){
        if(arr[i]>0){
            arr[i] = 'big';
        }
    }
    return arr;
}

makeItBig([-1,3,5,-5]);

// Create a function that takes array of numbers.
// The function should print the lowest value in the
// array, and return the highest value in the array

function Array4(arr){
    var low = arr[0];
    var high = arr[0];
    for(var i=0; i<arr.length+1; i++){
        if(arr[i]<low){
            low = arr[i];
        }
        else if (arr[i]>high){
            high = arr[i];
        }
    }
    console.log(low);
    return high;
}

Array4([-1,3,5,-5]);

// Build a function that takes array of numbers.The
// function should print second - to - last value in the
// array, and return first odd value in the array.


function Array5(arr){
    for(var i=1;i<arr.length;i++){
        console.log(arr[i]);
    }
    return arr[0];
}

Array5([1,3,5,6,7,8,9]);

// Given array, create a function to return a new
//     array where each value in the original has been
// doubled.Calling double([1, 2, 3]) should
// return [2, 4, 6] without changing original.

function Array6(arr){
    newArr = [];
    for(var i=0;i<arr.length;i++){
        newArr.push(arr[i]*2);
    }
    return newArr;
}

Array6([3,5,6,2]);

// Create a function that accepts an array.Every
// time that array has three odd values in a row,
//     print "That’s odd!" Every time the array has
// three evens in a row, print "Even more so!"

function Array7(arr){
    var odds = 0;
    var evens = 0;
    for(var i=0; i<arr.length;i++){
        if(arr[i]%2==0){
            if(arr[i+1]%2==0){
                if(arr[i+2]%2==0){
                    console.log("Even More So!");
                }
            }
        }

        if (arr[i] % 2 !== 0) {
            if (arr[i + 1] % 2 !== 0) {
                if (arr[i + 2] % 2 !== 0) {
                    console.log("That's odd!");
                }
            }
        }
    }
}


Array7([1, 1, 4, 5, 6, 7]);
Array7([1,1,2,2,2,2,2,]);

Array7([1, 1, 1, 4, 5, 6, 7]);

// Given arr, add 1 to odd elements([1], [3],
//     etc.), console.log all values and return arr

function Array8(arr){
    for(var i = 0; i<arr.length; i++){
        if(i%2!==0){
            arr[i]+=1;
        }
        console.log(arr[i]);
    }
    return arr;
}

Array8([1,3,5,6,7,8,9,1]);

// You are passed an array containing strings.
// Working within that same array, replace each
// string with a number – the length of the string at
// previous array index – and return the array.

function Array9(arr){
    for(var i=0; i<arr.length+1; i++){
        if(typeof arr[i]=='string'){
            arr[i] = arr[i].length;
            console.log('string');
        }
        else{
            console.log('not a string');
        }
    }
    console.log(arr);
    return arr;
}

Array9([1,"hello", "dojo", "awesome"]);


// Build function that accepts array.Return a new
//     array with all values except first, adding 7 to
// each.Do not alter the original array.


function Array10(arr){
    var newArr = [];
    newArr.push(arr[0]);
    for(var i=1;i<arr.length;i++){
        if(typeof arr[i] == 'number'){
            newArr.push(arr[i]+7);
        }
    }
    console.log(newArr);
    return newArr;
}

Array10([1,2,3,4,5,6]);
Array10([1,2,'3',4]);

// Given array, write a function to reverse values,
// in -place.Example: reverse([3, 1, 6, 4, 2])
// returns same array, containing[2, 4, 6, 1, 3]. 

function Array11(arr){
    for(var i=0;i<Math.floor(arr.length/2); i++){
        temp = arr[i];
        arr[i] = arr[arr.length-1-i];
        arr[arr.length-1-i] = temp;
    }
    console.log(arr);
    return arr;
}

Array11([1,2,3,4,5,6]);

// Given an array, create and return a new one
// containing all the values of the provided array,
//     made negative(not simply multiplied by - 1).
//         Given[1, -3, 5], return [-1, -3, -5]. 

function Array12(arr){
    var newArr = [];
    for(var i=0;i<arr.length;i++){
        if(arr[i]<0){
            newArr.push(arr[i]*-1);
        }
        else{
            newArr.push(arr[i]);
        }
    }
    console.log(newArr);
    return newArr;
}

Array12([-2,3,5,-3]);

// Create a function that accepts an array, and
// prints "yummy" each time one of the values is
// equal to "food".If no array elements are
// "food", then print "I'm hungry" once. 

function Array13(arr){
    var counter  = 0;
    for(var i=0; i<arr.length;i++){
        if(arr[i]=='food'){
            counter++;
            console.log('yummy');
        }
        else if(arr[i]==arr[arr.length-1] && counter==0){
            console.log("I'm hungry");
        }
    }
}

Array13([1,2,3,4]);
Array13(['food',1,4,6,'food']);

// Given array, swap first and last, third and third - tolast, etc.Input[true, 42, "Ada", 2, "pizza"]
// becomes["pizza", 42, "Ada", 2, true].
//     Change[1, 2, 3, 4, 5, 6] to[6, 2, 4, 3, 5, 1].

function Array14(arr){
    for(var i=0;i<Math.floor(arr.length/2);i++){
        if(i%2==0){
            temp=arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i]= temp;
        }
    }
    console.log(arr);
    return arr;
}

Array14([1, 2, 3, 4, 5, 6,10]);
Array14([true, 42, "Ada", 2, "pizza"]);

// Given array arr and number num, multiply each
// arr value by num, and return the changed arr.

function Array15(arr, num){
    newArr = [];
    for(var i=0;i<arr.length;i++){
        newArr.push(arr[i]*num);
    }
    return newArr;
    console.log(newArr);
}

Array15([2,4,5,7,1], 3);