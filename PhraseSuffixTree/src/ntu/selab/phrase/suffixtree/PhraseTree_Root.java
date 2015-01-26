package ntu.selab.phrase.suffixtree;

import java.util.HashSet;
import java.util.Set;

public class PhraseTree_Root implements Aggregator {
	
	private String rootName;
	private Set<PhraseTree_Node> nodes;
	
	public PhraseTree_Root(String rootName) {		
		this.rootName = rootName;
		nodes = new HashSet<PhraseTree_Node>();
	}
	
	protected void finalize() {
		nodes = null;
	}
	
//	public void addNode(PhraseTree_Node word) {
//		//nodes = new HashSet<PhraseTree_Node>();
//		this.nodes.add(word);
//	
//	}
	
	public void addNode(String word) {
	//nodes = new HashSet<PhraseTree_Node>();
	PhraseTree_Node newNode = new PhraseTree_Node();	
	newNode.setWord(word);

	}
	
	public void addNodes(String word) {
		//nodes = new HashSet<PhraseTree_Node>();
		nodes.add(null);
		
		}
	
	public void displayPhraseTree(String rootName) {
		
	}
	
}
