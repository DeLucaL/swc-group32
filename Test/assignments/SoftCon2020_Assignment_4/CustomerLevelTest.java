package assignments.SoftCon2020_Assignment_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerLevelTest {

    @Test
    void next() {
        Customer c = new Customer("M.", "L.", 30);
        Employee e = new MainChief("D.", "S.", 44);
        e.add_customer(c);
        e.upgrade_user(c.getID());
        String expected = "Golden Customer";
        String actual = c.getLevel().toString();
        assertEquals(expected, actual);
    }

    @Test
    void prev() {
        Customer c = new Customer("M.", "L.", 30);
        Employee e = new MainChief("D.", "S.", 44);
        e.add_customer(c);
        e.upgrade_user(c.getID());
        e.downgrade_user(c.getID());
        String expected = "Regular Customer";
        String actual = c.getLevel().toString();
        assertEquals(expected, actual);
    }
}