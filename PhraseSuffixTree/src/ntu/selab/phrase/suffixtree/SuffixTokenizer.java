package ntu.selab.phrase.suffixtree;

import java.util.ArrayList;
import java.util.List;

public class SuffixTokenizer {

	//Input: "please call me asap"
	
	public void readLine (String sentence){
		String[] word = sentence.split(" ");
		for (int i = 0; i < word.length; ++i){
			List<String> childNodes = new ArrayList<String>();
			for(int j = i; j < word.length; ++j) childNodes.add(word[j]+"");
			System.out.println(childNodes);
		}
	}
	//Output:   1) please call me asap
			 // 2) call me asap
			 // 3) me asap
			 // 4) asap
	
	
	
}
