package assignments.SoftCon2020_Assignment_2;

import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args){
        System.out.println("Welcome to Battleship!\n");

        GameBoard b = new GameBoard();
        String[] ships = {"Carrier", "Battleship 1", "Battleship 2", "Submarine 1", "Submarine 2",
                "Submarine 3", "Patrol boat 1", "Patrol boat 2", "Patrol boat 3", "Patrol boat 4"};

        int i = 0;
        while (i < 10){
            System.out.print("Please enter the position of your " + ships[i] +":\t");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            //input format
            if (!isValidInput(input)) {
                System.out.println("The specified input is invalid");
                continue;
            }

            //
            String[] a = input.split(" ");
            String start = a[0];
            String end = a[1];

            Ship ship;

            if (i == 0) ship = new Carrier();
            else if (i <= 2) ship = new Battleship();
            else if (i <= 5) ship = new Submarine();
            else ship = new PatrolBoat();

            boolean horizontal = isHorizontal(start, end);
            int column = computeBowColumn(start, end);
            int row = computeBowRow(start, end);

            if (computeLength(start, end, horizontal) != ship.getSize()) {
                System.out.println("The specified input is invalid");
                continue;
            }

            ship.setBowRow(row);
            ship.setBowColumn(column);
            ship.setHorizontal(horizontal);

            if (!ship.isPlaceableAt(row, column, horizontal, b)) {
                System.out.println("The specified input is invalid");
                continue;
            }

            ship.placeAt(row, column, horizontal, b);

            i++;
        }

        System.out.println("Your board is:\n");
        b.display();
    }

    static boolean isValidInput(String s){
        if (s.length() != 5) return false;

        char[] a = s.toCharArray();

        boolean validChars = isValidLetter(a[0]) && isValidDigit(a[1]) && a[2] == ' '
                && isValidLetter(a[3]) && isValidDigit(a[4]);

        boolean isInline = a[0] == a[3] || a[1] == a[4];

        return validChars && isInline;
    }

    static boolean isValidLetter(char c){
        char[] validLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        for (char l : validLetters) {
            if (l == c) return true;
        }
        return false;
    }

    static boolean isValidDigit(char c){
        char[] validDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char d : validDigits) {
            if (d == c) return true;
        }
        return false;
    }

    static boolean isHorizontal(String a, String b){
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        return A[0] != B[0];
    }

    static int computeLength(String a, String b, boolean horizontal){
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        if (horizontal) return (int) A[0] - (int) B[0] + 1;
        else return (int) A[1] - (int) B[1] + 1;
    }

    static int computeBowColumn(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();

        if (A[0] < B[0]) return (int) A[0] - 65;
        else return (int) B[0] - 65;
    }

    static int computeBowRow(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();

        if (A[1] < B[1]) return A[1];
        else return B[1];
    }
}
