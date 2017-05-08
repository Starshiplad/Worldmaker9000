package worldbuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 * 
 * @author Ozzy1
 *
 */
public class Map {
	private boolean[][] isFull;
	private int[][] types;
	private boolean enemy[][];
	Random random=new Random();
	/**
	 * 
	 * @param Size
	 */
	public Map(int Size) {
		enemy= new boolean[Size][Size];
		isFull= new boolean[Size][Size];
		types= new int[Size][Size];
		for(int i=0;i<Size;i++){
			for(int f=0;f<Size;f++){
				isFull[i][f]=random.nextBoolean();
			}
		}
		for(int i=0;i<Size;i++){
			for(int f=0;f<Size;f++){
				if(isFull[i][f]){
					types[i][f]=random.nextInt(3)+1;
					if(random.nextInt(5)>3){
						enemy[i][f]=true;
					}
				}
			}
		}

		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @return
	 */
	public int getSize(){
		return isFull.length;
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int getType(int x, int y){
		return types[y][x];
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean getEnemy(int x, int y){
		return enemy[y][x];
	}
	/**
	 * 
	 * @param serial
	 */
	public void printMap(int serial){
		String output= ("Map "+serial+".txt");
		File outputFile= new File(output);
		try{
			fileWriter writer= new fileWriter(outputFile,false);
			for(int i=0;i<getSize();i++){

				for(int f=0;f<getSize();f++){
					if(f>0){
						writer.write(" ");;
					}
					if(getType(f,i)==1){
						writer.write("[$] ");
					}else if(getType(f,i)==2){
						writer.write("[*] ");
					}else if(getType(f,i)==3){
						writer.write("[^] ");
					}else{
						writer.write("[ ] ");;
					}

				}
				writer.write("\r\n"+"\n");;
			}
			writer.close();
		}catch(IOException e){

		}
	}
	/**
	 * 
	 * @author Ozzy1
	 *
	 */
	private class fileWriter extends FileWriter{

		public fileWriter(File file, boolean append) throws IOException {
			super(file, append);
			// TODO Auto-generated constructor stub
		}



	}



}
