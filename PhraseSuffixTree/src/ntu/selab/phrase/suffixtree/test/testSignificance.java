package ntu.selab.phrase.suffixtree.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import ntu.selab.phrase.suffixtree.Scanner;
import ntu.selab.phrase.suffixtree.Significance;

import org.junit.Test;

public class testSignificance {

	@Test
	public void test() {
		Scanner sc = new Scanner();
		File file = new File("doc1.txt");
		try{
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while((line=br.readLine()) != null){
			//sc.scan(line);
			sc.scanToMix(line, 3);
		}
		sc.printM();
		br.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		Significance sig = new Significance();
		HashSet<String> si = sig.markSignificant(sc.getTable());
		for(String s: si)
			System.out.println("* "+s);
		
	}

}
