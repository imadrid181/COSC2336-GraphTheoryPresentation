import java.util.*;
public class WeightedGraph {
	
	Map<Vertex,List<Edge>> wGraph;
	int numOfVertices;
	Queue<Vertex> topSortList;
	
	public WeightedGraph() {
		this.wGraph = new HashMap<Vertex,List<Edge>>();
		this.numOfVertices = 0;		
		this.topSortList = new LinkedList<Vertex>();
	}
	
	
	public void weightedNegative(Vertex s) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		for(Vertex key : wGraph.keySet()) {
			key.distance = Double.POSITIVE_INFINITY;
		}
		
		while(!q.isEmpty()) {
			Vertex v = q.poll();
			
			for(Edge z : wGraph.get(v)) {
				if(z.destination.distance > v.distance + z.weight) {
					z.destination.distance = v.distance + z.weight;
					z.destination.path = v;
					
					if(!q.contains(z.destination))
						q.add(z.destination);
				}					
			}	
		}
	}
	
	public void dijkstra(Vertex s) {
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		for(Vertex key : wGraph.keySet()) {
			key.distance = Double.POSITIVE_INFINITY;
			key.known = false;
		}
		s.distance = 0;
		q.add(s);
		while(!q.isEmpty()) {
			Vertex v = q.poll();
			while(v.known == false)
				v = q.poll();
			v.known = true;
			
			for(Edge z : wGraph.get(v)) {
				if(z.destination.distance > v.distance + z.weight) {
					z.destination.distance = v.distance + z.weight;
					z.destination.path = v;
					q.add(z.destination);
					
				}					
			}	
		}
	}

}
