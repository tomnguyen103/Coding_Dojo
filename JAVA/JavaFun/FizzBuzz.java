/**
 * FizzBuzz
 */
public class FizzBuzz {

    public String fizzBuzz(int number) {
        // String ans;

        if(number%15==0){
            return "FizzBuzz";
            // ans.concat("FizzBuzz");
        }
        else if(number%3==0){
            return "Fizz";
        }
        else if(number%5==0){
            return "Buzz";
        }
        else {
            return Integer.toString(number);
        }
        // return ans;
    }
}