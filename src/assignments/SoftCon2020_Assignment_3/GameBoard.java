package assignments.SoftCon2020_Assignment_3;

import java.util.ArrayList;

public class GameBoard{
    private final Ship[][] board = new Ship[10][10];

    GameBoard() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                board[y][x] = new Water();
            }
        }
    }


    // Getter
    public Ship[][] getBoard() {
        return board;
    }

    public void display() {
        System.out.println("   |[A][B][C][D][E][F][G][H][I][J]\n---|------------------------------");
        print(board);
    }

    private static void print(assignments.SoftCon2020_Assignment_3.Ship[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("["+i+"]|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public boolean isOccupied(int row, int col) {
        return !board[row][col].getType().equals("Water");
    }
}

