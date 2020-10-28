package assignments.SoftCon2020_Assignment_3;


public interface Subject {
    boolean isGameOver = false;

    static boolean getIsGameOver() {
        return isGameOver;
    }

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();

}
