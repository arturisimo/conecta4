package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.view.GameView;

public class GameConsoleView extends GameView {
	
	private PlayerDialogView playerView;
	private PlayView playView;
	private ResumeDialogView resumeView;
	
	 
	public GameConsoleView(Conecta4 game) {
        super(game);
        this.playerView = new PlayerDialogView(logic);
        this.playView = new PlayView(logic);
        this.resumeView = new ResumeDialogView(logic);
	}
	
	
	@Override
	public void init() {
		logic.reset();
		String[] namePlayers = new String[logic.getNumPlayers()];
		for (int i = 0; i < namePlayers.length; i++) {
			namePlayers[i] = playerView.getPlayerName(i);
		}	
		logic.initPlayers(namePlayers);
		
	}
	
	@Override
	public void play() {
		playView.play();
	}

	
	@Override
	public boolean isResumeGame() {
		return resumeView.resumeGame();
	}
	
	
}
	