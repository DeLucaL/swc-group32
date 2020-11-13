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

    /***
     * Constructor
     * @param name of customer
     * @param surname of customer
     * @param age of customer
     */
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

    /***
     * creates CreditCard according to level of customer
     * @return CreditCard of level of the person
     */
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

    /***
     * with the help of a hash function it creates an unique ID from the serial number
     * @return unique ID
     */
    private int createUniqueID(){
        return  creditCard.getSerialNumber()+123%9999;
    }

    /***
     * deposit the money, add to savings
     * @param money to deposit
     * @return void
     */
    public void deposit(int money){
        this.savings += money;
    }

    /***
     * deposit the money, add to savings
     * @param money to withdraw
     * @return money which was withdrawn
     */
    public int withdraw(int money){
        if (savings-money >= 0){
            savings -= money;
            return money;
        }
        else{System.out.println("Not enough money");}
        return 0;
    }

    /***
     * takes money from savings if enough money is available
     * @param money to pay
     * @return void
     */
    public void paying_with_bank_transfer(int money){
        if (savings-money >= 0){
            savings -= money;
        }
        else{System.out.println("Not enough money");}
    }

    /***
     * takes amount of money from savings if it less than the limit
     * @param money to pay
     * @return void
     */
    public void paying_by_credit_card(int money){
        if (money <= limit){
            savings -= money;
        }
        else{System.out.println("exceeds limit");}
    }
}
