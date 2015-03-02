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
		
		
//		try(PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("complex2gram.txt", true)))) {
//		    out2.println("the text");
//		}catch (IOException e) {
//		    //exception handling left as an exercise for the reader
//		}
		
		
        out.close();
	}
	
	
}