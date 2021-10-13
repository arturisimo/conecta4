package org.cloud.apps.qa.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Console {
	
	private static Console instance = new Console();
	
	public static Console getInstance() {
		return instance;
	}
	
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	public void print(String string) {
		System.out.print(string);
	}
	public void println(String string) {
		System.out.println(string);
	}
	
	public String readLine() {
		String input = null;
		try {
			input = this.bufferedReader.readLine();
		} catch (Exception ex) {
		}
		return input;
	}
	public String readLine(String... options) {
		String input = readLine();
		while (!Arrays.asList(options).contains(input)) {
			println("Error: se espera "+Arrays.toString(options));
			input = readLine();
		}
		return input;
	}
	
	private int readInt() {
		String line = readLine();
		int input = 0;
		try {
			input = Integer.parseInt(line);			
		} catch (Exception e) {
			println("Error: se espera un nuúmero.");
			return readInt();
		}
		return input;
	}
	
	public int readIntInRange(int min, int max) {
		int input = readInt();
		while (min > input || input > max) {
			println("Error: se espera un número: ["+min+"-"+max+"]");
			input = readInt();
		}
		return input;
	}
	
}