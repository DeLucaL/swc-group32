package assignments.SoftCon2020_Assignment_5.Airport_Shuttle_Service;

public class Customer {
    Vehicle vehicle;

    public Customer(Vehicle car){
        this.vehicle = car;
    }

    /***
     * depending on the type of car to drive, prints the following
     * "[name of the car] + [bags allowed] + [speed] + [price]".
     */
    public void ride(){
        System.out.println(
                vehicle.getCarType() +"; "
                +vehicle.LuggageSpace()+"; "
                + vehicle.Speed()+" speed; "
                + vehicle.price+" CHF/h");
    }
}
