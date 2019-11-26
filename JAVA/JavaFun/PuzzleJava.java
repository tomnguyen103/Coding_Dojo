import java.util.ArrayList;
import java.util.Collections;

/**
 * PuzzleJava
 */
public class PuzzleJava {
    public static int Sum(int[] arr) {
        int sum=0;
        for(int element: arr){
            sum += element;
        }
        return sum;
    }

    public static ArrayList<Integer> GreaterThan10(int[] arr){
        ArrayList<Integer> newArr = new ArrayList<>();
        for(int i =0; i< arr.length; i++){
            if(arr[i]>10){
                newArr.add(arr[i]);
            }
        }
        return newArr;
    }

    public static void LongerThan5(String[] strArr) {
        ArrayList<String> newStr = new ArrayList<>();
        ArrayList<String> newStr2 = new ArrayList<>();

        for(int i = 0; i<strArr.length; i++){
            if(strArr[i].length()>5){
                newStr2.add(strArr[i]);
            }
            newStr.add(strArr[i]);
        }
        Collections.shuffle(newStr);
        System.out.println(newStr);
        System.out.println(newStr2);
    }

    public static void ShuffleLetter(String[] arr){
        ArrayList<String> newStr = new ArrayList<>();
        ArrayList<String> newStr2 = new ArrayList<>();
        
    }


    public static void main(String[] args) {
        // int[] arr = {3,5,1,2,7,9,8,13,25,32};
        // System.out.println(Sum(arr));
        // System.out.println(GreaterThan10(arr));

        String[] strArr = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        LongerThan5(strArr);
    }
}