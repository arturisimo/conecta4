package org.cloud.apps.qa.model;

import java.util.Arrays;
import java.util.Optional;

public class Hole {
	
	private Integer[] coordenada;
	private Optional<Colour> piece;
	
	public Hole(Integer[] coordenada) {
		super();
		this.coordenada = coordenada;
		this.piece = Optional.empty();
	}
	
	public boolean hasColour(Colour color) {
		return piece.map(p -> p.equals(color)).orElse(false);
	}
	
	public Optional<Colour> getPiece() {
		return piece;
	}

	public void setPiece(Optional<Colour> piece) {
		this.piece = piece;
	}

	public String print() {
		return this.piece.map(Colour::name).orElse(" ");
	}
	
	@Override
	public String toString() {
		return "[" + print() + " : " + Arrays.toString(coordenada) + "]";
	}
}
