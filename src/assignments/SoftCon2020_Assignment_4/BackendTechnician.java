package assignments.SoftCon2020_Assignment_4;

public class BackendTechnician extends Customer{
    public BackendTechnician(String name, String surname, int ID, int age) {
        super(name, surname, ID, age);
    }

    public void fix_backend(int id){
        System.out.println("fixed!");
    }
}
