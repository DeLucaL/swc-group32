package assignments.SoftCon2020_Assignment_2;

import java.util.Arrays;

public class GameBoard {
    Ship[][] board = new Ship[10][10];
    private Ship Carrier;
    private Ship Battleship;
    private Ship Submarine;
    private Ship PatrolBoat;
    private GameBoard GameBoard;

    GameBoard() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                board[y][x] = new Water();
            }
        }
    }

    //TODO edit display to match specification
    void display() {
        System.out.println("   |[A][B][C][D][E][F][G][H][I][L]\n---|------------------------------");
        print(board);
        //System.out.println(Arrays.deepToString(board));
    }

    public static void print(Ship[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("["+i+"]|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    // encapsulation problem?
    boolean isOccupied(int row, int col) {
        return !board[row][col].getType().equals("Water");
    }
}

