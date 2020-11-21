package assignments.SoftCon2020_Assignment_5.Airport_Shuttle_Service;

public class main {
    public static void main(String[] args){
        Vehicle family_car = new FamilyCar();
        Vehicle micro_car = new MicroCar();
        Customer c = new Customer(micro_car);
        Customer c2 = new Customer(family_car);
        c.ride();
        c2.ride();
    }
}
