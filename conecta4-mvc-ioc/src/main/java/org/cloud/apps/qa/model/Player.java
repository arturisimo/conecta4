package org.cloud.apps.qa.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private Colour colour;
	private String name;
	private List<Colour> pieces;
	
	public Player(String name, Integer numPieces, Colour colour) {
		this.name = name;
		this.colour = colour;
		this.pieces = new ArrayList<>();
		
		for (int i = 0; i < numPieces; i++) {
			this.pieces.add(colour);
		}
	}


	public String getName() {
		return name;
	}

	public Colour getColour() {
		return colour;
	}

	public List<Colour> getPieces() {
		return pieces;
	}
	
	public Colour getPiece() {
		this.pieces.remove(pieces.size()-1);
		return pieces.get(pieces.size()-1);
	}

}
