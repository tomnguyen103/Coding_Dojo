function findIntersections(arrayA, arrayB) {
    var inters = [];
    Boolean found;
    for (var i in arrayA) {
        for (var j in arrayB) {
            if (i == j) {
                found = true
                inters.append(i)
            }
        }
    }

    return inters
}

arrayA = [1,1,1,2,3,5,1,7]
arrayB = [1,4,4,5,6,6,7]

findIntersections(arrayA, arrayB)
// Expected result [1,5,7]