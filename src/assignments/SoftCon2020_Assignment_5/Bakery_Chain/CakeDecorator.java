package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

public abstract class CakeDecorator extends Cake {
    protected Cake decoratedCake;

    protected CakeDecorator(Cake decoratedCake) {
        this.decoratedCake = decoratedCake;
    }

    public abstract String getDescription();
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

