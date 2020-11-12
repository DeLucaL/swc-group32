package assignments.SoftCon2020_Assignment_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    @Test
    void createSerialNumber() {
        Customer c1 = new Customer("Meier", "Laura", 30);
        int a = c1.getID();
        Customer c2 = new Customer("S.", "M.", 30);
        int b= c2.getID();
        assertNotEquals(a, b);
    }

}