package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

interface BakeryInterface extends Hub {
    /***
     *
     * @param sandwich
     */
    void buySandwich(Sandwich sandwich);
    void buyCake(Cake cake);
    String getCity();
}

public class Bakery extends BaseHub implements BakeryInterface {

    public Bakery(String name, String street, String postcode, String city) {
        super(name, street, postcode, city);
    }

    /***
     * this method prints the bakery's name
     */
    @Override
    public void printInfo() {
        System.out.print(this.name);
    }

    public void printName(){
        this.printInfo();
    }

    /***
     * this method lets the customer buy the sandwich and prints the product with it's fillings and the price
     * @param sandwich
     */
    @Override
    public void buySandwich(Sandwich sandwich) {
        System.out.println(sandwich.getDescription());
        System.out.println("Price: " + sandwich.getPrice() + " CHF");
    }

    /***
     * this method lets the customer buy the cake and prints the product with it's toppings and the price
     * @param cake
     */
    @Override
    public void buyCake(Cake cake) {
        System.out.println(cake.getDescription());
        System.out.println("Price: " + cake.getPrice() + " CHF");
    }

    /***
     * this method returns the city of the bakery
     * @return city
     */
    @Override
    public String getCity() {
        return this.city;
    }
}