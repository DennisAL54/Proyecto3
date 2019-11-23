/**
 * Paquete e importaciones.
 */
package Modelos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


/**
 * Algoritmo dijkstra con lista de adyacencia
 * @author Mario
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
         * Funcion para obtener el minimo vertice no visitado
	 */
	private Node findMinimunVertex() {
		Node minimunVertex = unvisitedVertices.iterator().next();
		for (Node key : shorestPath.keySet()) {
			if (unvisitedVertices.contains(key) && shorestPath.get(key).getWeight() < shorestPath.get(minimunVertex).getWeight()) {
				minimunVertex = key;
			} // fin if
		} // fin for
		return minimunVertex;
	}
	
	/**
         * Metodo para encontrar el camino mas corto de un nodo a otro.
	 * @param pGraph nodo al que se decea llegar.
	 * @param pOrigin nodo de origen.
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
					} // fin if
				} // fin if
			} // fin for
		} // fin while
	}
	
	/**
	 * Función para obtener la lista de rutas de un vertice.
	 * @param pDestination vertice de destino
         * @return ruta.
	 */
	public ArrayList<Node> getPathTo(Node pDestination) {
		Stack<Node> findPath = new Stack();
		ArrayList<Node> path = new ArrayList();
		findPath.push(pDestination);
		while (findPath.peek() != origin) {
			findPath.push(shorestPath.get(findPath.peek()).getPreviousVertex());
		}
                /**
                 * si la lista no está vacía.
                 */
		while(!findPath.isEmpty()) {
                    path.add(findPath.pop());
		}
		return path;
	}
	
}

/**
 * Estructura para guardar la ruta
 * @author Mario
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
	 * @return vertice anterior
	 */
	public Node getPreviousVertex() {
		return previousVertex;
	}

	/**
	 * @param pPreviousVertex el vertice anterior a establecer
	 */
	public void setPreviousVertex(Node pPreviousVertex) {
		this.previousVertex = pPreviousVertex;
	}

	/**
         * Metodo para obtener el peso.
	 * @return peso
	 */
	public int getWeight() {
		return weight;
	}

	/**
         * Metodo para establecer el peso.
         * @param pWeight 
         */
	public void setWeight(int pWeight) {
		this.weight = pWeight;
	}
}
