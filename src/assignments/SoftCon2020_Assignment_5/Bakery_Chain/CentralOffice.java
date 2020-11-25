package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

import java.util.ArrayList;

//Singleton
public class CentralOffice extends BaseHub {
    private static final CentralOffice hq = new CentralOffice("HQ", "Bahnhofstr. 1", "8001", "Zürich");
    private ArrayList<CityOffice> cityOffices = new ArrayList<>();

    private CentralOffice(String name, String street, String postcode, String city) {
        super(name, street, postcode, city);
    }

    public static CentralOffice getCentralOffice(){
        return hq;
    }

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

    public void openNewCityOffice(CityOffice office) {
        for(CityOffice o : cityOffices) assert (!o.city.equals(office.city));
        cityOffices.add(office);
    }
    
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

