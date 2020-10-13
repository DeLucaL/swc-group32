package assignments.SoftCon2020_Assignment_2;

import java.util.Scanner;

public class PlayGame {
    public void main(String[] args){
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
            if (!isValid(input)) {
                System.out.println("The specified input is invalid");
                continue;
            }
            //
            String[] a = input.split(" ");
            String start = a[0];
            String end = a[1];
            if (!b.setShip(ships[i], start, end)) {
                System.out.println("The specified input is invalid");
                continue;
            }
            i++;
        }

        System.out.println("Your board is:\n");
        b.display();
    }

    boolean isValid(String s){
        if (s.length() != 5) return false;
        char[] a = s.toCharArray();

        return isValidLetter(a[0]) & isValidDigit(a[1]) & a[2] == ' '
                & isValidLetter(a[3]) & isValidDigit(a[4]);
    }

    boolean isValidLetter(char c){
        char[] validLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        for (char l : validLetters) {
            if (l == c) return true;
        }
        return false;
    }

    boolean isValidDigit(char c){
        char[] validDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char d : validDigits) {
            if (d == c) return true;
        }
        return false;
    }
}
