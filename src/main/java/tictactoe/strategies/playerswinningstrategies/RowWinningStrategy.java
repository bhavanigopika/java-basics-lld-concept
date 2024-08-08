package tictactoe.strategies.playerswinningstrategies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.Move;
import tictactoe.models.Player;
import tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{

    private Map<Integer, Map<Symbol, Integer>> rowHashMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        //calculate the hashmap for corresponding/current row and column - Better Tc -> O(1)...Not to calculate hashmap for every row and column
        Cell cell = move.getCell();
        int row = cell.getRowNo(); //have to check, only this row is winning row

        //check all the symbols are in the current player
        Player player = move.getPlayer();
        Symbol symbol = player.getSymbol();

        //Before updating…Check, if the rowHashMap contains the current row? If it contains, then update the symbol in the hashmap…
        // if not contains, then create a new hashmap in the row
        if(!rowHashMaps.containsKey(row)){
            rowHashMaps.put(row, new HashMap<Symbol, Integer>());
        }

        //before updating...check, if the rowHashMap, contains the symbol? if it contains, then update the count of symbol in hashmap
        //if not contains, then put the symbols first count as 0
        //if(!rowHashMaps.get(row).containsKey(symbol)){}
        //or
        Map<Symbol, Integer> hm = rowHashMaps.get(row);
        if(!hm.containsKey(symbol)){
            hm.put(symbol, 0);
        }

        hm.put(symbol, hm.get(symbol) + 1);

        //update the count in hashmap and then get count of symbol
        int count = hm.get(symbol);

        if(count == board.getDimension()){
            return true;
        }else {
            return false;
        }
        //return count == board.getDimension();
    }
}

/*
[     ] -> (0, hm1)          -
[     ] -> (1, hm2)
[     ] -> (2, hm3) - 'X'

Every row/column/diagaonal have hashmap
say, N row -> N hashmap per row
     N column -> N hashmap per column
     2 diagonal -> 2 hashmap
HashMap< Integer, HashMap<Symbol, Integer>> rowHashMaps
HashMap< Integer, HashMap<Symbol, Integer>> ColumnHashMaps
HashMap< Integer, HashMap<Symbol, Integer>> DiagonalHashMaps
    E.g.,(<index, HashMap<X, 3>>)
             0  :  (X,3) -> [X, X, X]
             1  :  (Y,2) -> [Y, Y,  ]
             2  :  (O,1) -> [ , O,  ]
 */
