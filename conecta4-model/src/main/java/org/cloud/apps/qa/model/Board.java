package org.cloud.apps.qa.model;

import java.util.Arrays;
import java.util.Optional;

public class Board {
	
	private static final Console CONSOLE = Console.getInstance();
	private Hole[][] holes;
	
	public Board(Integer rows, Integer columns) {
		this.holes = new Hole[rows][columns];
		for (int x=0; x < this.holes.length; x++) {
			  for (int y=0; y < holes[x].length; y++) {
				  this.holes[x][y] = new Hole(new Integer[]{x,y});
			  }
		}
	}
	
	public void print() {
		
		CONSOLE.println("[-------CONECTA4------]");
		for (int x=0; x < holes.length; x++) {
			  CONSOLE.print("[");
			  for (int y=0; y < holes[x].length; y++) {
			    CONSOLE.print("|" + holes[x][y].print() + "|");
			  }
			  CONSOLE.println("]");
			  CONSOLE.println("[---------------------]");
		}
	}

	public Hole[] getColumn(Integer idx) {
		Hole[] column =	new Hole[Conecta4.ROWS];
		for (int i=0; i < Conecta4.ROWS; i++) {
			column[i] = holes[i][idx];
		}
		return column;
	}
	
	public Hole[] getRow(Integer idx) {
		return holes[idx];
	}
	
	public void putPiece(Colour piece, Integer column) {
		for (int i = Conecta4.ROWS; i > 0; i--) {
			Hole hole = holes[i-1][column];
			if (!hole.getPiece().isPresent()) {
				hole.setPiece(Optional.ofNullable(piece));
				return;
			}
		}	
	}

	public boolean checkPutFicha(Integer idx) {
		Hole[] column = getColumn(idx);
		return Arrays.asList(column).stream().filter(hole -> !hole.getPiece().isPresent()).count() > 0;
	}
	
	
	public boolean isConecta4(Colour colour) {
		for (int i = 0; i < Conecta4.ROWS; i++) {
			if (new Line(getRow(i)).isConecta4(colour)) {
				return true;
			}
		}
		
		for (int i = 0; i < Conecta4.COLUMNS-1; i++) {
			if (new Line(getColumn(i)).isConecta4(colour)) {
				return true;
			}
		}
	
	    for (int i=3; i<(Conecta4.COLUMNS-1); i++){
	        for (int j=0; j<(Conecta4.ROWS-1)-3; j++){
	        	Line ascendingDiagonal = new Line(new Hole[]{holes[i][j], holes[i-1][j+1], holes[i-2][j+2], holes[i-3][j+3]});
	        	if (ascendingDiagonal.isConecta4(colour)) {
	        		return true;
	        	}
	        }
	    }
	
	    for (int i=3; i<(Conecta4.COLUMNS-1); i++){
	        for (int j=3; j<(Conecta4.ROWS-1); j++){
	        	Line descendingDiagonal = new Line(new Hole[]{holes[i][j], holes[i-1][j-1], holes[i-2][j-2], holes[i-3][j-3]});
	        	if (descendingDiagonal.isConecta4(colour)) {
	        		return true;
	        	}
	        }
	    }
		
		return false;
	}
	
}