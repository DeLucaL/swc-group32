package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

public interface Hub {
    String getName();
    String getAddress();
    String getCity();
}

abstract class BaseHub implements Hub{
    String name;
    String street;
    String pc;
    String city;

    protected BaseHub(String name, String street, String postcode, String city) {
        this.name = name;
        this.street = street;
        this.pc = postcode;
        this.city = city;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String getAddress() {
        return null;
    }
}