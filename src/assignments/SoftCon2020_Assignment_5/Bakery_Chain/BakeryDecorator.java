package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

public abstract class BakeryDecorator implements BakeryInterface{
    protected Bakery decoratedBakery;

    public BakeryDecorator(Bakery decoratedBakery) {
        this.decoratedBakery = decoratedBakery;
    }

    @Override
    public String getName() {
        return decoratedBakery.getName();
    }

    @Override
    public String getAddress() {
        return decoratedBakery.getAddress();
    }

    @Override
    public  String getCity(){
        return decoratedBakery.getCity();
    }

    public void buySandwich(){
        decoratedBakery.buySandwich();
    }


    public void buyCake() {
        decoratedBakery.buyCake();
    }
}

class SweetsBakery extends BakeryDecorator {

    public SweetsBakery(Bakery decoratedBakery) {
        super(decoratedBakery);
    }

    @Override
    public void buySandwich() {
        System.out.println("Sorry, we do not sell sandwiches.");
    }

    @Override
    public void buyCake() {
        decoratedBakery.buyCake();
    }
}

class BreadBakery extends BakeryDecorator {

    public BreadBakery(Bakery decoratedBakery) {
        super(decoratedBakery);
    }

    @Override
    public void buySandwich() {
        super.buySandwich();
    }

    @Override
    public void buyCake() {
        System.out.println("Sorry, we do not sell cake.");
    }
}