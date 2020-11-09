package assignments.SoftCon2020_Assignment_4;

public abstract class Customer {
    String name;
    String surname;
    int age;
    int bank_account_number;
    int savings;

    //Constructor
    public Customer(String name, String surname, int ID, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bank_account_number = ID;
        savings=0;
    }

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

    abstract public void paying_by_credit_card(int money);
}


class RegularCustomer extends Customer{
    int limit = 2000;

    //Constructor
    public RegularCustomer(String name, String surname, int ID, int age){
        super(name, surname, ID, age);
    }
    @Override
    public void paying_by_credit_card(int money){
        if (money <= limit){
            savings-=money;
        }
        else{System.out.println("Not enough money");}
    }
}

class GoldenCustomer extends Customer{
    int limit = 5000;

    public GoldenCustomer(String name, String surname, int ID, int age){
        super(name, surname, ID, age);
    }
    @Override
    public void paying_by_credit_card(int money) {
        if (money <= limit){
            savings-=money;
        }
        else{System.out.println("Not enough money");}
    }
}

class PlatinumCustomer extends Customer{
    int limit = 10000;

    public PlatinumCustomer(String name, String surname, int ID, int age){
        super(name, surname, ID, age);
    }
    @Override
    public void paying_by_credit_card(int money) {
        if (money <= limit){
            savings-=money;
        }
        else{System.out.println("Not enough money");}
    }
}