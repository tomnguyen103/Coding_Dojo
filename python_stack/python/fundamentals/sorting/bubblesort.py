arr = [8,1,5,3,2,0,2,6,5]*1000

def bubleSort(arr):
    count = 0
    for j in range(len(arr)-1):
        # print("\n\n", "-"*50, "Iteration", j)
        for i in range(len(arr)-1-j):
            count += 1
            # print("index",i, 'value', arr[i])
            if arr[i] > arr[i+1]:
                arr[i],arr[i+1] = arr[i+1], arr[i]
                # print("swapped", arr[i], arr[i+1])
    print("# of evaluation: ", count)
    return arr

print(bubleSort(arr))