package assignments.SoftCon2020_Assignment_5.Airport_Shuttle_Service;

public class main {
    public static void main(String[] args){
        Vehicle family_car = new FamilyCar();
        Vehicle micro_car = new MicroCar();
        Vehicle super_car = new SuperCar();
        Vehicle bus = new Bus();
        Customer c = new Customer(super_car);
        Customer c2 = new Customer(bus);
        c.ride();
        c2.ride();
    }
}
