package org.cloud.apps.qa.model;

import java.util.Arrays;

public class Line {
	
	private Hole[] holes;

	public Line(Hole[] holes) {
		this.holes = holes;
	}

	public boolean isConecta4(Colour colour) {
		return Arrays.asList(holes).stream().filter(hole -> hole.hasColour(colour)).count() == 4;
	}
	
}
