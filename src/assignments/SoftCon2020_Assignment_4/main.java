package assignments.SoftCon2020_Assignment_4;

public class main {
    public static void main(String[] args){
        Customer c = new Customer("Meier", "Sabine", 122, 40);
        c.deposit(400);
        int w= c.withdraw(200);
        c.paying_with_bank_transfer(300);
        c.paying_by_credit_card(300);
    }
}
