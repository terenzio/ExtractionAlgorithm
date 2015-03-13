package ntu.selab.phrase.suffixtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TreeElement {

	
	public void collectFrequencies() {
		
		
		FrequencyAggregator fa = new FrequencyAggregator(); 
		try {
			fa.aggregateFrequency();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public void acceptVisitors(PrintWriter out) {
		    TreeBuilder tb = new TreeBuilder();
			PhraseSuffix_Tree st = tb.buildTree(500000);
			st.printFullTree(out);
	 }
	
	
}
