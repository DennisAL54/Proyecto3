import java.util.*;

public class Node {
    private int value;
    private final ArrayList<Arista> aristasList;
    private boolean visited;
    public final int idNodo;
    public int outDegree = 0;
    public int inDegree = 0;

    /**
     * Constructor de la clase.
     * @param idNodo ID del nodo a identificar.
     * @param value Numero de telefono el cual sera la entidad del nodo
     */
    public Node(int idNodo, int value) {
        this.value = value;
        this.aristasList = new ArrayList();
        this.visited = false;
        this.idNodo = idNodo;
    }

    //Setters y Getters de los atributos de la clase
    public void setOutDegree() {
        this.outDegree++;
    }

    public void setInDegree() {
        this.inDegree++;
    }

    public int getValue() {
        return this.value; 
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * Metodo para obtener una lista de nodos conectados al nodo actual mediante aristas salientes.
     * @return Lista de nodos de destino conectados al nodo actual.
     */
    public ArrayList<Node> getNodesDestination() {
        ArrayList nodesDestination = new ArrayList();
        
        for(Arista arista : aristasList) {
           nodesDestination.add(arista.getDestination());//Guardaen una lista el destino de cada arista que sale del nodo.
        }
        return nodesDestination;
    }

    /**
     * Metodo para obtener todas las aristas del nodo.
     * @return Lista de aristas entrantes y salientes.
     */
    public ArrayList<Arista> getAristas() {
        return aristasList;
    }

    
    /**
     * Metodo para agregar una arista saliente a este nodo.
     * @param pDestino Nodo de destino.
     * @param pWeight Peso de dicha arista.
     * @param idArista ID de la arista para ser identificada.
     */
    public void addArista(Node pDestino, int pWeight, int idArista) {
        boolean haveDestination = false; //Dato booleano para saber si este nodo ya tiene como destino el nodo que pasamos por parametro.
        Node destinoEncontrado = null;
        if (pDestino != this) {
            for (Node destino : this.getNodesDestination()) { //Recorre todos los nodos de destino del nodo actual.
                if (destino == pDestino){ //Si lo encuentra...
                    haveDestination = true;
                    destinoEncontrado = destino; //Asignamos dicho nodo a una variable de tipo nodo.
                }
            }
            if(haveDestination) //Si encontro el mismo nodo de destino sumamos el peso que tiene actualmente con el que se agrega.
                this.getArista(destinoEncontrado).setWeight(this.getArista(destinoEncontrado).getWeight() + pWeight);
            else // Si no se encuentra, se crea una nueva arista con el nodo de destino pasado por parametro.
                aristasList.add(new Arista(this, pDestino, pWeight, idArista));
            pDestino.setInDegree(); //Aumentamos el numero de aristas entrantes al nodo de destino
            this.setOutDegree(); //Aumentamos el numero de aristas salientes a este nodo.
        }
        
    }
    
    /**
     * Metodo para obtener el grado promedio del nodo.
     * @return Grado promedio del nodo.
     */
    public int getDegree(){
        return (this.inDegree + this.outDegree);
    }

    /**
     * Metodo para obtener la arista que da de este nodo a un nodo de destino.
     * @param pDestination Nodo de destino conectado con este nodo.
     * @return Arista que une a ambos nodos.
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