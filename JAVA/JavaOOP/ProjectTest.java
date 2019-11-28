/**
 * ProjectTest
 */
public class ProjectTest {

    public static void main(String[] args) {
        Project testProject = new Project("name1", "description1", 4.99);
        testProject.setName("name2");
        testProject.setDescription("description2");
        testProject.setCost(5.99);

        System.out.println(testProject.elevatorPitch());
    }
}