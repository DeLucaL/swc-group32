package assignments.SoftCon2020_Assignment_3;

abstract class Ship {

    private int bowRow;
    private int bowColumn;
    private boolean horizontal;

    abstract int getSize();
    abstract String getType();


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

class Carrier extends Ship {

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


}

class Battleship extends Ship {

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
}

class Submarine extends Ship {

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
}

class PatrolBoat extends Ship {

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
}

class Water extends Ship {

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
}
