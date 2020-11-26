package assignments.SoftCon2020_Assignment_5.Airport_Shuttle_Service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class ShuttleOfficeTest {
    @Test
    void createCustomerWrongDateTimeFormat() {
        Vehicle bus = new Bus();
        ShuttleOffice shuttleOffice = ShuttleOffice.getInstance();
        ShuttleOffice.Customer actual = shuttleOffice.createCustomer(bus, "1221");
        assertEquals(actual, null);
    }

    @Test
    void createCustomerWrongDateTimeFormat2() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        Vehicle bus = new Bus();
        ShuttleOffice shuttleOffice = ShuttleOffice.getInstance();
        ShuttleOffice.Customer actual = shuttleOffice.createCustomer(bus, "1221");

        String expectedOutput  = ("invalid date input: Please create a customer with date format dd/MM/yyyy").replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));


        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    void createCustomerExpiredDate() {
        Vehicle bus = new Bus();
        ShuttleOffice shuttleOffice = ShuttleOffice.getInstance();
        ShuttleOffice.Customer actual = shuttleOffice.createCustomer(bus, "01/01/2020");
        assertEquals(actual, null);
    }

    @Test
    void createCustomerExpiredDate2() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        Vehicle bus = new Bus();
        ShuttleOffice shuttleOffice = ShuttleOffice.getInstance();
        ShuttleOffice.Customer actual = shuttleOffice.createCustomer(bus, "01/01/2020");

        String expectedOutput  = ("Sorry, this date has already passed").replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));


        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    void createCustomerDateDoesNotExist() {
        Vehicle bus = new Bus();
        ShuttleOffice shuttleOffice = ShuttleOffice.getInstance();
        ShuttleOffice.Customer actual = shuttleOffice.createCustomer(bus, "01/30/2021");
        assertEquals(actual, null);
    }

    @Test
    void createCustomerDateDoesNotExist2() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        Vehicle bus = new Bus();
        ShuttleOffice shuttleOffice = ShuttleOffice.getInstance();
        ShuttleOffice.Customer actual = shuttleOffice.createCustomer(bus, "01/30/2021");

        String expectedOutput  = ("invalid date input: this date does not exist").replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));


        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString().trim());
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

    @Test
    void rideNonExistingCustomer(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        Vehicle bus = new Bus();
        ShuttleOffice s = ShuttleOffice.getInstance();
        ShuttleOffice.Customer c = null;
        try {
            s.rideCustomer(c);
        } catch (NullPointerException e) {
            //expected exception
        }

        String expectedOutput = "There is no such customer";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    /*@Test
    void createInvalidCustomer(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        Vehicle bus = new Bus();
        ShuttleOffice s = ShuttleOffice.getInstance();
        ShuttleOffice.Customer c = null;
        try {
            s.createCustomer(bus, "07/03/2020");
        } catch (ParseException e) {
            //expected exception
        }

        String expectedOutput = "There is no such customer";
        assertEquals(expectedOutput, outContent.toString().trim());
    }*/
}