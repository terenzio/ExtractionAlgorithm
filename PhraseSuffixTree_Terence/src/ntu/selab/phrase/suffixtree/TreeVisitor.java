package ntu.selab.phrase.suffixtree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TreeVisitor implements Visitor {

	public static void main(String[] args) throws Exception 
	{
		System.out.println("Starting Program.... ");
		
		TreeVisitor concreteVist = new TreeVisitor();
			try {
				concreteVist.visitTree();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	/*
	 *Suffix Tree Search and Traversal 
	 */
	public void visitTree() throws Exception{
	
		/*
		 * Read in the Corpus File
		 */
		System.out.print("STEP1: Reading Input Corpus.... ");
		File inCorpus = new File("input5000.txt");
		System.out.println("Done!"); System.out.println("");
		
		/*
		 *  Tokenizing and Parsing
		 */
		System.out.print("STEP2: Tokenizing and Parsing.... ");
		DocumentBuilder sc = new DocumentBuilder();
		PrintWriter outFrequency = null;
		try {
			outFrequency = new PrintWriter(new FileWriter("complex2gram.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			BufferedReader br = new BufferedReader(new FileReader(inCorpus));
			String line;
			while((line=br.readLine()) != null){
				sc.scanToMix(line, 2); //nGram = 2
			}
			sc.printM(outFrequency);
			br.close();
			outFrequency.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("Done!"); System.out.println("");
		
		/*
		 * Calculate Frequencies
		 */
		System.out.print("STEP3: Calculating Frequencies.... ");
		System.out.println("Done!"); System.out.println("");
		
		/*
		 * Calculating Collocations from Frequency and Print into Corpus
		 */
		System.out.print("STEP4: Calculating Collocations.... ");
		PrintWriter outCollocations = new PrintWriter(new FileWriter("complex2gram.txt",true));
		//PhraseSuffix_Tree st = new PhraseSuffix_Tree(500000);
		TreeBuilder tb = new TreeBuilder();
		PhraseSuffix_Tree st = tb.buildTree(500000);
		st.printCollocationFrequencies(inCorpus, outCollocations);
		System.out.println("Done!"); System.out.println("");
		
		/*
		 * Constructing Suffix Tree
		 */
		System.out.print("STEP5: Constructing Suffix Tree.... ");
		BufferedReader in5 = new BufferedReader(new FileReader("complex2gram.txt"));
		PrintWriter outGraphV = new PrintWriter(new FileWriter("st.dot"));
		String phrasePrior;
		while((phrasePrior=in5.readLine()) != null){
			String [] wordPrior=phrasePrior.split("=");
				String wordPrior1 = wordPrior[0];
				String [] wordPriorPrior=wordPrior1.split(" ");
				for(int j = 0; j < wordPriorPrior.length; j++){
					//if(i==word.length-1) word[i]+="$";
					st.addWord(wordPriorPrior[j]);
				}
				st.sep();
		}
		st.printFullTree(outGraphV);
		outGraphV.close();
		in5.close();
		System.out.println("Done!"); System.out.println("");
		
		/*
		 * Updating Frequency
		 */
		System.out.print("Updating Frequency.... ");
		BufferedReader in52 = new BufferedReader(new FileReader("complex2gram.txt"));
		String phrasePriorPrior;
		while((phrasePriorPrior=in52.readLine()) != null){
			String [] word2=phrasePriorPrior.split("=");
				String updatePhrase =  word2[0];
				//System.out.println("Checking: "+word2[0]);
				Double updateFreq = Double.parseDouble(word2[1]);
				String [] wordPriorPrior=updatePhrase.split(" ");
				for(int j = 0; j < wordPriorPrior.length; j++){
					//System.out.println("Checking: "+wordPriorPrior[j]+updateFreq);
						st.updateFrequency(1, wordPriorPrior[j], updateFreq);
			}
		}
		in52.close();
		System.out.println("Done!"); System.out.println("");
		outCollocations.close();
		
		/*
		 *Suffix Tree Search and Traversal 
		 */
		BufferedReader inSystem = new BufferedReader(new InputStreamReader(System.in));
		String searchWord; 
	 	System.out.print("Enter a phrase: ");
	 	searchWord=inSystem.readLine();    
	 	st.setInitialMessage(searchWord);
		st.queryTree(1, searchWord);
	  	if (st.suggestionNo == 0)  System.out.println("No Prediction Yet!");
	 	System.out.println("");
	 	st.querySuggestionKey();
	 	System.out.println("");
	 	st.queryPredsuggestionsMap();
	 	searchWord=inSystem.readLine();
	 	System.out.println("");
	 	 do {
	 		st.queryPredictionTable(1, Integer.parseInt(searchWord));
	 	 	System.out.println("");
	 	 	st.querySuggestionKey();
	 	 	System.out.println("");
	 	 	st.queryPredsuggestionsMap();
		 	searchWord=inSystem.readLine();
	 	} while (Integer.parseInt(searchWord)!=0);	 	
	 	st.getMessage();
	 }
 
		
		
		
		
	
	
	
}
