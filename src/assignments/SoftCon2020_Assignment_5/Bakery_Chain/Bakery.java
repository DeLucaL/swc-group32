package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

interface BakeryInterface extends Hub {
    public void buySandwich(Sandwich sandwich);
    public void buyCake(Cake cake);
}

public class Bakery extends BaseHub implements BakeryInterface {

    public Bakery(String name, String street, String postcode, String city) {
        super(name, street, postcode, city);
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
}