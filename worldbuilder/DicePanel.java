package worldbuilder;
import javax.swing.*;
import java.util.*;
import java.awt.Color;
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
	Random newRandom= new Random();
	JTextArea display= new JTextArea("0");
	JTextArea display1= new JTextArea("Dice rolled: ");
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
		this.setBackground(Color.gray);
		setPreferredSize(new Dimension(xSize, ySize));
		add(display1);
		for(int i =0;i<diceArray.length;i++){
			diceArray[i]=new JButton(buttonLables[i]);
			diceArray[i].addActionListener(actionHandler);
			add(diceArray[i]);

		}
		add(display);
	}
	private String getDice(){
		return (Integer.toString(newRandom.nextInt(6)+1));
	}
	private class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){	
			for(int i =0;i<diceArray.length;i++){
				String diceConcat= "";
				if(e.getSource()==diceArray[i]){
					for(int f=0;f<(Integer.parseInt(diceArray[i].getText()));f++){
						diceConcat=diceConcat.concat(" "+getDice());
					}
					display.setText(diceConcat);
				}

			}

		}
	}
	

}
