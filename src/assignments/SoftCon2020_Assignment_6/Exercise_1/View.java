package assignments.SoftCon2020_Assignment_6.Exercise_1;

import assignments.SoftCon2020_Assignment_6.Exercise_1.ObserverPattern.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements Observer {

    private final Controller controller;
    private final EmployeeModel model;
    JFrame viewFrame;
    JFrame viewFrameAddress;
    JPanel panelAddress;
    JPanel panel;
    JLabel emptyLabel;
    JLabel emptyLabelA;
    JLabel printLabel;
    JTextField newAdressTextField;
    JTextField IDTextField;
    JLabel newAdressFeedbackLabel;
    //name
    JLabel LabelName;
    JTextField EmployeeNameTextField;
    //surname
    JLabel LabelSurname;
    JTextField EmployeeSurnameTextField;
    JButton createEmployeeButton;
    JButton updateAdreessButton;
    JButton printEmployeeButton;



    public View(Controller controller, EmployeeModel model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver(this);
        model.registerObserver(this);
    }

    public void createView() {
        //Create Employee View
        viewFrame = new JFrame("Create Employee");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(1000, 800));
        panel = new JPanel(new GridLayout(8, 2));

        //Employee Surname
        JLabel LabelSurname = new JLabel("Enter employee surname:", SwingConstants.CENTER);
        panel.add(LabelSurname);
        JTextField EmployeeSurnameTextField = new JTextField();
        panel.add(EmployeeSurnameTextField);

        //Employee Name
        JLabel LabelName = new JLabel("Enter employee name:", SwingConstants.CENTER);
        panel.add(LabelName);
        JTextField EmployeeNameTextField = new JTextField();
        panel.add(EmployeeNameTextField);

        //Employee address
        JLabel LabelAddress = new JLabel("Enter employee address:", SwingConstants.CENTER);
        panel.add(LabelAddress);
        JTextField AddressTextField = new JTextField();
        panel.add(AddressTextField);

        //Employee telephone number
        JLabel LabelPhoneNumber = new JLabel("Enter employees phone number:", SwingConstants.CENTER);
        panel.add(LabelPhoneNumber);
        JTextField PhoneNumberTextField = new JTextField();
        panel.add(PhoneNumberTextField);

        //create Employee
        createEmployeeButton = new JButton("Create Employee");
        createEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String name = EmployeeNameTextField.getText();
                String surname = EmployeeSurnameTextField.getText();
                String address = AddressTextField.getText();
                String number = PhoneNumberTextField.getText();
                if (!name.equals("") && !surname.equals("") && !address.equals("")  && !number.equals(""))
                {controller.createEmployee(surname, name, address, number);}
                else {System.out.println("All fields must not be empty");}
            }
        });
        panel.add(createEmployeeButton);

        //Empty label
        emptyLabel = new JLabel("", SwingConstants.CENTER);
        panel.add(emptyLabel);

        //Print Employee
        printEmployeeButton = new JButton("Print Empoyee");
        printEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                controller.printEmployee();
            }
        });
        panel.add(printEmployeeButton);

        //Empty label
        printLabel = new JLabel("", SwingConstants.CENTER);
        panel.add(printLabel);


        //ADDRESS VIEW

        //Address View
        viewFrameAddress = new JFrame("Update Address");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(1000, 800));
        panelAddress = new JPanel(new GridLayout(8, 2));

        //ID
        JLabel LabelID = new JLabel("Enter employee ID:", SwingConstants.CENTER);
        panelAddress.add(LabelID);
        IDTextField = new JTextField();
        panelAddress.add(IDTextField);

        //New Address
        JLabel newAdressLabel = new JLabel("Enter new Address:", SwingConstants.CENTER);
        panelAddress.add(newAdressLabel);
        newAdressTextField = new JTextField();
        panelAddress.add(newAdressTextField);


        //UpdateAddress
        updateAdreessButton = new JButton("Update address");
        updateAdreessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //update address of employee
                controller.ifEmployeeExistsUpdate(IDTextField.getText(), newAdressTextField.getText());
            }
        });
        panelAddress.add(updateAdreessButton);

        //New Address Feedback Label
        newAdressFeedbackLabel = new JLabel("", SwingConstants.CENTER);
        panelAddress.add(newAdressFeedbackLabel);

        //Empty label
        emptyLabelA = new JLabel("", SwingConstants.CENTER);
        panelAddress.add(emptyLabelA);

        //Print label
        printLabel = new JLabel("", SwingConstants.CENTER);

        //add panel to frame
        viewFrame.getContentPane().add(panel, BorderLayout.CENTER);
        viewFrameAddress.getContentPane().add(panelAddress, BorderLayout.CENTER);

        //show
        viewFrame.pack();
        viewFrame.setVisible(true);
        viewFrameAddress.pack();
        viewFrameAddress.setVisible(true);
    }
    public void updatePrintLabel(String str){
        printLabel.setText(str);
        panel.add(printLabel);
        System.out.println(str);
        viewFrame.pack();
        viewFrame.setVisible(true);
    }

    public void updateAddressLabel(boolean bool){
        if (bool) {
            newAdressFeedbackLabel.setText("Successfully updated");
        }
        else {newAdressFeedbackLabel.setText("Employee not found");}
    }

    @Override
    public void update(boolean bool) {
        updateAddressLabel(bool);
    }
}
