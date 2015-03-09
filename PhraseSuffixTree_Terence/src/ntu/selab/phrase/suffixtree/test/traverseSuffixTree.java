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
	 
		File file = new File("complex2gram2.txt");
		BufferedReader in = new BufferedReader(new FileReader(file));
		BufferedReader in2 = new BufferedReader(new FileReader(file));
		PrintWriter out = new PrintWriter(new FileWriter("st.dot"));
		
		PhraseSuffix_Tree st1 = new PhraseSuffix_Tree(500000);
		
		System.out.println("Constructing Tree.... ");
		String phrase;
		while((phrase=in.readLine()) != null){
			String [] wordPrior=phrase.split("=");
		//	for(int i = 0; i < wordPrior.length; i++){
				String wordPrior1 = wordPrior[0];
				String [] wordPriorPrior=wordPrior1.split(" ");
				for(int j = 0; j < wordPriorPrior.length; j++){
					//if(i==word.length-1) word[i]+="$";
					//System.out.println("Adding phrase "+j+": "+wordPriorPrior[j]);
					st1.addWord(wordPriorPrior[j]);
				}
				st1.sep();
	//		}
		}
		
		System.out.println("Updating Frequency.... ");
		String phrase2;
		while((phrase2=in2.readLine()) != null){
			String [] word2=phrase2.split("=");
				String updatePhrase =  word2[0];
				Double updateFreq = Double.parseDouble(word2[1]);
				String [] wordPriorPrior=updatePhrase.split(" ");
				for(int j = 0; j < wordPriorPrior.length; j++){
				//	if (j!=0) {
						//System.out.print("Updating phrase: ["+wordPriorPrior[j]+"]");
						//System.out.println(" with freq: "+updateFreq);
						st1.updateFrequency(1, wordPriorPrior[j], updateFreq);
				//	}
			}
		}
		
		in.close();
		in2.close();
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
	
		st1.printFullTree(out);
		
		String searchWord; 
	 	System.out.print("Enter a phrase: ");
	 	searchWord=in.readLine();    
	 	st1.setInitialMessage(searchWord);
		st1.queryTree(1, searchWord);
	  	if (st1.suggestionNo == 0)  System.out.println("No Prediction Yet!");
	 	System.out.println("");
	 	st1.querySuggestionKey();
	 	System.out.println("");
	 	st1.queryPredsuggestionsMap();
	 	searchWord=in.readLine();
	 	System.out.println("");
	 	 do {
	 		st1.queryPredictionTable(1, Integer.parseInt(searchWord));
	 	 	System.out.println("");
	 	 	st1.querySuggestionKey();
	 	 	System.out.println("");
	 	 	st1.queryPredsuggestionsMap();
		 	searchWord=in.readLine();
	 	} while (Integer.parseInt(searchWord)!=0);	 	
	 	st1.getMessage();
	    out.close();
	 	
	 }

	

	
 
 
}
