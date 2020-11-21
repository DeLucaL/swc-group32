package assignments.SoftCon2020_Assignment_5.Bakery_Chain;

public class Main {
    public static void main(String[] args) {
        Bakery b1 = new Bakery("Beck1", "str1", "8001", "ZH");
        BreadBakery b2 = new BreadBakery(new Bakery("Beck2", "str2", "9001", "St.G"));

        CityOffice c1 = new CityOffice("platz1", "8002", "ZH");

        CentralOffice.getCentralOffice().openNewCityOffice(c1);
        CentralOffice.getCentralOffice().openNewBakery(b1);
        CentralOffice.getCentralOffice().openNewBakery(
                new SweetsBakery(new Bakery("Beck3", "str3", "8032", "ZH"))
        );
        CentralOffice.getCentralOffice().openNewCityOffice(
                new CityOffice("platz2", "9000", "St.G")
        );
        CentralOffice.getCentralOffice().openNewBakery(b2);

        CentralOffice.getCentralOffice().printAllOffices();
    }
}
