package assignments.SoftCon2020_Assignment_4;

public class BackendTechnician extends Person {
    public BackendTechnician(String name, String surname, int age) {
        super(name, surname, age);
    }

    public void fix_backend(int id){
        if(this.ID == id) System.out.println("fixed!");
        else System.out.println("I think you confused me with somebody else...");
    }
}
