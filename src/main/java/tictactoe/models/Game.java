package tictactoe.models;

import tictactoe.exceptions.InvalidBotCountException;
import tictactoe.exceptions.InvalidMoveException;
import tictactoe.exceptions.InvalidPlayerCountException;
import tictactoe.strategies.playerswinningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> playerList;
    private List<Move> moveList;
    private Player winner;
    private GameState gameState;
    private int nextPlayerMoveIndex;
    //Game also have list of winning strategy
    private List<WinningStrategy> winningStrategyList;

    //constructor of game will be private because
    private Game(int dimension, List<Player> playerList, List<WinningStrategy> winningStrategyList){
        //now, initialize the attributes
        this.playerList = playerList;
        this.winningStrategyList = winningStrategyList;
        //Who can help you to create a board? Inside board class
        this.board = new Board(dimension);
        //initially, moves will be empty moves
        this.moveList = new ArrayList<>();
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

    private boolean validateMove(Move move){
        /*have to get rowNo and columnNo to validate the cell
        move.getCell().getRowNo();
        move.getCell().getColumnNo();*/
        //or
        Cell cell = move.getCell();
        int row = cell.getRowNo();
        int column = cell.getColumnNo();

        //first validation is row and column should be within the dimension
        if(row < 0 || column < 0 || row >= board.getDimension() || column >= board.getDimension()){
            return false;
        }
        //second validation is whether is cell is not empty that is filled -> if cellstate is filled, then return false
        //Also, we should not check the dummy cell, and we have to check board...so, board to cell checking should happen...comment 61 to 63...
        //write a code to check in board -> board.getBoard()[row][column]
        /*if(cell.getCellState() == CellState.FILLED){
            return false;
        }*/
        if(board.getBoard().get(row).get(column).getCellState().equals(CellState.FILLED)){
            return false;
        }

        return true;
    }

    public void makeMove() throws InvalidMoveException {
        //After printing the board, we will print the currentPlayer turn
        Player currentPlayer = playerList.get(nextPlayerMoveIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s turn");
        //Now, allow the currentPlayer to make a turn
        //Ask the player to choose the move, so create makeMove() method in Player class
        //I have to make the move by board and currentPlayer make a move
        Move move = currentPlayer.makeMove(board);

        if(!validateMove(move)){
            throw new InvalidMoveException("Move is not invalid");
        }

        //if it is validated move, then execute on board that is update the cell in board
        //get the rowNo and columnNo
        int row = move.getCell().getRowNo();
        int column = move.getCell().getColumnNo();
        //board.getBoard()[row][column] -> now we get that particular cell object(that particular cell line) from the board...see below line
        //Actual cell object here and actual move here where we set the cellState and player.
        Cell cell = board.getBoard().get(row).get(column);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);
        //finalMove will actually execute this is the new Move object with the currentPlayer and above cell
        Move finalMove  = new Move(currentPlayer, cell);
        moveList.add(finalMove);

        //once the currentplayer update the move in board. we want the next player to move
        //now, update the nextPlayerMoveIndex
        /*
        simply, nextPlayerMoveIndex = nextPlayerMoveIndex + 1 -> is not enough, because
        say, 4 player -> [p1, p2, p3, p4] - list<Player>, index 0 has played the move (i.e) player p1 has played, index 1 has played the move (i.e) player p2 has played,
                                                          index 2 has played the move (i.e) player p3 has played, index 3 has played the move (i.e) player p4 has played
        index 3 (i.e) p3 is last player... once last player has played, index will go back to 0, then 1, then 2, then 3...it is cyclic
        index - 0, 1, 2, 3 , 0, 1, 2, 3... it is cyclic...we get 0th index again...so mod with playerLise.size()
        */
        nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % playerList.size();

        //After every move, we have to do check winning algorithm – we have to check the winner after every move, so check, current move will be winning move
        //checkWinner will be find out by both ENDED and DRAW not IN_PROGRESS...so we wrote the code for ENDED and DRAW
        if(checkWinner(finalMove)){
            //now across the row/column/diagonal are same, the game has ended
            gameState = GameState.ENDED;
            //update the winner
            winner = currentPlayer;
        }else if(moveList.size() == board.getDimension() * board.getDimension()  ){
        /*  if checkWinner is false, which means, the game might be drawn or still in_progress
            Suppose, the game has drawn -> the cell state has filled, in 3*3 dimenion -> how many moves at max can take 9 moves because [|.| |.| |.|
                                                                                                                                         |.| |.| |.|   -> so total 9 moves
                                                                                                                                         |.| |.| |.|] */
            gameState = GameState.DRAW;
        }
    }

    private boolean checkWinner(Move move){
        //check the row, column, diagonal(if applicable), we wrote the checkWinnerAlgorithm in strategy
        //now, check all the winning strategies and implement via interface that is Strategy Design pattern
        for(WinningStrategy winningStrategy : winningStrategyList){
            if(winningStrategy.checkWinner(move, board)){
                return true;
            }
        }
        //if the symbol is not same (i.e) neither across the row, column nor diagonal
        return false;
    }

    public void undo(){
        /*
        remove the last move from the list and corresponding to that you have to make that
        cell empty in the board and also go to the previous player.
         */
    }

    public void printBoard(){
        board.print();
    }

    /***********************************************************************************************/
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

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
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

    public List<WinningStrategy> getWinningStrategyList() {
        return winningStrategyList;
    }

    public void setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
        this.winningStrategyList = winningStrategyList;
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

        /***************************************************************************************************/

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
                throw new InvalidBotCountException("Count of BOTs are greater than 1");
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

        /********************************************************************************************/
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
