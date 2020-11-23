package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

public abstract class SandwichDecorator extends Sandwich {
    protected Sandwich decoratedSandwich;

    protected SandwichDecorator(Sandwich decoratedSandwich) {
        this.decoratedSandwich = decoratedSandwich;
    }

    public abstract String getDescription();
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
