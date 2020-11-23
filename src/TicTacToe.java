import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static char[] board = new char[10];
	static char player = ' ';
	static char computer = ' ';
	static int User;
	static int playerId = 0;
	static int computerId = 1;

	public static void main(String[] args) {
		String winner = "";
		System.out.println("Welcome to TicTacToe");
		populateBoard();
		selectXorO();
		System.out.println(player + " is player " + computer + " is computer");
		showBoard();
		User = tossToDecideWhoPlaysFirst();
		if (User == 0)
			System.out.println("player moves first");
		else
			System.out.println("computer moves first");
		while (winner == "") {
			makeaMove();
			winner = checkWinner();
			if (!winner.equalsIgnoreCase("")) {
				if (winner.equalsIgnoreCase("draw")) {
					System.out.println("It's a draw! Thanks for playing.");
				} else {
					if (winner.charAt(0) == player)
						System.out.println("Congratulations! player" + " has won!");
					else if (winner.charAt(0) == computer) {
						System.out.println("Congratulations! computer" + " has won!");
					}
				}
			}
			if (User == 0)
				User = 1;
			else
				User = 0;
		}
	}

	private static String checkWinner() {
		for (int i = 0; i < 8; i++) {
			String line = null;
			switch (i) {
			case 0:
				line = board[1] + "" + board[2] + "" + board[3];
				break;
			case 1:
				line = board[4] + "" + board[5] + "" + board[6];
				break;
			case 2:
				line = board[7] + "" + board[8] + "" + board[9];
				break;
			case 3:
				line = board[1] + "" + board[4] + "" + board[7];
				break;
			case 4:
				line = board[2] + "" + board[5] + "" + board[8];
				break;
			case 5:
				line = board[3] + "" + board[6] + "" + board[9];
				break;
			case 6:
				line = board[1] + "" + board[5] + "" + board[9];
				break;
			case 7:
				line = board[3] + "" + board[5] + "" + board[7];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int j = 1; j < 10; j++) {
			if (board[j] == ' ') {
				break;
			} else if (j == 9)
				return "draw";
		}

		return "";
	}

	private static int tossToDecideWhoPlaysFirst() {
		Random toss = new Random();
		return toss.nextInt(2);
	}

	private static void makeaMove() {
		Scanner scan = new Scanner(System.in);
		char entry;
		if (User == 0)
			entry = player;
		else
			entry = computer;
		while (true) {
			System.out.println("Enter a slot to place " + entry);
			int slot = scan.nextInt();
			if (slot >= 1 && slot <= 9) {
				if (isSpaceFree(slot)) {
					board[slot] = entry;
					break;
				} else {
					System.out.println("slot already taken,Enter again");
				}
			} else {
				System.out.println("Invalid choice.Enter again");
			}
		}
		showBoard();

	}

	public static boolean isSpaceFree(int index) {
		return board[index] == ' ';
	}

	private static void showBoard() {
		for (int i = 1; i < board.length; i = i + 3) {
			System.out.println("|" + board[i] + " |" + board[i + 1] + " |" + board[i + 2] + " |");
			System.out.println("-----------");
		}
	}

	private static void selectXorO() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Select either X or O");
			player = scan.next().toUpperCase().charAt(0);
			if (player == 'X' || player == 'O') {
				computer = player == 'X' ? 'O' : 'X';
				break;
			} else {
				System.out.println("Invalid choice,Enter again");
				continue;
			}
		}
	}

	static void populateBoard() {
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
	}
}