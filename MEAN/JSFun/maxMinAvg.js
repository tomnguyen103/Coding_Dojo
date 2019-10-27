function maxMinAvg(arr){
    var min = arr[0]
    var max = arr[0]
    var sum = arr[0]

    for(var i=1; i<arr.length;i++){
        if(arr[i]<min){
            min = arr[i];
        }
        if(arr[i]>max){
            max = arr[i];
        }
        sum +=arr[i];
    }
    avg = sum / (arr.length);
    return "The minimum is " +min + ", the maximum is " + max + ", and the average is " + avg + "."
}   

console.log(maxMinAvg([1,-2,9,4]))
