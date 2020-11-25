package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

public interface Hub {
    void printInfo();
}

abstract class BaseHub implements Hub{
    public final String name;
    public final String street;
    public final String pc;
    public final String city;

    protected BaseHub(String name, String street, String postcode, String city) {
        this.name = name;
        this.street = street;
        this.pc = postcode;
        this.city = city;
    }
}