package tictactoe.controllers;

import tictactoe.exceptions.InvalidBotCountException;
import tictactoe.exceptions.InvalidMoveException;
import tictactoe.exceptions.InvalidPlayerCountException;
import tictactoe.models.Game;
import tictactoe.models.GameState;
import tictactoe.models.Player;
import tictactoe.strategies.playerswinningstrategies.WinningStrategy;

import java.util.List;

public class GameController {
    //user will start the game not create the game, so we create GameController
    //Now, startGame will accept all attributes
    public Game startGame(int dimension, List<Player> playerList, List<WinningStrategy> winningStrategyList) throws InvalidBotCountException, InvalidPlayerCountException {
        return Game.getBuilder()
                   .setDimension(dimension)
                   .setPlayerList(playerList)
                   .setWinningStrategies(winningStrategyList)
                   .build();

    }

    //to make a move, passing the game here
    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    //UNOD feature
    public void undo(Game game){
        game.undo();
    }
}
