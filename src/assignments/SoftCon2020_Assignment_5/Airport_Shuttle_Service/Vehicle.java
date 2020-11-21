package assignments.SoftCon2020_Assignment_5.Airport_Shuttle_Service;

public abstract class Vehicle {
    int price;

    DrivingMode drivingMode;
    LuggageSpace luggageSpace;
    Speed speed;

    //getters

    /***
     * @return type of the car
     */
    abstract String getCarType();

    /***
     * @return the available space for luggage of the car
     */
    public String LuggageSpace(){
        return luggageSpace.getLuggageSpace();
    };

    /***
     * @return the speed of the car
     */
    public String Speed(){
        return speed.getSpeed();
    }
}

class MicroCar extends Vehicle{

    public MicroCar(){
        drivingMode = new ElectricCar();
        luggageSpace = new SmallSpace();
        speed = new NormalSpeed();
        this.price = 12;
    }

    @Override
    String getCarType() {
        return "Micro car";
    }
}

class FamilyCar extends Vehicle{

    public FamilyCar(){
        drivingMode = new GasolineCar();
        luggageSpace = new LargeSpace();
        speed = new NormalSpeed();
        this.price = 15;
    }
    @Override
    String getCarType() {
        return "Family car";
    }
}

class SuperCar extends Vehicle{

    public SuperCar(){
        drivingMode = new GasolineCar();
        luggageSpace = new NormalSpace();
        speed = new FastSpeed();
        this.price = 30;
    }
    @Override
    String getCarType() {
        return "Super car";
    }
}

class Bus extends Vehicle{

    public Bus(){
        drivingMode = new DieselCar();
        luggageSpace = new InfiniteSpace();
        speed = new SlowSpeed();
        this.price = 5;
    }
    @Override
    String getCarType() {
        return "Bus";
    }
}
