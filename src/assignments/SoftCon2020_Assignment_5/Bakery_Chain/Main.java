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

        System.out.println("Central Office info:");
        CentralOffice.getCentralOffice().printInfo();
        System.out.println("");
        System.out.println("City Office info:");
        c1.printInfo();
        System.out.println("");
        System.out.println("Bakery info:");
        b1.printInfo();
        System.out.println("");

        Cake c = new Cake();
        c = new Strawberry(c);
        c = new Chocolate(c);
        c = new Cream(c);
        c = new Strawberry(c);

        Sandwich s = new Sandwich();
        s = new Ham(s);
        s = new Ham(s);
        s = new Tomato(s);
        s = new Cheese(s);

        b1.buyCake(c);
        b2.buyCake(c);
        new SweetsBakery(new Bakery("Beck3", "str3", "8032", "ZH")).buyCake(c);

        b1.buySandwich(s);
        b2.buySandwich(s);
        new SweetsBakery(new Bakery("Beck3", "str3", "8032", "ZH")).buySandwich(s);
    }
}
