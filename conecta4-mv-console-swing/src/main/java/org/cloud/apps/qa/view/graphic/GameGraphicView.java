package org.cloud.apps.qa.view.graphic;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.cloud.apps.qa.model.Conecta4;
import org.cloud.apps.qa.model.Player;
import org.cloud.apps.qa.view.GameView;
import org.cloud.apps.qa.view.util.Constraints;
import org.cloud.apps.qa.view.util.Msgs;

public class GameGraphicView extends JFrame implements GameView { 
	
	private static final long serialVersionUID = 6838941282842730691L;
	private Conecta4 game;
	private BoardPanel boardView;
	private PlayerDialogPanel playerDialog;
	private ColumnDialogPanel columnDialog;
	private ResumeDialogGraphicView resumeDialog;
	int turn = 0;
	
	public GameGraphicView() {
		super(Msgs.TITLE);
		this.game = new Conecta4();
		this.getContentPane().setLayout(new GridBagLayout());
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        playerDialog = new PlayerDialogPanel();
        columnDialog = new ColumnDialogPanel();
        boardView = new BoardPanel();
        resumeDialog = new ResumeDialogGraphicView();
	}
	
	@Override
	public void init() {
		
		getContentPane().add(this.playerDialog, new Constraints(0, 1, 1, 1));
        setVisible(true);
		String[] players;
		do {
			players = playerDialog.getPlayers();
			sleep();
        } while (players[0]==null);
		
		playerDialog.removeAll();
		game.init(players);
		JLabel title = new JLabel(String.format(Msgs.PLAYERS, players));
	    this.add(title);
	    boardView.print(game.getBoard());
	    this.getContentPane().add(boardView, new Constraints(0, 4, 1, 1));
		this.setVisible(true);
	}

	@Override
	public void play() {
		Player[] players = game.getPlayers();
		Player turnPlayer;
		do {
			turnPlayer = players[turn];
			String turnMessage = String.format(Msgs.TURN, turnPlayer.getName(), turnPlayer.getColour(), Conecta4.getMaxOption());
			JLabel panelTurn = new JLabel(turnMessage);
			columnDialog.add(panelTurn, new Constraints(0, 1, 1, 1));
			this.getContentPane().add(this.columnDialog, new Constraints(0, 3, 1, 1));
			this.setVisible(true);
			Integer column; 
			do {
				column = columnDialog.getColumn();
				sleep();
			} while (column==null);
			
			columnDialog.setColumn(null);
			
			if (putPiece(turnPlayer, column)) {
				boardView.removeAll();
				boardView.print(game.getBoard());
				this.getContentPane().add(boardView, new Constraints(0, 4, 1, 1));
				setVisible(true);
				turn = turn == 0 ? 1 : 0;
				columnDialog.remove(panelTurn);
			}
		} while (!game.end(turnPlayer));
		
		String endMessage = game.getWinner().map(winner -> String.format(Msgs.WINNER, winner.getName())).orElse(Msgs.NO_PIECES);
		JOptionPane.showMessageDialog(null, endMessage, "FIN", JOptionPane.INFORMATION_MESSAGE);
		
	}

	private boolean putPiece(Player player, Integer column) {
        boolean check = game.checkPutPiece(column);
        if (check) {
        	  game.putPiece(player, column);
        } else {
        	JOptionPane.showMessageDialog(null, String.format(Msgs.FULL_COLUMN_ERROR, column), "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        return check;
    }
	
	@Override
	public boolean isResumeGame() {
		return resumeDialog.resumeGame();
	}
	
	private void sleep() {
		try {
			Thread.sleep(1);
		} catch (Exception e) {
		}
	}
	
}
