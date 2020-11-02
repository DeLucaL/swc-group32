package assignments.SoftCon2020_Assignment_3;


import java.util.ArrayList;

public class GameBoard {
    private final Ship[][] board = new Ship[10][10];
    private ArrayList<String> shots_taken;

    GameBoard() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                board[y][x] = new Water();
            }
        }
        shots_taken = new ArrayList<String>();
    }


    // Getter
    public Ship[][] getBoard() {
        return board;
    }

    public ArrayList<String> getShots_taken() {
        return shots_taken;
    }

    public void addShot(String coordinate) {
        shots_taken.add(coordinate);
    }

    public void display_player_board() {
        System.out.println("   |[A][B][C][D][E][F][G][H][I][J]\n---|------------------------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("[" + i + "]|");
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j].getType().equals("Water")) {
                    if(board[i][j].getIsSunk()) {
                        System.out.print("[O]");
                    }
                        else {
                            System.out.print("[ ]");
                        }
                } else if (board[i][j].getShipPart(i, j).getPartIsHit()) {
                    System.out.print("[X]");
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }

    public boolean isOccupied(int row, int col) {
        return !board[row][col].getType().equals("Water");
    }

    public void display_computer_board(){
        System.out.println("   |[A][B][C][D][E][F][G][H][I][J]\n---|------------------------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("["+i+"]|");
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j].getType().equals("Water")) {
                    if(board[i][j].getIsSunk()) {
                        System.out.print("[O]");
                    }
                    else {
                        System.out.print("[ ]");
                    }
                } else if (board[i][j].getIsSunk()) {
                    System.out.print(board[i][j]);
                } else if (board[i][j].getShipPart(i, j).getPartIsHit()){
                    System.out.print("[X]");
                }
                else {System.out.print("[ ]");}
            }
            System.out.println();
        }
    }

}

