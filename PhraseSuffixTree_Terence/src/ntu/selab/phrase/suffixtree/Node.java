package ntu.selab.phrase.suffixtree;

import java.util.TreeMap;

public class Node {
	
	
	 final int oo = Integer.MAX_VALUE/2;
	 
	 
	 /*
    There is no need to create an "Edge" class.
    Information about the edge is stored right in the node.
    [start; end) interval specifies the edge,
    by which the node is connected to its parent node.
 */

 int start, end = oo, link;
 public TreeMap<String, Integer> next = new TreeMap<String, Integer>();

 public Node(int start, int end) {
     this.start = start;
     this.end = end;
 }

 public int edgeLength() {
     return Math.min(end, SuffixTree.position + 1) - start;
 }

}
