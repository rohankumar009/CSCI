import java.util.Scanner;

public class Piece {

    // Instance variables
    private char character;
    private int row;
    private int col;
    private boolean isBlack;
    
    public Piece(char character, int row, int col, boolean isBlack) {
        this.character = character;
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

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

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public char getCharacter(){
        return this.character;
    }

    public boolean getIsBlack() {
        return this.isBlack;
    }

    public boolean equals(Piece other){
        return this.character == other.character;
    }

    public String toString() {
        return "" + this.character;
    }

    // Pawn Promotion on chess board
    public void pawnPromo(char Character) { 
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
