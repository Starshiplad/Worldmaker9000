package worldbuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.*;
public class MapPanel extends JPanel{
	private int mapSize=3;
	private Map[] mapArray= new Map[mapSize];
	private boolean[] mapArrayMade= new boolean[mapSize];
	private int selectedMap=0;
	Random random= new Random();
	KeyListner keyListner= new KeyListner();
	public MapPanel() {
		int i=0;
		while(i<mapSize){
			mapArrayMade[i]=false;
			i++;
		}
		MapSelector mapSelector= new MapSelector();
		MapDisplayer mapDisplayer= new MapDisplayer();
		setPreferredSize(new Dimension(500,750));
		setBackground(Color.gray);
		add(mapSelector);
		mapSelector.addKeyListener(keyListner);
		add(mapDisplayer);
	}
	private class MapSelector extends JPanel{
		MapSelector(){
			setPreferredSize(new Dimension(500,250));
		}
		public void paint(Graphics g){
			for(int i=0;i<mapSize;i++){
				g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
				g.fillRect(20*i,20,20,20);
			}
			g.setColor(Color.yellow);
			g.drawRect(20*selectedMap, 20,22,22);
			g.drawRect(20*selectedMap, 20,21,21);
			g.drawRect(20*selectedMap, 20,20,20);
			g.drawString(String.valueOf(selectedMap),100,22);
			requestFocus(true);
			grabFocus();
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);

		}
	}
	private class MapDisplayer extends JPanel{
		public MapDisplayer(){
			setPreferredSize(new Dimension(500,500));
		}
		public void paint(Graphics g){
			if(!(mapArrayMade[selectedMap])){
				mapArray[selectedMap]=new Map(10);
				mapArrayMade[selectedMap]=true;
				mapArray[selectedMap].printMap(selectedMap);
			}
			else{
				for(int i=0;i<mapArray[selectedMap].getSize();i++){
					for(int f=0;f<mapArray[selectedMap].getSize();f++){
						if(mapArray[selectedMap].getType(i,f)==1){
							g.setColor(Color.yellow);
						}else if(mapArray[selectedMap].getType(i,f)==2){
							g.setColor(Color.blue);
						}else if (mapArray[selectedMap].getType(i,f)==3){
							g.setColor(Color.red);
						}else{
							g.setColor(Color.black);
						}
						g.fillRect(5*i, 5*f,5,5);
					}
				}
			}
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);

		}
	}
	private class KeyListner implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {

			// TODO Auto-generated method stub
			if (e.getKeyCode()==39)
			{
				if(selectedMap<mapArray.length-1){
					selectedMap++;  //Right arrow key code
					System.out.println("right");
					repaint();
				}

			}

			else if (e.getKeyCode()==37)
			{
				if(!(selectedMap==0)){
					selectedMap=(selectedMap-1);
					System.out.println("Left");
					repaint();
				}

				//Left arrow key code
			}

			repaint();

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
