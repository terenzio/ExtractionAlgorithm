package ntu.selab.phrase.suffixtree;

import java.util.HashSet;
import java.util.Set;

public class PhraseTree_Root implements Aggregator {
	
	private Set<PhraseTree_Node> nodes;
	
//	public PhraseTree_Root() {
//		nodes = new HashSet<PhraseTree_Node>();
//	}
	
	protected void finalize() {
		nodes = null;
	}
	
	public void addNode(PhraseTree_Node word) {
		nodes = new HashSet<PhraseTree_Node>();
		nodes.add(word);
	
	}
	
	
}
