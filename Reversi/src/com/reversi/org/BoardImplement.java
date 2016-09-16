
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
		
		return true;
		
//		check above the current position and change 
//		return ( checkabove( row, column, isWhitesTurn, opposite, color)
//				|| checkbelow( row, column, isWhitesTurn, opposite, color) 
//				|| checkright( row, column, isWhitesTurn, opposite, color)
//				|| checkleft(row, column, isWhitesTurn, opposite, color));

		
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
//		If the column and row names are illegal
		if ((row > Game.SIZE) || (intCol+1 > Game.SIZE))
			return false;
		
//		If there was already a coin
		if (boardArray[row-1][intCol] != ' ') 
			return false;
		
		return ( checkabove( row, column, isWhitesTurn, opposite, color)
				|| checkbelow( row, column, isWhitesTurn, opposite, color) 
				|| checkright( row, column, isWhitesTurn, opposite, color)
				|| checkleft(row, column, isWhitesTurn, opposite, color));
		
		
////		if ((boardArray[Math.max(0, row-2)][intCol] != ' ') || (boardArray[Math.max(0, row)][intCol] != ' ') || 
////				(boardArray[row-1][Math.max(0,intCol-1)] != ' ') || (boardArray[row-1][Math.max(0,intCol)] != ' '));
//		
//		
////		Look on top
//		for (int i = row-2; i >= 0; i--) {
//			if ( boardArray[i][intCol] == player )
//				return true;
//		}
//		
////		Look below		
//		for (int i = row; i < Game.SIZE; i++ ) {
//			if ( boardArray[i][intCol] == player )
//				return true;			
//		}
		
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


