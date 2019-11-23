public class Arista {
    private Node origin;
    private Node destination;
    private int weight;
    public int idArista;

    /**
     * Constructor de la clase.
     * @param pOrigin Nodo del cual sale la arista.
     * @param pDestination Nodo donde llega la arista.
     * @param pWeight Peso de la arista simulando la duracion de la llamada.
     * @param idArista ID de la arista para ser identificada.
     */
    public Arista(Node pOrigin, Node pDestination, int pWeight, int idArista) {
        this.origin = pOrigin;
        this.destination = pDestination;
        this.weight = pWeight;
        this.idArista = idArista;
    }

    //Getters y Setters de los atributos de la clase.
    public Node getOrigin() {
        return origin;
    }

    public void setOrigin(Node origin) {
        this.origin = origin;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int pWeight) {
        this.weight = pWeight;
    }
    
    /**
     * Metodo para comparar el peso de dos aristas.
     * @param pArista Arista que sera comparada con la actual.
     * @return 0 si los pesos son iguales, mayor a 0 si el peso de la arista actual es mayor, menor que 0 si el peso de la arista actual es menor.
     */
    public int compareTo(Arista pArista) {
        return Integer.compare(this.weight, pArista.getWeight());
    }	
}