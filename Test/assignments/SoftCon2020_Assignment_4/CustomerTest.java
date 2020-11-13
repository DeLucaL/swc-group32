package assignments.SoftCon2020_Assignment_4;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    /***
     * This methods set a customer to his previous level.
     * @param
     * @return void
     */
    @org.junit.jupiter.api.Test
    void previousLevel() {
        Customer c = new Customer("Meier", "Laura", 30);
        Employee e = new MainChief("D.", "S.", 44);
        e.add_customer(c);
        e.upgrade_user(c.getID());
        e.downgrade_user(c.getID());
        String lc = c.getLevel();
        String expected = "Regular Customer";
        String actual = c.getLevel().toString();
        assertEquals(expected, actual);
    }

    /***
     * This methods set a customer to his next level.
     * @param
     * @return void
     */
    @org.junit.jupiter.api.Test
    void nextLevel() {
        Customer c = new Customer("Meier", "Laura", 30);
        Employee e = new MainChief("D.", "S.", 44);
        e.add_customer(c);
        e.upgrade_user(c.getID());
        String lc = c.getLevel();
        String expected = "Golden Customer";
        String actual = c.getLevel().toString();
        assertEquals(expected, actual);
    }

    /***
     * This methods set a customer to his next level.
     * @param
     * @return void
     */
    @org.junit.jupiter.api.Test
    void deposit() {
        Customer c = new Customer("Meier", "Laura", 30);
        c.deposit(300);
        int expected = 300;
        int actual = c.getSavings();
        assertEquals(expected, actual);
    }
    /***
     * This methods set a customer to his next level.
     * it takes as a parameter int money
     * it returns
     */
    @org.junit.jupiter.api.Test
    void withdraw1() {
        Customer c = new Customer("Meier", "Laura", 30);
        c.deposit(300);
        int expected = 200;
        int actual = c.withdraw(200);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void withdraw2() {
        Customer c = new Customer("Meier", "Laura", 30);
        c.deposit(300);
        int expected = 0;
        int actual = c.withdraw(400);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void paying_with_bank_transfer1() {
        Customer c = new Customer("Meier", "Laura", 30);
        c.deposit(300);
        c.paying_with_bank_transfer(200);
        int expected = 100;
        int actual = c.getSavings();
        assertEquals(expected, actual);
    }

    void paying_with_bank_transfer2() {
        Customer c = new Customer("Meier", "Laura", 30);
        c.deposit(300);
        c.paying_with_bank_transfer(350);
        int expected = 300;
        int actual = c.getSavings();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void paying_by_credit_card1() {
        Customer c = new Customer("Meier", "Laura", 30);
        c.deposit(300);
        c.paying_by_credit_card(200);
        int expected = 100;
        int actual = c.getSavings();
        assertEquals(expected, actual);
    }
    void paying_by_credit_card2() {
        Customer c = new Customer("Meier", "Laura", 30);
        c.deposit(300);
        c.paying_by_credit_card(400);
        int expected = -100;
        int actual = c.getSavings();
        assertEquals(expected, actual);
    }
}