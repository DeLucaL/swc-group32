package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

import java.util.ArrayList;

public class CityOffice extends BaseHub {
    private ArrayList<BakeryInterface> bakeries = new ArrayList<>();

    public CityOffice(String street, String postcode, String city) {
        super("city office of " + city, street, postcode, city);
    }

    /***
     * this method print all the existing bakeries
     */
    @Override
    public void printInfo(){
        for(BakeryInterface bakery : bakeries) {
            System.out.print("[");
            bakery.printInfo();
            System.out.print("]");
            if(bakeries.indexOf(bakery) != bakeries.size()-1) System.out.print(", ");
        }
    }

    public void printAllBakeriesNames() {
        this.printInfo();
    }

    /***
     * this method adds the bakery to the ArrayList bakeries
     * @param b
     */
    public void addBakery(BakeryInterface b) {
        bakeries.add(b);
    }
}
