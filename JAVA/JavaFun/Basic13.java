import java.util.ArrayList;
import java.util.Scanner;

public class Basic13 {

    // Print 1-255
    public void Print1To255(){
        for(int i=1;i<256;i++){
            System.out.println(i);
        }
    }
    // Print odd numbers between 1-255
    public void PrintOddNumber(){
        for(int i=1; i< 256; i++){
            if(i%2==1){
                System.out.println(i);
            }
        }
    }

    // Print sum
    public void PrintSum(){
        int i = 0;
        int sum = 0;
        while (i<256){
            System.out.println("New Number: " + i + " Sum: " + sum);
            i++;
            sum += i;
        }
    }

    // Iterating through an array
    public void IteratingAnArray(int[] arr){
        for(int element: arr){
            System.out.println(element);
        }
    }

    // Find max
    public Integer FindMax(int[] arr){
        int max=arr[0];
        for(int i=0; i< arr.length; i++){
            if(max< arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    // Square the values
    public int[] Square(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i] *= arr[i];
        }
        return arr;
    }

    public int[] ShiftArray(int[] arr){
        for(int i=1; i<arr.length;i++){
            arr[i-1]= arr[i];
        }
        arr[arr.length-1] = 0;
        return arr;
    }

    public ArrayList<Double> MaxMinAve(int[] arr){
        double min = arr[0];
        double max = arr[0];
        double sum=0;
        double avg=0;
        for(int element: arr){
            if(max < element){
                max = element;
            }
            if(min > element){
                min = element;
            }
            sum += element;
            avg = sum / arr.length;
        }
        ArrayList<Double> retArr = new ArrayList<>();
        retArr.add(min);
        System.out.println(min);
        retArr.add(max);
        System.out.println(max);
        retArr.add(avg);
        System.out.println(avg);
        return retArr;
    }

    // public int[] replaceNeg(int[] arr){
    //     for(int i=0; i<arr.length; i++){
    //         if(arr[i]<0){
    //             arr[i] = 0;
    //         }
    //     }
    //     return arr;
    // }

    // public double getAvg(double[] arr){
    //     double sum= 0 ;
    //     for(int i=0;i<arr.length;i++){
    //         sum += arr[i];
    //     }
    //     double avg = sum / arr.length;
    //     return (avg);
    // }
}