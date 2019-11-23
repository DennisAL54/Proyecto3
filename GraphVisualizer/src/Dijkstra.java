
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Dijkstra {

	private final ArrayList<Node> unvisitedVertices;
	private final HashMap<Node, D> shorestPath;
	private Node origin;
	
	/**
	 * Constructor de la clase.
	 */ 
	public Dijkstra() {
            unvisitedVertices = new ArrayList<>();
            shorestPath = new HashMap<>();
            origin = null;
	}
	
	/**
	 * Funcion para obtener el vertice minimo no visitado.
	 */
	private Node findMinimunVertex() {
		Node minimunVertex = unvisitedVertices.iterator().next();
		for (Node key : shorestPath.keySet()) {
			if (unvisitedVertices.contains(key) && shorestPath.get(key).getWeight() < shorestPath.get(minimunVertex).getWeight()) {
				minimunVertex = key;
			}
		}
		return minimunVertex;
	}
	
	/**
         * Metodo para encontrar la ruta mas corta de cada nodo, (D0).
	 * @param pGraph Grafo que sera recorrido.
	 * @param pOrigin Nodo al cual se enontrara la ruta mas corta.
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
					}
				}
			}
		}
	}
	
	/**
	 * Metodo para obtener una lista de nodos formando la ruta mas corta hacia un nodo de destino.
	 * @param pDestination Nodo de destino.
         * @return Lista de nodos formanod la ruta.
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


class D {
	private Node previousVertex;
	private int weight;
	
	/**
	 * Constructor de la clase.
	 */
	public D(int pWeight) {
		previousVertex = null;
		weight = pWeight;
	}
        
        //Getters y Setters.
	public Node getPreviousVertex() {
		return previousVertex;
	}
        
	public void setPreviousVertex(Node pPreviousVertex) {
		this.previousVertex = pPreviousVertex;
	}
        
	public int getWeight() {
		return weight;
	}
        
	public void setWeight(int pWeight) {
		this.weight = pWeight;
	}
}