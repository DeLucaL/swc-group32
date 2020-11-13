package assignments.SoftCon2020_Assignment_4;


public class BackendTechnician extends Customer {
    public BackendTechnician(String name, String surname, int age) {
        super(name, surname, age);
    }

    /***
     * just prints "fixed" if ID is correct
     * @param id of BackendTechnician
     * @return void
     */
    public void fix_backend(int id){
        if(this.getID() == id) System.out.print("fixed!");
        else System.out.println("I think you confused me with somebody else...");
    }
}
