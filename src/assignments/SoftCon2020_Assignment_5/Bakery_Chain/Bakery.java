package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

interface BakeryInterface extends Hub {
    void buySandwich(Sandwich sandwich);
    void buyCake(Cake cake);
    String getCity();
}

public class Bakery extends BaseHub implements BakeryInterface {

    public Bakery(String name, String street, String postcode, String city) {
        super(name, street, postcode, city);
    }

    @Override
    public void printInfo() {
        System.out.print(this.name);
    }

    public void printName() {
        this.printInfo();
    }

    @Override
    public void buySandwich(Sandwich sandwich) {
        System.out.println(sandwich.getDescription());
        System.out.println("Price: " + sandwich.getPrice() + " CHF");
    }

    @Override
    public void buyCake(Cake cake) {
        System.out.println(cake.getDescription());
        System.out.println("Price: " + cake.getPrice() + " CHF");
    }

    @Override
    public String getCity() {
        return this.city;
    }
}