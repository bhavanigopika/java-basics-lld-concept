package tictactoe.strategies.playerswinningstrategies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.Move;
import tictactoe.models.Player;
import tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{

    private Map<Integer, Map<Symbol,Integer>> columnHashMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        //calculate the hashmap for corresponding/current row and column - Better Tc -> O(1)...Not to calculate hashmap for every row and column
        Cell cell = move.getCell();
        int column = cell.getColumnNo(); //have to check, only this column is winning column

        //check all the symbols are in the current player
        Player player = move.getPlayer();
        Symbol symbol = player.getSymbol();

        //Before updating…Check, if the columnHashMap contains the current column? If it contains, then update the symbol in the hashmap…
        // if not contains, then create a new hashmap in the column
        if(!columnHashMaps.containsKey(column)){
            columnHashMaps.put(column, new HashMap<Symbol, Integer>());
        }

        //before updating...check, if the columnHashMap, contains the symbol? if it contains, then update the count of symbol in hashmap
        //if not contains, then put the symbols first count as 0
        //if(!columnHashMaps.get(column).containsKey(symbol)){}
        //or
        Map<Symbol, Integer> hm = columnHashMaps.get(column);
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
