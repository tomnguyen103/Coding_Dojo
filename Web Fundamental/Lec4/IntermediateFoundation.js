//Part 1
//1. Sigma
function sumSigma(num) {
    var sum = 0;
    for (var i = 0; i <= num; i++) {
        sum += i;
    }
    return sum;
}

//console.log(sumSigma(5));

//2. Factorial
function productFactorial(num) {
    var product = 1;
    for (var i = 1; i <= num; i++) {
        product *= i;
    }
    return product;
}

//console.log(productFactorial(3));


//3. Fibonacci
function fibonacciNumber(num) {
    if (num <= 1) {
        return num;
    }

    return fibonacciNumber(num - 1) + fibonacciNumber(num - 2);
}

//console.log(fibonacciNumber(7));

//4. Array: Second-to-Last
function secondToLast(arr) {
    if (arr.length <= 2) {
        return null;
    } else {
        return arr[arr.length - 2];
    }
}

//console.log(secondToLast([1, 2, 'Liam', 4]));
//console.log(secondToLast([1, 2]));

//5. Array: Nth-to-Last
function arrayNthToLast(arr, n) {
    if (arr.length <= 2) {
        return null;
    } else {
        return arr[n];
    }
}

//console.log(arrayNthToLast([1, 2, 3, 4, 5, 6, 7], 3));

//6. Array: Second-Largest
function arraySecondLargest(arr) {
    var secondLargest;
    arr.sort();
    if (arr.length <= 2) {
        return null;
    } else {
        secondLargest = arr[arr.length - 2];
    }
    return secondLargest;
}

//console.log(arraySecondLargest([1, 7, 2, 4, 5, 6, 3]));

//7. Double Trouble
function doubleTrouble(arr) {
    var newArr = [];
    for (var i = 0; i < arr.length; i++) {
        newArr.push(arr[i]);
        newArr.push(arr[i]);
    }
    return newArr;
}

//console.log(doubleTrouble([1, 2, 3, 4, 5, 6, 7]));

//Part 2