package assignments.SoftCon2020_Assignment_3;

public class ScoreBoard implements Observer{
    private static ScoreBoard uniqueInstance;
    private int remaining_boats = 10;
    private int destroyed_boats = 0;

    private ScoreBoard(){}

    //Singleton Pattern
    public static ScoreBoard getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ScoreBoard();
        }
        return uniqueInstance;
    }

    public void print(){
        System.out.println("Your scoreboard:\n\t- Player remaining boats: "+remaining_boats+"\n\t- Enemy boats destroyed: "+destroyed_boats);
    }

    public void update(GameBoard GameBoard) {
        // update remaining boats and destroyed boats
    }
}
