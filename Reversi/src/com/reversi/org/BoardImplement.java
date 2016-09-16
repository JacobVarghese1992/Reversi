
package com.reversi.org;

import java.util.Scanner;

/**
 * Implements the Board object to be called in the Game class 
 * @author jacob
 *
 */
public class BoardImplement implements Board{
	
	private char[][] boardArray = new char[Game.SIZE][Game.SIZE];  
	private boolean[] move = {false, false, false, false,false, false, false, false};
	
	@Override
	public boolean placePiece(int row, char column, boolean isWhitesTurn) {
		int intCol = (int)column - 65;
		if (this.isMoveLegal(row, column, isWhitesTurn)) {
			
			return (changeColor(row, column, isWhitesTurn));
			
//			if (isWhitesTurn == true) {
//				boardArray[row-1][intCol] = 'w';
//			}
//			else {
//				boardArray[row-1][intCol] = 'b';
//			}
//			return true;
		};
		return false;
		
	}

	private boolean changeColor(int row, char column, boolean isWhitesTurn) {
		
//		colors to be set based on the turn
		char opposite, color;
		if (isWhitesTurn == true) {
			opposite = 'b';
			color = 'w';	
		}
		else {
			opposite = 'w';
			color = 'b';			
		}		
		
		if (this.move[0] == true) {
			changeAbove(row, column, isWhitesTurn, opposite, color);
			this.move[0] = false;
		}
		
		if (this.move[1] == true) {
			changeBelow(row, column, isWhitesTurn, opposite, color);
			this.move[1] = false;
		}
		
		if (this.move[2] == true) {
			changeLeft(row, column, isWhitesTurn, opposite, color);
			this.move[2] = false;
		}
		
		if (this.move[3] == true) {
			changeRight(row, column, isWhitesTurn, opposite, color);
			this.move[3] = false;
		}

		if (this.move[4] == true) {
			changeAboveLeft(row, column, isWhitesTurn, opposite, color);
			this.move[4] = false;
		}
		
		if (this.move[5] == true) {
			changeAboveRight(row, column, isWhitesTurn, opposite, color);
			this.move[5] = false;
		}

		if (this.move[6] == true) {
			changeBelowLeft(row, column, isWhitesTurn, opposite, color);
			this.move[6] = false;
		}
		
				
		return true;
		
	}

	private void changeBelowLeft(int row, char column, boolean isWhitesTurn, char opposite, char color) {
		// TODO Auto-generated method stub
		
	}

	private void changeAboveRight(int row, char column, boolean isWhitesTurn, char opposite, char color) {
		int intCol = (int)column - 65;
		int j = intCol + 1 ; 
		int i = row-2;
		
		while (i >= 0 && j < Game.SIZE) {
			if (boardArray[i][j] == opposite) {
				boardArray[i][j] = color;
				boardArray[row-1][intCol] = color;
			}
			else break;
			i++;
			j--;			
		}
	}

	private void changeAboveLeft(int row, char column, boolean isWhitesTurn, char opposite, char color) {

		int intCol = (int)column - 65;
		int j = intCol - 1 ;
		int i = row-2;
		
		while (i >= 0 && j >= 0) {
			if (boardArray[i][j] == opposite) {
				boardArray[i][j] = color;
				boardArray[row-1][intCol] = color;
			}
			else break;
			i++;
			j++;
		}
	}

	private void changeRight(int row, char column, boolean isWhitesTurn, char opposite, char color) {
		int intCol = (int)column - 65;
		int i = intCol+1;
		while(i < Game.SIZE) {
			if (boardArray[row-1][i] == opposite) {
				boardArray[row-1][i] = color;
				boardArray[row-1][intCol] = color;
			}
			else break;
			i++;
		}
	}	
		
	private void changeLeft(int row, char column, boolean isWhitesTurn, char opposite, char color) {
		int intCol = (int)column - 65;
		int i = intCol-1;
		
		while(i >= 0) {
			if (boardArray[row-1][i] == opposite) {
				boardArray[row-1][i] = color;
				boardArray[row-1][intCol] = color;
			}
			else break;
			}
		i--;
	}
		
	

	private void changeBelow(int row, char column, boolean isWhitesTurn, char opposite, char color) {
		
		int intCol = (int)column - 65;
		int i = row;
		while(i < Game.SIZE) {
			if (boardArray[i][intCol] == opposite) {
				boardArray[i][intCol] = color;
				boardArray[row-1][intCol] = color;
			}
			else break;
			i++;
		}
	
	}

