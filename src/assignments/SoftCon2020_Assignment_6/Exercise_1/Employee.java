package assignments.SoftCon2020_Assignment_6.Exercise_1;

public class Employee {
    String name;
    String surname;
    String address;
    String telephone_number;
    String ID;

    public Employee(String name, String surname, String address, String telephone_number){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone_number = telephone_number;
        this.ID = createID();
    }

    /***
     * @return a sequence of 8 characters or numbers
     */
    private String createID(){ //TODO: make ID unique
        //example
        return "1dslie45";
    }

    public void printEmployee(){ //TODO: print all Infos
        System.out.println(surname+name+ID);
    }

    //getters
    public String getID(){
        return ID;
    }

    public String getAddress(){
        return address;
    }

    //setters
    public void setNewAddress(String newAddress){
        address = newAddress;
    }
}
