package worldbuilder;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;

/**
 * 
 * WorldBuilderApp constructs the components necessary for worldBuilder9000 then packages them and dispalys a window
 * @author StarshipladDev
 * @version 1.0
 */
public class WorldBuilderApp{

	static final long serialVersionUID= 0;
	/**
	 * main runs as soon as the app is run, preforming WorldBuilderApp's functions
	 * @param args - Who knows what this does?
	 */
	


	public static void main(String[] args) {
		DicePanel dicePanel= new DicePanel(500,125);
		GeneratorPanel generatorPanel= new GeneratorPanel(500,125);
		GridLayout bigGrid= new GridLayout(2,3);
		GridLayout grid1= new GridLayout(1,2);
		GridLayout grid2= new GridLayout(1,1);
		GridLayout grid3= new GridLayout(1,1);
		Logo logo= new Logo();
		MapPanel mapPanel= new MapPanel();
		JFrame worldFrame= new JFrame("WorldBuilder9000");
		worldFrame.setSize(1000,1000);
		
		worldFrame.setLayout(bigGrid);
		worldFrame.add(dicePanel);
		worldFrame.add(generatorPanel);
		worldFrame.add(logo);
		worldFrame.add(mapPanel);
		mapPanel.requestFocus(true);
		worldFrame.pack();
		worldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		worldFrame.setVisible(true);

		
		
	}

	
}
