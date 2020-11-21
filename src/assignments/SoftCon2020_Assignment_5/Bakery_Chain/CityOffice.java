package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

import java.util.ArrayList;

public class CityOffice extends BaseHub {
    private ArrayList<BakeryInterface> bakeries = new ArrayList<>();

    public CityOffice(String street, String postcode, String city) {
        super("city office of " + city, street, postcode, city);
    }

    void printAllBakeriesNames(){
        for(BakeryInterface bakery : bakeries) {
            System.out.printf("[%s]", bakery.getName());
            if(bakeries.indexOf(bakery) != bakeries.size()-1) System.out.print(", ");
        }
    }

    public void addBakery(BakeryInterface b) {
        bakeries.add(b);
    }
}
