package automata;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Program to draw grids.
 * 
 * @author Ian Darwin, http://www.darwinsys.com/
 */
class GridsCanvas extends Canvas {
	private int width, height;

	private int rows;

	private int cols;

	private int cs;

	GridsCanvas(int w, int h, int r, int c, int cellSize) {
		setSize(width = w, height = h);
		rows = r;
		cols = c;
		cs = cellSize;
	}

	public void paint(Graphics g) {
		width = getSize().width;
		height = getSize().height;

		Automata a = new Automata(cols);
		a.run(rows,g,this);
		// draw the rows
		/*for (i = 0; i < rows; i++)
			paintLine(g, i);*/

	}

	public void paintLine(Graphics g, int i, ArrayList<Integer> line) {
		int rowWid = width / (cols);
		int rowHt = height / (rows);
		boolean test = true;
		for (int j = 0; j < cols; j++) {
			if (line.get(j)==1) {
				g.setColor(Color.BLACK);
			}else
				g.setColor(Color.WHITE);
			test= !test;
			g.fillRect(j * cs, i * cs, rowWid, rowHt);
			g.setColor(Color.black);
			g.drawRect(j * cs, i * cs, rowWid, rowHt);
		}
	}
}
