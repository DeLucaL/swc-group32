package assignments.SoftCon2020_Assignment_6.Exercise_1;

public class MVCPatternDemo {
   public static void main(String[] args) {
        EmployeeModel model = new EmployeeModel();
        Controller controller = new Controller(model);
    }
}
