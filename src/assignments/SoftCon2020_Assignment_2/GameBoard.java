package assignments.SoftCon2020_Assignment_2;


public class GameBoard {
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
        System.out.println("   |[A][B][C][D][E][F][G][H][I][L]\n---|------------------------------");
        print(board);
    }

    private static void print(Ship[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("["+i+"]|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    // encapsulation problem? - don't think so, returns bool
    public boolean isOccupied(int row, int col) {
        return !board[row][col].getType().equals("Water");
    }
}

