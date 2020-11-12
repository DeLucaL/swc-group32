package assignments.SoftCon2020_Assignment_4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class main {
    public static void main(String[] args){
        Customer c = new Customer("Meier", "Sabine", 40);
        int ID = c.getID();
        System.out.println(ID);
        c.deposit(400);

        Employee e = new MainChief("Hauser", "Frank", 123);
        e.add_customer(c);
        e.upgrade_user(122);
        String lc = c.getLevel();
        System.out.println(lc);

    }
}

