import java.lang.Math;
public class Knight {
    
    private int row;
    private int col;
    private boolean isBlack;
    public Knight(int row, int col, boolean isBlack) {
        
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
        
    }
    
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        
        if( board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack) == true ){
            if(Math.pow((endCol - this.col),2) + Math.pow((endRow - this.row), 2) == 5){ // Worked with a TA to get this formula for movement of the Knight
                return true;
            }
        }
        return  false;
        //&& board.verifyHorizontal(row, col, endRow, endCol) && board.verifyVertica(row, col, endRow, endCol);
    }
}
