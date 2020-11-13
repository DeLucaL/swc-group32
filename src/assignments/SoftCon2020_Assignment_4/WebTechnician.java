package assignments.SoftCon2020_Assignment_4;

import java.util.concurrent.TimeUnit;

public class WebTechnician extends Customer {

    public WebTechnician(String name, String surname, int age) {
        super(name, surname, age);
    }

    /***
     * This method throws an Interrupted Exception were one has to wait for 30 seconds
     * before it prints that the reparations are complete
     * @throws InterruptedException
     */
    public void fix_website() throws InterruptedException {
        TimeUnit.SECONDS.sleep(30);
        System.out.print("reparations complete");
    }
}
