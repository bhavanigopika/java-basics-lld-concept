package tictactoe.models;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private static Scanner sc = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playerType){
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        //We have to take input from user both row and column
        System.out.println("Enter the row no for where you want to make your move");
        int row = sc.nextInt();

        System.out.println("Enter the column no for where you want to make your move");
        int column = sc.nextInt();

        //once we have row and column, we create a new move object
        //Is it a dummy move or did we persist the move on board? Dummy move, we didn't change anything on the board
        //passing the arguments as current player(this), what ever cell we have to move mentioning with row and column
        return new Move(this, new Cell(row, column));
    }
}
