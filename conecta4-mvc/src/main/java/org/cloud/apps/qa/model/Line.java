package org.cloud.apps.qa.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Line {
	
	private Hole[] holes;

	public Line(Hole[] holes) {
		this.holes = holes;
	}

	public boolean isConecta4(Colour colour) {
		String c4 = colour.name()+colour.name()+colour.name()+colour.name();
		return Arrays.asList(holes).stream().map(hole -> hole.getPiece().map(Colour::name).orElse(" ")).collect(Collectors.joining()).contains(c4);
	}
	
}
