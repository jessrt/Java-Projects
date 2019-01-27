import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	
	//initialize players and board
	char player = 'x';
	int moves = 0; 
	char[][] board = new char[3][3]; 
	int[] playerMove = new int[2];
	
	initalizeArray(board);
	
	//While there is no winner
	while(moves < 9) {
		
		//Player makes a move 
		System.out.println("Player please make a move, enter coordinates");
		Scanner sc = new Scanner(System.in);
		playerMove[0] = sc.nextInt(); 
		playerMove[1] = sc.nextInt(); 
		if(validMove(board, playerMove, player)){
			
			board[playerMove[0]][playerMove[1]] = player; 
		}
		else {
			System.out.println("Invalid move, please make a valid move");
			continue; 
		}
		
		//print the Board
		printBoard(board);
		moves++; 
		
		//check if there is a winner
		if (hasWinner(board, player) == true) {
			System.out.println("Player " + player + " is the winner!");
			sc.close();
			break; 
		}
		
		//if there is a draw, restart
		if ( moves == 9) {
			initalizeArray(board);
			moves = 0; 
		}
		
		//switch the player
		player = changePlayer(player);
	}
	 

	}

	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public static void initalizeArray(char [][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = 'f';
			}
		}
		
	}
	
	public static boolean hasWinner(char[][] board, char player) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true; 
			else if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
			else if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
			else if (board[2][0] == player && board[1][1] == player && board[0][2] == player) return true;
		}
		return false;
	}
	
	public static boolean validMove(char[][]board, int[] playerMove, char player) {
		if (playerMove[0] < 0 || playerMove[0] > 2 || playerMove[1] < 0 || playerMove[1] > 2) return false; 
		if (player == 'x') {
			if (board[playerMove[0]][playerMove[1]] == 'o') return false; 
		}
		if (player == 'o') {
			if (board[playerMove[0]][playerMove[1]] == 'x') return false;
		}
		return true; 
	}
	
	public static char changePlayer(char player) {
		if (player == 'x') player = 'o';
		else if (player == 'o') player ='x';
		return player; 
	}
	
}

