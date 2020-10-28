package assignments.SoftCon2020_Assignment_3;

import java.util.Random;

public class ComputerOcean implements Observer{


    //randomize input for Computer Board
    public static GameBoard setComputerOcean() {
        GameBoard computer_ocean = new GameBoard();
        String[] ships = {"Carrier", "Battleship 1", "Battleship 2", "Submarine 1", "Submarine 2",
                "Submarine 3", "Patrol boat 1", "Patrol boat 2", "Patrol boat 3", "Patrol boat 4"};

        //while loop
        int i = 0;
        while (i < 10) {
            Ship ship;

            if (i == 0) ship = new Carrier();
            else if (i <= 2) ship = new Battleship();
            else if (i <= 5) ship = new Submarine();
            else ship = new PatrolBoat();

            //generate random Input
            String[] Letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
            Random random = new Random();
            int r1 = random.nextInt(10);
            int r2 = random.nextInt(10);
            String bow = Letters[r1] +  Integer.toString(r2);
            String rear;

            boolean bool = random.nextBoolean();
            if (bool) {
                r2 = r2 + ship.getSize()-1;
                rear = Letters[r1] + Integer.toString(r2);
            } else {
                r1 = r1 + ship.getSize()-1;
                rear = Letters[r1 % 10] + Integer.toString(r2);
            }

            //check if input is valid
            String place_at = bow + " " + rear;
            Input input;
            try {
                input = new Input(place_at);
            } catch (IllegalArgumentException e) {
                continue;
            }


            int column = input.getBow_x();
            int row = input.getBow_y();
            boolean horizontal = input.isInputHorizontal();

            try {
                ship.placeAt(row, column, horizontal, computer_ocean);
            } catch (AssertionError e) {
                continue;
            }
            //uncomment for testing purposes
            //computer_ocean.display();
            i++;
        }
        return computer_ocean;
    }


    public void update(GameBoard game_Board) {

    }
}
