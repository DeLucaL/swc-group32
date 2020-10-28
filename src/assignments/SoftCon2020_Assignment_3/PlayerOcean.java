package assignments.SoftCon2020_Assignment_3;

public class PlayerOcean implements Observer{
    private Subject GameBoard;

    public PlayerOcean (Subject GameBoard){
        this.GameBoard = GameBoard;
        GameBoard.registerObserver(this);
    }

    public void update(GameBoard GameBoard) {
        //? check whether board has been hit
    }
}
