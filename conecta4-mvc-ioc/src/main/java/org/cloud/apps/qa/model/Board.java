package org.cloud.apps.qa.model;

import java.util.Arrays;
import java.util.Optional;

public class Board {
	
	private Hole[][] holes;
	
	private int rows;
	private int columns;
	
	public Board(Integer rows, Integer columns) {
		this.rows = rows;
		this.columns = columns;
		this.reset();
	}
	
	public Hole[][] getHoles() {
		return holes;
	}
	
	public void putPiece(Colour piece, Integer column) {
		for (int i = rows; i > 0; i--) {
			Hole hole = holes[i-1][column];
			if (!hole.getPiece().isPresent()) {
				hole.setPiece(Optional.ofNullable(piece));
				return;
			}
		}	
	}

	public boolean checkPutPiece(Integer idx) {
		if (idx == null) return false;
		Hole[] column = getColumn(idx);
		return Arrays.asList(column).stream().filter(hole -> !hole.getPiece().isPresent()).count() > 0;
	}
	
	
	public boolean hasConecta4(Colour colour) {
		for (int i = 0; i <rows; i++) {
			if (new Line(getRow(i)).isConecta4(colour)) {
				return true;
			}
		}
		
		for (int i = 0; i < columns-1; i++) {
			if (new Line(getColumn(i)).isConecta4(colour)) {
				return true;
			}
		}
	
	    for (int i=3; i<(columns-1); i++){
	        for (int j=0; j<(rows-1)-3; j++){
	        	Line ascendingDiagonal = new Line(new Hole[]{holes[i][j], holes[i-1][j+1], holes[i-2][j+2], holes[i-3][j+3]});
	        	if (ascendingDiagonal.isConecta4(colour)) {
	        		return true;
	        	}
	        }
	    }
	
	    for (int i=3; i<(columns-1); i++){
	        for (int j=3; j<(rows-1); j++){
	        	Line descendingDiagonal = new Line(new Hole[]{holes[i][j], holes[i-1][j-1], holes[i-2][j-2], holes[i-3][j-3]});
	        	if (descendingDiagonal.isConecta4(colour)) {
	        		return true;
	        	}
	        }
	    }
		
		return false;
	}
	
	public Hole[] getColumn(Integer idx) {
		Hole[] column =	new Hole[rows];
		for (int i=0; i < rows; i++) {
			column[i] = holes[i][idx];
		}
		return column;
	}
	
	public Hole[] getRow(Integer idx) {
		return holes[idx];
	}

	public void reset() {
		this.holes = new Hole[rows][columns];
		for (int x=0; x < this.holes.length; x++) {
			  for (int y=0; y < holes[x].length; y++) {
				  this.holes[x][y] = new Hole();
			  }
		}
	}
	
}