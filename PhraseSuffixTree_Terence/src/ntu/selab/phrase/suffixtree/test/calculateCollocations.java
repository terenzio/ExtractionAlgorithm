package ntu.selab.phrase.suffixtree.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import junit.framework.TestCase;
import ntu.selab.phrase.suffixtree.PhraseSuffix_Tree;

public class calculateCollocations extends TestCase {
	
	
	public void testTelescope() throws Exception {
		File file = new File("input3.txt");
		BufferedReader in = new BufferedReader(new FileReader(file));
		PrintWriter out = new PrintWriter(new FileWriter("st.dot"));
		
		PhraseSuffix_Tree st = new PhraseSuffix_Tree(500000);
		
		
		 String phrase;
		while((phrase=in.readLine()) != null){
			String [] word=phrase.split(" ");
			for(int i = 0; i < word.length; i++){
				if(i==word.length-1) word[i]+="$";
				st.addWord(word[i]);
			}
			st.sep();
		}
		in.close();
		st.signSignificance();
		st.printSignificanceNodes();
		st.printTree(out);
		
//For Carson:
		
//1) Total the Collocation Significance Scores
//2) Perfrom Normalization
//3) /2
//4) output to a .txt file		

		
		
        out.close();
	}
	
	
}