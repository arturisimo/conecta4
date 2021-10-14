package org.cloud.apps.qa.view.graphic;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.cloud.apps.qa.controller.PlayController;
import org.cloud.apps.qa.controller.ResumeController;
import org.cloud.apps.qa.controller.StartController;
import org.cloud.apps.qa.model.Player;
import org.cloud.apps.qa.view.ControllerVisitor;
import org.cloud.apps.qa.view.util.Constraints;
import org.cloud.apps.qa.view.util.Msgs;

public class GameGraphicView implements ControllerVisitor { 
	
	private PlayGraphicView playView;
	private PlayerDialogGraphicView playerView;
	private ResumeDialogGraphicView resumeView;
	private FrameView frameView;
	private BoardGraphicView boardView;
	
	public GameGraphicView() {
		this.frameView = new FrameView();
		this.playerView = new PlayerDialogGraphicView();
		this.playView = new PlayGraphicView();
        this.resumeView = new ResumeDialogGraphicView();
        this.boardView = new BoardGraphicView();
	}


	@Override
	public void visit(StartController startController) {
		
		this.frameView.removeAll();
		playerView.playersPanel(startController);
		frameView.getContentPane().add(playerView, new Constraints(0, 1, 1, 1));
		frameView.setVisible(true);
		String[] namePlayers;
		do {
			namePlayers = playerView.getPlayers();
        } while (namePlayers[0]==null);
		
		playerView.removeAll();
		startController.initPlayers(namePlayers);
		JLabel title = new JLabel(String.format(Msgs.PLAYERS, (Object[])namePlayers));
		frameView.add(title);
	    boardView.print(startController.getBoard());
	    frameView.getContentPane().add(boardView, new Constraints(0, 4, 1, 1));
	    boardView.setVisible(true);
		
	}


	@Override
	public void visit(PlayController playController) {
		Player[] players = playController.getPlayers();
		Player turnPlayer;
		int turn = 0;
		do {
			turnPlayer = players[turn];
			String turnMessage = String.format(Msgs.TURN, turnPlayer.getName(), turnPlayer.getColour(), playController.getMaxOption());
			JLabel panelTurn = new JLabel(turnMessage);
			playView.add(panelTurn, new Constraints(0, 1, 1, 1));
			frameView.getContentPane().add(this.playView, new Constraints(0, 3, 1, 1));
			frameView.setVisible(true);
			Integer column; 
			do {
				column = playView.getColumn();
			} while (column==null);
			
			playView.setColumn(null);
			
			if (putPiece(playController, turnPlayer, column)) {
				boardView.removeAll();
				boardView.print(playController.getBoard());
				frameView.getContentPane().add(boardView, new Constraints(0, 4, 1, 1));
				frameView.setVisible(true);
				turn = turn == 0 ? 1 : 0;
				playView.remove(panelTurn);
			}
		} while (!playController.isEndGame(turnPlayer));
		
		JOptionPane.showMessageDialog(null, playController.getEndMessage(), "FIN", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private boolean putPiece(PlayController playController, Player player, Integer column) {
        boolean check = playController.checkPutPiece(column);
        if (check) {
        	playController.putPiece(player, column);
        } else {
        	JOptionPane.showMessageDialog(null, String.format(Msgs.FULL_COLUMN_ERROR, column), "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        return check;
    }
	

	@Override
	public void visit(ResumeController resumeController) {
		resumeView.resume(resumeController);
	}	
}
