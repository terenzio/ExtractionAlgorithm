package ntu.selab.phrase.suffixtree.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import junit.framework.TestCase;

import org.junit.Test;

import ntu.selab.phrase.suffixtree.PhraseSuffix_Tree;


public class traverseSuffixTree extends TestCase {
	
		
	@Test
	public void test() throws Exception {
	 
		File file = new File("complex2gram.txt");
		BufferedReader in = new BufferedReader(new FileReader(file));
		PrintWriter out = new PrintWriter(new FileWriter("st.dot"));
		
		PhraseSuffix_Tree st1 = new PhraseSuffix_Tree(500000);
		
		
		 String phrase;
		while((phrase=in.readLine()) != null){
			String [] word=phrase.split(" ");
			for(int i = 0; i < word.length; i++){
				//if(i==word.length-1) word[i]+="$";
				st1.addWord(word[i]);
			}
			st1.sep();
		}
		in.close();
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
	
		st1.printFullTree(out);
		
		String searchWord; 
	 	System.out.print("Enter a phrase: ");
	 	searchWord=in.readLine();    
	 	st1.setInitialMessage(searchWord);
		st1.queryTree(1, searchWord);
		
	  	if (st1.suggestionNo == 0)  System.out.println("No Prediction Yet!");
		
	 	searchWord=in.readLine();
	 	System.out.println("");
	 	 do {
	 		st1.queryPredictionTable(1, Integer.parseInt(searchWord));
		 	searchWord=in.readLine();
	 	} while (Integer.parseInt(searchWord)!=0);	 	
	 	st1.getMessage();
	    out.close();
	 	
	 }

	

	
 
 
}
