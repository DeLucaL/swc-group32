package assignments.SoftCon2020_Assignment_4;

public abstract class Customer implements Person {
int age;
int bank_account_number;
int savings;
int ID;

public void deposit(){
    //
}

public void withdraw(){

}

public void paying_with_bank_transfer(){

}

public void paying_by_credit_card(){

}
}


class RegularCustomer extends Customer{
    @Override
    public void paying_by_credit_card(){
        //
    }
}

class GoldenCustomer extends Customer{
    @Override
    public void paying_by_credit_card() {
        //
    }
}

class PlatinumCustomer extends Customer{
    @Override
    public void paying_by_credit_card() {
    }
}