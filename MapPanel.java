package worldbuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
/**
 * 
 * @author Ozzy1
 *
 */
public class MapPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mapSize=10;
	private Color[] colors = new Color[mapSize];
	private Map[] mapArray= new Map[mapSize];
	private boolean[] mapArrayMade= new boolean[mapSize];
	private int selectedMap=0;
	private int blockSize=10;
	Random random= new Random();
	KeyListner keyListner= new KeyListner();
	/**
	 * 
	 */
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
	/**
	 * 
	 * @author Ozzy1
	 *
	 */
	private class MapSelector extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		MapSelector(){
			setPreferredSize(new Dimension(500,250));
			for(int i=0;i<mapSize;i++){
				colors[i]=new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
				mapArray[i]=new Map(10);
				mapArrayMade[i]=true;
				mapArray[i].printMap(i);
				
			}

		}
		/**
		 * 
		 */
		public void paint(Graphics g){
			for(int i=0;i<mapSize;i++){
				g.setColor(colors[i]);
				g.fillRect(20*i,20,20,20);
			}
			g.setColor(Color.yellow);
			g.drawRect(20*selectedMap, 20,22,22);
			g.drawRect(20*selectedMap, 20,21,21);
			g.drawRect(20*selectedMap, 20,20,20);
			g.drawString(String.valueOf(selectedMap),100,18);
			requestFocus(true);
			grabFocus();
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);

		}
	}
	/**
	 * 
	 * @param g
	 * @param x
	 * @param y
	 */
	private void drawEnemy(Graphics g,int x,int y){
		if(mapArray[selectedMap].getEnemy(x,y)){
			g.setColor(Color.red);
			g.drawOval(x*blockSize, y*blockSize,blockSize,blockSize);
		}
		
	}
	/**
	 * 
	 * @author Ozzy1
	 *
	 */
	private class MapDisplayer extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public MapDisplayer(){
			setPreferredSize(new Dimension(500,500));
		}
		/**
		 * 
		 */
		public void paint(Graphics g){
			for(int i=0;i<mapArray[selectedMap].getSize();i++){
				for(int f=0;f<mapArray[selectedMap].getSize();f++){
					if(mapArray[selectedMap].getType(i,f)==1){
						g.setColor(Color.yellow);
						drawEnemy(g,f,i);
					}else if(mapArray[selectedMap].getType(i,f)==2){
						g.setColor(Color.blue);
						drawEnemy(g,f,i);
					}else if (mapArray[selectedMap].getType(i,f)==3){
						g.setColor(Color.lightGray);
						drawEnemy(g,f,i);
					}else{
						g.setColor(Color.green);
					}
					g.fillRect(blockSize*i, blockSize*f,blockSize,blockSize);
				}
			}

		}
		/**
		 * 
		 */
		public void paintComponent(Graphics g){
			super.paintComponent(g);

		}
	}
	/**
	 * 
	 * @author Ozzy1
	 *
	 */
	private class KeyListner implements KeyListener{
		/**
		 * 
		 */
		@Override
		public void keyPressed(KeyEvent e) {

			// TODO Auto-generated method stub
			if (e.getKeyCode()==39)
			{
				repaint();
				if(selectedMap<mapArray.length-1){
					selectedMap++;  //Right arrow key code
					System.out.println("right");
					repaint();
				}

			}

			else if (e.getKeyCode()==37)
			{
				repaint();
				if(!(selectedMap==0)){
					selectedMap=(selectedMap-1);
					System.out.println("Left");
					repaint();
				}

				//Left arrow key code
			}
			else if ((e.getKeyCode()==38)||(e.getKeyCode()==40))
			{
				if(blockSize==5){
					blockSize=10;
				}else{
					blockSize=5;
				}
				repaint();
				

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
