import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
        // ArrayList<String> newStr2 = new ArrayList<>();
        for(char alpha = 'A'; alpha <= 'Z'; alpha++){
            newStr.add(Character.toString(alpha));
        }
        
        System.out.println(newStr);
        Collections.shuffle(newStr);
        System.out.println(newStr);
        System.out.println("First letter of the shuffled array: " + newStr.get(0));
        System.out.println("Last letter of the shuffled array: " + newStr.get(25));
    }

    public static void Random10(){
        ArrayList<Integer> newArr = new ArrayList<>();
        Random randomNum = new Random();
        for(int i=0;i<10;i++){
            int rNum = randomNum.nextInt(45)+55;
            newArr.add(rNum);
        }
        System.out.println(newArr);
        
    }

    public static void Random10Sorted(){
        ArrayList<Integer> newArr = new ArrayList<>();
        Random randomNum = new Random();
        for(int i=0;i<10;i++){
            int rNum = randomNum.nextInt(45)+55;
            newArr.add(rNum);
        }
        System.out.println(newArr);
        Collections.sort(newArr);
        System.out.println(newArr);
        System.out.println("Minimum value: " +newArr.get(0));
        System.out.println("Max value: " + newArr.get(9));
    }

    public static void RandomString(){
        
        Random randomNum = new Random();
        StringBuilder randomString = new StringBuilder();
        String allSymbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for(int i =0; i<5; i++){
            randomString.append(allSymbols.charAt(randomNum.nextInt(allSymbols.length())));
        }
        String finalStr = randomString.toString();
        System.out.println(finalStr);
    }

    public static void TenRandomString(){
        ArrayList<String> ranStr = new ArrayList<>();
        Random randomNum = new Random();
        StringBuilder randomString = new StringBuilder();
        String allSymbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for(int i=0; i<10;i++){
            for(int j =0; j<5; j++){
                randomString.append(allSymbols.charAt(randomNum.nextInt(allSymbols.length())));
            }
            String finalStr = randomString.toString();
            // System.out.println(finalStr);
            ranStr.add(finalStr);
            randomString.setLength(0);

        }

        System.out.println(ranStr);
    }


    public static void main(String[] args) {
        int[] arr = {3,5,1,2,7,9,8,13,25,32};
        System.out.println(Sum(arr));
        System.out.println(GreaterThan10(arr));

        String[] strArr = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        LongerThan5(strArr);

        ShuffleLetter(strArr);

        Random10();

        Random10Sorted();

        RandomString();

        TenRandomString();

    }
}