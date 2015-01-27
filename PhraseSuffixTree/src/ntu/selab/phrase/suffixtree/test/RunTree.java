package ntu.selab.phrase.suffixtree.test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import ntu.selab.phrase.suffixtree.*;
import junit.framework.TestCase;

import org.junit.Test;



import static org.junit.Assert.*;



public class RunTree extends TestCase {


		//CompactSuffixTree tree = new CompactSuffixTree(new SimpleSuffixTree("bananas$"));
	
	 public void testBasicTreeGeneration() {
		 
		 String root1 = "FirstTree";
			
//		 Scanner sc = new Scanner();
//		 SuffixTokenizer st = new SuffixTokenizer();
//		 
//			File file = new File("doc1.txt");
//			try{
//			BufferedReader br = new BufferedReader(new FileReader(file));
//			String line;
//			while((line=br.readLine()) != null){
//				//sc.scan(line);
//				st.readLine(line);
//				sc.scanToMix(line, 3);
//			}
		
		 
		 PhraseTree_Root phraseTree = new PhraseTree_Root(root1);
		 
	//	 phraseTree.addNode(st.readLine(line));

		 //Parser
	    
		 
		 
		 //Sentence 1: "please call me asap if you"
		 phraseTree.addNode("please", 1);
		 phraseTree.addNode("call", 1);
		 phraseTree.addNode("me", 1);
		 phraseTree.addNode("asap");
		 phraseTree.addNode("if");
		 phraseTree.addNode("you");
		 
		//Sentence 2:
		 phraseTree.addNode("call", 2);
		 
		 
		 
		 
		 phraseTree.displayPhraseTree(root1);
		 
		 	 
		 	
		 
	 }
	 	
	 	
	 	
}

