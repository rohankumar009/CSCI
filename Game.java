import java.util.Scanner;
public class Game {
    
    // This code was written in dark mode but the functions are the same for all pieces and game is over when the king is caputured
    public static void main(String[] args) {
        Board chessBoard = new Board(); // Makes the Chess board
        Scanner myScan = new Scanner(System.in);
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", chessBoard); // Using the Fen class to put the pieces in the cells 
        boolean userturn = true;
        int endRow = 0;
        int endCol = 0;
        while(!chessBoard.isGameOver()) { // while the game is not over
            System.out.println(chessBoard.toString());
            if(userturn) {
                System.out.println("White Player's Turn");
            }
            else {
                System.out.println("Black Player's Turn");
            }
            System.out.println("Enter your move: [startRow][startCol][endRow][endCol]");
            int startRow = myScan.nextInt(); //startRow -> row
            int startCol = myScan.nextInt(); //startCol -> col
            endRow = myScan.nextInt();
            endCol = myScan.nextInt();
        
            if(chessBoard.movePiece(startRow, startCol, endRow, endCol)) {
                System.out.println(chessBoard.toString());
                userturn = !userturn;
            }
            else {
                System.out.println("Invalid Move, try a valid move on the grid");
                System.out.println(chessBoard.toString());
            }
        
        }
      
        System.out.println(chessBoard);
        System.out.println("The King has been captured- Game Over");
    
        myScan.close();
    
    }
    
}
