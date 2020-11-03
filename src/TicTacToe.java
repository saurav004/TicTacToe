import java.util.Scanner;

public class TicTacToe {
	static char[] board = new char[10];

	public static void main(String[] args) {
		char player = ' ';
		char computer = ' ';
		System.out.println("Welcome to TicTacToe");
		populateBoard();
		player = selectXorO();
		if (player == 'X') {
			computer = 'O';
		} else {
			computer = 'X';
		}
		System.out.println(player + " is player " + computer + " is computer");
	}

	private static char selectXorO() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Select X or O");
		char player = scan.next().charAt(0);
		return player;

	}

	static void populateBoard() {
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
	}
}