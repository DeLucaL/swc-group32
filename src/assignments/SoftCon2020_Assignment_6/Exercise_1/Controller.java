package assignments.SoftCon2020_Assignment_6.Exercise_1;

import assignments.SoftCon2020_Assignment_6.Exercise_1.ObserverPattern.Observer;

public class Controller implements Observer {
    Model model;
    View view;
    Employee lastCreatedEmployee;

    public Controller(Model model) {
        this.model = model;
        view = new View(this, model);
        view.createView();
        //view.createControls();
        //view.disableStopMenuItem();
        //view.disableStartMenuItem();
    }
    @Override
    public void update() {

    }

    public void createEmployee(String name, String surname) {
        //create a new Employee
        System.out.println("created new Employee "+ surname +" " + name);
        lastCreatedEmployee = new Employee(surname, name);
    }

    public void printEmployee() {
        lastCreatedEmployee.printEmployee();
    }
}
