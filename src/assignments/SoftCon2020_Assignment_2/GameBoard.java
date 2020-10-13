package assignments.SoftCon2020_Assignment_2;

import java.util.Arrays;

public class GameBoard {
    Ship[][] board = new Ship[10][10];

    GameBoard() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                board[y][x] = new Water();
            }
        }
    }

    //TODO edit display to match specification
    void display() {
        System.out.println(Arrays.deepToString(board));
    }

    boolean isOccupied(int row, int col) {
        return !board[row][col].getType().equals("Water");
    }
}
