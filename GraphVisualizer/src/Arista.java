package Modelos;
/**
 * Clase para las aristas.
 * @author Mario 
 */
public class Arista {
    /**
     * Variables.
     */
    private Node origin;
    private Node destination;
    private int weight;
    public int idArista;
    /**
     * Metodo pafra la creación de aristas para los nodos.
     * @param pOrigin nodo de rigen.
     * @param pDestination nodo de destino.
     * @param pWeight peso a asignarle al arista.
     * @param idArista identificacion del arista.
     */
    public Arista(Node pOrigin, Node pDestination, int pWeight, int idArista) {
        this.origin = pOrigin;
        this.destination = pDestination;
        this.weight = pWeight;
        this.idArista = idArista;
        pDestination.setInDegree();
    }
    /**
     * Metodo para obtener el nodo origen del arista.
     * @return nodo de origen
     */
    public Node getOrigin() {
        return origin;
    }
    /**
     * Metodo para establecer el nodo origen del arista.
     * @param origin nodo origen a establecer.
     */
    public void setOrigin(Node origin) {
        this.origin = origin;
    }
    /**
     * Metodo para obtener el nodo destino del arista.
     * @return nodo destino del origen.
     */
    public Node getDestination() {
        return destination;
    }
    /**
     * Metodo para establecer el nodo destino del arista.
     * @param destination nodo destino.
     */
    public void setDestination(Node destination) {
        this.destination = destination;
    }
    /**
     * Metodo para obtener el peso del arista.
     * @return peso del arista.
     */
    public int getWeight() {
        return weight;
    }
    /**
     * Metodo para establecer el peso del arista.
     * @param pWeight 
     */
    public void setWeight(int pWeight) {
        this.weight = pWeight;
    }
    /**
     * Metodo de comparación 
     * @param pArc Arista
     * @return 
     */
    public int compareTo(Arista pArc) {
        return Integer.compare(this.weight,pArc.getWeight());
    }	
    /**
     * Metodo para saber si el id del arista existe.
     * @param idArista id del arista.
     * @return true / false.
     */
    public boolean haveThisID (int idArista){
        return this.idArista == idArista;
    }
}
