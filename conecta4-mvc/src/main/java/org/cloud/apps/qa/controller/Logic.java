package org.cloud.apps.qa.controller;

import org.cloud.apps.qa.model.Board;
import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.model.Player;
import org.cloud.apps.qa.view.util.Msgs;

/**
 * Clase facade que llama a la logica de negocio
 */
public class Logic {
	
    private Conecta4 game;
    private PlayController playController;
    private ResumeController resumeController;
    private StartController startController;
    
    public Logic(Conecta4 game) {
        this.game = game;
        this.playController = new PlayController(game);
        this.resumeController = new ResumeController(game);
        this.startController = new StartController(game);
    }
	
	public void initPlayers(String[] namePlayers) {
		startController.initPlayers(namePlayers);
	}
    
    public boolean checkPutPiece(Integer column) {
		return playController.checkPutPiece(column);
	}
    
    public boolean isEndGame(Player player) {
		return playController.isEndGame(player);
	}

	public void putPiece(Player player, Integer column) {
		this.game.putPiece(player, column);
	}

	public Player[] getPlayers() {
		return game.getPlayers();
	}

	public String getEndMessage() {
		return game.getWinner().map(winner -> String.format(Msgs.WINNER, winner.getName())).orElse(Msgs.NO_PIECES);
	}

	public Board getBoard() {
		return game.getBoard();
	}

	public int getMaxOption() {
		return Conecta4.COLUMNS -1;
	}
	
	public int getNumPlayers() {
		return Conecta4.NUM_PLAYERS;
	}

	public void reset() {
		resumeController.reset(); 
		
	}
		
    
    
}
