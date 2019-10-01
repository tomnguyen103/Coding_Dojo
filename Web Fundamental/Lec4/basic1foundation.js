//1. Get 1 to 255
function oneto255() {
    var arr = [];
    for (var i = 1; i < 256; i++) {
        arr[i] = i
    }
    return arr;
}

//console.log(oneto255());

//2.Get even 1000
function getEven1000() {
    var sum = 0;
    for (var i = 0; i < 1001; i++) {
        if (i % 2 == 0) {
            sum += i;
        }
    }
    return sum;
}

//console.log(getEven1000());

//3.Sum odd 5000
function sumOdd5000() {
    var sum = 0;
    for (var i = 0; i < 50001; i++) {
        if (i % 2 !== 0) {
            console.log(i);
            sum += i;
        }
    }
    return sum;
}

//console.log(sumOdd5000());

//4.Iterate an array
function sumArray(arr) {
    var sum = 0;
    for (var i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    return sum;
}

//console.log(sumArray([1, 2, 34, 5]));

//5.Find max

function findMax(arr) {
    var Max = 0;
    for (var i = 0; i < arr.length; i++) {
        if (Max < arr[i]) {
            Max = arr[i];
        }
    }
    return Max;
}

//console.log(findMax([4, 5, 3, 9, 12, 8]));

//6.Find average

function findAvg(arr) {
    var avg, sum = 0;
    for (var i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    avg = sum / arr.length;
    return avg;
}

//console.log(findAvg([4, 5, 3, 7, 2, 3]));

//7.Array odd 

function arrayOdd1to50() {
    var result = [];
    for (var i = 0; i < 51; i++) {
        if (i % 2 !== 0) {
            result.push(i);
        }
    }
    return result;
}

//console.log(arrayOdd1to50());

//8.Greater than Y

function greaterThanY(arr, y) {
    var counter = 0;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] > y) {
            counter++;
        }
    }
    return counter;
}

//console.log(greaterThanY([1, 3, 5, 6, 7], 4));

//9. Squares
function squaresArray(arr) {
    var newArr = [];
    for (var i = 0; i < arr.length; i++) {
        newArr[i] = arr[i] * arr[i];
    }
    return newArr;
}

//console.log(squaresArray([1, 5, 3, 2]));

//10. Negatives
function negativeNumber(arr) {
    var newArr = [];
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] < 0) {
            arr[i] = 0;
        }
        newArr[i] = arr[i];
    }
    return newArr;
}

//console.log(negativeNumber([3, 5, -9, 30, -98]));

//11. Max/Min/Avg
function maxMinAve(arr) {
    var newArr = [];
    var max = arr[0];
    var min = arr[0];
    var avg = 0;
    var sum = 0;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] < min) {
            min = arr[i];
        }
        if (arr[i] > max) {
            max = arr[i];
        }
        sum += arr[i];
        avg = sum / arr.length;
    }
    newArr = [min, max, avg];
    return newArr;
}

//console.log(maxMinAve([3, 6, 6]));

//12. Swap Values
function swapValues(arr) {
    if (arr.length < 2) {
        console.log("Array is too short!");
    } else {
        [arr[0], arr[arr.length - 1]] = [arr[arr.length - 1], arr[0]];
    }
    return arr;
}

//console.log(swapValues([3, 5, 6, 4, 2]));

//13. Number to String
function numberString(arr) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] < 0) {
            arr[i] = 'Dojo';
        }
    }
    return arr;
}

//console.log(numberString([2, 4, -9, 2, -8]));