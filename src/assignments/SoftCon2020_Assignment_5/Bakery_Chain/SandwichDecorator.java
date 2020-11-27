package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

public abstract class SandwichDecorator extends Sandwich {
    protected Sandwich decoratedSandwich;

    /***
     * this method sets the actual sandwich
     * @param decoratedSandwich
     */
    protected SandwichDecorator(Sandwich decoratedSandwich) {
        this.decoratedSandwich = decoratedSandwich;
    }

    /***
     * this method returns the description of the fillings of a sandwich
     * @return description
     */
    public abstract String getDescription();

    /***
     * further classes extend the interface with a getPrice method, which returns the price of the sandwich with the added filling
     * @return price of filling + momentary price of sandwich with possible previous added fillings
     */
}

class Ham extends SandwichDecorator {

    public Ham(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return decoratedSandwich.getDescription() + ", slice of ham";
    }

    @Override
    public double getPrice() {
        return 2 + decoratedSandwich.getPrice();
    }
}

class Tomato extends SandwichDecorator {

    public Tomato(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return decoratedSandwich.getDescription() + ", portion of tomatoes";
    }

    @Override
    public double getPrice() {
        return 1.5 + decoratedSandwich.getPrice();
    }
}

class Cheese extends SandwichDecorator {

    public Cheese(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return decoratedSandwich.getDescription() + ", slice of cheese";
    }

    @Override
    public double getPrice() {
        return 1 + decoratedSandwich.getPrice();
    }
}

class Tuna extends SandwichDecorator {

    public Tuna(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return decoratedSandwich.getDescription() + ", portion of tuna";
    }

    @Override
    public double getPrice() {
        return 3 + decoratedSandwich.getPrice();
    }
}
