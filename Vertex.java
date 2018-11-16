
public class Vertex {
	public double distance;
	public int indegree;
	public Vertex path;
	public boolean known;
	public int topNum;
	
	public Vertex() {
		this.distance = 0;
		this.indegree = 0;
		this.path = null;
		this.known = false;
		this.topNum = 0;
	}
	
	public double compareTo(Vertex v) {
		return this.distance - v.distance;
		
	}
}
