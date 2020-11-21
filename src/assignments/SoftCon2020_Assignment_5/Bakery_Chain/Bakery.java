package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

interface BakeryInterface extends Hub {
    public void buySandwich();
    public void buyCake();
}

public class Bakery extends BaseHub implements BakeryInterface {

    public Bakery(String name, String street, String postcode, String city) {
        super(name, street, postcode, city);
    }


    @Override
    public void buySandwich() {

    }

    @Override
    public void buyCake() {

    }
}
