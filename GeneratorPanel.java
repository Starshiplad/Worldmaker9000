package worldbuilder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.xml.internal.ws.api.config.management.policy.ManagedServiceAssertion.ImplementationRecord;

public class GeneratorPanel extends JPanel {
	int selectedButton=0;
	JTextField displayText= new JTextField();
	actionListner actionListner= new actionListner();
	String[] buttonString= new String[]{"Ants" ,"Solnum","Warhammer"};
	int buttonLength=buttonString.length;
	JButton[] Buttonarray= new JButton[buttonLength];
	JButton[] choiceArray= new JButton[]{new JButton(),new JButton(),new JButton()};
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param xSize
	 * @param ySize
	 */
	public GeneratorPanel(int xSize,int ySize) {
		// TODO Auto-generated constructor stub
		displayText.setEditable(false);
		displayText.setText("Nigger");
		setPreferredSize(new Dimension(xSize,ySize));
		setBackground(Color.green);
		for(int i=0;i<buttonLength;i++){
			Buttonarray[i]=new JButton(buttonString[i]);
			Buttonarray[i].addActionListener(actionListner);
			add( Buttonarray[i]);
		}
		int i=0;
		while(i<3){
			choiceArray[i].addActionListener(actionListner);
			add(choiceArray[i]);
			i++;
		}
		add(displayText);
	}
	private static void generateName(int type){

	}
	private static void generateEvent(int type){

	}
	private static void generateStore(int type){

	}
	private class actionListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==Buttonarray[1]){
				selectedButton=1;
			}else if
			(e.getSource()==Buttonarray[2]){
				selectedButton=2;
			}else if(e.getSource()==Buttonarray[3]){
				selectedButton=3;
			}else if(e.getSource()==choiceArray[1]){
				generateStore(selectedButton);

			}else if(e.getSource()==choiceArray[2]){
				generateEvent(selectedButton);
			}else if(e.getSource()==choiceArray[3]){
				generateName(selectedButton);

			}
		}

	}

}

