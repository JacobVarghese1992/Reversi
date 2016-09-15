package com.reversi.org;
/**
 * The game interface - this will control the Battleship game. 
 * It will keep track of the turn order
 * It will keep track of 
 *
 */
public interface Game {
	
	public static final int SIZE = 8; //number of columns
	
	/**
	 * This method will initialize the game.
	 * It must create the board object with SIZE row and columns.
	 * The board should be blank at this time (do not create the starting position)
	 */
	public void initialize();
	
	/**
	 * This method sets up the boards start condition.
	 * This includes setting the turn to White.
	 * After setting up initial condition, this should prompt user to input
	 * where they want to play a piece. The user should input "A1", "B3", order
	 * any coordinates where the character is the column, and the number is the row.
	 * 
	 * If the move fails, print that the move failed, and prompt again.
	 *
	 * If the move succeeds, check if the game is over. If it is not over,
	 * change whose turn it is and prompt again.
	 *
	 * If the game is over, print who wins.
	 */
	 
	public void playGame();
	
	/**
	 * This is the same as playGame(), but should randomly assign a
	 * "computer" opponent to either White or Black. The computer opponent
	 * does not need to be particularly good, but it should be functional.
	 */	 
	public void playGameAgainstComputer();
	
}
