package assignments.SoftCon2020_Assignment_6.Exercise_1;

import assignments.SoftCon2020_Assignment_6.Exercise_1.ObserverPattern.Observer;
import assignments.SoftCon2020_Assignment_6.Exercise_1.ObserverPattern.Subject;

public class Model implements Subject {
    Thread thread;

    public Model() {
        thread = new Thread(String.valueOf(this));
        thread.start();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) { observers.remove(i);}
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update();
        }
    }
}
