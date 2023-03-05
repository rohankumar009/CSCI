public class Board {
    
    // Instance variables
    private Piece[][] board;
    
    //TODO:
    // Construct an object of type Board using given arguments.
    public Board() { //Based off Instructions
        board = new Piece[8][8]; // Intiallized the Chess board 8 by 8 grid
    }
    
    // Accessor Methods
    
    //TODO:
    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        
        return board[row][col]; //Getting Piece at a location
    }
    
    //TODO:
    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        
        board[row][col] = piece; //Set the piece at a location
        piece.setPosition(row, col);
    }
    
    // Game functionality methods
    
    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. Returns a boolean to signify success or failure.
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        
        if(this.board[startRow][startCol] != null && this.board[startRow][startCol].isMoveLegal(this, endRow, endCol)) {
            System.out.println("t");
            this.board[endRow][endCol] = this.board[startRow][startCol];
            this.board[startRow][startCol].setPosition(endRow, endCol);
            this.board[startRow][startCol] = null;
            return true;
        }
    
        return false;
    }
    
    //TODO:
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {

        int num_king = 0; //Start value of king on the board
        for(int i = 0; i < 8; i++) { // iterate through the rows
            for(int j = 0; j < 8; j++) { // iterate through the columns
                if(board[i][j] != null && (board[i][j].getCharacter() == '\u265a' || board[i][j].getCharacter() == '\u2654')) {
                    num_king += 1;
                }
            } 
        }
        if(num_king != 2) {
            return true;
        }
        else {
            return false;
        }
    }
    
    //TODO:
    // Construct a String that represents the Board object's 2D array. Return
    // the fully constructed String.
    public String toString() {
        String result = "   0 1 2 3 4 5 6 7" + "\n"; //Printing the Columns
        for(int i = 0; i < 8; i++) {
            result  += i + " |"; // Space between row numbers
            for(int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                     result += " " + "|"; //Creates the space between the diving bars ( | | )
                }
                else {
                    result += board[i][j] + "|";
                }
            }
            result += "\n";
        }
        return result;
    }
    
    //TODO:
    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {
        for(int i = 0; i < 8; i++) { // Going through all the rows and then Going through all the columns in the next loop
            for(int j = 0; j < 8; j++) { 
                board[i][j] = null; // Setting all the positions or square on the 8 x 8 gird to null 
            }
        }
        
    }
    
    // Movement helper functions
    
    //TODO:
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
    
        if(startRow >= 0 || startCol >= 0 || endRow <= 7 || endCol <= 7) { //Checking if in bound
            if(this.board[startRow][startCol] != null) { //Check if the position is empty
                if(this.board[startRow][startCol].getIsBlack() == isBlack) { // Check for black color piece
                    if(this.board[endRow][endCol] == null || this.board[endRow][endCol].getIsBlack() != isBlack) {
                        return true;
                    
                    }
                
                }
            }
        }
        return false;
    }
        
    
    
    //TODO:
    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        if((startRow + 1 == endRow) || (startCol + 1 == endCol) || (startRow - 1 == endRow ) || (startCol - 1 == endCol)) { // Left, right, up, and down - adding 1 or subtracting 1 would give me the end result such as endRow etc.
            return true;
        }
        return false;
    }
    
    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        
        if(startRow != endRow){
            return false;
        }
        
        if(verifyAdjacent(startRow, startCol, endRow, endCol)){
            return true;
        }else {
            int min, max;
            if(startCol > endCol) {
                max = startCol;
                min = endCol;
            }
            else {
                min = startCol;
                max = endCol;
            }
    
            for(int i = min + 1; i < max; i++) { // Looping to make sure there are no pieces on the grid
                if(board[startRow][i] != null) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
       
        if(startCol != endCol){
            return false;
        }
    
        if(verifyAdjacent(startRow, startCol, endRow, endCol)){
            return true;
        }else {
            int min, max; // Setting a max and min for the grid
            if(startRow > endRow) {
                max = startRow;
                min = endRow;
            }
            else {
                min = startRow;
                max = endRow;
            }
            
            for(int i = min + 1; i < max; i++) { // Looping to make sure there are no pieces on the grid similar to horizontal method
                if(board[i][startCol] != null) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        if(Math.abs(startRow - endRow) != Math.abs(startCol - endCol)) {
            return false;
        }else{
            int min_row, max_row, min_col, max_col;
            if(startRow > endRow) {
                max_row = startRow;
                min_row = endRow;
            }
            else {
                min_row = startRow;
                max_row = endRow;
            }
            if(startCol > endCol) {
                max_col = startCol;
                min_col = endCol;
            }
            else {
                min_col = startCol;
                max_col = endCol;
            }
            if((startRow - endRow) == (startCol - endCol)){ // Loop going down in the diagonal
                for(int i = 1; i < max_col-max_col; i++){
                    if(board[min_row - i][max_col + i] != null){
                        return false;
                    }
                }
            }else{
                for(int i = 1; i < max_col - min_col; i++){ // Loop going up in the diagonal
                    if(board[min_row + i][min_col + i] != null){
                        return false;
                    }
                }
            }
            return true;
        }
    }
    
    public static void main(String[] args) { // This was just a test before I made the game class to test the movement of the pieces, kindly ignore
        /*Board test = new Board();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR",test);
        test.movePiece(7,6,5,5);
        
        System.out.println(test);*/
    }
    
}
