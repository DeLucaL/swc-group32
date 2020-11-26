package assignments.SoftCon2020_Assignment_5.Airport_Shuttle_Service;

public class main {
    public static void main(String[] args){
        Vehicle family_car = new FamilyCar();
        Vehicle micro_car = new MicroCar();
        Vehicle super_car = new SuperCar();
        Vehicle bus = new Bus();
        ShuttleOffice shuttleOffice = ShuttleOffice.getInstance();
        ShuttleOffice.Customer c = shuttleOffice.createCustomer(family_car, "07/03/2020");
        shuttleOffice.rideCustomer(c);
        ShuttleOffice.Customer c2 = shuttleOffice.createCustomer(micro_car, "45655");
        shuttleOffice.rideCustomer(c2);

    }
}
