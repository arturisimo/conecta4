package org.cloud.apps.qa.model;

import java.util.Optional;

public class Conecta4 {
	
	private static final Integer ROWS = 6;
	public static final Integer COLUMNS = 7;
	private static final Integer NUM_PLAYERS = 2;
	private static final Integer NUM_PIECES = (ROWS * COLUMNS) / NUM_PLAYERS;
	
	private Board board;
	private Player[] players = new Player[NUM_PLAYERS];
	private Optional<Player> winner;
	
	public void init(String[] names) {
		for (int i = 0; i < names.length; i++) {
			Colour colour = Colour.get(i);
		    this.players[i] = new Player(names[i], NUM_PIECES, colour);
		}
		board = new Board(ROWS, COLUMNS);
		winner = Optional.empty();
		
	}

	public boolean end(Player player) {
		boolean isConecta4 = board.hasConecta4(player.getColour());
		if (isConecta4) winner = Optional.ofNullable(player);
		return isConecta4 || player.getPieces().isEmpty();
	}

	public boolean checkPutPiece(Integer column) {
		return board.checkPutPiece(column);
	}

	public void putPiece(Player player, int column) {
		Colour piece = player.getPiece();
		board.putPiece(piece, column);
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public Board getBoard() {
		return board;
	}

	public Optional<Player> getWinner() {
		return winner;
	}
	
	public static int getNumPlayers() {
		return NUM_PLAYERS;
	}
	
	public static int getMaxOption() {
		return COLUMNS - 1;
	}
	
}
