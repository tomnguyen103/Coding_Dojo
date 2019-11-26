/**
 * CatTest
 */
public class CatTest {
    public static void main(String[] args) {
        Cat newCat = new Cat();
        Cat otherCat = new Cat("Tito", "Lasagna Cat", 3);
        System.out.println(otherCat.getName());
        otherCat.setName("Garfield");
        System.out.println(otherCat.getName());
        
        otherCat.attack();
    }
}