	private void changeAbove(int row, char column, boolean isWhitesTurn, char opposite, char color) {
		int i = row-2;
		int intCol = (int)column - 65;
		while(i >= 0) {
			if (boardArray[i][intCol] == opposite) {
				boardArray[i][intCol] = color;
				boardArray[row-1][intCol] = color;
			}
			else break;
			i--;
		}		
	}


	@Override
	public void printBoard() {
		
//		Print top dashes
		System.out.print("  ");
		for (int i = 0; i<boardArray.length; i++)
			System.out.print(" _ ");
		System.out.println();

//		Print the Array along with row numbers 
		for (int i = 0; i<boardArray.length; i++) { 
			for (int j=0; j<boardArray[0].length; j++) {
				if (j==0) {
					System.out.print(i+1);
					System.out.print("|");
				}
				
				System.out.print(" " + boardArray[i][j] + " ");
				
				if (j == ( boardArray[0].length - 1) ) {
					System.out.print("|");
					System.out.println();	
				}
					
			}
		}
		
//		Print the bottom dashes 
		System.out.print("  ");		
		for (int i = 0; i<boardArray.length; i++)
			System.out.print(" _ ");
		
//		Print the Column letters
		System.out.println();
		System.out.print("  ");
		for (int i = 0; i<boardArray.length; i++)
			System.out.print(" " + (char)(i+65)+" ");
			
			
	}

	@Override
	public boolean isMoveLegal(int row, char column, boolean isWhitesTurn) {

		char opposite, color;
		if (isWhitesTurn == true) {
			opposite = 'b';
			color = 'w';	
		}
		else {
			opposite = 'w';
			color = 'b';			
		}
		
		int intCol = (int)column - 65;
		//If the column and row names are illegal
		if ((row > Game.SIZE) || (intCol+1 > Game.SIZE))
			return false;
		
		//If there was already a piece
		if (boardArray[row-1][intCol] != ' ') 
			return false;
		
		//Check valid moves if any and set the move[] attributes accordingly 
		boolean[] moveCheck = new boolean[8];
		moveCheck [0] = checkabove( row, column, isWhitesTurn, opposite, color);
		moveCheck[1] = checkbelow( row, column, isWhitesTurn, opposite, color);
		moveCheck[2] = checkleft(row, column, isWhitesTurn, opposite, color);
		moveCheck[3] = checkright( row, column, isWhitesTurn, opposite, color);
		moveCheck[4] = checkAboveLeft(row, column, isWhitesTurn, opposite, color);
		moveCheck[5] = checkAboveRight(row, column, isWhitesTurn, opposite, color);
		moveCheck[6] = checkBelowLeft(row, column, isWhitesTurn, opposite, color);

		//Return if a valid move exists
		return ( moveCheck[0]||moveCheck[1]||moveCheck[2]||moveCheck[3]||
				 moveCheck[4]||moveCheck[5]||moveCheck[6]);
				
	}

	private boolean checkBelowLeft(int row, char column, boolean isWhitesTurn, char opposite, char color) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean checkAboveRight(int row, char column, boolean isWhitesTurn, char opposite, char color) {
		boolean aboveRight = false;
		int intCol = (int)column - 65;
		int j = intCol + 1 ; 
		int i = row-2;
		
		while (i >= 0 && j < Game.SIZE) {
			if (i == row-2 && j == intCol+1  && boardArray[i][j]!=opposite) {
				aboveRight = false;
				break;
			}
			
			if (boardArray[i][j] == ' ') {
				aboveRight = false;
				break;
			}
			
			else if ( (i != row-2 || j != intCol+1) && boardArray[i][j]!=opposite) {
				aboveRight = true;
				this.move[5] = true;
				break;
			}
			i--;
			j++;		
		}
		
		return aboveRight;
	}	
	
