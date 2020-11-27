package assignments.SoftCon2020_Assignment_5.Airport_Shuttle_Service;

public interface Speed {
    /***
     * this method returns the speed
     * @return the speed of the car
     */
    public String getSpeed();
}

class SlowSpeed implements Speed{

    @Override
    public String getSpeed() {
        return "slow";
    }
}

class NormalSpeed implements Speed{
    @Override
    public String getSpeed() {
        return "normal";
    }

}

class FastSpeed implements Speed{
    @Override
    public String getSpeed() {
        return "fast";
    }

}
