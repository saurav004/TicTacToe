
public class TicTacToe {
	static char[] board;

	public static void main(String[] args) {
		board = new char[10];
		System.out.println("Welcome to TicTacToe");

		populateBoard();
	}

	static void populateBoard() {
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
	}
}