package tictactoe.models;

import tictactoe.exceptions.InvalidBotCountException;
import tictactoe.exceptions.InvalidPlayerCountException;
import tictactoe.strategies.playerswinningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> playerList;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerMoveIndex;
    //Game also have list of winning strategy
    private List<WinningStrategy> winningStrategies;

    //constructor of game will be private because
    private Game(int dimension, List<Player> playerList, List<WinningStrategy> winningStrategies){
        //now, initialize the attributes
        this.playerList = playerList;
        this.winningStrategies = winningStrategies;
        //Who can help you to create a board? Inside board class
        this.board = new Board(dimension);
        //initially, moves will be empty moves
        this.moves = new ArrayList<>();
        //initially, gameState will be IN_PROGRESS
        this.gameState = GameState.IN_PROGRESS;
        //initially, firstplayer will play at index = 0
        this.nextPlayerMoveIndex = 0;
        /*
        Who will be the winner? Initially, no one will be the winner...so leave it, otherwise
        this.winner = playerList.get(0);
        //or
        this.winner = null;
        */

    }
    public static Builder getBuilder(){
        return new Builder();
    }

    public void makeMove(){

    }

    public void printBoard(){
        board.print();
    }
    //getters and setters
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    /*
    have to do the validation check, so, let's create builder design pattern
    what are all the attributes we have created in Game class(Game creation),that same attributes in Builder class also
    //But, we should not add all attributes in Builder class, we have to add the impt attributes from the user
    //to be able to create a game, u have to add all these attributes in Builder class.
    Now, you don't create a game, we create a builder and through builder we create a game object
    */
    public static class Builder{
        private int dimension;
        private List<Player> playerList;
        private List<WinningStrategy> winningStrategies;

        public int getDimension() {
            return dimension;
        }

        /*
        return type is Builder in setters instead of void because
        when we say Game.getBuilder -> return Builder object...so Game.getBuilder().setDimension() -> setting the dimension for Builder object, so implicitly it will return the builder object
        on top of it, again I want to set the playersList so, implicitly it will return the builder object
        on top of it, again I want to set the winningStrategies so, implicitly it will return the builder object
        on top of it, we are going to build it and return game object

        Game.getBuilder().setDimension().setPlayerList().setWinningStrategies().build();
        */
        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public List<Player> getPlayerList() {
            return playerList;
        }

        public Builder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }

        //how many bots can exist in one game
        private void validateBotCount() throws InvalidBotCountException {
            int botCount = 0;
            //Check the botCount in players attribute
            for(Player player : playerList){
                if(player.getPlayerType() == PlayerType.BOT){
                    botCount = botCount + 1;
                }
            }
            if(botCount > 1){
                //then you should not create the object...validation should fail. So, throw the exception
                //It is better to have own custom exception
                throw new InvalidBotCountException("Count of BOTs are greater than one");
            }
        }

        //let's validate the PlayerCount
        public void validatePlayerCount() throws InvalidPlayerCountException {
           if(playerList.size() != dimension - 1){
               throw new InvalidPlayerCountException("Number of players does not match the dimension");
           }
           //when playerList.size() == dimension - 1, then code will work
        }

        //let's validate the unique symbol for each player
        public void validateUniqueSymbolForEachPlayer() {

        }

        private void validate() throws InvalidBotCountException, InvalidPlayerCountException {
            validateBotCount();
            validatePlayerCount();
            validateUniqueSymbolForEachPlayer();
        }
        //build method
        public Game build() throws InvalidPlayerCountException, InvalidBotCountException {
            //Before building the game, we should validate the game object
            validate();
            //Once all the validation passed, now game object will create
            //While creating the game object, you have to pass the 3 things that you got from the user

            //we need constructor game object which accepts these 3 things
            return new Game(dimension, playerList, winningStrategies);
        }
    }
}
