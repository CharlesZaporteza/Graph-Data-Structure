package pset4;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
public class GraphTester {
	// tests for method "addEdge" in class "Graph"
	@Test public void tae0() {
		Graph g = new Graph();
		g.addEdge(0, 1);
		assertEquals(g.toString(), "nodes=[0, 1]; edges={0=[1]}");
	}
	
	// your tests for method "addEdge" in class "Graph" go here

	@Test public void tae1() {
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		assertEquals(g.toString(), "nodes=[0, 1, 2]; edges={0=[1], 1=[2]}");
	}
	@Test public void tae2() {
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(1, 0);
		assertEquals(g.toString(), "nodes=[0, 1]; edges={0=[1], 1=[0]}");
	}
	@Test public void tae3() {
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(0, 1);
		assertEquals(g.toString(), "nodes=[0, 1]; edges={0=[1, 1]}");
	}
	@Test public void tae4() {
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(2, 3);
		assertEquals(g.toString(), "nodes=[0, 1, 2, 3]; edges={0=[1], 2=[3]}");
	}
	@Test public void tae5() {
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		assertEquals(g.toString(), "nodes=[0, 1, 2, 3]; edges={0=[1], 2=[3], 3=[0]}");
	}
	@Test public void tae6() {
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		assertEquals(g.toString(), "nodes=[0, 1, 2]; edges={0=[1, 2]}");
	}
	@Test public void tae7() {
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(2, 0);
		assertEquals(g.toString(), "nodes=[0, 1, 2]; edges={0=[1, 2], 2=[1, 0]}");
	}
	@Test public void tae8() {
		Graph g = new Graph();
		g.addNode(0);
		g.addNode(1);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		assertEquals(g.toString(), "nodes=[0, 1, 2]; edges={0=[1], 1=[2]}");
	}
	
	// you must provide at least 4 test methods;
	// each test method must have at least 1 invocation of addEdge;
	// each test method must have at least 1 test assertion;
	// your test methods must provide full statement coverage of your
	// implementation of addEdge and any helper methods
	// no test method directly invokes any method that is not
	// declared in the Graph class as given in this homework
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	// tests for method "unreachable" in class "Graph"
	@Test public void tr0() {
		Graph g = new Graph();
		g.addNode(0);
		Set<Integer> nodes = new HashSet<Integer>();
		nodes.add(0);
		assertTrue(g.unreachable(new HashSet<Integer>(), nodes));
	}
	// your tests for method "unreachable" in class "Graph" go here
	
	@Test public void tr1() {
		Graph g = new Graph();
		g.addEdge(0, 1);
		
		Set<Integer> sources = new HashSet<Integer>();
		sources.add(0);
		
		Set<Integer> targets = new HashSet<Integer>();
		targets.add(0);
		
		assertTrue(g.unreachable(sources, targets));
	}
	
	@Test public void tr2() {
		Graph g = new Graph();
		g.addEdge(0, 1);
		
		Set<Integer> sources = new HashSet<Integer>();
		sources.add(0);
		
		Set<Integer> targets = new HashSet<Integer>();
		targets.add(1);
		
		
		assertFalse(g.unreachable(sources, targets));
	}
	
	@Test public void tr3() {
		Graph g = new Graph();
		g.addNode(0);
		Set<Integer> sources = new HashSet<Integer>();
		sources.add(2);
		
		Set<Integer> targets = new HashSet<Integer>();
		targets.add(0);
		

		
		assertFalse(g.unreachable(sources, targets));
	}
	
	@Test public void tr4() {
		Graph g = new Graph();
		g.addNode(0);
		Set<Integer> sources = new HashSet<Integer>();
		sources.add(0);
		
		Set<Integer> targets = new HashSet<Integer>();
		targets.add(2);
		
		
		
		assertFalse(g.unreachable(sources, targets));
	}
	@Test public void tr5() {
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(2, 3);
		
		
		Set<Integer> sources = new HashSet<Integer>();
		sources.add(0);
		sources.add(2);
		
		Set<Integer> targets = new HashSet<Integer>();
		targets.add(2);
		
	
		
		assertTrue(g.unreachable(sources, targets));
	}
	
	@Test public void tr6() {
		Graph g = new Graph();
		g.addNode(0);
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		
		
		
		Set<Integer> sources = new HashSet<Integer>();
		sources.add(1);
		sources.add(3);
		
		Set<Integer> targets = new HashSet<Integer>();
		targets.add(2);
		
		
		
		assertTrue(g.unreachable(sources, targets));
	}
	@Test public void tr7() {
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		g.addEdge(1, 4);
		
		
		
		Set<Integer> sources = new HashSet<Integer>();
		sources.add(0);
		sources.add(1);
		sources.add(3);
		
		Set<Integer> targets = new HashSet<Integer>();
		targets.add(1);
		targets.add(2);
		targets.add(4);
		
		
		
		
		assertFalse(g.unreachable(sources, targets));
	}
	@Test(expected = IllegalArgumentException.class) 
	public void tr8(){
		Graph g = new Graph();
		
		Set<Integer> sources = null;
		Set<Integer> targets = null;
		
		
		
		assertTrue(g.unreachable(sources, targets));
	}
	public void tr9(){
		Graph g = new Graph();
		
		Set<Integer> sources = new HashSet<Integer>();
		sources.add(0);
		
		Set<Integer> targets = new HashSet<Integer>();
		
		
		
		assertTrue(g.unreachable(sources, targets));
	}
	public void tr10(){
		Graph g = new Graph();
		
		Set<Integer> sources = new HashSet<Integer>();
		Set<Integer> targets = new HashSet<Integer>();
		sources.add(0);
		
		
		
		assertTrue(g.unreachable(sources, targets));
	}
	public void tr11(){
		Graph g = new Graph();
		
		Set<Integer> sources = new HashSet<Integer>();
		Set<Integer> targets = new HashSet<Integer>();
		
		assertTrue(g.unreachable(sources, targets));
	}
	
	
	// you must provide at least 6 test methods;
	// each test method must have at least 1 invocation of unreachable;
	// each test method must have at least 1 test assertion;
	// at least 2 test methods must have at least 1 invocation of addEdge;
	// your test methods must provide full statement coverage of your
	// implementation of unreachable and any helper methods
	// no test method directly invokes any method that is not
	// declared in the Graph class as given in this homework
}