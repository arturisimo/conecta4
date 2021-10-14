package org.cloud.apps.qa.model;

import java.util.Arrays;

public enum ModeGame {
	G,C;

	public static ModeGame get(String mode) {
		return Arrays.asList(ModeGame.values()).stream().filter(m->m.name().equals(mode)).findFirst().get();
	}
}
