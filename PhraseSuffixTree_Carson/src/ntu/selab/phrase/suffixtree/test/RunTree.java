package ntu.selab.phrase.suffixtree.test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import ntu.selab.phrase.suffixtree.*;
import junit.framework.TestCase;

import org.junit.Test;
import static org.junit.Assert.*;



public class RunTree extends TestCase {


		//CompactSuffixTree tree = new CompactSuffixTree(new SimpleSuffixTree("bananas$"));
	BufferedReader in;
	PrintWriter out;
	 public void testBasicTreeGeneration() throws Exception{
		 
		 File file = new File("doc1.txt");
		 in = new BufferedReader(new FileReader(file));
		 out = new PrintWriter(new FileWriter("st.dot"));
	     String line;
	     
	     PhraseTree_Root phraseTree = new PhraseTree_Root(500);
	     try{
	    	 while((line=in.readLine()) != null){
	    		 String [] word=line.split(" ");
	    		 for(int i = 0; i < word.length; i++){
	    			 phraseTree.addChar(word[i]);
	    		  }
	    		 phraseTree.sep();
	    	}
	    	 in.close();
	    	 
	     } catch(IOException e){
	    	 e.printStackTrace();
	    }
	     
	     out.println("digraph {");
         out.println("\trankdir = LR;");
         out.println("\tedge [arrowsize=0.4,fontsize=10]");
         out.println("\tnode1 [label=\"\",style=filled,fillcolor=lightgrey,shape=circle,width=.1,height=.1];");
         out.println("//------edges------");
         PhraseTree_Root.printEdges(phraseTree.root);
         out.println("}");
         
         
	     out.close();
		 
		 
		 
//		 String childNodes = null;
//		 String root1 = "FirstTree";
//			
//		 SuffixTokenizer document = new SuffixTokenizer();
//		 File file = new File("doc1.txt");
//		 try{
//			 BufferedReader br = new BufferedReader(new FileReader(file));
//			 String line;
//				while((line=br.readLine()) != null){
//					childNodes = document.readLine(line);
//					System.out.println("childNodes: " + childNodes);
//				}
//				
//				br.close();
//			} catch(IOException e){
//				e.printStackTrace();
//			}
//		 
//		 PhraseTree_Root phraseTree = new PhraseTree_Root(root1);
		 
//		 phraseTree.addNode(st.readLine(line));
//		 Parser
		 
		 
//		 Sentence 1: "please call me asap if you"
//		 phraseTree.addNode("please");
//		 phraseTree.addNode("call");
//		 phraseTree.addNode("me");
//		 phraseTree.addNode("asap");
//		 phraseTree.addNode("if");
//		 phraseTree.addNode("you");
		 
//		Sentence 2:
//		 phraseTree.addNode("call");
		 
//		 phraseTree.displayPhraseTree(root1);
	 }


}

