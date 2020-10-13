package assignments.SoftCon2020_Assignment_2;

public class GameBoard {
    GameBoard() {
        Spot[][] board = new Spot[10][10];

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                board[x][y] = new Spot();
            }
        }
    }

    void display() {}

    boolean setShip(String type, String bow, String rear) {


    }

    boolean check(String type, String bow, String rear){
        return (inline(bow, rear) & length_matches(type, bow, rear) & isfree(bow, rear));
    }

    boolean inline(String bow, String rear) {}

    boolean length_matches(String type, String bow, String rear) {}

    boolean isfree(String bow, String rear) {}
}



class Spot {
    Spot(){

    }

    @Override
    public String toString() {
        if (occupied) return "";
        else return "[ ]";
    }
}

