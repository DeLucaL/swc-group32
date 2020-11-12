package assignments.SoftCon2020_Assignment_4;

import java.util.ArrayList;

public abstract class Employee extends Customer {
    protected ArrayList<Customer> customers = new ArrayList<>();
    protected Employee supervisor;

    protected Employee(String name, String surname, int age) {
        super(name, surname, age);
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void add_customer(Customer c) {
        this.customers.add(c);
        this.supervisor.add_customer(c);
    }

    abstract void upgrade_user(int id);
    abstract void downgrade_user(int id);
}

class RegularEmployee extends Employee {

    public RegularEmployee(String name, String surname, int age, SectionChief supervisor) {
        super(name, surname, age);
        this.supervisor = supervisor;
    }

    @Override
    public void upgrade_user(int id) {
        boolean found = false;
        for (Customer customer : customers) {
            if(customer.getID() == id) {
                found = true;
                if(customer.getLevel().equals("Regular Customer")) customer.nextLevel();
                else System.out.println("I am not authorized to do this, please contact my supervisor.");
            }
        }
        if(!found) System.out.println("It seams like I am not responsible for this customer");
    }

    @Override
    public void downgrade_user(int id) {
        System.out.println("I am not authorized to do this, please contact my supervisor.");
    }
}


class SectionChief extends Employee {
    private final String city;

    public SectionChief(String name, String surname, int age, MainChief supervisor, String city) {
        super(name, surname, age);
        this.supervisor = supervisor;
        assert !supervisor.getCities().contains(city);
        this.city = city;
        supervisor.addCity(city);
    }

    @Override
    void upgrade_user(int id) {
        boolean found = false;
        for(Customer customer : customers) {
            if(customer.getID() == id) {
                found = true;
                customer.nextLevel();
            }
        }
        if(!found) System.out.println("It seams like I am not responsible for this customer");
    }

    @Override
    void downgrade_user(int id) {
        boolean found = false;
        for(Customer customer : customers) {
            if(customer.getID() == id) {
                found = true;
                if(customer.getLevel().equals("Golden Customer")) customer.previousLevel();
                else System.out.println("I am not authorized to do this, please contact my supervisor.");
            }
        }
        if(!found) System.out.println("It seams like I am not responsible for this customer");
    }
}

class MainChief extends Employee {
    private ArrayList<String> cities;

    public MainChief(String name, String surname, int age) {
        super(name, surname, age);
        this.supervisor = this;
    }

    public ArrayList<String> getCities() {
        return cities;
    }

    public void addCity(String city) {
        this.cities.add(city);
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

    @Override
    public void add_customer(Customer c) {
        this.customers.add(c);
    }
}