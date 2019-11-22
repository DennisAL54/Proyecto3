/**
 * Paquete e importaciones.
 */
package Modelos;
import java.util.*;
/**
 * Clase para los nodos.
 * @author Mario
 */
public class Node {
    /**
     * Variables
     */
    private int value;
    private final ArrayList<Arista> aristasList;
    private boolean visited;
    public final int idNodo;
    public int outDegree = 0;
    public int inDegree = 0;
    /**
     * Metodo para a creacion de nodos.
     * @param idNodo id que va a tener el nodo.
     * @param value valor que va a tener el nodo.
     */
    public Node(int idNodo, int value) {
        this.value = value;
        this.aristasList = new ArrayList();
        this.visited = false;
        this.idNodo = idNodo;
    }
    /**
     * Setter para el grado de salida.
     */
    public void setOutDegree() {
        this.outDegree++;
    }
    /**
     * Setter para el grado de entrada
     */
    public void setInDegree() {
        this.inDegree++;
    }
    /**
     * Getter para el valor del nodo
     * @return 
     */
    public int getValue() {
        return this.value; 
    }
    /**
     * Getter para obtener los nodos visitados.
     * @return 
     */
    public boolean getVisited() {
        return visited;
    }
    /**
     * Setter para los nodos visitados.
     * @param visited 
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    /**
     * Setter para el valor del nodo.
     * @param value valor a establecer.
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * Se obtienen los nodos de destino de las aristas y se guardan en una lista.
     * @return lista de nodos de destino.
     */
    public ArrayList<Node> getNodesDestination() {
        ArrayList nodesDestination = new ArrayList();
        
        for(Arista arista : aristasList) {
           nodesDestination.add(arista.getDestination());
        }
        return nodesDestination;
    }
    /**
     * Getter para las aristas del nodo.
     * @return array con la aristas.
     */
    public ArrayList<Arista> getAristas() {
        return aristasList;
    }
    /**
     * Agregar arista a nodo.
     * @param pNode nodo destino.
     * @param pWeight peso del arista.
     * @param idArista id del arista.
     */
    public void addArista(Node pNode, int pWeight, int idArista) {
        boolean haveDestination = false;
        Node destinoEncontrado = null;
        if (pNode != this) {
            for (Node destino : this.getNodesDestination()) {
                if (destino == pNode){
                    haveDestination = true;
                    destinoEncontrado = destino;
                }
            }
            /**
             * Si ya el nodo tiene destino.
             */
            if(haveDestination)
                this.getArista(destinoEncontrado).setWeight(this.getArista(destinoEncontrado).getWeight() + pWeight);
            else
                aristasList.add(new Arista(this, pNode, pWeight, idArista));
            this.setOutDegree();
        }
        
    }
    
    /**
     * Metodo para obtener el grado promedio del nodo
     * @return el grado promedio del nodo
     */
    public int getDegree(){
        return (this.inDegree + this.outDegree);
    }
    /**
     * Getter para el arista del nodo.
     * @param pDestination nodo de destino
     * @return arista
     */
    public Arista getArista(Node pDestination) {
        for (Arista arista : this.aristasList){
            if (arista.getDestination() == pDestination){
                return arista;
            }
        }
        return null;
    }
}
