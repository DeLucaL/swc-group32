package assignments.SoftCon2020_Assignment_3;

public class Input {
    private final String first;
    private final String last;
    private final int bow_x;
    private final int bow_y;
    private final int distance;

    //Constructor
    public Input(String user_input) {
        if (!isValidUserInput(user_input)) throw new IllegalArgumentException();

        first = user_input.split(" ")[0];
        last = user_input.split(" ")[1];

        bow_x = computeInputBowX();
        bow_y = computeInputBowY();
        distance = computeInputLength();
    }

    //Getters
    public int getBow_x() {
        return bow_x;
    }

    public int getBow_y() {
        return bow_y;
    }

    public int getDistance() {
        return distance;
    }

    //Public
    public boolean isInputHorizontal(){
        char[] A = first.toCharArray();
        char[] B = last.toCharArray();
        return A[0] != B[0];
    }

    //Private - used in constructor
    private static boolean isValidUserInput(String s) {
        if (s.length() != 5) return false;

        char[] a = s.toCharArray();

        boolean validChars = isValidLetter(a[0]) && isValidDigit(a[1]) && a[2] == ' '
                && isValidLetter(a[3]) && isValidDigit(a[4]);

        boolean isInline = a[0] == a[3] || a[1] == a[4];

        return validChars && isInline;
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

    private int computeInputLength(){
        char[] A = first.toCharArray();
        char[] B = last.toCharArray();
        if (this.isInputHorizontal()) return Math.abs((int) A[0] - (int) B[0]) + 1;
        else return Math.abs((int) A[1] - (int) B[1]) + 1;
    }

    private int computeInputBowX() {
        char[] A = first.toCharArray();
        char[] B = last.toCharArray();

        if (A[0] < B[0]) return (int) A[0] - 65;
        else return (int) B[0] - 65;
    }

    private int computeInputBowY() {
        char[] A = first.toCharArray();
        char[] B = last.toCharArray();

        if (A[1] < B[1]) return A[1] - 48;
        else return B[1] - 48;
    }
}
