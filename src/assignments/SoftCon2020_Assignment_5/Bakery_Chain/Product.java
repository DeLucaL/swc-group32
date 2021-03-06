package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

public abstract class Product {

    String description;
    /***
     * this method returns the description of the product
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /***
     * this method returns the price of the product
     * @return price
     */
    public abstract double getPrice();
}

class Sandwich extends Product {
    public  Sandwich() {
        this.description = "Sandwich";
    }

    @Override
    public double getPrice() {
        //the price of a basic sandwich not specified in the task description, set it to 5
        return 5;
    }
}

class Cake extends Product {
    public Cake(){
        this.description = "Cake";
    }

    @Override
    public double getPrice() {
        return 3;
    }
}