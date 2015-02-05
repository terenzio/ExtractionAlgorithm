package ntu.selab.phrase.suffixtree.test;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import junit.framework.TestCase;
import ntu.selab.phrase.suffixtree.SuffixTree;

public class runStackOverF_Tree extends TestCase {
	
	

	
	public void testSO_TreeGeneration() throws Exception{
		
			BufferedReader in;
		    PrintWriter out = null;
//		 	String[] word = null; 
		
		  	in = new BufferedReader(new InputStreamReader(System.in));
	        try {
				out = new PrintWriter(new FileWriter("st.dot"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        Scanner input = new Scanner(System.in);
	        int f = input.nextInt();
	        
	        SuffixTree st1 = new SuffixTree(500);
	        //Suppose a document has 500 words at most
	        
	        String[] word; 
	       	
	       	while(f-->0){
	       	word=in.readLine().split(" ");
	        for(int i = 0; i < word.length; ++i)
	        {
	        	 st1.addChar(word[i]);
	        }
	        st1.sep();
	       	}
	  
	       // st1.printNodes();
	        st1.printTree(out);
	        out.close();
	       	
		
	}
	
	
}
