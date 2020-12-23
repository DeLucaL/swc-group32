package assignments.SoftCon2020_Assignment_6.Exercise_1;

import assignments.SoftCon2020_Assignment_6.Exercise_1.ObserverPattern.Observer;
import assignments.SoftCon2020_Assignment_6.Exercise_1.ObserverPattern.Subject;

import java.util.ArrayList;

public class EmployeeModel implements Subject {
    ArrayList<Employee> employees = new ArrayList<>();

    public void createEmployee(String surname, String name, String address, String number){
        Employee e = new Employee(surname, name, address, number);
        employees.add(e);
        System.out.println("Created new Employee: " + surname + " " +name);
    }

    public String printEmployee() {
        if (employees.size() >= 1) {
            Employee e = employees.get(employees.size() - 1);
            return e.surname + " " + e.name + " " + e.ID;
        }
        else{
            return "You have to create an employee first";}
    }

    public void modelUpdateAddress(String ID, String address){
        //if employee exists update
        boolean employeeExists = false;
        for (Employee e: employees){
            if (e.getID().equals(ID)){
                e.setNewAddress(address);
                employeeExists = true;
                }
            }
        notifyObserver(employeeExists);
    }

    public String modelGetAddress(String ID){
        for (Employee e: employees){
            if (e.getID().equals(ID)) {
                return e.getAddress();
            }
        }
        return "No such employee found";
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) { observers.remove(i);}
    }

    @Override
    public void notifyObserver(boolean bool) {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(bool);
        }
    }
}
