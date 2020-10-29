package assignments.SoftCon2020_Assignment_3;

public class Hit{
    private final int shot_x;
    private final int shot_y;

    //Constructor
    public Hit(String user_input) {
        if (!isValidUserInput(user_input)) throw new IllegalArgumentException();

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
    private static boolean isValidUserInput(String s) {
        if (s.length() != 2) return false;
        char[] a = s.toCharArray();
        boolean validChars = isValidLetter(a[0]) && isValidDigit(a[1]);
        return validChars;
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
            b[shot_y][shot_x].setHit(); //sets also string to X, doesn't work yet
            b[shot_y][shot_x].registerObserver(score_board);
            b[shot_y][shot_x].notifyObservers();
            //b[shot_y][shot_x].removeObserver(score_board); don't know yet if necessary
        }
        else{
            //miss
            Ship[][] b = board.getBoard();
            b[shot_x][shot_y].setMiss();
        }

    }
    public void computer_shoot(GameBoard board){
        if(board.isOccupied(shot_y, shot_x)){
            //hit
            Ship[][] b = board.getBoard();
            b[shot_y][shot_x].setHit(); //sets also string to X, doesn't work yet
        }
        else{
            //miss
            Ship[][] b = board.getBoard();
            b[shot_x][shot_y].setMiss();
        }

    }
}
