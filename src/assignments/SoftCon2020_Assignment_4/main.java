package assignments.SoftCon2020_Assignment_4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class main {
    public static void main(String[] args){
        Customer c = new Customer("Meier", "Sabine", 122, 40);
        c.deposit(400);

        Employee e = new RegularEmployee("Hauser", "Frank", 123, 50);
        e.add_customer(c);
        e.upgrade_user(122);
        String lc = c.getLevel();
        System.out.println(lc);

    }
}

//TODO: if customer is upgraded, does he get a new card with new numbers?
//TODO: unit-testing