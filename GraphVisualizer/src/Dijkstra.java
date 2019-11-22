import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


/**
 * Dijkstra algorithm implementations with adjacency list
 * @author pablo
 */
public class Dijkstra {

	private ArrayList<Node> unvisitedVertices;
	private HashMap<Node, D> shorestPath;
	private Node origin;
	
	/**
	 * Constructor
	 */ 
	public Dijkstra() {
            unvisitedVertices = new ArrayList<Node>();
            shorestPath = new HashMap<Node,D>();
            origin = null;
	}
	
	/**
	 * Function to get minimum vertex no visited
	 */
	private Node findMinimunVertex() {
		Node minimunVertex = unvisitedVertices.iterator().next();
		for (Node key : shorestPath.keySet()) {
			if (unvisitedVertices.contains(key) && shorestPath.get(key).getWeight() < shorestPath.get(minimunVertex).getWeight()) {
				minimunVertex = key;
			} // end if
		} // end for
		return minimunVertex;
	}
	
	/**
	 * @param pGraph 
	 * @param pOrigin
	 */ 
	public void findMinimunPath(Graph pGraph, Node pOrigin) {
		origin = pOrigin;
		unvisitedVertices.addAll(pGraph.getNodes());
		for (Node vertex : pGraph.getNodes()) {
			shorestPath.put(vertex, new D(Integer.MAX_VALUE));
		}
		shorestPath.get(origin).setPreviousVertex(origin);
		shorestPath.get(origin).setWeight(0);
		unvisitedVertices.remove(origin);
		for (Arista adjacency : origin.getAristas()) {
			shorestPath.get(adjacency.getDestination()).setPreviousVertex(adjacency.getOrigin());
			shorestPath.get(adjacency.getDestination()).setWeight(adjacency.getWeight());
		}
		while (unvisitedVertices.size() != 1) {
			Node minimunVertex = findMinimunVertex();
			unvisitedVertices.remove(minimunVertex);
			for (Node vertex : unvisitedVertices) {
				Arista arcFromMinimun = minimunVertex.getArista(vertex);
				if (arcFromMinimun != null) {
					int weight = shorestPath.get(minimunVertex).getWeight() + arcFromMinimun.getWeight();
					if (shorestPath.get(vertex).getWeight() > weight) {
						shorestPath.get(vertex).setWeight(weight);
						shorestPath.get(vertex).setPreviousVertex(minimunVertex);
					} // end if
				} // end if
			} // end for
		} // end while
	}
	
	/**
	 * Function to get the list of path vertex
	 * @param pDestination the end vertex
         * @return 
	 */
	public ArrayList<Node> getPathTo(Node pDestination) {
		Stack<Node> findPath = new Stack();
		ArrayList<Node> path = new ArrayList();
		findPath.push(pDestination);
		while (findPath.peek() != origin) {
			findPath.push(shorestPath.get(findPath.peek()).getPreviousVertex());
		}
		while(!findPath.isEmpty()) {
                    path.add(findPath.pop());
		}
		return path;
	}
	
}

/**
 * Structure to contains the path 
 * @author pablo
 *
 * @param 
 */
class D {
	private Node previousVertex;
	private int weight;
	
	/**
	 * Constructor
	 */
	public D(int pWeight) {
		previousVertex = null;
		weight = pWeight;
	}

	/**
	 * @return the previousVertex
	 */
	public Node getPreviousVertex() {
		return previousVertex;
	}

	/**
	 * @param pPreviousVertex the previousVertex to set
	 */
	public void setPreviousVertex(Node pPreviousVertex) {
		this.previousVertex = pPreviousVertex;
	}

	/**
	 * @return the distanceFromVertex
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param pDistanceFromVertex the distanceFromVertex to set
	 */
	public void setWeight(int pWeight) {
		this.weight = pWeight;
	}
}