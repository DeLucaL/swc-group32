// INPUT INSTRUCTIONS: The board contains 10x10 spots. Rows are handled with numbers from 0 to 9 and columns
// are handled with capital letters from A to J. Between the start and end point of the ship there should be a space.
// An example input would be: A2 A5.

package assignments.SoftCon2020_Assignment_2;

import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args){
        System.out.println("Welcome to Battleship!\n");

        GameBoard ocean = new GameBoard();
        String[] ships = {"Carrier", "Battleship 1", "Battleship 2", "Submarine 1", "Submarine 2",
                "Submarine 3", "Patrol boat 1", "Patrol boat 2", "Patrol boat 3", "Patrol boat 4"};

        int i = 0;
        while (i < 10){
            System.out.print("Please enter the position of your " + ships[i] +":\t");
            Scanner scanner = new Scanner(System.in);

            Input input;
            try {
                input = new Input(scanner.nextLine());
            }
            catch (IllegalArgumentException e) {
                System.out.println("The specified input is invalid");
                continue;
            }

            Ship ship;

            if (i == 0) ship = new Carrier();
            else if (i <= 2) ship = new Battleship();
            else if (i <= 5) ship = new Submarine();
            else ship = new PatrolBoat();

            if (input.getDistance() != ship.getSize()) {
                System.out.println("The specified input is invalid");
                continue;
            }

            int column = input.getBow_x();
            int row = input.getBow_y();
            boolean horizontal = input.isInputHorizontal();

            try {
                ship.placeAt(row, column, horizontal, ocean);
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
        ocean.display();
    }
}
