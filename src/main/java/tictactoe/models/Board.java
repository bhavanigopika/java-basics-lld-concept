package tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
     private int dimension;
     List<List<Cell>> board;

     public Board(int dimension) {
         this.dimension = dimension;
         this.board = new ArrayList(); //1D arraylist -> []
         for(int i = 0; i < dimension; i++){
             //I am going to add 2D arrayList...So we first created 1D arraylist in 12th line...now adding one more new arrayList in board...this.board -> current board
             this.board.add(new ArrayList<>()); /* if dimesnion = 3 -> then, 2D arrayList -> [[]
                                                                                              []
                                                                                              []] */
             //Every index i, j will have a cell object
             for(int j = 0; j < dimension; j++){
                 //I am going add the column(j) to the each row(i)...multiple cell forming a board and each cell forming a cell object, because each cell have some attributes...see cell.java
                 //Each cell having rowNo, columnNo, player, cellState attribute
                 //so, I will create a new Cell Object in ith row...
                 this.board.get(i).add(new Cell(i,j));
             }
         }
         /*finally we get as, if 3 * 3 -> [cell object, cell object, cell object] for every row
                                         [cell object, cell object, cell object]
                                         [cell object, cell object, cell object]
          */
     }

     void print(){
         //iterate the board and entire board is List<List<Cell>>
         //Every row is list of cell List<Cell>
         for(List<Cell> row : this.board){
             //Every row you are going to each cell
             for(Cell cell : row){
                 if(cell.getCellState() == CellState.EMPTY){
                     System.out.print("| |");
                 }else{
                     System.out.println("| " + cell.getPlayer().getSymbol());//corresponding player symbol
                 }
             }
             System.out.println();
         }
     }

     public int getDimension(){
         return dimension;
     }
     public void setDimension(int dimension){
         this.dimension = dimension;
     }

     public List<List<Cell>> getBoard(){
         return board;
     }
     public void setBoard(List<List<Cell>> board){
         this.board = board;
     }
}
