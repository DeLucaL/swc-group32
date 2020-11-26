package assignments.SoftCon2020_Assignment_5.Airport_Shuttle_Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Calendar;
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

    /***
     * The shuttleOffice creates a new Costumer
     * @param vehicle of costumer
     * @param date on which costumer arrives
     * @return customer
     */
    public Customer createCustomer(Vehicle vehicle, String date){
        Customer c = null;
        try{
            c = new Customer(vehicle, date);
        } catch (ParseException e) {
            System.out.println("invalid date input: Please create a customer with date format dd/MM/yyyy");
        } catch (ExpiredDateException e) {
            System.out.println("Sorry, this date has already passed");
        } catch (DateTimeParseException e){
            System.out.println("invalid date input: this date does not exist");
        }
        return c;
    }

    /***
     * The shuttleOffice allows the customer to ride its car
     * if the customer is a null pointer, it will return that no such customer exists
     * @param c
     */
    public void rideCustomer(Customer c){
        try{
            c.ride();
        }
        catch (NullPointerException e){
            System.out.println("There is no such customer");
        }
    }

    public class Customer {
        Vehicle vehicle;
        Date arrival_date;

        private Customer(Vehicle car, String aDate) throws DateTimeParseException, ParseException, ExpiredDateException {
            this.vehicle = car;
            String sDate= aDate;

            //throws ParseException if DateFormat is invalid
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);

            //throws DateTimeParseException if date does not exist
            LocalDate.parse(aDate,
                    DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT)
            );


            //throws ExpiredDateException if date has already passed
            Date currDate = Calendar.getInstance().getTime();
            if (date.before(currDate)){
                throw new ExpiredDateException();
            }
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
