import java.util.Scanner;
public class PythagoreanTest{
    public static void main(String[] args) {
        Pythagorean py = new Pythagorean();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the a: ");
        int a = input.nextInt();
        System.out.println("Enter the b: ");
        int b = input.nextInt();
        int hypo = (int)py.calculateHypotenuse(a,b);
        System.out.println("Hypitenuse: " + hypo);
    }
}