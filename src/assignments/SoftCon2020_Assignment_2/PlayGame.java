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

    //TODO: check whether input is in the specified format (capital letters A-J, digits 0-9)
    static boolean isValid(String s){

    }
}
