// INPUT INSTRUCTIONS: The board contains 10x10 spots. Rows are handled with numbers from 0 to 9 and columns
// are handled with capital letters from A to J. Between the start and end point of the ship there should be a space.
// An example input would be: A2 A5.

package assignments.SoftCon2020_Assignment_3;

import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args){
        System.out.println("Welcome to Battleship!\n");

        GameBoard PlayerOcean = new GameBoard();
        String[] ships = {"Carrier", "Battleship 1", "Battleship 2", "Submarine 1", "Submarine 2",
                "Submarine 3", "Patrol boat 1", "Patrol boat 2", "Patrol boat 3", "Patrol boat 4"};

        int i = 0;
        while (i < 10){
            System.out.print("Please enter the position of your " + ships[i] +":\t");
            Scanner scanner = new Scanner(System.in);

            assignments.SoftCon2020_Assignment_3.Input input;
            try {
                input = new Input(scanner.nextLine());
            }
            catch (IllegalArgumentException e) {
                System.out.println("The specified input is invalid");
                continue;
            }

            assignments.SoftCon2020_Assignment_3.Ship ship;

            if (i == 0) ship = new assignments.SoftCon2020_Assignment_3.Carrier();
            else if (i <= 2) ship = new assignments.SoftCon2020_Assignment_3.Battleship();
            else if (i <= 5) ship = new assignments.SoftCon2020_Assignment_3.Submarine();
            else ship = new assignments.SoftCon2020_Assignment_3.PatrolBoat();

            if (input.getDistance() != ship.getSize()) {
                System.out.println("The specified input is invalid");
                continue;
            }

            int column = input.getBow_x();
            int row = input.getBow_y();
            boolean horizontal = input.isInputHorizontal();

            try {
                ship.placeAt(row, column, horizontal, PlayerOcean);
            }
            catch (AssertionError e) {
                System.out.println("The specified input is invalid");
                continue;
            }
            //uncomment for testing purposes
            //b.display();
            i++;
        }

        System.out.println("Your board is:\n");
        PlayerOcean.display();

        //third Assignment starts
        GameBoard c = new GameBoard();
        c = ComputerOcean.setComputerOcean();
        c.display();

        System.out.println("The opponent's board is:");
        ComputerOcean.display();
        ScoreBoard.print();

        while (!isGameOver()){
            System.out.println("Enter place to hit: ");
            Scanner scanner = new Scanner(System.in);
            assignments.SoftCon2020_Assignment_3.Hit hit;
            try {
                hit = new Hit(scanner.nextLine());
            }
            catch (IllegalArgumentException e) {
                System.out.println("The specified input is invalid");
                continue;
            }

            hit.shoot(ComputerOcean);

            //hit.shoot(PlayerOcean);       Computer shoots at PlayerOcean

            i++;
        }
    }
}