package worldbuilder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
/**
 * 
 * @author Ozzy1
 *
 */
public class Logo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage logo;
	/**
	 * 
	 */
	public Logo(){
		try{
			logo=ImageIO.read(new File("img/Logo.png"));
		}
		catch(IOException e){
			
		}
		setPreferredSize(new Dimension(500,250));
	}
	/**
	 * 
	 */
	public void paint (Graphics g){
		g.drawImage(logo,0,0,null);
	}
}
