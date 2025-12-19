package com.tct;

import java.util.Scanner;

class TicTacToe {

	static char board[][];

	public TicTacToe() {

		board = new char[3][3];
		createBoard();

	}

	public static void createBoard() {

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public static void displayBoard() {

		System.out.println("-------------");
		for (int i = 0; i < board.length; i++) {
			System.out.print("| ");

			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " | ");

			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	public static void markYourPlace(int row, int col, char mark) {

		if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {

			board[row][col] = mark;
		} else {
			System.out.println("Invalid Marking Position...! Mark your place again");
			displayBoard();
		}
	}

	public static boolean colWiseWin() {

		for (int j = 0; j < 3; j++) {

			if (board[0][j] != ' ' && (board[0][j] == board[1][j]) && (board[1][j] == board[2][j])) {
				return true;
			}
		}

		return false;
	}

	public static boolean rowWiseWin() {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] != ' ' && (board[i][0] == board[i][1]) && (board[i][1] == board[i][2])) {
				return true;
			}
		}
		return false;
	}

	public static boolean diagonalWin() {
		if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]
				|| board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isBoardFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

}

class HumanPlayer {

	String player;
	char mark;

	int row;
	int col;

	public HumanPlayer(String player, char mark) {
		this.player = player;
		this.mark = mark;

	}

	public static boolean validMove(int row, int col) {
		if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
			if (TicTacToe.board[row][col] == ' ') {
				return true;
			}
		}
		return false;
	}

	public void makeMove() {
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Enter the row and column");
			row = sc.nextInt();
			col = sc.nextInt();
		} while (!validMove(row, col));

		TicTacToe.markYourPlace(row, col, mark);

	}

}

public class StartGame {

	public static void main(String[] args) {

		TicTacToe ticTacToe = new TicTacToe();

		HumanPlayer player1 = new HumanPlayer("Mohith", 'X');
		HumanPlayer player2 = new HumanPlayer("Kalyan", 'O');

		HumanPlayer cp;
		cp = player1;

		while (true) {

			System.out.println(cp.player + "'s Turn ");
			cp.makeMove();
			TicTacToe.displayBoard();

			if (TicTacToe.colWiseWin() || TicTacToe.rowWiseWin() || TicTacToe.diagonalWin()) {
				System.out.println(cp.player + " Won the match");
				break;
			} else if (TicTacToe.isBoardFull()) {
				System.out.println("Game Tie No Further Moves");
				break;

			} else {
				if (cp == player1) {
					cp = player2;
				} else {
					cp = player1;
				}
			}

		}

	}

}
