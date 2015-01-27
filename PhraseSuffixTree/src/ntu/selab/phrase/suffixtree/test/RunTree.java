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
		 
		 //Level 1:
		 phraseTree.addNode("please");
		 phraseTree.addNode("call");
		 phraseTree.addNode("me");
		 phraseTree.addNode("asap");
		 phraseTree.addNode("if");
		 phraseTree.addNode("you");
		 
		//Level 2:
		 //phraseTree.addNode("call", 2, 1);
		 
		 
		 
		 
		 phraseTree.displayPhraseTree(root1);
		 
		 	 
		 	
		 
	 }
	 	
	 	
	 	
}

