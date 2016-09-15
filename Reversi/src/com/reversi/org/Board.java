package com.reversi.org;

/**
 * The Board Interface
 * This board should maintain the game state by processing moves.
 */
public interface Board {
	
	/**
	 * This method will place a disc on the board.
	 * This method MUST ensure the move is legal. If the move is legal,
	 * execute the move, change the board
	 *
	 * Return true if the move is legal. Return false if the move is illegal.
	 */
	 public boolean placePiece(int row, char column, boolean isWhitesTurn);
	 
	 /**
	 * This method should print the board, and should be called after every succesful move.
	 * It should also note whose turn it is.
	 * It should print a textual representation of the board to the console like this:
	 *
	 *    --------
	 * 1 |        |
	 * 2 |        |
	 * 3 |        |
	 * 4 |   wb   |
	 * 5 |   bw   |
	 * 6 |        |
	 * 7 |        |
	 * 8 |        |
	 *    --------
	 *    ABCDEFGH
	 *
	 * Current Turn - White
	 */
	 public void printBoard();
	
	/**
	 * This method checks if a given move is legal.
	 * A move is legal if row and column are on the board (not out of bounds),
	 * if (row,column) is empty, and if it results in 1 or more other discs being
	 * flipped over.
	 
	 * Return true if the move is legal. Return false if the move is illegal.
	 */
	public boolean isMoveLegal(int row, char column, boolean isWhitesTurn);
	
	/**
	 * returns True if the game is over.
	 * The game is over if the board is full, or the player whose turn it is
	 * cannot make any legal moves.
	 */
	public boolean isGameOver(boolean isWhiteTurn);

}