	private boolean checkAboveLeft(int row, char column, boolean isWhitesTurn, char opposite, char color) {
		boolean aboveLeft = false;
		int intCol = (int)column - 65;
		int j = intCol - 1 ;
		int i = row-2;
		
		while (i >= 0 && j >= 0) {
			if (i == row-2 && j == intCol-1  && boardArray[i][j]!=opposite) {
				aboveLeft = false;
				break;
			}
			
			if (boardArray[i][j] == ' ') {
				aboveLeft = false;
				break;
			}
			
			else if ( (i != row-2 || j != intCol-1) && boardArray[i][j]!=opposite) {
				aboveLeft = true;
				this.move[4] = true;
				break;
			}
			i--;
			j--;		
		}
		
		return aboveLeft;
	}

	
	private boolean checkleft(int row, char column, boolean isWhitesTurn, char opposite, char color) {
		boolean left = false;
		int intCol = (int)column - 65;

		int i = intCol - 1 ;
		while(i >= 0) {			

			if (i == intCol-1 && boardArray[row-1][i]!=opposite) {
				left = false;
				break;
			}
			
			if (boardArray[row-1][i] == ' ') {
				left = false;
				break;
			}
			
			else if ( i != intCol-1&& boardArray[row-1][i]!=opposite) {
				left = true;
				this.move[2] = true;
				break;
			}
			i--;
		}
				
		return left;		
	}

	private boolean checkright(int row, char column, boolean isWhitesTurn, char opposite, char color) {
		boolean right = false;
		int intCol = (int)column - 65;

		int i = intCol + 1 ;
		while(i < Game.SIZE) {			

			if (i == intCol+1 && boardArray[row-1][i]!=opposite) {
				right = false;
				break;
			}
			
			if (boardArray[row-1][i] == ' ') {
				right = false;
				break;
			}
			
			else if ( i != intCol+1&& boardArray[row -1][i]!=opposite) {
				right = true;
				this.move[3] = true;
				break;
			}
			i++;
		}
		
		return right;
	}

	private boolean checkbelow(int row, char column, boolean isWhitesTurn, char opposite, char color) {

		boolean down = false;
		int intCol = (int)column - 65;

		int i = row;
		while(i < Game.SIZE) {			

			if (i == row && boardArray[i][intCol]!=opposite) {
				down = false;
				break;
			}
			
			if (boardArray[i][intCol] == ' ') {
				down = false;
				break;
			}
			
			else if ( i != row&& boardArray[i][intCol]!=opposite) {
				down = true;
				this.move[1] = true;
				break;
			}
			i++;
		}
		
		return down;
		
	}

	private boolean checkabove(int row, char column, boolean isWhitesTurn, char opposite, char color) {
//		check above
		
		boolean up = false;
		int intCol = (int)column - 65;

		int i = row-2;
		while(i >= 0) {			

			if (i == row-2 && boardArray[i][intCol]!=opposite) {
				up = false;
				break;
			}
			
			if (boardArray[i][intCol] == ' ') {
				up = false;
				break;
			}
			
			else if ( i != row-2 && boardArray[i][intCol]!=opposite) {
				up = true;
				this.move[0] = true;
				break;
			}
			i = i - 1;
		}
				
		return up;
		
	}	
	@Override
	public boolean isGameOver(boolean isWhiteTurn) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public void setBoardArray(char[][] boardArray) {
//		Print the Array along with row numbers 
		for (int i = 0; i<boardArray.length; i++) { 
			for (int j=0; j<boardArray[0].length; j++) {		
				this.boardArray[i][j] = boardArray[i][j];
			}			
		}

	}

/**
 * 	Initilaize the board and set all the tiles to zero
 */
	public void initialize() {
		for (int i = 0; i<boardArray.length; i++) { 
			for (int j=0; j<boardArray[0].length; j++) {
				boardArray[i][j] = ' ';
			}
		}
		
	}
	
	
	
/**
 * 		Initialize sets the board to as seen below
 *  	   _  _  _  _  _  _  _  _ 
 * 	   1|                        |
 * 	   2|                        |
 * 	   3|                        |
 * 	   4|          w  b          |
 * 	   5|          b  w          |
 * 	   6|                        |
 * 	   7|                        |
 * 	   8|                        |
 * 	      _  _  _  _  _  _  _  _ 
 * 	      A  B  C  D  E  F  G  H 
 * 
 */
	public void playGame() {
		boardArray[boardArray.length/2 - 1][boardArray.length/2 - 1] = 'w';
		boardArray[boardArray.length/2][boardArray.length/2] = 'w';
		boardArray[boardArray.length/2 - 1][boardArray.length/2] = 'b';
		boardArray[boardArray.length/2][boardArray.length/2 - 1] = 'b';	
	}
		
		
	}


