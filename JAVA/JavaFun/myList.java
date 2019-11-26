import java.util.ArrayList;

/**
 * myList
 */
public class myList {

    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("Hello World");
        myList.add(48);
        myList.add("Goodbye World!");

        for(int i = 0; i<myList.size();i++){
            Integer castedValue = (Integer) myList.get(i);
        }
    }
}