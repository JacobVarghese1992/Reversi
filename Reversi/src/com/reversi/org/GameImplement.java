package com.reversi.org;

import java.util.Scanner;

public class GameImplement implements Game{
	
	private char[][] boardArray = new char[SIZE][SIZE];
	private BoardImplement currentBoard;  
	
	@Override
	public void initialize() {
		this.currentBoard = new BoardImplement();
		currentBoard.initialize();
	}

	@Override
	public void playGame() {
		String move;
		boolean wMove = true;
		
		currentBoard.playGame();
		currentBoard.printBoard();
		
		System.out.print("\n\n  White, Make your move: ");
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		move = reader.next();
		
		while(!currentBoard.isGameOver(wMove)) {
			currentBoard.placePiece((int)move.charAt(1) - 48, move.charAt(0), wMove);
			currentBoard.printBoard();
			wMove = !wMove;
			if (wMove == true)
				System.out.print("\n\n  White, Make your move: ");
			else
				System.out.print("\n\n  Black, Make your move: ");
			move = reader.next();
			while(!(currentBoard.isMoveLegal((int)move.charAt(1) - 48, move.charAt(0), wMove))) {
				System.out.print("\n\n  Your Move was illegal,");
				if (wMove == true)
					System.out.print("\n  White, Make your move: ");
				else
					System.out.print("\n  Black, Make your move: ");
				move = reader.next();								
			}
		}
		
	}

	@Override
	public void playGameAgainstComputer() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		GameImplement currentGame = new GameImplement();
		currentGame.initialize();
		currentGame.playGame();
	}
}
