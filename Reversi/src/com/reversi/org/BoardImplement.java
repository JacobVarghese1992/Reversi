
package com.reversi.org;

import java.util.Scanner;

/**
 * Implements the Board object to be called in the Game class 
 * @author jacob
 *
 */
public class BoardImplement implements Board{
	
	private char[][] boardArray = new char[Game.SIZE][Game.SIZE];  
	
	@Override
	public boolean placePiece(int row, char column, boolean isWhitesTurn) {
		int intCol = (int)column - 65;
		if (this.isMoveLegal(row, column, isWhitesTurn)) {
			if (isWhitesTurn == true) {
				boardArray[row-1][intCol] = 'w';
			}
			else {
				boardArray[row-1][intCol] = 'b';
			}
			return true;
		};
		return false;
		
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
		
		int intCol = (int)column - 65;
//		If the column and row names are illegal
		if ((row <= Game.SIZE) || (intCol+1 <= Game.SIZE))
			return false;
		
//		If there was already a coin
		if (boardArray[row-1][intCol] != ' ') 
			return false;
		
		char player;
		if (isWhitesTurn == true)
			player = 'w';
		else
			player = 'b';
//		
//		if ((boardArray[Math.max(0, row-2)][intCol] != ' ') || (boardArray[Math.max(0, row)][intCol] != ' ') || 
//				(boardArray[row-1][Math.max(0,intCol-1)] != ' ') || (boardArray[row-1][Math.max(0,intCol)] != ' '));
		
//		Look on top
		for (int i = row-2; i >= 0; i--) {
			if ( boardArray[i][intCol] == player )
				return true;
		}
		
		for (int i = row; i < Game.SIZE; i++ ) {
			if ( boardArray[i][intCol] == player )
				return true;			
		}
		
		
		
		return true;
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


