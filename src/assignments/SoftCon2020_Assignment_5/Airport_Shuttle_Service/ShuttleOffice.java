package assignments.SoftCon2020_Assignment_5.Airport_Shuttle_Service;

import assignments.SoftCon2020_Assignment_5.Bakery_Chain.CentralOffice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ShuttleOffice {
    //Singleton
    private static ShuttleOffice shuttleOffice = null;
    private ShuttleOffice(){}
    public static ShuttleOffice getInstance(){
        if (shuttleOffice == null){
            shuttleOffice = new ShuttleOffice();
        }
        return shuttleOffice;
    }

    public Customer createCustomer(Vehicle vehicle, String date){
        Customer c = null;
        try{
            c = new Customer(vehicle, date);
        } catch (ParseException e) {
            System.out.println("invalid date input: Please create a customer with date format dd/MM/yyyy");
        }
        return c;
    }

    public void rideCustomer(Customer c){
        try{
            c.ride();
        }
        catch (NullPointerException e){
            System.out.print("There is no such customer");
        }
    }

    public class Customer {
        Vehicle vehicle;
        Date arrival_date;

        private Customer(Vehicle car, String aDate) throws ParseException {
            this.vehicle = car;
            String sDate= aDate;
            Date date =new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            arrival_date = date;
        }

        /***
         * depending on the type of car to drive, prints the following
         * "[name of the car] + [bags allowed] + [speed] + [price]".
         */
        private void ride(){
            System.out.println(
                    vehicle.getCarType() +"; "
                            +vehicle.LuggageSpace()+"; "
                            + vehicle.Speed()+" speed; "
                            + vehicle.price+" CHF/h");
        }

    }
}
