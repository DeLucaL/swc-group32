package assignments.SoftCon2020_Assignment_4;

public class Customer {
    final String name;
    final String surname;
    int age;
    private final int ID;
    private int savings;
    private int limit;
    private CustomerLevel level;
    private CreditCard creditCard;

    //Constructor
    public Customer(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.limit = 2000;
        this.level = new RegularLevel();
        this.savings=0;
        this.creditCard = setCreditCard();
        this.ID = createUniqueID();
    }

    //Getters
    public int getID() {
        return ID;
    }

    public String getLevel() {
        return level.toString();
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public int getSavings(){ return savings; }

    //Setters
    public void setLevel(CustomerLevel level) {
        this.level = level;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void previousLevel() {
        level.prev(this);
    }

    public void nextLevel() {
        level.next(this);
        creditCard = setCreditCard();
    }

    public CreditCard setCreditCard(){
        if (level.toString().equals("Golden Customer")){
            return new GoldCard(this);
        }
        else if (level.toString().equals("Platinum Customer")){
            return new PlatinumCard(this);
        }
        else if (level.toString().equals("Regular Customer")){
            return new RegularCard(this);
        }
        return null;
    }

    //Utils
    private int createUniqueID(){
        return  creditCard.getSerialNumber()+123%9999;
    }

    //Payments
    public void deposit(int money){
        this.savings += money;
    }

    public int withdraw(int money){
        if (savings-money >= 0){
            savings -= money;
            return money;
        }
        else{System.out.println("Not enough money");}
        return 0;
    }

    public void paying_with_bank_transfer(int money){
        if (savings-money >= 0){
            savings -= money;
        }
        else{System.out.println("Not enough money");}
    }

    public void paying_by_credit_card(int money){
        if (money <= limit){
            savings -= money;
        }
        else{System.out.println("exceeds limit");}
    }
}
