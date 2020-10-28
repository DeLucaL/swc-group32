package assignments.SoftCon2020_Assignment_3;

public class ScoreBoard implements Observer{
    private static ScoreBoard uniqueInstance;
    public boolean isGameOver;
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

    public void update() {
        remaining_boats -= 1;
        destroyed_boats += 1;
    }

    public boolean isGameOver(){
        if (destroyed_boats == 6 | remaining_boats == 0){
            return true;
        }
        return false;
    }
}
