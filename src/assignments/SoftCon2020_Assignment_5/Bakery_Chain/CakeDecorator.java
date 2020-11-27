package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

public abstract class CakeDecorator extends Cake {
    protected Cake decoratedCake;

    /***
     * this method sets the actual cake
     * @param decoratedCake
     */
    protected CakeDecorator(Cake decoratedCake) {
        this.decoratedCake = decoratedCake;
    }

    /***
     * this method returns the description of the cake and adds the topping at the end
     * @return description formatted Cake, [topping1], [topping2], ...
     */
    public abstract String getDescription();

    /***
     * further classes extend the interface with a getPrice method, which returns the price of the cake with the added topping
     * @return price of topping + momentary price of cake with possible previous added toppings
     */
}

class Strawberry extends CakeDecorator {

    public Strawberry(Cake decoratedCake) {
        super(decoratedCake);
    }

    @Override
    public String getDescription() {
        return decoratedCake.getDescription() + ", one strawberry";
    }

    @Override
    public double getPrice() {
        return 1 + decoratedCake.getPrice();
    }
}

class Cream extends CakeDecorator {

    public Cream(Cake decoratedCake) {
        super(decoratedCake);
    }

    @Override
    public String getDescription() {
        return decoratedCake.getDescription() + ", portion of cream";
    }

    @Override
    public double getPrice() {
        return 1.5 + decoratedCake.getPrice();
    }
}

class Chocolate extends CakeDecorator {

    public Chocolate(Cake decoratedCake) {
        super(decoratedCake);
    }

    @Override
    public String getDescription() {
        return decoratedCake.getDescription() + ", portion of chocolate";
    }

    @Override
    public double getPrice() {
        return 2 + decoratedCake.getPrice();
    }
}

