import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * CodeExample
 */
public class CodeExample {

    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(4);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);

        Collections.shuffle(numbers);
        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);

        Random r =  new Random();
        System.out.println(r.nextInt());
        System.out.println(r.nextInt(5));
    }
}