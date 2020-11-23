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
		System.out.println("Welcome to TicTacToe");
		playGame();
	}

	private static void askIfWantToPlayAgain() {
		Scanner scan = new Scanner(System.in);
		String choice = null;
		int end = 0;
		while (end == 0) {
			System.out.println("Enter YES/yes if you want to play again OR Enter NO/no if you want to exit ");
			choice = scan.next().toUpperCase();
			System.out.println(choice);
			if (choice.equals("YES")) {
				playGame();
			} else if (choice.equals("NO")) {
				end = 1;
			} else {
				System.out.println("Invalid choice,Enter again");
			}
		}
	}

	public static void playGame() {
		populateBoard();
		selectXorO();
		System.out.println(player + " is player " + computer + " is computer");
		showBoard();
		tossToDecideWhoPlaysFirst();
		String winner = "";
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
		askIfWantToPlayAgain();
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

	private static void tossToDecideWhoPlaysFirst() {
		Random toss = new Random();
		User = toss.nextInt(2);
		if (User == 0)
			System.out.println("player moves first");
		else
			System.out.println("computer moves first");

	}

	private static void makeaMove() {
		Scanner scan = new Scanner(System.in);
		char entry;
		if (User == 0)
			entry = player;
		else
			entry = computer;
		int slot = 0;
		while (true) {
			if (User == 0) {
				System.out.println("Enter a slot to place " + entry);
				slot = scan.nextInt();
			} else
				slot = findWinningMove(computerId);
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

	private static int findWinningMove(int checkingWinFor) {
		char[] boardCopy = new char[board.length];
		for (int i = 1; i < board.length; i++) {
			boardCopy[i] = board[i];
		}
		String[] line = new String[3];
		for (int j = 1; j < 10; j++) {
			if (isSpaceFree(j)) {
				if (checkingWinFor == 0) {
					boardCopy[j] = player;
				} else {
					boardCopy[j] = computer;
				}
				switch (j) {
				case 1:
					line[0] = boardCopy[1] + "" + boardCopy[2] + "" + boardCopy[3];
					line[1] = boardCopy[1] + "" + boardCopy[4] + "" + boardCopy[7];
					line[2] = boardCopy[1] + "" + boardCopy[5] + "" + boardCopy[9];
					break;
				case 2:
					line[0] = boardCopy[2] + "" + boardCopy[5] + "" + boardCopy[8];
					line[1] = boardCopy[1] + "" + boardCopy[2] + "" + boardCopy[3];
					line[2] = "";
					break;
				case 3:
					line[0] = boardCopy[3] + "" + boardCopy[5] + "" + boardCopy[7];
					line[1] = boardCopy[3] + "" + boardCopy[6] + "" + boardCopy[9];
					line[2] = boardCopy[1] + "" + boardCopy[2] + "" + boardCopy[3];
					break;
				case 4:

					line[0] = boardCopy[1] + "" + boardCopy[4] + "" + boardCopy[7];
					line[1] = boardCopy[4] + "" + boardCopy[5] + "" + boardCopy[6];
					line[2] = "";
					break;
				case 5:
					line[0] = boardCopy[2] + "" + boardCopy[5] + "" + boardCopy[8];
					line[1] = boardCopy[1] + "" + boardCopy[5] + "" + boardCopy[9];
					line[2] = boardCopy[3] + "" + boardCopy[5] + "" + boardCopy[7];
					break;
				case 6:
					line[0] = boardCopy[3] + "" + boardCopy[6] + "" + boardCopy[9];
					line[1] = boardCopy[4] + "" + boardCopy[5] + "" + boardCopy[6];
					line[2] = "";
					break;
				case 7:
					line[0] = boardCopy[1] + "" + boardCopy[4] + "" + boardCopy[7];
					line[1] = boardCopy[3] + "" + boardCopy[5] + "" + boardCopy[7];
					line[2] = boardCopy[7] + "" + boardCopy[8] + "" + boardCopy[9];
					break;
				case 8:
					line[0] = boardCopy[2] + "" + boardCopy[5] + "" + boardCopy[8];
					line[1] = boardCopy[7] + "" + boardCopy[8] + "" + boardCopy[9];
					line[2] = "";
					break;
				case 9:
					line[0] = boardCopy[1] + "" + boardCopy[5] + "" + boardCopy[9];
					line[1] = boardCopy[7] + "" + boardCopy[8] + "" + boardCopy[9];
					line[2] = boardCopy[3] + "" + boardCopy[6] + "" + boardCopy[9];
					break;
				}
				if (checkingWinFor == computerId) {
					for (int i = 0; i < 3; i++) {
						if (line[i].equals(computer + "" + computer + "" + computer)) {
							return j;
						}
					}
					boardCopy[j] = ' ';
				} else if (checkingWinFor == playerId) {
					for (int k = 0; k < 3; k++) {
						if (line[k].equals(player + "" + player + "" + player)) {
							return j;
						}
					}
					boardCopy[j] = ' ';
				}
			}
		}
		if (checkingWinFor == computerId) {
			return moveToBlockOpponent();
		} else {
			return 0;
		}
	}

	private static int moveToBlockOpponent() {
		int blockingMove = findWinningMove(playerId);
		if (blockingMove > 0) {
			return blockingMove;
		} else {
			return selectOneCorner();
		}
	}

	private static int selectOneCorner() {
		if (isSpaceFree(1))
			return 1;
		else if (isSpaceFree(3))
			return 3;
		else if (isSpaceFree(7))
			return 7;
		else if (isSpaceFree(9))
			return 9;
		else
			return checkIfCentreIsFree();
	}

	private static int checkIfCentreIsFree() {
		if (isSpaceFree(5))
			return 5;
		else
			return checkIfAnySideIsFree();
	}

	private static int checkIfAnySideIsFree() {
		Random random = new Random();
		int randomValue = random.nextInt(9) + 1;
		if (isSpaceFree(2))
			return 2;
		else if (isSpaceFree(4))
			return 4;
		else if (isSpaceFree(6))
			return 6;
		else if (isSpaceFree(8))
			return 8;
		else
			return randomValue;
	}

	public static boolean isSpaceFree(int index) {
		return board[index] == ' ';
	}

	private static void showBoard() {
		for (int i = 1; i < board.length; i = i + 3) {
			System.out.println("|" + board[i] + " |" + board[i + 1] + " |" + board[i + 2] + " |");
			System.out.println("-----------");
		}
		System.out.println();
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
