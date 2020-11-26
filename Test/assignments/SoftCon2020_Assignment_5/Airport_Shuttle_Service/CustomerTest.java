package assignments.SoftCon2020_Assignment_5.Airport_Shuttle_Service;

import assignments.SoftCon2020_Assignment_4.BackendTechnician;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void rideFamilyCar() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        // So, you can normally call,
        Vehicle family_car = new FamilyCar();
        Customer c = new Customer(family_car);
        c.ride();

        String expectedOutput  = "Family car; one small and one large bag; normal speed; 15 CHF/h";

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());

    }
    void rideMicroCar() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        // So, you can normally call,
        Vehicle family_car = new FamilyCar();
        Customer c = new Customer(family_car);
        c.ride();

        String expectedOutput  = "Micro car; one bag; normal speed; 12 CHF/h";

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());

    }
    void rideSuperCar() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        // So, you can normally call,
        Vehicle family_car = new FamilyCar();
        Customer c = new Customer(family_car);
        c.ride();

        String expectedOutput  = "Super car; two small and two large bags; fast speed; 30 CHF/h";

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());

    }
    void rideBus() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        // So, you can normally call,
        Vehicle family_car = new FamilyCar();
        Customer c = new Customer(family_car);
        c.ride();

        String expectedOutput  = "Bus; no luggage restrictions; slow speed; 5 CHF/h\n";

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());

    }

}