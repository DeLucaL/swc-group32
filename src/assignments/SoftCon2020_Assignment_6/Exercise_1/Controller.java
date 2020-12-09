package assignments.SoftCon2020_Assignment_6.Exercise_1;

import assignments.SoftCon2020_Assignment_6.Exercise_1.ObserverPattern.Observer;

public class Controller implements Observer {
    EmployeeModel model;
    View view;
    Employee lastCreatedEmployee;

    public Controller(EmployeeModel model) {
        this.model = model;
        view = new View(this, model);
        view.createView();
        //view.createControls();
        //view.disableStopMenuItem();
        //view.disableStartMenuItem();
    }

    public boolean updateAddress(String ID){
        return model.updateAddress(ID);
    }
    @Override
    public void update() {

    }

    public void createEmployee(String surname, String name, String address, String number) {
        //create a new Employee
        model.createEmployee(surname, name, address, number);
    }

    public void printEmployee() {
        view.updatePrintLabel(model.printEmployee());
    }
}
