package assignments.SoftCon2020_Assignment_5.Airport_Shuttle_Service;

import assignments.SoftCon2020_Assignment_4.BackendTechnician;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void rideFamilyCar() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        // So, you can normally call,
        Vehicle family_car = new FamilyCar();
        ShuttleOffice shuttleOffice = ShuttleOffice.getInstance();
        ShuttleOffice.Customer c = shuttleOffice.createCustomer(family_car, "12/03/2021");
        shuttleOffice.rideCustomer(c);

        String expectedOutput  = ("Family car; one small and one large bag; normal speed; 15 CHF/h").replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString().trim());

    }
    @Test
    void rideMicroCar() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        // So, you can normally call,
        Vehicle microCar = new MicroCar();
        ShuttleOffice shuttleOffice = ShuttleOffice.getInstance();
        ShuttleOffice.Customer c = shuttleOffice.createCustomer(microCar, "12/03/2021");
        shuttleOffice.rideCustomer(c);


        String expectedOutput  = "Micro car; one bag; normal speed; 12 CHF/h".replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString().trim());

    }
    @Test
    void rideSuperCar() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        // So, you can normally call,
        Vehicle superCar = new SuperCar();
        ShuttleOffice shuttleOffice = ShuttleOffice.getInstance();
        ShuttleOffice.Customer c = shuttleOffice.createCustomer(superCar, "12/03/2021");
        shuttleOffice.rideCustomer(c);


        String expectedOutput  = "Super car; two small and two large bags; fast speed; 30 CHF/h".replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString().trim());

    }
    @Test
    void rideBus() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        // So, you can normally call,
        Vehicle bus = new Bus();
        ShuttleOffice shuttleOffice = ShuttleOffice.getInstance();
        ShuttleOffice.Customer c = shuttleOffice.createCustomer(bus, "12/03/2021");
        shuttleOffice.rideCustomer(c);


        String expectedOutput  = "Bus; no luggage restrictions; slow speed; 5 CHF/h".replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString().trim());

    }

}