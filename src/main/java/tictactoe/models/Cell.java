package tictactoe.models;

public class Cell {
    private int rowNo;
    private int columnNo;
    private Player player;
    private CellState cellState;

    /*public Cell(int i, int j){

    }
    //i, j is rowNo and columnNo

     */
    public Cell(int rowNo, int columnNo){
        this.rowNo = rowNo;
        this.columnNo = columnNo;
        this.cellState = CellState.EMPTY;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getColumnNo() {
        return columnNo;
    }

    public void setColumnNo(int columnNo) {
        this.columnNo = columnNo;
    }
}
