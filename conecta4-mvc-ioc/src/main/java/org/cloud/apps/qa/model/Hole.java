package org.cloud.apps.qa.model;

import java.util.Optional;

public class Hole {
	
	private Optional<Colour> piece;
	
	public Hole() {
		super();
		this.piece = Optional.empty();
	}
		
	public Optional<Colour> getPiece() {
		return piece;
	}
	
	public void setPiece(Optional<Colour> piece) {
		this.piece = piece;
	}
	
	@Override
	public String toString() {
		return this.piece.map(Colour::name).orElse("··");
	}
}
