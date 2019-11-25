import java.util.Scanner;
public class FizzBuzzTest{
    public static void main(String[] args) {
        FizzBuzz fizzbuzz = new FizzBuzz();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int fb = input.nextInt();
        String ans = fizzbuzz.fizzBuzz(fb);
        System.out.println(ans);
        input.close();
    }
}