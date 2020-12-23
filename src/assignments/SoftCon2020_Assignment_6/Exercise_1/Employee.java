package assignments.SoftCon2020_Assignment_6.Exercise_1;

import java.util.Random;

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
    private String createID(){
        Random r = new Random();
        String str = "";
        for (int i = 0; i < 4; i++) {
            str += String.valueOf(r.nextInt(10));
            str += (char)(r.nextInt(26) + 'a');
        }
        return str;

    }

    public void printEmployee(){
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
