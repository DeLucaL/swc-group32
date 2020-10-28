package assignments.SoftCon2020_Assignment_3;

public class Hit{
    private final int shot_x;
    private final int shot_y;

    //Constructor
    public Hit(String user_input) {
        if (!isValidUserInput(user_input)) throw new IllegalArgumentException();

        char[] A = user_input.toCharArray();
        shot_x = (int) A[0] - 65;
        shot_y = A[1];
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

    public void shoot(GameBoard board){
        if(board.isOccupied(shot_x, shot_y)){
            //hit
        }
        else{
            //miss
        }

    }
}
