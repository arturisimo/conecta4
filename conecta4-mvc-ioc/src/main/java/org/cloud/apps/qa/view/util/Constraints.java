package org.cloud.apps.qa.view.util;

import java.awt.GridBagConstraints;

public class Constraints extends GridBagConstraints {
	
	public Constraints(int gridX, int gridY, int gridWidth, int gridHeight) {
		this.gridx = gridX;
		this.gridy = gridY;
		this.gridwidth = gridWidth;
		this.gridheight = gridHeight;
		this.fill = 1;
	}


}
