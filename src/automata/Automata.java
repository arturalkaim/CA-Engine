package automata;

import java.awt.Graphics;
import java.util.ArrayList;

public class Automata {
	private int size;

	ArrayList<Integer> line;

	public Automata(int i) {
		size = i;
		line = new ArrayList<Integer>(i);
		for (int j = 0; j < i; j++) {
			line.add(0);
		}
		line.set(i / 2, 1);
	}

	private String neighbourToString(int index) {
		if (index == 0)
			return "0" + line.get(index) + "" + line.get(index + 1);
		if (index == size - 1)
			return line.get(index - 1) + "" + line.get(index) + "0";
		else
			return line.get(index - 1) + "" + line.get(index) + ""
					+ line.get(index + 1);
	}

	@SuppressWarnings("unused")
	private int nextValue(String s) {
		switch (s) {
		case "000":
			return 0;
		case "001":
			return 1;
		case "010":
			return 0;
		case "100":
			return 1;
		case "011":
			return 1;
		case "110":
			return 1;
		case "101":
			return 0;
		case "111":
			return 1;
		}
		return 0;
	}
	@SuppressWarnings("unused")
	private int nextValue30(String s) {
		switch (s) {
		case "000":
			return 0;
		case "001":
			return 1;
		case "010":
			return 1;
		case "100":
			return 1;
		case "011":
			return 1;
		case "110":
			return 0;
		case "101":
			return 0;
		case "111":
			return 0;
		}
		return 0;
	}
	private int nextValue110(String s) {
		switch (s) {
		case "000":
			return 0;
		case "001":
			return 1;
		case "010":
			return 1;
		case "100":
			return 0;
		case "011":
			return 1;
		case "110":
			return 1;
		case "101":
			return 1;
		case "111":
			return 0;
		}
		return 0;
	}
	private int nextValue007(String s) {
		switch (s) {
		case "000":
			return 1;
		case "001":
			return 0;
		case "010":
			return 1;
		case "100":
			return 0;
		case "011":
			return 1;
		case "110":
			return 0;
		case "101":
			return 1;
		case "111":
			return 0;
		}
		return 0;
	}
	public ArrayList<Integer> run(int L, Graphics g, GridsCanvas gridsCanvas){
		printLine();
		for (int i = 0; i < L; i++) {
			line = computeNextLine();
			gridsCanvas.paintLine(g, i,line);
			printLine();
		}
		
		return line;
	}

	private void printLine() {
		for (Integer i : line) {
			System.out.print((i==0?" ":"W") + " ");
		}
		System.out.println();
	}

	private ArrayList<Integer> computeNextLine() {
		ArrayList<Integer> next = new ArrayList<Integer>(size);

		for (int i = 0; i < size; i++) {
			next.add(nextValue(neighbourToString(i)));
		}
		
		return next;
	}
}
