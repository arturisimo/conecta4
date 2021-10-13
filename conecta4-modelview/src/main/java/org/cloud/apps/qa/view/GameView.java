package org.cloud.apps.qa.view;

import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.model.Player;
import org.cloud.apps.qa.view.util.Console;

public class GameView {
	
	private Conecta4 game;
	private static final Console CONSOLE = Console.getInstance();
	private int turn = 0;
	private BoardView boardView;
	
	
	public GameView() {
		this.game = new Conecta4();
	}
	
	public void init() {
		
		String[] players = new String[game.getNumPlayers()];
		for (int i = 0; i < players.length; i++) {
			CONSOLE.println(" Jugador " + i +":");
		    players[i] = CONSOLE.readLine();
		}
		game.init(players);
		boardView = new BoardView(game.getBoard());
	}

	public void play() {
		Player[] players = game.getPlayers();
		Player turnPlayer;
		do {
			turnPlayer = players[turn];
			
			CONSOLE.println("Turno " + turnPlayer.getName() + "[" + turnPlayer.getColour() + "]. Columna ? [0-"+ game.getMaxOption() + "]");
			
			int column = CONSOLE.readIntInRange(0, game.getMaxOption());
			
			putPiece(turnPlayer, column);
			
			boardView.print();
			
			turn = turn == 0 ? 1 : 0;
			
		} while (!game.end(turnPlayer));
		
		CONSOLE.println(game.getWinner().map(winner -> "Enhorabuena " + winner.getName()).orElse("Tablas"));
	}

	private void putPiece(Player player, Integer column) {
        boolean check;
        do {
            check = game.checkPutPiece(column);
            if (!check) {
            	CONSOLE.println("Movimiento no valido: Columna "+ column + " llena. Columna ? [0-"+ (game.getMaxOption()) + "]");
            	column = CONSOLE.readIntInRange(0, game.getMaxOption());
            }
        } while (!check);
        this.game.putPiece(player, column);
    }
	
	public boolean isResumeGame() {
		CONSOLE.println("Repetir juego ? [S,N]");
		String resume = CONSOLE.readLine("S","N");
		return "S".equals(resume);
	}
	
	
}
	