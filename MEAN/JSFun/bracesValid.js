function bracesValid(arr){
    var matches = {'(': ')', '{':'}', '[':']'};
    var stack=[];
    var current;

    for(var i=0;i<arr.length;i++){
        current=arr[i];

        if(matches[current]){
            stack.push(current);
        }
        else{
            if(current != matches[stack.pop()]){
                return false;
            }
        }
    }
    return true;
}

console.log(bracesValid("{{()}}[]"));
console.log(bracesValid("{(})"));