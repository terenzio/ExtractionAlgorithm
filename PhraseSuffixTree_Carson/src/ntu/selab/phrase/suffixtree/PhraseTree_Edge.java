package ntu.selab.phrase.suffixtree;

import java.util.Arrays;

public class PhraseTree_Edge {
	
	public static String edgeString(int node) {
    	String [] s = Arrays.copyOfRange(PhraseTree_Root.text, PhraseTree_Root.nodes[node].start,
    			Math.min(PhraseTree_Root.position+1, PhraseTree_Root.nodes[node].end));
        String a = "";
        int count=0;
        for(String t:s){
        	if(s.length!=0){
        		a+=t;
        		count++;
        		if(count!=s.length) a+=" ";
        	}
        }
        return a;
    }
	
//	private int significanceFactor;	
//	private PhraseTree_Node startNode;
//	private PhraseTree_Node endNode;
//	private boolean telescoped;
//	
//	public int getSignificanceFactor() {
//		return significanceFactor;
//	}
//	public void setSignificanceFactor(int significanceFactor) {
//		this.significanceFactor = significanceFactor;
//	}
//	
//	public PhraseTree_Node getStartNode() {
//		return startNode;
//	}
//	public void setStartNode(PhraseTree_Node startNode) {
//		this.startNode = startNode;
//	}
//	
//	public PhraseTree_Node getEndNode() {
//		return endNode;
//	}
//	public void setEndNode(PhraseTree_Node endNode) {
//		this.endNode = endNode;
//	}
//	
//	public boolean isTelescoped() {
//		return telescoped;
//	}
//	public void setTelescoped(boolean telescoped) {
//		this.telescoped = telescoped;
//	}

}
