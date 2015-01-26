package ntu.selab.phrase.suffixtree;

import java.util.ArrayList;

public class PhraseTree_Node {

	private PhraseTree_Root root;
	private PhraseTree_Edge startEdge;
	private PhraseTree_Edge endEdge; 
	private ArrayList<String> childNodes = new ArrayList<String>();
	private String word; 
	private int significanceFactorNode;
	
	public PhraseTree_Root getRoot() {
		return root;
	}
	public void setRoot(PhraseTree_Root root) {
		this.root = root;
	}
	
	public PhraseTree_Edge getStartEdge() {
		return startEdge;
	}
	public void addStartEdge(PhraseTree_Edge startEdge) {
		this.startEdge = startEdge;
	}
	
	public PhraseTree_Edge getEndEdge() {
		return endEdge;
	}
	public void addEndEdge(PhraseTree_Edge endEdge) {
		this.endEdge = endEdge;
	}
	
	public ArrayList<String> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(ArrayList<String> childNodes) {
		this.childNodes = childNodes;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	
	public int getSignificanceFactorNode() {
		return significanceFactorNode;
	}
	public void setSignificanceFactorNode(int significanceFactorNode) {
		this.significanceFactorNode = significanceFactorNode;
	}
	
	
	
	
	
	

	
	
	
}
