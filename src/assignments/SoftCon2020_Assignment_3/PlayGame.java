// INPUT INSTRUCTIONS: The board contains 10x10 spots. Rows are handled with numbers from 0 to 9 and columns
// are handled with capital letters from A to J. Between the start and end point of the ship there should be a space.
// An example input would be: A2 A5.

package assignments.SoftCon2020_Assignment_3;

import java.util.Random;
import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args){
        System.out.println("Welcome to Battleship!\n");

        GameBoard player_board = new GameBoard();
        String[] ships = {"Carrier", "Battleship 1", "Battleship 2", "Submarine 1", "Submarine 2",
                "Submarine 3", "Patrol boat 1", "Patrol boat 2", "Patrol boat 3", "Patrol boat 4"};

        /*
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
                ship.placeAt(row, column, horizontal, player_board);
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
        player_board.display_player_board();
        */
        //uncomment for testing purposes
        int i = 0;
        while (i < 10){
            String s[] = {"E9 J9", "A2 A5", "G0 J0", "D0 D2", "F2 H2", "J5 J7", "A0 B0", "A7 B7", "F5 F6", "J2 J3"};
            Ship ship;
            if (i == 0) ship = new assignments.SoftCon2020_Assignment_3.Carrier();
            else if (i <= 2) ship = new assignments.SoftCon2020_Assignment_3.Battleship();
            else if (i <= 5) ship = new assignments.SoftCon2020_Assignment_3.Submarine();
            else ship = new assignments.SoftCon2020_Assignment_3.PatrolBoat();
            Input input;
            input = new Input(s[i]);
            int column = input.getBow_x();
            int row = input.getBow_y();
            boolean horizontal = input.isInputHorizontal();

            try {
                ship.placeAt(row, column, horizontal, player_board);
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
        player_board.display_player_board();


        //third Assignment starts
        GameBoard computer_board = new GameBoard();
        System.out.println("\nThe opponent's board is:\n");
        computer_board.display_player_board();
        computer_board = ComputerOcean.setComputerOcean();

        //uncomment for testing purposes:
        computer_board.display_player_board();

        System.out.print("\n");
        ScoreBoard score_board = ScoreBoard.getInstance();
        score_board.print();


        while (!score_board.isGameOver()){
            System.out.println("Enter place to hit: ");
            Scanner scanner = new Scanner(System.in);
            Hit hit_p;
            try {
                hit_p = new Hit(scanner.nextLine(), computer_board);
            }
            catch (IllegalArgumentException e) {
                System.out.println("The specified input is invalid");
                continue;
            }

            // Player shoots at computer_board
            hit_p.player_shoot(computer_board, score_board);

            //create a random hit
            Hit hit_c;
            while (true) {
            String[] Letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
            Random random = new Random();
            int r1 = random.nextInt(10);
            int r2 = random.nextInt(10);
            String random_input = Letters[r1] +  r2;
                try {
                    hit_c = new Hit(random_input, player_board);
                    break;
                } catch (IllegalArgumentException e) { }
            }

            //Computer shoots at player_board
            hit_c.computer_shoot(player_board, score_board);

            //If a boat is hit in the computer's board, an X will appear in the position the bomb was thrown
            //Otherwise, an O should be shown.

            player_board.display_player_board();
            System.out.println("\n");
            computer_board.display_computer_board();
            score_board.print();

        }
        if (score_board.getRemaining_boats() == 0){System.out.println(" Sorry, you lost!");}
        else{System.out.println("Congratulations, you won!");}

    }
}