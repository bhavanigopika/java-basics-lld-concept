package tictactoe.strategies.botwinningstrategies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.CellState;
import tictactoe.models.Move;

import java.util.List;

public class EasyBotWinningStrategy implements BotWinningStrategy {
    @Override
    public Move makeMove(Board board) {
        /*
        iterate the board and entire board is List<List<Cell>>
        Every row is list of cell List<Cell>
        Iterate through the board and make the move at the first empty cell
        */
        //It works as whichever next cell is empty, then it will place the next move
        for(List<Cell> row : board.getBoard()){
            //Every row you are going to each cell
            for(Cell cell : row){
                if(cell.getCellState() == CellState.EMPTY){
                    //Move accept player -> BOT and cell
                    return new Move(null, cell);
                }
            }
        }
        //if none of the cells are empty, so not able to make the move
        return null;
    }
}
