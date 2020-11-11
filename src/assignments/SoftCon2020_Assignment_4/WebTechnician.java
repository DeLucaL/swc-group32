package assignments.SoftCon2020_Assignment_4;

import java.util.concurrent.TimeUnit;

public class WebTechnician extends Customer {
    public WebTechnician(String name, String surname, int ID, int age) {
        super(name, surname, age);
    }

    public void fix_website() throws InterruptedException {
        TimeUnit.SECONDS.sleep(30);
        System.out.println("reparations complete");
    }
}
