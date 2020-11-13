package assignments.SoftCon2020_Assignment_4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    MainChief m = new MainChief("Müller", "Thomas", 53);
    SectionChief s = new SectionChief("Hauser", "Frank", 123, m, "Zuerich");
    RegularEmployee r = new RegularEmployee("Meyer", "Hans", 32, s);
    Customer c =  new Customer("Meier", "Sabine", 40);
    int ID = c.getID();

    //Test Regular Employee
    @Test
    void testGetSupervisor_RE() {
        assertEquals(s, r.getSupervisor());
    }
    @Test
    void testValidUpgrade_user_RE() {
        r.add_customer(c);
        r.upgrade_user(ID);
        assertEquals("Golden Customer", c.getLevel());
    }

    @Test
    void testInvalidUpgrade_user_RE() {
        r.add_customer(c);
        r.upgrade_user(ID);
        r.upgrade_user(ID);
        assertEquals("Golden Customer", c.getLevel());
    }

    //Test Section Chief
    @Test
    void testGetSupervisor_SC() {
        assertEquals(m, s.getSupervisor());
    }
    @Test
    void testValidUpgrade_user_SC_1() {
        s.add_customer(c);
        s.upgrade_user(ID);
        assertEquals("Golden Customer", c.getLevel());
    }
    @Test
    void testValidUpgrade_user_SC_2() {
        s.add_customer(c);
        s.upgrade_user(ID);
        s.upgrade_user(ID);
        assertEquals("Platinum Customer", c.getLevel());
    }
    @Test
    void testValidDowngrade_user_SC() {
        s.add_customer(c);
        s.upgrade_user(ID);
        s.downgrade_user(ID);
        assertEquals("Regular Customer", c.getLevel());
    }
    @Test
    void testInvalidDowngrade_user_SC() {
        s.add_customer(c);
        s.upgrade_user(ID);
        s.upgrade_user(ID);
        s.downgrade_user(ID);
        assertEquals("Platinum Customer", c.getLevel());
    }

    //Test Main Chief
    @Test
    void testValidUpgrade_user_MC_1() {
        m.add_customer(c);
        m.upgrade_user(ID);
        assertEquals("Golden Customer", c.getLevel());
    }
    @Test
    void testValidUpgrade_user_MC_2() {
        m.add_customer(c);
        m.upgrade_user(ID);
        m.upgrade_user(ID);
        assertEquals("Platinum Customer", c.getLevel());
    }
    @Test
    void testDowngrade_user_MC1() {
        m.upgrade_user(ID);
        m.downgrade_user(ID);
        assertEquals("Regular Customer", c.getLevel());
    }
    @Test
    void testDowngrade_user_MC2() {
        m.upgrade_user(ID);
        m.upgrade_user(ID);
        m.downgrade_user(ID);
        m.downgrade_user(ID);
        assertEquals("Regular Customer", c.getLevel());
    }
}