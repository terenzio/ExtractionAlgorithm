package ntu.selab.phrase.suffixtree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FrequencyAggregator {
	
	
	
	
	public void aggregateFrequency() throws IOException {
		
		System.out.print("STEP1: Reading Input Corpus.... ");
		File inCorpus = new File("input5000.txt");
		System.out.println("Done!"); System.out.println("");
		
		System.out.print("STEP2: Tokenizing and Parsing.... ");
		DocumentBuilder sc = new DocumentBuilder();
		PrintWriter outFrequency;
		outFrequency = new PrintWriter(new FileWriter("complex2gram.txt"));
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
	}
		
}
