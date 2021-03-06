package automata;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** This is the demo class. */

public class App extends Frame {
  /*
   * Construct a GfxDemo2 given its title, width and height. Uses a
   * GridBagLayout to make the Canvas resize properly.
   */
  App(String title, int w, int h, int rows, int cols) {
    setTitle(title);

    // Now create a Canvas and add it to the Frame.
    GridsCanvas xyz = new GridsCanvas(w, h, rows, cols, 16);
    add(xyz);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        setVisible(false);
        dispose();
      }
    });

    // Normal end ... pack it up!
    pack();
  }

  public static void main(String[] a) {
    new App("Cellular Automaton", 600, 600, 40, 80).setVisible(true);
  }
}
