package assignments.SoftCon2020_Assignment_6.Exercise_1;

import assignments.SoftCon2020_Assignment_6.Exercise_1.ObserverPattern.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements Observer {

    private final Controller controller;
    private final Model model;
    JFrame viewFrame;
    JPanel viewPanel;
    JLabel bpmLabel;
    //name
    JLabel LabelName;
    JTextField EmployeeNameTextField;
    //surname
    JLabel LabelSurname;
    JTextField EmployeeSurnameTextField;
    JButton createEmployeeButton;
    JButton getAdreessButton;
    JButton printEmployeeButton;



    public View(Controller controller, Model model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver(this);
        model.registerObserver(this);
    }

    public void createView() {
        // Create all Swing components here
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        JPanel panel = new JPanel(new GridLayout(6, 1));

        //Employee Surname
        LabelSurname = new JLabel("Enter employee surname:", SwingConstants.CENTER);
        panel.add(LabelSurname);
        EmployeeSurnameTextField = new JTextField();
        panel.add(LabelSurname);
        panel.add(EmployeeSurnameTextField);

        //Employee Name
        LabelName = new JLabel("Enter employee name:", SwingConstants.CENTER);
        panel.add(LabelName);
        EmployeeNameTextField = new JTextField();
        panel.add(EmployeeNameTextField);

        //create Employee
        createEmployeeButton = new JButton("Create Employee");
        createEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String name = EmployeeNameTextField.getText();
                String surname = EmployeeSurnameTextField.getText();
                controller.createEmployee(name, surname);
            }
        });
        panel.add(createEmployeeButton);

        //Print Employee
        printEmployeeButton = new JButton("Print Empoyee");
        printEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                controller.printEmployee();
            }
        });
        panel.add(printEmployeeButton);

        //Address
        getAdreessButton = new JButton("Get address");
        panel.add(getAdreessButton);

        //add to panel
        viewPanel.add(panel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);

        //show
        viewFrame.pack();
        viewFrame.setVisible(true);
    }

    @Override
    public void update() {

    }
}
