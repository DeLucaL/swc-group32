package assignments.SoftCon2020_Assignment_4;

import java.util.ArrayList;

public abstract class Employee extends Customer {
    protected ArrayList<Customer> customers = new ArrayList<Customer>();

    protected Employee(String name, String surname, int age) {
        super(name, surname, age);
    }

    public void add_customer(Customer c) {
        customers.add(c);
    }

    abstract void upgrade_user(int id);
    abstract void downgrade_user(int id);
}

class RegularEmployee extends Employee {

    public RegularEmployee(String name, String surname, int ID, int age) {
        super(name, surname, age);
    }

    @Override
    public void upgrade_user(int id) {
        for(Customer customer : customers) {
            if(customer.getID() == id && customer.getLevel().equals("Regular Customer")) {
                customer.nextLevel();
            }
        }
    }

    @Override
    public void downgrade_user(int id) {}


}

class SectionChief extends Employee {
    String city;

    public SectionChief(String name, String surname, int ID, int age) {
        super(name, surname, age);
    }

    @Override
    void upgrade_user(int id) {
        for(Customer customer : customers) {
            if(customer.getID() == id) {
                customer.nextLevel();
            }
        }
    }

    @Override
    void downgrade_user(int id) {
        for(Customer customer : customers) {
            if(customer.getID() == id && customer.getLevel().equals("Golden Customer")) {
                customer.previousLevel();
            }
        }
    }

    void setCity(String city){
        city = city;
    }


}

class MainChief extends Employee {
    public MainChief(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    void upgrade_user(int id) {
        for(Customer customer : customers) {
            if(customer.getID() == id) {
                customer.nextLevel();
            }
        }
    }


    @Override
    void downgrade_user(int id) {
        for(Customer customer : customers) {
            if(customer.getID() == id) {
                customer.previousLevel();
            }
        }
    }
}