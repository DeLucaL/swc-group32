package assignments.SoftCon2020_Assignment_6.Exercise_1.ObserverPattern;

import java.util.ArrayList;

public interface Subject {
    ArrayList<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver(boolean bool);
}
