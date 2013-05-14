package leBrowser;

import java.awt.*;
import javax.swing.*;

public class Cat {
  public static void main(String[] args) {
		Bacon dude = new Bacon();
		//making a new object from class Bacon, and setting the GUI's default close operation to exit.
		//note: by making a new object, it called the constructor in Bacon class.
		//the constructor was "public Bacon() { all the server code and stuff }"
		dude.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
