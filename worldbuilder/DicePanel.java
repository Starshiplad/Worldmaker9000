package worldbuilder;
import javax.swing.*;
import java.util.*;
import java.awt.Dimension;
import java.awt.event.*;


import javax.imageio.ImageIO;
/**
 * DicePanel is a JPanel that contains 3 buttons and a text box.
 * The buttons can be chosen to make the textbox show 1,3 or 6 rolls of 1-6.
 * It's size is defined in consstruction
 * 
 *@author StarshipladDev
 *@version 1.0
 */
public class DicePanel extends JPanel {
	private int xSize=0;
	private int ySize=0;
	String[] buttonLables= new String[]{"1","3","5"};
	JButton[] diceArray= new JButton[buttonLables.length];
	private ActionHandler actionHandler= new ActionHandler();
	/**
	 * 
	 * 
	 * @param xSize- xSize is the intended width of th component
	 * @param ySize- ySize is the intended hight of the component
	 */
	public DicePanel(int xSize, int ySize){
		this.xSize= xSize;
		this.ySize = ySize;
		setPreferredSize(new Dimension(xSize, ySize));
		for(int i =0;i<diceArray.length;i++){
			diceArray[i]=new JButton(buttonLables[i]);
			diceArray[i].addActionListener(actionHandler);
			add(diceArray[i]);
			
		}
	}
	
	private class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){	
			
		}
	}

}
