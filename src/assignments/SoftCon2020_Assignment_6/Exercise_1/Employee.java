package assignments.SoftCon2020_Assignment_6.Exercise_1;

public class Employee {
    String name;
    String surname;
    //String adress;
    //String telephone_number;
    String ID;

    public Employee(String name, String surname){// String adress, String telephone_number){
        this.name = name;
        this.surname = surname;
        //this.adress = adress;
        //this.telephone_number = telephone_number;
        this.ID = createID();
    }

    /***
     * @return a sequence of 8 characters or numbers
     */
    private String createID(){
        //example
        return "1dslie45";
    }

    public void printEmployee(){
        System.out.println(surname+name+ID);
    }
}
