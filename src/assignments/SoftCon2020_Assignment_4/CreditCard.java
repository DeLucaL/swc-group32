package assignments.SoftCon2020_Assignment_4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public abstract class CreditCard {
    String customer_name;
    String customer_surname;
    int serial_number;
    int security_code;
    String expiration_date;
    ArrayList<Integer> serial_numbers = new ArrayList<Integer>();

    //Constructor
    public CreditCard(Customer customer){
        customer_name = customer.getName();
        customer_surname = customer.getSurname();
        serial_number = createSerialNumber();
        security_code = 100 + new Random().nextInt(900);
        expiration_date= setExpirationDate();

    }

    /***
     * creates a five digit serial number that hasn't been used before
     * @param
     * @return void
     */
    public int createSerialNumber() {
        serial_number = 10000 + new Random().nextInt(90000);
        while (serial_numbers.contains(serial_number)) {
            serial_number = (serial_number%99999)+1;
        }
        serial_numbers.add(serial_number);
        return serial_number;
    }

    /***
     * sets ExpirationDate to three years from now
     * @return ExpirationDate of Creditcard
     */

    public String setExpirationDate(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 3);
        Date threeYears = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(threeYears);
        return strDate;
    }

    //getters
    public int getSerialNumber(){
        return serial_number;
    }
}

class GoldCard extends CreditCard{

    public GoldCard(Customer customer) {
        super(customer);
    }
}

class PlatinumCard extends CreditCard{

    public PlatinumCard(Customer customer) {
        super(customer);
    }
}

class RegularCard extends CreditCard{

    public RegularCard(Customer customer) {
        super(customer);
    }
}