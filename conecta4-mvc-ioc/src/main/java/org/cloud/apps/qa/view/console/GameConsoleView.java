package org.cloud.apps.qa.view.console;

import org.cloud.apps.qa.controller.PlayController;
import org.cloud.apps.qa.controller.ResumeController;
import org.cloud.apps.qa.controller.StartController;
import org.cloud.apps.qa.view.ControllerVisitor;

public class GameConsoleView implements ControllerVisitor {
	
	private PlayerDialogView playerView;
	private PlayView playView;
	private ResumeDialogView resumeView;
	 
	public GameConsoleView() {
        this.playerView = new PlayerDialogView();
        this.playView = new PlayView();
        this.resumeView = new ResumeDialogView();
	}
	
	@Override
	public void visit(StartController startController) {
		playerView.initGame(startController);
	}

	@Override
	public void visit(PlayController playController) {
		playView.play(playController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		resumeView.resume(resumeController);
	}
		
}