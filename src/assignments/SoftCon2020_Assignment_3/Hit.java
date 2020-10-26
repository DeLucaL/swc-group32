package assignments.SoftCon2020_Assignment_3;

public class Hit{
    private final int shot;

    //Constructor
    public Hit(String user_input) {
        if (!isValidUserInput(user_input)) throw new IllegalArgumentException();
        shot = computeInput();
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

    private int computeInput(){
        return 0;
    }

    //private void updateHit(String input){}
}
