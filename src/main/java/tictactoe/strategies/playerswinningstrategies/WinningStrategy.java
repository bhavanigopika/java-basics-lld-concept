package tictactoe.strategies.playerswinningstrategies;

import tictactoe.models.Board;
import tictactoe.models.Move;

public interface WinningStrategy {
    //winner can win by row or column or diagonal and check the checkWinner algorithm, check valid move or not, check it in board
    boolean checkWinner(Move move, Board board);
}
