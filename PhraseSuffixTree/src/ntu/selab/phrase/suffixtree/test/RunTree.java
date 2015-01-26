package ntu.selab.phrase.suffixtree.test;


import ntu.selab.phrase.suffixtree.*;
import junit.framework.TestCase;

import org.junit.Test;


import static org.junit.Assert.*;



public class RunTree extends TestCase {


		//CompactSuffixTree tree = new CompactSuffixTree(new SimpleSuffixTree("bananas$"));
	
	 public void testBasicTreeGeneration() {
		 
		 String root1 = "FirstTree";
			
	
		 PhraseTree_Root phraseTree = new PhraseTree_Root(root1);
		 	
		
		 phraseTree.addNode("Hello");
		 phraseTree.addNode("How");
		 phraseTree.addNode("Are");
		 phraseTree.addNode("You");
		 
		 phraseTree.displayPhraseTree(root1);
		 
		 	 
		 	
		 
	 }
	 	
	 	
	 	
}

