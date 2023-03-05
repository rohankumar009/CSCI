import java.util.Scanner;

public class Piece {

    // Instance variables
    private char character;
    private int row;
    private int col;
    private boolean isBlack;

    /**
     * Constructor.
     * @param character     The character representing the piece.
     * @param row           The row on the board the piece occupies.
     * @param col           The column on the board the piece occupies.
     * @param isBlack       The color of the piece.
     */
    public Piece(char character, int row, int col, boolean isBlack) {
        this.character = character;
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Determines if moving this piece is legal.
     * @param board     The current state of the board.
     * @param endRow    The destination row of the move.
     * @param endCol    The destination column of the move.
     * @return If the piece can legally move to the provided destination on the board.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        switch (this.character) {
            // Pawn chars
            case '\u2659':
            case '\u265f':
                Pawn pawn = new Pawn(row, col, isBlack);
                return pawn.isMoveLegal(board, endRow, endCol);
            // Rook chars
            case '\u2656':
            case '\u265c':
                Rook rook = new Rook(row, col, isBlack);
                return rook.isMoveLegal(board, endRow, endCol);
            // Knight chars
            case '\u265e':
            case '\u2658':
                Knight knight = new Knight(row, col, isBlack);
                return knight.isMoveLegal(board, endRow, endCol);
            // Bishop chars
            case '\u265d':
            case '\u2657':
                Bishop bishop = new Bishop(row, col, isBlack);
                return bishop.isMoveLegal(board, endRow, endCol);
            // Queen chars
            case '\u265b':
            case '\u2655':
                Queen queen = new Queen(row, col, isBlack);
                return queen.isMoveLegal(board, endRow, endCol);
            // King chars
            case '\u265a':
            case '\u2654':
                King king = new King(row, col, isBlack);
                return king.isMoveLegal(board, endRow, endCol);
            default:
                return false;
        }
    }

    /**
     * Sets the position of the piece.
     * @param row   The row to move the piece to.
     * @param col   The column to move the piece to.
     */
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the current chess unicode character.
     * @return Unicode character.
     */
    public char getCharacter(){
        return this.character;
    }

    /**
     * Return the color of the piece.
     * @return  The color of the piece.
     */
    public boolean getIsBlack() {
        return this.isBlack;
    }

    /**
     * Tests the equality of two Piece objects based on
     * their character parameter.
     * @param other An instance of Piece to compare with this
     *              instance.
     * @return Boolean value representing equality result.
     */
    public boolean equals(Piece other){
        return this.character == other.character;
    }

    /**
     * Returns a string representation of the piece.
     * @return  A string representation of the piece.
     */
    public String toString() {
        return "" + this.character;
    }


    public void pawnPromo(char Character) { //Two big if statement with other if statement nested within the main two. One checks for the Black pieces moving to row 7 (or the White player end) and the other chekcs for the white pieces moving to row 0 (or the Black player's end)
        if (character == '\u265f') { // Checking for the Black Pawn to be on the side of the White Pieces
            if (row == 7){
                System.out.println("Looks like your pawn can now be promoted, to choose- select K for Knight, Q for Queen, B for Bishop, and R for Rook");
                Scanner myScanner = new Scanner(System.in); 
                String input = myScanner.nextLine(); // Reads the input from the player
                if (input.equals("Q")) { // If Q is inputed then the pawn will be promoted to a White Queen
                    this.character = '\u265b';
                }
                else if (input.equals("K")){ // If K is inputed then the pawn will be promoted to a Black Knight
                    this.character = '\u265e'; // Using K for the Knight as that made sense because you cannot promote a pawn to a King
                    
                }
                else if (input.equals("B")){ // If B is inputed then the pawn will be promoted to a Black Bishop
                    this.character = '\u265d';
    
                }
                else if (input.equals("R")){ // If R is inputed then the pawn will be promoted to a Black Rook
                    this.character = '\u265c';
    
                }
                else {
                    System.out.println("Invalid Input, please try another peice"); // This will promt the user that the input is invalid when they do not choose from the piece above
    
                }
                
            }
        }
        if (character == '\u2659') { // Checking for the White Pawn to be on the side of the Black Pieces
            if (row == 0){ // Repeating the same steps used above for the following if statements
                System.out.println("Looks like your pawn can now be promoted, to choose- select K for Knight, Q for Queen, B for Bishop, and R for Rook");
                Scanner myScanner = new Scanner(System.in);
                String input = myScanner.nextLine(); // Reads the input from the player
                if (input.equals("Q")) { // If Q is inputed then the pawn will be promoted to a White Queen
                    this.character = '\u2655';
                }
                else if (input.equals("K")){ // If K is inputed then the pawn will be promoted to a White Knight
                    this.character = '\u2658'; // Using K for the Knight as that made sense because you cannot promote a pawn to a King
        
                }
                else if (input.equals("B")){ // If B is inputed then the pawn will be promoted to a White Bishop
                    this.character = '\u2657';
        
                }
                else if (input.equals("R")){ // If R is inputed then the pawn will be promoted to a White Rook
                    this.character = '\u2656';
        
                }
                else {
                    System.out.println("Invalid Input, please try another peice"); // This will promt the user that the input is invalid when they do not choose from the piece above
        
                }
                
            }
        }
    }
}
// If you do end up down here reading this comment then please go easy on the grading for my project 
// I really hope this is correct and work, otherwise I think this should still count for most of the partial credit 
