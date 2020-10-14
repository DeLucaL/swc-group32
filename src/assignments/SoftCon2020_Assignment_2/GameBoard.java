package assignments.SoftCon2020_Assignment_2;


public class GameBoard {
    private Ship[][] board = new Ship[10][10];

    Ship[][] getBoard(){return board;}

    GameBoard() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                board[y][x] = new Water();
            }
        }

    }

    void display() {
        System.out.println("   |[A][B][C][D][E][F][G][H][I][J]\n---|------------------------------");
        print(board);
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

    boolean isOccupied(int row, int col) {
        return !board[row][col].getType().equals("Water");
    }
}

