function reverseArray(arr) {
    var newArr = [];
    for (var i = 0; i < arr.length; i++) {
        newArr.push(arr[arr.length - 1 - i]);
    }
    return newArr;
}

b = reverseArray([1, 2]);
console.log(b);

describe("reverseArray", function() {
    it("should return [5,3,1] when [1,3,5] is passed", function() {
        expect(reverseArray([1, 3, 5])).toEqual([5, 3, 1]);
    });
    it("should return [2,4,8,1] when [1,8,4,2] is passed", function() {
        expect(reverseArray([2, 4, 8, 1])).toEqual([1, 8, 4, 2]);
    });
});