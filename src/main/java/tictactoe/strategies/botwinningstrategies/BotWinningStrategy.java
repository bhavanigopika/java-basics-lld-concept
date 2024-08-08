package tictactoe.strategies.botwinningstrategies;

import tictactoe.models.Board;
import tictactoe.models.Move;

public interface BotWinningStrategy {
    //without a board, we cannot make a move
    public Move makeMove(Board board);
}
