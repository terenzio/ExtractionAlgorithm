package ntu.selab.phrase.suffixtree;

import java.util.*;



public class PhraseTree_Root implements Aggregator {
	
	final static int oo = Integer.MAX_VALUE/2;
	static PhraseTree_Node [] nodes;
    static String [] text;
    public static int root, position = -1,
            currentNode,
            needSuffixLink,
            remainder;

    int active_node, active_length, active_edge;
    ArrayList<Integer> hasLink= new ArrayList<Integer>(); 
	
	public PhraseTree_Root(int length) {
        nodes = new PhraseTree_Node[2* length + 2];
        text = new String[length];
        root = active_node = newNode(-1, -1);
    }
	
	private void addSuffixLink(int node) {
        if (needSuffixLink > 0)
            nodes[needSuffixLink].link = node;
        needSuffixLink = node;
    }

    String active_edge() {
        return text[active_edge];
    }

    boolean walkDown(int next) {
        if (active_length >= nodes[next].edgeLength()) {
            active_edge += nodes[next].edgeLength();
            active_length -= nodes[next].edgeLength();
            active_node = next;
            return true;
        }
        return false;
    }

    int newNode(int start, int end) {
        nodes[++currentNode] = new PhraseTree_Node(start, end);
        return currentNode;
    }

    public void addChar(String c) throws Exception {
    	text[++position]=c;
        needSuffixLink = -1;
        remainder++;
        while(remainder > 0) {
            if (active_length == 0) active_edge = position;
            if (!nodes[active_node].next.containsKey(active_edge())){
                int leaf = newNode(position, oo);
                nodes[active_node].next.put(active_edge(), leaf);
                addSuffixLink(active_node); //rule 2
            } else {
                int next = nodes[active_node].next.get(active_edge());
                if (walkDown(next)) continue;   //observation 2
                if (text[nodes[next].start + active_length].equals(c)) { //observation 1
                    active_length++;
                    addSuffixLink(active_node); // observation 3
                    break;
                }
                int split = newNode(nodes[next].start, nodes[next].start + active_length);
                nodes[active_node].next.put(active_edge(), split);
                int leaf = newNode(position, oo);
                nodes[split].next.put(c, leaf);
                nodes[next].start += active_length;
                nodes[split].next.put(text[nodes[next].start], next);
                addSuffixLink(split); //rule 2
            }
            remainder--;

            if (active_node == root && active_length > 0) {  //rule 1
                active_length--;
                active_edge = position - remainder + 1;
            } else
                active_node = nodes[active_node].link > 0 ? nodes[active_node].link : root; //rule 3
        }
    }
    
    public void sep(){
    	remainder = 0;
   	 	active_node = root;
   	 	active_length = 0;
   	 	active_edge = 0;
   	 	for(int i = 0; i < hasLink.size(); i++)
   	 		nodes[hasLink.get(i)].link=0;
   	 	for(int i = 1; i < nodes.length; ++i){
   	 		if(nodes[i] == null)
   	 			break;
   	 		nodes[i].end=Math.min(position + 1, nodes[i].end);
   	 	}
    }
    public static void printEdges(int x) {
        for (int child : nodes[x].next.values()) {
            System.out.println("\tnode"+x+" -> node"+child+" [label=\""+PhraseTree_Edge.edgeString(child)+"\",weight=3]");
            printEdges(child);
        }
    }
	
//	private String rootName;
//	//private HashSet<PhraseTree_Node> nodes;
//	private Collection<PhraseTree_Node> nodes = null;
//
//	private int nodeCount = 0;
//	private int nodeDepth = 0;
//	private int edgeCount = 0;
//	
//	public PhraseTree_Root(String rootName) {		
//		this.rootName = rootName;
//		//nodes = new HashSet<PhraseTree_Node>();
//		nodes = new ArrayList<PhraseTree_Node>();
//		nodeDepth = 0;
//		//label = 0;
//	}
//	
//	protected void finalize() {
//		nodes = null;
//	}
//	
//
//	
//	public void addNode(String word) {
//		PhraseTree_Node nodeData = new PhraseTree_Node(word);
//		nodes.add(nodeData);
//		
//	}
//	
//	public void displayPhraseTree(String rootName) {		
//		System.out.println("Dislaying Tree: " + rootName);		
//		if (rootName == this.rootName) {
//		
//			java.util.Iterator<PhraseTree_Node> iterator = nodes.iterator();
//			
//			while( iterator.hasNext()) {		
//				System.out.println("Node:" + iterator.next().getWord() + "");
//			}
//		
//		}
//	}
	
	
}
