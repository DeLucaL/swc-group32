package assignments.SoftCon2020_Assignment_4;

public interface CustomerLevel {
    void next(Customer c);
    void prev(Customer c);
}

class RegularLevel implements CustomerLevel {

    @Override
    public void next(Customer c) {
        c.setLevel(new GoldLevel());
        c.setLimit(5000);
    }

    @Override
    public void prev(Customer c) {}

    @Override
    public String toString() {
        return "Regular Customer";
    }
}

class GoldLevel implements CustomerLevel {

    @Override
    public void next(Customer c) {
        c.setLevel(new PlatinumLevel());
        c.setLimit(10000);
    }

    @Override
    public void prev(Customer c) {
        c.setLevel(new RegularLevel());
        c.setLimit(2000);
    }

    @Override
    public String toString() {
        return "Golden Customer";
    }
}

class PlatinumLevel implements CustomerLevel {

    @Override
    public void next(Customer c) {}

    @Override
    public void prev(Customer c) {
        c.setLevel(new GoldLevel());
        c.setLimit(5000);
    }

    @Override
    public String toString() {
        return "Platinum Customer";
    }
}