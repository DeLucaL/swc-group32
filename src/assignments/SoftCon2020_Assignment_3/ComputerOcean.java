package assignments.SoftCon2020_Assignment_3;

import java.util.Scanner;

public class ComputerOcean implements Observer{
    //randomize input for Computer Board
    public static GameBoard setComputerOcean(){
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

        update()
}
