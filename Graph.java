package pset4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class Graph {
	private Set<Integer> nodes; // set of nodes in the graph
	
	private Map<Integer, List<Integer>> edges;
	// map between a node and a list of nodes that are connected to it by outgoing edges
	// class invariant: fields "nodes" and "edges" are non-null;
	// "this" graph has no node that is not in "nodes"
	public Graph() {
		nodes = new HashSet<Integer>();
		edges = new HashMap<Integer, List<Integer>>(); //key value pair
	}
	public String toString() {
		return "nodes=" + nodes + "; " + "edges=" + edges;
	}
	public void addNode(int n) {
		// postcondition: adds the node "n" to this graph
		nodes.add(n);
	}
	public void addEdge(int from, int to) {
		// postcondition: adds a directed edge "from" -> "to" to this graph
		// your code goes here
		// ...
		
		if(!nodes.contains(from)){
			nodes.add(from);
		}
		if(!nodes.contains(to)){
			nodes.add(to);
		}
		
		if(edges.containsKey(from)){
			List<Integer> l = edges.get(from);
			l.add(to);
			
			
		}else{
			List<Integer> l = new ArrayList<Integer>();
			edges.put(from, l);
			l.add(to);
		}
		
		
		
	}
	public boolean unreachable(Set<Integer> sources, Set<Integer> targets) {
		if (sources == null || targets == null) 
			throw new IllegalArgumentException();
		// postcondition: returns true if (1) "sources" is a subset of "nodes", (2) "targets" is
		// a subset of "nodes", and (3) for each node "m" in set "targets",
		// there is no node "n" in set "sources" such that there is a
		// directed path that starts at "n" and ends at "m" in "this"; and
		// false otherwise
		// your code goes here
		// ...
		Set<Integer> nodes = this.nodes;
		Map<Integer, List<Integer>> edges = this.edges;
		
		for(Integer i : sources){
			if(!nodes.contains(i)){
				return false;
			}
		}
		for(Integer i : targets){
			if(!nodes.contains(i)){
				return false;
			}
		}
		
		for(Integer i : sources){
			List<Integer> l = edges.get(i);
			if(l == null){
				l = new ArrayList<Integer>();
			}
			for(Integer q : targets){
				if(l.contains(q)){
					return false;
				}
			}
			
		}
		
		return true;
	}
}
