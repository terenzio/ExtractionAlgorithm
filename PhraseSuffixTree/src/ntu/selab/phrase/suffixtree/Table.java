package ntu.selab.phrase.suffixtree;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.TreeMap;

public class Table {
	
	private Map<String, Integer> mixed;
	
	public Table(){
	
	mixed = new TreeMap<String, Integer>();
	}


	public void addToMix(String word){
		if(mixed.containsKey(word))
			mixed.put(word, mixed.get(word)+1);
		else
			mixed.put(word, 1);
	}
	public void printMix(){
		for(Map.Entry<String, Integer> entry : mixed.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + "=" + value);
		}
	}

}