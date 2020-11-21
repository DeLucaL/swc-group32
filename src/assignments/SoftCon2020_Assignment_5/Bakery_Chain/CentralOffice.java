package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

import java.util.ArrayList;

//Singleton
public class CentralOffice extends BaseHub {
    private static final CentralOffice hq = new CentralOffice("HQ", "Bahnhofstr. 1", "8001", "ZH");
    private ArrayList<CityOffice> cityOffices = new ArrayList<>();

    private CentralOffice(String name, String street, String postcode, String city) {
        super(name, street, postcode, city);
    }

    public static CentralOffice getCentralOffice(){
        return hq;
    }

    public void openNewCityOffice(CityOffice office) {
        for(CityOffice o : cityOffices) assert (!o.getCity().equals(office.getCity()));
        cityOffices.add(office);
    }
    
    public void openNewBakery(BakeryInterface bakery) {
        int idx = -1;
        for (CityOffice o : cityOffices) {
            if (o.getCity().equals(bakery.getCity())) {
                o.addBakery(bakery);
                idx = cityOffices.indexOf(o);
                break;
            }
        }
        assert (idx != -1);
    }

    public void printAllOffices(){
        for(CityOffice office : cityOffices) {
            System.out.printf("[%s], ", office.getName());
            office.printAllBakeriesNames();
            if(cityOffices.indexOf(office) != cityOffices.size()-1) System.out.print(", ");
        }
    }


}

