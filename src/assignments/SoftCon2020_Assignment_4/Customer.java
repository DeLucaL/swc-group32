package assignments.SoftCon2020_Assignment_4;

public class Customer {
    String name;
    String surname;
    int age;
    int ID;
    private int savings;
    private int limit;
    private CustomerLevel level;
    private CreditCard creditCard;

    //Constructor
    public Customer(String name, String surname, int ID, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.ID = ID;
        this.limit = 2000;
        this.level = new RegularLevel();
        savings=0;
        creditCard = setCreditCard();
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
