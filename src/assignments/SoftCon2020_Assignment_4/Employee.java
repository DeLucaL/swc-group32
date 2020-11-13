package assignments.SoftCon2020_Assignment_4;

import java.util.ArrayList;

/***
 * <h1>Configure Employee</h1>
 * Create an Employee with different capabilities based on their level:
 * - Regular Employee
 * - Section Chief
 * - Main Chief
 */

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
        /***
         * This method creates a RegularEmployee based on the abstract class Employee and sets the supervisor
         *
         * @param name
         * @param surname
         * @param age
         * @param supervisor
         * @return void
         */
        super(name, surname, age);
        this.supervisor = supervisor;
    }

    @Override
    public void upgrade_user(int id) {
        /***
         * This method takes an user ID and upgrades the customer if found in own customer list. It can only upgrade Regular Customer to Golden Customer.
         *
         * @param id
         * @return void
         */
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
        /***
         * The Regular Employee cannot downgrade a customer therefore only prints a message, that the Employee is unauthorized.
         *
         * @param id
         * @return void
         */
        System.out.println("I am not authorized to do this, please contact my supervisor.");
    }
}


class SectionChief extends Employee {
    private final String city;

    public SectionChief(String name, String surname, int age, MainChief supervisor, String city) {
        /***
         * This method creates a Section Chief based on the abstract class Employee and sets the supervisor as well as the city in which the Employee acts.
         *
         * @param name
         * @param surname
         * @param age
         * @param supervisor
         * @param city
         * @return void
         */
        super(name, surname, age);
        this.supervisor = supervisor;
        assert !supervisor.getCities().contains(city);
        this.city = city;
        supervisor.addCity(city);
    }

    @Override
    void upgrade_user(int id) {
        /***
         * This method takes an user ID and upgrades the customer if found in own customer list. It can upgrade Regular Customer to Golden and Platinum Customer.
         *
         * @param id
         * @return void
         */
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
        /***
         * This method takes an user ID and downgrades the customer if found in own customer list. It can only downgrade Golden Customer to Regular Customer.
         *
         * @param id
         * @return void
         */
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
    private ArrayList<String> cities = new ArrayList<>();

    public MainChief(String name, String surname, int age) {
        /***
         * This method creates a Main Chief based on the abstract class Employee.
         *
         * @param name
         * @param surname
         * @param age
         * @return void
         */
        super(name, surname, age);
        this.supervisor = this;
    }

    public ArrayList<String> getCities() {
        /***
         * This method gets a MainChief and return a list with all the current cities.
         *
         * @param MainChief
         * @return ArrayList Return a list of all current cities
         */
        return cities;
    }

    public void addCity(String city) {
        /***
         * This method gets city and adds it to the ArrayList of all current cities.
         *
         * @param city
         * @return void
         */
        this.cities.add(city);
    }

    @Override
    void upgrade_user(int id) {
        /***
         * This method gets a customer by it's ID and upgrades it to every level.
         *
         * @param id
         * @return void
         */
        for(Customer customer : customers) {
            if(customer.getID() == id) {
                customer.nextLevel();
            }
        }
    }

    @Override
    void downgrade_user(int id) {
        /***
         * This method gets a customer by it's ID and downgrades it to every level.
         *
         * @param id
         * @return void
         */
        for(Customer customer : customers) {
            if(customer.getID() == id) {
                customer.previousLevel();
            }
        }
    }

    @Override
    public void add_customer(Customer c) {
        /***
         * This method gets a customer c and adds it to the customers list.
         *
         * @param c Customer
         * @return void
         */
        this.customers.add(c);
    }
}