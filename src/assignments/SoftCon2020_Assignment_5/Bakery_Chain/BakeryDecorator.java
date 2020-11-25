package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

public abstract class BakeryDecorator implements BakeryInterface{
    protected Bakery decoratedBakery;

    protected BakeryDecorator(Bakery decoratedBakery) {
        this.decoratedBakery = decoratedBakery;
    }

    @Override
    public void printInfo() {
        decoratedBakery.printInfo();
    }

    public void buySandwich(Sandwich sandwich){
        decoratedBakery.buySandwich(sandwich);
    }

    public void buyCake(Cake cake) {
        decoratedBakery.buyCake(cake);
    }

    @Override
    public  String getCity(){
        return decoratedBakery.getCity();
    }
}

class SweetsBakery extends BakeryDecorator {

    public SweetsBakery(Bakery decoratedBakery) {
        super(decoratedBakery);
    }

    @Override
    public void buySandwich(Sandwich sandwich) {
        System.out.println("Sorry, we do not sell sandwiches.");
    }

    @Override
    public void buyCake(Cake cake) {
        decoratedBakery.buyCake(cake);
    }
}

class BreadBakery extends BakeryDecorator {

    public BreadBakery(Bakery decoratedBakery) {
        super(decoratedBakery);
    }

    @Override
    public void buySandwich(Sandwich sandwich) {
        super.buySandwich(sandwich);
    }

    @Override
    public void buyCake(Cake cake) {
        System.out.println("Sorry, we do not sell cake.");
    }
}