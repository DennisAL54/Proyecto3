public class Arista {
    private Node origin;
    private Node destination;
    private int weight;
    public int idArista;

    public Arista(Node pOrigin, Node pDestination, int pWeight, int idArista) {
        this.origin = pOrigin;
        this.destination = pDestination;
        this.weight = pWeight;
        this.idArista = idArista;
        pDestination.setInDegree();
    }

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

    public int compareTo(Arista pArc) {
        return Integer.compare(this.weight,pArc.getWeight());
    }	
    
    public boolean haveThisID (int idArista){
        return this.idArista == idArista;
    }
}