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
		char player = 'X';
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Select either X or O");
			player = scan.next().charAt(0);
			if (player == 'x' || player == 'X') {
				return 'X';
			} else if (player == 'o' || player == 'O') {
				return 'O';
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