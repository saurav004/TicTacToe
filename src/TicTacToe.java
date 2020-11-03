import java.util.Scanner;

public class TicTacToe {
	static char[] board = new char[10];
	static char player = ' ';

	public static void main(String[] args) {

		char computer = ' ';
		System.out.println("Welcome to TicTacToe");
		populateBoard();
		player = selectXorO();
		computer = player == 'X' ? 'O' : 'X';
		System.out.println(player + " is player " + computer + " is computer");
		showBoard();
		makeaMove();
	}

	private static void makeaMove() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Enter a slot to place " + player);
			int slot = scan.nextInt();
			if (slot >= 1 && slot <= 9) {
				if (board[slot] == ' ') {
					board[slot] = player;
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

	private static void showBoard() {
		for (int i = 1; i < board.length; i = i + 3) {
			System.out.println("|" + board[i] + " |" + board[i + 1] + " |" + board[i + 2] + " |");
			System.out.println("-----------");
		}
	}

	private static char selectXorO() {
		char player = 'X';
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Select either X or O");
			player = scan.next().toUpperCase().charAt(0);
			if (player == 'X' || player == 'O') {
				return player;
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