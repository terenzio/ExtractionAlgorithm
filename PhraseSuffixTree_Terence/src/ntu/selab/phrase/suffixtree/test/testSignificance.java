package ntu.selab.phrase.suffixtree.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;

import ntu.selab.phrase.suffixtree.Scanner;
import ntu.selab.phrase.suffixtree.Significance;

import org.junit.Test;

public class testSignificance {

	@Test
	public void test() throws IOException {
		
		PrintWriter out;
		 out = new PrintWriter(new FileWriter("parsedDocument2.txt"));
		
		Scanner sc = new Scanner();
		File file = new File("input.txt");
		try{
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while((line=br.readLine()) != null){
			//sc.scan(line);
			sc.scanToMix(line, 2);
		}
		sc.printM(out);
		br.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("------------------------------");
		
		float thr = (float) 1/16;
		Significance sig = new Significance();
		sig.threshold(sc.getTable(), thr);
		for(Map.Entry<String, Float> entry: sc.getTable().entrySet())
		{
			//System.out.println(entry.getKey() + " : "+entry.getValue());
			//System.out.println(entry.getKey());
		}
		HashSet<String> si = sig.markSignificant(sc.getTable());
		//for(String s: si)
			//System.out.println("* "+s);
		
	}

}
