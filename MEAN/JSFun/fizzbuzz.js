function fizzbuzz(n){
    var newArr=[]
    if(typeof(n) !== 'number'){
        console.log("Parameter must be a positive number");
        return null;
    }
    else{
        for(var i=1; i<n+1;i++){
            if(i%15==0){
                console.log("FizzBuzz");
                newArr.push("FizzBuzz")
            }
            else if(i%3==0){
                console.log("Fizz")
                newArr.push("Fizz")
            }
            else if(i%5==0){
                console.log("Buzz")
                newArr.push("Buzz")
            }
            else {
                console.log(i)
                newArr.push(i);
            }
        }
        return newArr;
    }
}

console.log(fizzbuzz(15))
console.log(fizzbuzz('fifteen'))
