package worldbuilder;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.*;

/**
 * 
 * WorldBuilderApp constructs the components necessary for worldBuilder9000 then packages them and dispalys a window
 * @author StarshipladDev
 * @version 1.0
 */
public class WorldBuilderApp {

	static final long serialVersionUID= 0;
	/**
	 * main runs as soon as the app is run, preforming WorldBuilderApp's functions
	 * @param args - Who knows what this does?
	 */

	public static void main(String[] args) {
		DicePanel dicePanel= new DicePanel(500,500);
		Logo logo= new Logo();
		JFrame worldFrame= new JFrame("WorldBuilder9000");
		worldFrame.setSize(750,1000);
		worldFrame.setLayout(new GridLayout(3,2));
		worldFrame.add(dicePanel);
		worldFrame.add(logo);
		worldFrame.pack();
		worldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		worldFrame.setVisible(true);
	}

}
