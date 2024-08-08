package tictactoe.strategies.playerswinningstrategies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.Move;
import tictactoe.models.Player;
import tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {

    private Map<Symbol, Integer> leftDiagonalMap = new HashMap<>();
    private Map<Symbol, Integer> rightDiagonalMap = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        Cell cell = move.getCell();
        int row = cell.getRowNo();
        int column = cell.getColumnNo();

        Symbol symbol = move.getPlayer().getSymbol();

        //for the entire leftDiagonal -> both rowNo and columnNo are same (i.e) rowNo == columnNo
        //for the entire rightDiagonal -> both rowNo and columnNo are !same (i.e) rowNo + columnNo == dimension - 1
        if(row == column){
            if(!leftDiagonalMap.containsKey(symbol)){
                leftDiagonalMap.put(symbol, 0);
            }
            leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol) + 1);

            int count = leftDiagonalMap.get(symbol);

            return count == board.getDimension();
        }

        if(row + column == board.getDimension() - 1){
            if(!rightDiagonalMap.containsKey(symbol)){
                rightDiagonalMap.put(symbol, 0);
            }
            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol) + 1);

            int count = rightDiagonalMap.get(symbol);

            return count == board.getDimension();
        }
        //if it is neither the leftDiagonal not norDiagonal
        return false;
    }
}
/*
[ , , ]
[ , , ]
[ , , ]
leftDiagonal = (0,0), (1,1), (2,2) -> r == c
rightDiagonal = (0,2), (1,1), (2,0) -> each sum = 2 which dimension - 1 -> so, row + column = dimension - 1
 */
