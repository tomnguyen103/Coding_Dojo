//1. Biggie Size 
function biggieSize(arr) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] > 0) {
            arr[i] = "big";
        }
    }
    return arr;
}

//console.log(biggieSize([-1, 3, -5, 2]));

//2.Print Low, Return High
function printLowreturnHigh(arr) {
    var low = arr[0];
    var high = arr[arr.length - 1];
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] < low) {
            low = arr[i];
        }
        if (arr[i] > high) {
            high = arr[i];
        }
    }
    console.log(low);
    return high;
}

//printLowreturnHigh([1, 2, 3, 4, 5, 6]);

//3.Print One, Return Another
function printOneReturnAnother(arr) {
    console.log(arr[arr.length - 2]);
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] % 2 !== 0) {
            return arr[i];
        }
    }
}

//console.log(printOneReturnAnother([2, 2, 4, 5, 6, 7, 8]));

//4. Double Vision
function doubleVision(arr) {
    var newArr = [];
    for (var i = 0; i < arr.length; i++) {
        newArr[i] = arr[i] * 2;
    }
    return newArr;
}

//console.log(doubleVision([4, 5, 6]));

//5.Count Positives
function countPos(arr) {
    var numPos = 0;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] > 0) {
            numPos++;
        }
    }
    arr[arr.length - 1] = arr[numPos];
    return arr;
}

//console.log(countPos([-1, 3, 5, 3, -9]));

//6.Evens and Odds
function evenOdd(arr) {
    var evenCounter = 0;
    var oddCounter = 0;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] % 2 === 0) {
            evenCounter++;
            if (evenCounter === 3) {
                console.log("Even so more!");
            }
        }
        if (arr[i] % 2 !== 0) {
            oddCounter++;
            if (oddCounter === 3) {
                console.log("That's odd!");
            }
        }
    }
}

// evenOdd([1, 3, 5, 8, 2]);
// evenOdd([1, 3, 8, 8, 2]);

//7. Increment the Seconds
function incrementSecond(arr) {
    for (var i = 1; i < arr.length; i += 2) {
        arr[i] = arr[i] + 1;
    }
    console.log(arr);
    return arr;

}

//incrementSecond([1, 3, 5, 6, 9, 3, 1]);

//8. Previous Lengths
function previousLengths(arr) {
    for (var i = arr.length - 1; i > 0; i--) {
        arr[i] = arr[i - 1].length;
    }
    return arr;
}

//console.log(previousLengths(["hello", "dojo", "awesome"]));

//9. Add Seven
function addSeven(arr) {
    var newArr = [];
    for (var i = 0; i < arr.length; i++) {
        newArr[i] = arr[i] + 7;
    }
    return newArr;
}

//console.log(addSeven([2, 3, 4, 5]));

//10. Reverse Array 
function reverseArray(arr) {
    var temp;
    for (var i = 0; i < Math.floor(arr.length / 2); i++) {
        temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
    }
    return arr;
}

//console.log(reverseArray([2, 3, 4, 5, 6, 7, 8, 9]));

//11.Outlook: Negative
function makeNegative(arr) {
    var newArr = [];
    for (var i = 0; i < arr.length; i++) {
        newArr[i] = arr[i] - (arr[i] * 2);
    }
    return newArr;
}

//console.log(makeNegative([3, 2, 1, 5]));

//12. Always Hungry
function alwaysHungry(arr) {
    var counter = 0;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] === 'food') {
            counter++;
            console.log('yummy');
        }
    }
    if (counter == 0) {
        console.log('I"m hungry!');
    }
}

// alwaysHungry([1, 2, 3, 4]);
// alwaysHungry(['1', '2', '3', 'food']);

//13.Swap Toward the Center 
function swapTowardCenter(arr) {
    var temp = 0;
    for (var i = 0; i < Math.floor(arr.length / 2); i++) {
        temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
    }
    return arr;
}

//console.log(swapTowardCenter([true, 2, false, 3, 4]));

//14.Scale the Array
function scaleTheArray(arr, num) {
    var newArr = [];
    for (var i = 0; i < arr.length; i++) {
        newArr[i] = arr[i] * num;
    }
    return newArr;
}

//console.log(scaleTheArray([1, 2, 3, 4, 5], 3));