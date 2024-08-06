package tictactoe;

import tictactoe.controllers.GameController;
import tictactoe.exceptions.InvalidBotCountException;
import tictactoe.exceptions.InvalidPlayerCountException;
import tictactoe.models.Game;
import tictactoe.models.GameState;
import tictactoe.models.Player;
import tictactoe.models.PlayerType;
import tictactoe.models.Symbol;
import tictactoe.strategies.playerswinningstrategies.ColumnWinningStrategy;
import tictactoe.strategies.playerswinningstrategies.DiagonalWinningStrategy;
import tictactoe.strategies.playerswinningstrategies.RowWinningStrategy;
import tictactoe.strategies.playerswinningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, InvalidPlayerCountException {
        //Player p1 = new Player("Krish", 'X', PlayerType.HUMAN);
        //Player p1 = new Player("Krish", new Symbol('X'), PlayerType.HUMAN);

        /*
        //getBuilder will create the Builder object
        //Game.getBuilder().setDimension().setPlayerList().setWinningStrategies().build();
        */

        //If we make the game as public constructor, anyone will create as...see below line...
        //To avoid this, we created a private constructor, only builder have to create a Game object...check Game.java
        /*
        Game game = new Game(3, new ArrayList<>(), new ArrayList<>());
        */

        //Now, game object will create as
        /*
        Game game = Game.getBuilder()
                        .setDimension(3)
                        .setPlayerList(new ArrayList<>())
                        .setWinningStrategies(new ArrayList<>())
                        .build();
        */
        /*
        We ask the controller to start the game for us
        Game game = GameController.startGame();
        */

        /*********************************************************/

        //dimension
        int dimension = 3;
        //player
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("Krish", new Symbol('X'), PlayerType.HUMAN));
        playerList.add(new Player("Vidhu", new Symbol('O'), PlayerType.HUMAN));
        //winningStrategy
        List<WinningStrategy> winningStrategyList = new ArrayList<>();
        winningStrategyList.add(new RowWinningStrategy());
        winningStrategyList.add(new ColumnWinningStrategy());
        winningStrategyList.add(new DiagonalWinningStrategy());

        GameController gameController = new GameController();
        //startGame will return the game object
        Game game = gameController.startGame(dimension, playerList, winningStrategyList);

        //say, someone asking I want to print the board, Initially, it was empty
        gameController.printBoard(game);
        /*
        Now, game will be start...so, game state is IN_PROGRESS - keep playing games
        When you compare object...you use .equals not as ==
        if the GameState is ENDED or DRAW...game will stop
        */
        while(game.getGameState().equals(GameState.IN_PROGRESS)){
            /*
            1. Before player makes the move, player have to see the board
            So, everytime print the board and make the move
            2. Ask the user to choose where to make the move
             */
            gameController.printBoard(game);
            gameController.makeMove(game);
        }

        //once ended the game, someone has won the game
        if(game.getGameState().equals(GameState.ENDED)){
            //print the final state of the board
            gameController.printBoard(game);
            //winner of the game
            System.out.println("Winner is " + gameController.getWinner(game).getName());
        }else{
            System.out.println("Game is drawn");
        }



    }
}
