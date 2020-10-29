package assignments.SoftCon2020_Assignment_3;

import java.util.ArrayList;

abstract class Ship implements Subject { //additional Interface ShipShip (implements Subject, ShipShip)

    private int bowRow;
    private int bowColumn;
    private boolean horizontal;
    private boolean isHit;
    private boolean isSunk;

    public String string;

    abstract int getSize();
    abstract String getType();

    public String toString() {
        return "[" + string + "]";
    }

    //Getters

    private int getBowRow() {
        return bowRow;
    }

    private int getBowColumn() {
        return bowColumn;
    }

    private boolean isHorizontal() {
        return horizontal;
    }

    public boolean getIsSunk(){
        return isSunk;
    }

    public boolean getIsHIt(){
        return isHit;
    }

    //Setters

    private void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    private void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    private void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public void setSunk(){
        this.isSunk = true;
    }

    public void setHit(){
        this.isHit = true;
    }


    //Interact with board

    private boolean isPlaceableAt(int row, int col, boolean horizontal, GameBoard board) {
        if (horizontal) {
            for (int i = 0; i < this.getSize(); i++) {
                if (board.isOccupied(row, col + i)) return false;
            }
        }
        else {
            for (int i = 0; i < this.getSize(); i++) {
                if (board.isOccupied(row + i, col)) return false;
            }
        }
        return true;
    }

    public void placeAt(int row, int col, boolean horizontal, GameBoard board) {
        if (!isPlaceableAt(row, col, horizontal, board)) throw new AssertionError();

        setHorizontal(horizontal);
        setBowRow(row);
        setBowColumn(col);

        if (horizontal) {
            for (int i = 0; i < this.getSize(); i++) {
                board.getBoard()[row][col + i] = this;
            }
        }
        else {
            for (int i = 0; i < this.getSize(); i++) {
                board.getBoard()[row + i][col] = this;
            }
        }
    }
}

class Carrier extends Ship  {
    private ArrayList observers;

    public Carrier() {
        observers = new ArrayList();
        string = "C";
    }
    @Override
    public int getSize() {
        return 6;
    }

    @Override
    public String getType() {
        return "Carrier";
    }

    @Override
    public String toString() {
        return "["+string+"]";
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o); if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update();
        }
    }
}

class Battleship extends Ship {
    private ArrayList observers;

    public Battleship() {
        observers = new ArrayList();
        string = "B";
    }
    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public String getType() {
        return "Battleship";
    }

    @Override
    public String toString() {
        return "["+string+"]";
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o); if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update();
        }
    }
}

class Submarine extends Ship {
    private ArrayList observers;

    public Submarine() {
        string = "S";
        observers = new ArrayList();
    }
    @Override
    public int getSize() {
        return 3;
    }

    @Override
    public String getType() {
        return "Submarine";
    }

    @Override
    public String toString() {
        return "["+string+"]";
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o); if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update();
        }
    }
}

class PatrolBoat extends Ship {
    private ArrayList observers;

    public PatrolBoat() {
        string = "P";
        observers = new ArrayList();
    }
    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public String getType() {
        return "Patrol Boat";
    }

    @Override
    public String toString() {
        return "["+string+"]";
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o); if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update();
        }
    }
}

class Water extends Ship {
    private ArrayList observers;

    public Water() {
        string = " ";
        observers = new ArrayList();
    }
    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public String getType() {
        return "Water";
    }

    @Override
    public String toString() {
        return "["+string+"]";
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o); if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update();
        }
    }
}
