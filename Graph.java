import java.util.*;
public class Graph {
	
	Map<Vertex,List<Vertex>> graph;
	int numOfVertices;
	Queue<Vertex> topSortList;
	
	public Graph() {
		this.graph = new HashMap<Vertex,List<Vertex>>();
		this.numOfVertices = 0;
		this.topSortList = new LinkedList<Vertex>();
	}
	
	public void topsort() {
		Queue<Vertex> q = new LinkedList<Vertex>();
		int counter = 0; 
		
		for(Vertex key : graph.keySet()) {
			q.add(key);
		}
		
		while(!q.isEmpty()) {
			Vertex v = q.poll();
			v.topNum = ++counter;
			topSortList.add(v);

			for(Vertex z : graph.get(v)) {
				if(--z.indegree == 0)
					q.add(z);
			}
				
		}
		if(counter > numOfVertices) 
			return;
	}
	
	public void unweightedShortestPath(Vertex x) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		for(Vertex key : graph.keySet()) {
			key.distance = Double.POSITIVE_INFINITY;
		}
		
		x.distance = 0;
		q.add(x);
		
		while(!q.isEmpty()) {
			Vertex v = q.poll();
			
			for(Vertex z : graph.get(v)) {
				if(z.distance == Double.POSITIVE_INFINITY) {
					z.distance = v.distance + 1;
					z.path = v;
					q.add(z);
				}
					
			}
		}
	}
	
	public void DAGshortestPath(Vertex x) {
		topsort();
		for(Vertex key : graph.keySet()) {
			key.distance = Double.POSITIVE_INFINITY;
		}
		
		x.distance = 0;
				
		while(!topSortList.isEmpty()) {
			Vertex v = topSortList.poll();
			for(Vertex z : graph.get(v)) {
				if(z.distance == Double.POSITIVE_INFINITY) {
					z.distance = v.distance + 1;
					z.path = v;
				}
					
			}
		}
	}

}
