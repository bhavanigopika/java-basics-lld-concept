package scalerTest;

public class Game {
    private int score;
    private boolean isGameOver;

    public Game(){
        this.score = 0;
        this.isGameOver = false;
    }

    public void display(){
        if(!isGameOver){
            System.out.println("Score: " + score);
            score = score + 10;
        }
    }
    public void endGame(){
        this.isGameOver = true;
    }

    public int getScore(){
        return this.score;
    }
}
