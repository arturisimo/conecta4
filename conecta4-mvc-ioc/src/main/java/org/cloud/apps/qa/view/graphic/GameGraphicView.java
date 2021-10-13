package org.cloud.apps.qa.view.graphic;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.model.Player;
import org.cloud.apps.qa.view.GameView;
import org.cloud.apps.qa.view.util.Constraints;
import org.cloud.apps.qa.view.util.Msgs;

public class GameGraphicView extends GameView { 
	
	private PlayGraphicView playView;
	private PlayerDialogGraphicView playerView;
	private ResumeDialogGraphicView resumeView;
	private FrameView frameView;
	private BoardGraphicView boardView;
	
	public GameGraphicView(Conecta4 game) {
		super(game);
		this.frameView = new FrameView();
		this.playerView = new PlayerDialogGraphicView(logic);
		this.playView = new PlayGraphicView(logic);
        this.resumeView = new ResumeDialogGraphicView();
        this.boardView = new BoardGraphicView();
	}
	
	@Override
	public void init() {
		this.frameView.removeAll();
		playerView.playersPanel();
		frameView.getContentPane().add(playerView, new Constraints(0, 1, 1, 1));
		frameView.setVisible(true);
		String[] namePlayers;
		do {
			namePlayers = playerView.getPlayers();
			sleep();
        } while (namePlayers[0]==null);
		
		playerView.removeAll();
		logic.initPlayers(namePlayers);
		JLabel title = new JLabel(String.format(Msgs.PLAYERS, (Object[])namePlayers));
		frameView.add(title);
	    boardView.print(logic.getBoard());
	    frameView.getContentPane().add(boardView, new Constraints(0, 4, 1, 1));
	    boardView.setVisible(true);
	}
	

	@Override
	public void play() {
		Player[] players = logic.getPlayers();
		Player turnPlayer;
		int turn = 0;
		do {
			turnPlayer = players[turn];
			String turnMessage = String.format(Msgs.TURN, turnPlayer.getName(), turnPlayer.getColour(), logic.getMaxOption());
			JLabel panelTurn = new JLabel(turnMessage);
			playView.add(panelTurn, new Constraints(0, 1, 1, 1));
			frameView.getContentPane().add(this.playView, new Constraints(0, 3, 1, 1));
			frameView.setVisible(true);
			Integer column; 
			do {
				column = playView.getColumn();
				sleep();
			} while (column==null);
			
			playView.setColumn(null);
			
			if (putPiece(turnPlayer, column)) {
				boardView.removeAll();
				boardView.print(logic.getBoard());
				frameView.getContentPane().add(boardView, new Constraints(0, 4, 1, 1));
				frameView.setVisible(true);
				turn = turn == 0 ? 1 : 0;
				playView.remove(panelTurn);
			}
		} while (!logic.isEndGame(turnPlayer));
		
		JOptionPane.showMessageDialog(null, logic.getEndMessage(), "FIN", JOptionPane.INFORMATION_MESSAGE);
	    
	}

	private boolean putPiece(Player player, Integer column) {
        boolean check = logic.checkPutPiece(column);
        if (check) {
        	logic.putPiece(player, column);
        } else {
        	JOptionPane.showMessageDialog(null, String.format(Msgs.FULL_COLUMN_ERROR, column), "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        return check;
    }
	
	@Override
	public boolean isResumeGame() {
		return resumeView.resumeGame();
	}
	
	private void sleep() {
		try {
			Thread.sleep(1);
		} catch (Exception e) {
		}
	}	
}
