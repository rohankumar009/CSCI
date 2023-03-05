
public class Fen {
  
    public static void load(String fen, Board b) {
        int rank = 0;   // Rank or row of the board
        int square = 0; // Square in 'rank'
        char query;     // Temp holder for current char

        // Iterate over FEN code chars, updating Board object accordingly
        for(int i = 0; i < fen.length(); i++) {
            query = fen.charAt(i);

          
            if(query == '/') {
                rank++;
                square = 0;
            }
            else if(Character.isDigit(query)) {
                square += Character.getNumericValue(query);
            }

            else if(query == 'p' || query == 'P') { // Pawn
                b.setPiece(rank, square, query == 'p' ? new Piece('\u265f', rank, square++, true) :
                                                            new Piece('\u2659', rank, square++, false));
            }
            else if(query == 'r' || query == 'R') { // Rook
                b.setPiece(rank, square, query == 'r' ? new Piece('\u265c', rank, square++, true) :
                                                            new Piece('\u2656', rank, square++, false));
            }
            else if(query == 'n' || query == 'N') { // Knight
                b.setPiece(rank, square, query == 'n' ? new Piece('\u265e', rank, square++, true) :
                                                            new Piece('\u2658', rank, square++, false));
            }
            else if(query == 'b' || query == 'B') { // Bishop
                b.setPiece(rank, square, query == 'b' ? new Piece('\u265d', rank, square++, true) :
                                                            new Piece('\u2657', rank, square++, false));
            }
            else if(query == 'q' || query == 'Q') { // Queen
                b.setPiece(rank, square, query == 'q' ? new Piece('\u265b', rank, square++, true) :
                                                            new Piece('\u2655', rank, square++, false));
            }
            else if(query == 'k' || query == 'K') { // King
                b.setPiece(rank, square, query == 'k' ? new Piece('\u265a', rank, square++, true) :
                                                            new Piece('\u2654', rank, square++, false));
            }
        }
    }
}
