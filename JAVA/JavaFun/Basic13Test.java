/**
 * Basic13Test
 */
import java.util.Arrays;
import java.util.Scanner;
public class Basic13Test {

    public static void main(String[] args) {

        Basic13 basic13 = new Basic13();

        // basic13.Print1To255();
        // basic13.PrintOddNumber();
        // basic13.PrintSum();
        
        // int[] arr = {1,2,3,4,5,6,7,8,9};
        // basic13.IteratingAnArray(arr);

        // int[] arr1 = {1,2,5,6,19,20,10};
        // int max = basic13.FindMax(arr1);
        // System.out.println(max);

        // int[] arr2 = {1,2,3,4,5};
        // basic13.Square(arr2);
        // for(int i=0;i<arr2.length;i++){
        //     System.out.println(arr2[i]);
        // }

        // int[] arr3 = {1,2,3,4,5,6,7,8,9,10};
        // basic13.ShiftArray(arr3);
        // System.out.println(Arrays.toString(arr3));
        
        int[] arr4 = {1,-2,-34,5,4,5,10};
        basic13.MaxMinAve(arr4);
        System.out.println(arr4);

        // basic13.replaceNeg(arr4);
        // System.out.println(Arrays.toString(arr4));

        // double[] arr5 = {4.5,5};
        // System.out.println(basic13.getAvg(arr5));
        
    }
}