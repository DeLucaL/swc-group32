package assignments.SoftCon2020_Assignment_3;

import java.util.ArrayList;

abstract class Ship implements Subject, Container {

    private int bowRow;
    private int bowColumn;
    private boolean horizontal;
    protected ArrayList<ShipPart> parts;


    public static class ShipPart {
        private final int x;
        private final int y;
        private boolean isHit;

        //Constructor
        ShipPart(int x_coordinate, int y_coordinate) {
            x = x_coordinate;
            y = y_coordinate;
            isHit = false;
        }

        public boolean getPartIsHit() {
            return isHit;
        }

        public void setPartIsHit() {
            isHit = true;
        }
    }

    abstract int getSize();
    abstract String getType();


    //Getters

    public int getBowRow() {
        return bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    private boolean isHorizontal() {
        return horizontal;
    }

    public ShipPart getShipPart(int row, int col) {
        Iterator iter = new ShipIterator();
        int i = 0;
        while(iter.hasNext()) {
            if(parts.get(i).x == col && parts.get(i).y == row) {
                return parts.get(i);
            }
            i++;
            iter.next();
        }
        return null;
    }

    public boolean getIsSunk(){
        Iterator iter = new ShipIterator();
        int i = 0;
        while(iter.hasNext()) {
            if(!this.parts.get(i).getPartIsHit()) {
                return false;
            }
            i++;
            iter.next();
        }
        return true;
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

    public void setHit(int row, int col) {
        this.getShipPart(row, col).setPartIsHit();
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
        parts = new ArrayList<ShipPart>();

        if (horizontal) {
            for (int i = 0; i < this.getSize(); i++) {
                board.getBoard()[row][col + i] = this;
                parts.add(new ShipPart(col + i, row));
            }
        }
        else {
            for (int i = 0; i < this.getSize(); i++) {
                board.getBoard()[row + i][col] = this;
                parts.add(new ShipPart(col, row + i));
            }
        }
    }

    //Iterator

    @Override
    public Iterator getIterator() {
        return new ShipIterator();
    }

    private class ShipIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            return index < parts.size();
        }

        @Override
        public Object next() {

            if(this.hasNext()) {
                return parts.get(index++);
            }
            return null;
        }
    }
}

class Carrier extends Ship  {
    private Observer observer;

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
        return "[C]";
    }


    @Override
    public void registerObserver(Observer o) {
        observer = o;
    }


    public void notifyComputerBoard() {
        observer.update_computer_board(this.getIsSunk());
    }
    public void notifyPlayerBoard() {
        observer.update_player_board(this.getIsSunk());
    }
}

class Battleship extends Ship {
    private Observer observer;

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
        return "[B]";
    }

    @Override
    public void registerObserver(Observer o) {
        observer = o;
    }


    public void notifyComputerBoard() {
        observer.update_computer_board(this.getIsSunk());
    }
    public void notifyPlayerBoard() {
        observer.update_player_board(this.getIsSunk());
    }
}

class Submarine extends Ship {
    private Observer observer;

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
        return "[S]";
    }

    @Override
    public void registerObserver(Observer o) {
        observer = o;
    }


    public void notifyComputerBoard() {
        observer.update_computer_board(this.getIsSunk());
    }
    public void notifyPlayerBoard() {
        observer.update_player_board(this.getIsSunk());
    }
}

class PatrolBoat extends Ship {
    private Observer observer;

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
        return "[P]";
    }

    @Override
    public void registerObserver(Observer o) {
        observer = o;
    }


    public void notifyComputerBoard() {
        observer.update_computer_board(this.getIsSunk());
    }
    public void notifyPlayerBoard() {
        observer.update_player_board(this.getIsSunk());
    }
}

class Water extends Ship {
    private Observer observer;
    private boolean isSunk;

    public Water() {
        parts = new ArrayList<ShipPart>();
        parts.add(new ShipPart(this.getBowColumn(), this.getBowRow()));
        isSunk = false;
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
        return "[ ]";
    }

    @Override
    public void setHit(int row, int col){
        isSunk = true;
    }

    @Override
    public boolean getIsSunk(){
        return isSunk;
    }

    @Override
    public void registerObserver(Observer o) {
        observer = o;
    }


    public void notifyComputerBoard() {
        observer.update_computer_board(false);
    }
    public void notifyPlayerBoard() {
        observer.update_player_board(false);
    }
}
