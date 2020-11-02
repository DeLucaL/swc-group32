package assignments.SoftCon2020_Assignment_3;

public class Hit{
    private final int shot_x;
    private final int shot_y;

    //Constructor
    public Hit(String user_input, GameBoard game_board) {
        if (!isValidUserInput(user_input, game_board)) throw new IllegalArgumentException();

        char[] A = user_input.toCharArray();
        shot_x = (int) A[0] - 65;
        shot_y = A[1]- 48;
    }



    //Getters
    public int getX() {
        return shot_x;
    }
    public int getY() {
        return shot_y;
    }

    //Private - used in constructor
    private boolean isValidUserInput(String s, GameBoard board) {
        if (s.length() != 2) return false;
        char[] a = s.toCharArray();
        if (isValidLetter(a[0]) && isValidDigit(a[1]) && !board.getShots_taken().contains(s)) {
            board.addShot(s);
            return true;
        } else return false;
    }

    private static boolean isValidLetter(char c) {
        char[] validLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        for (char l : validLetters) {
            if (l == c) return true;
        }
        return false;
    }

    private static boolean isValidDigit(char c) {
        char[] validDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char d : validDigits) {
            if (d == c) return true;
        }
        return false;
    }

    public void player_shoot(GameBoard board, ScoreBoard score_board){
        if(board.isOccupied(shot_y, shot_x)){
            //hit

            Ship[][] b = board.getBoard();
            b[shot_y][shot_x].setHit(shot_y, shot_x);
            b[shot_y][shot_x].registerObserver(score_board);
            b[shot_y][shot_x].notifyComputerBoard();
            if(b[shot_y][shot_x].getIsSunk()) {
                System.out.println(" You destroyed a "+b[shot_y][shot_x].getType()+" ");
            }
            else {
                System.out.println(" You hit a boat! ");
            }
        }
        else{
            //miss
            Ship[][] b = board.getBoard();
            b[shot_y][shot_x].setHit(shot_y, shot_x);
            System.out.println("Miss");
        }
    }

    public void computer_shoot(GameBoard board, ScoreBoard score_board){
        if(board.isOccupied(shot_y, shot_x)){
            //hit
            Ship[][] b = board.getBoard();
            b[shot_y][shot_x].setHit(shot_y, shot_x);
            b[shot_y][shot_x].registerObserver(score_board);
            b[shot_y][shot_x].notifyPlayerBoard();
            if(b[shot_y][shot_x].getIsSunk()){
                System.out.println("Your "+b[shot_y][shot_x].getType()+" was destroyed. ");
            }
            else{System.out.println(" Your boat was hit! ");}

        }
        else{
            //miss
            Ship[][] b = board.getBoard();
            b[shot_y][shot_x].setHit(shot_y, shot_x);
            System.out.println(" The computer missed ");
        }

    }
}
