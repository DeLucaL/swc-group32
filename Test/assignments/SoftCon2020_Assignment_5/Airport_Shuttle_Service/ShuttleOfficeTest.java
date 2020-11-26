package assignments.SoftCon2020_Assignment_5.Airport_Shuttle_Service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ShuttleOfficeTest {
    @Test
    void createCustomerWrongInputDate() {
        Vehicle bus = new Bus();
        ShuttleOffice shuttleOffice = ShuttleOffice.getInstance();
        ShuttleOffice.Customer actual = shuttleOffice.createCustomer(bus, "1221");
        assertEquals(actual, null);
    }

    @Test
    void rideCustomer() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        Vehicle bus = new Bus();
        ShuttleOffice shuttleOffice = ShuttleOffice.getInstance();
        ShuttleOffice.Customer actual = shuttleOffice.createCustomer(bus, "1221");
        shuttleOffice.rideCustomer(actual);

        String expectedOutput  = ("invalid date input: Please create a customer with date format dd/MM/yyyy\n" +
                "There is no such customer").replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));


        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}