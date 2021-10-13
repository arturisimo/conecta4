package org.cloud.apps.qa.model;

import java.util.Optional;

public class Conecta4 {
	
	public static final Integer ROWS = 6;
	public static final Integer COLUMNS = 7;
	public static final Integer NUM_PIECES = (ROWS * COLUMNS) / 2;
	
	private Board board;
	private Player[] players;
	private static Optional<Player> winner = Optional.empty();
	private Integer turn;
	
	private static final Console CONSOLE = Console.getInstance();
	
	public Conecta4(String namePlayer1, String namePlayer2) {
		
		final Player player1 = new Player(namePlayer1, NUM_PIECES, Colour.O);
		final Player player2 = new Player(namePlayer2, NUM_PIECES, Colour.X);
		
		players = new Player[]{player1, player2};
		board = new Board(ROWS, COLUMNS);
		turn = 0;
	}
	
	private void play() {
		Player turnPlayer;
		do {
			CONSOLE.println("Turno " + players[turn].getName() + "[" + players[turn].getColour() + "]. Columna ? [0-"+ (Conecta4.COLUMNS-1) + "]");
			int column = CONSOLE.readIntInRange(0, Conecta4.COLUMNS-1);
			turnPlayer = players[turn];
			
			if (board.checkPutFicha(column)) {
				board.putPiece(players[turn].getPiece(), column);
				board.print();
				if (board.isConecta4(turnPlayer.getColour()))
					winner = Optional.ofNullable(turnPlayer);
				turn = turn == 0 ? 1 : 0;
			} else {
				CONSOLE.println("movimiento no valido");
			}
			
		} while (!winner.isPresent() && !turnPlayer.getPieces().isEmpty());
		
	}
	
	private static boolean isResumeGame() {
		CONSOLE.println("Repetir juego[S,N]");
		String resume = CONSOLE.readLine("S","N");
		return "S".equals(resume);
	}
	
	
	public static void main(String[] args) {
		
		do {
			CONSOLE.println("Jugador 1: ");
			String playerName1 = CONSOLE.readLine();
			CONSOLE.println("Jugador 2: ");
			String playerName2 = CONSOLE.readLine();
			
			new Conecta4(playerName1, playerName2).play();
			
			CONSOLE.println(winner.map(winner -> "Enhorabuena " + winner.getName()).orElse("Tablas"));
		} while (isResumeGame());
		
	}
}