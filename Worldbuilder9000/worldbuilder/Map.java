package worldbuilder;
import java.awt.Color;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Map {
	private boolean[][] isFull;
	private int[][] types;
	Random random=new Random();

	public Map(int Size) {

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
				}
			}
		}
		// TODO Auto-generated constructor stub
	}
	public int getSize(){
		return isFull.length;
	}
	public int getType(int x, int y){
		return types[y][x];
	}
	public void printMap(int serial){
		String output= ("Map "+serial+".txt");
		File outputFile= new File(output);
		try{
			fileWriter writer= new fileWriter(outputFile,true);
			for(int i=0;i<getSize();i++){
				for(int f=0;f<getSize();f++){
					if(getType(f,i)==1){
						writer.write("Y");
					}else if(getType(f,i)==2){
						writer.write("B");
					}else if(getType(f,i)==3){
						writer.write("R");
					}else{
						writer.write("X");;
					}

				}
				writer.write("\r\n");;
			}
			writer.close();
		}catch(IOException e){

		}
	}
	private class fileWriter extends FileWriter{

		public fileWriter(File file, boolean append) throws IOException {
			super(file, append);
			// TODO Auto-generated constructor stub
		}



	}



}
