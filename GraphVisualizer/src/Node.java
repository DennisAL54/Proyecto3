import java.util.*;

public class Node {
    private int value;
    private final ArrayList<Arista> aristasList;
    private boolean visited;
    public final int idNodo;
    public int outDegree = 0;
    public int inDegree = 0;

    public Node(int idNodo, int value) {
        this.value = value;
        this.aristasList = new ArrayList();
        this.visited = false;
        this.idNodo = idNodo;
    }

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
    

    public ArrayList<Node> getNodesDestination() {
        ArrayList nodesDestination = new ArrayList();
        
        for(Arista arista : aristasList) {
           nodesDestination.add(arista.getDestination());
        }
        return nodesDestination;
    }

    public ArrayList<Arista> getAristas() {
        return aristasList;
    }

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

    public Arista getArista(Node pDestination) {
        for (Arista arista : this.aristasList){
            if (arista.getDestination() == pDestination){
                return arista;
            }
        }
        return null;
    }
}