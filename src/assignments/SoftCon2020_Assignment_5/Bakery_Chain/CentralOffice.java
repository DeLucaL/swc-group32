package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

import java.util.ArrayList;

//Singleton
public class CentralOffice extends BaseHub {
    private static final CentralOffice hq = new CentralOffice("HQ", "Bahnhofstr. 1", "8001", "Zürich");
    private ArrayList<CityOffice> cityOffices = new ArrayList<>();

    private CentralOffice(String name, String street, String postcode, String city) {
        super(name, street, postcode, city);
    }
    //getter

    /***
     * this method returns the CentralOffice
     * @return hq
     */
    public static CentralOffice getCentralOffice(){
        return hq;
    }

    /***
     * this method prints the CityOffices and its bakeries
     */
    @Override
    public void printInfo(){
        for(CityOffice office : cityOffices) {
            System.out.printf("[%s], ", office.name);
            office.printInfo();
            if(cityOffices.indexOf(office) != cityOffices.size()-1) System.out.print(", ");
        }
    }

    public void printAllOffices() {
        this.printInfo();
    }

    /***
     * this method opens a new CityOffice, if there isn't any Office in this city yet
     * @param office
     */
    public void openNewCityOffice(CityOffice office) {
        for(CityOffice o : cityOffices) assert (!o.city.equals(office.city));
        cityOffices.add(office);
    }

    /***
     * this method opens a new bakery, if there is a CityOffice in the city
     * @param bakery
     */
    public void openNewBakery(BakeryInterface bakery) {
        int idx = -1;
        for (CityOffice o : cityOffices) {
            if (o.city.equals(bakery.getCity())) {
                o.addBakery(bakery);
                idx = cityOffices.indexOf(o);
                break;
            }
        }
        assert (idx != -1);
    }
}

