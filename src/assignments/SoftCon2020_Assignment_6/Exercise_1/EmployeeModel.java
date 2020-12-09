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

    public String printEmployee(){
        Employee e = employees.get(employees.size() - 1);
        return e.surname + e.name + e.ID;
    }

    public boolean updateAddress(String address){ //TODO: update Address if employee exists in ArrayList employees and notify observers, else return false
        //if employee exist update
        return true;
        //else return false
        //notify
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
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update();
        }
    }
}
