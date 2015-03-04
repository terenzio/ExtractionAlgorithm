package ntu.selab.phrase.suffixtree;

import java.io.PrintWriter;
import java.util.Map;

public class Scanner{

	private Table table;
	public Scanner (){
		table = new Table();
	}
	
	public void scanToMix(String phrase, int window_size){  //window_size = no. of nGrams
		String[] tmp = phrase.split(" ");
		for(int i = 0; i < window_size; ++i){
			for(int j = 0; i+j < tmp.length; ++j)
			{
				String str = tmp[j];
				for(int k = 0; k < i; ++k)
					str=str+" "+tmp[j+k+1];
				System.out.println(str+ " " + i);
				table.addToMix(str);
			}
		}
	}
	
	public void printM(PrintWriter out)
	{
		table.printMix(out);
	}
	
	public Map<String, Float> getTable(){
		return table.getMap();
	}
}