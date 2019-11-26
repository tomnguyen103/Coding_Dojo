/**
 * Cat
 */
public class Cat {

    private String name;
    private String breed;
    private int age;

    public Cat(){

    }

    public Cat(String name, String breed, int age){
        this.name = name;
        this.breed = breed;
        this.age = age;

    }

    public void attack(){
        System.out.println(this.name + " is attacking you. Run for cover.");
    }

    // public string
    //Getter
    public String getName(){
        return this.name;
    }

    // Setter
    public void setName(String name){
        this.name= name;
    }

    public String getBreed(){
        return this.breed;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }
}