package assignments.SoftCon2020_Assignment_4;

public class BackendTechnician extends Customer {
    public BackendTechnician(String name, String surname, int age) {
        super(name, surname, age);
    }

    public void fix_backend(int id){
        if(this.getID() == id) System.out.print("fixed!");
        else System.out.println("I think you confused me with somebody else...");
    }
}
