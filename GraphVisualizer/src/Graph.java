

import java.util.*;

public class Graph{
    private final ArrayList<Node> nodes;
    private int idNodo = 1;
    private int idArista = 1;
    public int idGrafo;

    /**
     * Metodo para la creacion de un nuevo grafo.
     * @param idGrafo Indica el id del grafo para diferenciarlo de otros.
     */
    public Graph(int idGrafo) {
        nodes = new ArrayList(); // lista de nodos.
        this.idGrafo = idGrafo;
    }
    
    /**
     * Metodo para obtener la lista de nodos del grafo. 
     * @return Retorna la lista de nodos.
     */
    public ArrayList<Node> getNodes(){
        if (nodes.isEmpty())
            return null;
        return nodes;
    }
    
    /**
     * Metodo para agregar nodo al grafo
     * @param Value Numero de telefono asociado al nodo.
     * @return Retorna el nodo.
     */
    public Node addNode(int Value) { // agregar nodo al grafo
        for (Node node : nodes) {
            if(node.getValue() == Value) {
                return node;
            }
        }
        Node result = new Node(idNodo++, Value);
        nodes.add(result);
        return result;
    }
    
    /**
     * Metodo para actualizar el numero de telefono
     * @param idNodo ID del vertices del grafo que sera actualizado.
     * @param value Numero de telefono a actualizar.
     */
    public void actualizarEntidad(int idNodo, int value){
        for (Node node : nodes) {
            if(node.idNodo == idNodo)
                node.setValue(value);
        }
    }
    
    /**
     * Metodo para obtener un nodo cualquiera.
     * @param idNodo ID del nodo a obtener.
     * @return Nodo buscado.
     */
    public Node getNodo(int idNodo){
        for (Node node : nodes) {
            if(node.idNodo == idNodo)
                return node;
        }
        return null;
    }
    
    /**
     * Metodo para borrar todos los nodos del grafo.
     */
    public void borrarNodos(){
        nodes.clear();
    }
    
    /**
     * Metodo para borrar un nodo especifico.
     * @param idNodo ID del nodo a borrar.
     */
    public void borrarNodo(int idNodo){
        nodes.remove(idNodo-1);
    }
    
    /**
     * Metodo para agregar aristas en formato dirigido a un nodo dentro del grafo.
     * @param Origen Nodo del cual sale la arista
     * @param Destino Nodo donde incide la arista.
     * @param pWeight Peso del arista.
     */
    public void addArista(Node Origen, Node Destino, int pWeight) { // agregar aristas entre nodos de un nodo a otro
        for (Node node : nodes) {
            if (Origen == node) { // se busca el nodo de origen y se le agrega la arista
                node.addArista(Destino, pWeight, idArista++);
            }
        }
    }
    
    /**
     * Metodo para actualizar una arista especifica.
     * @param idArista ID de la arista a actualizar.
     * @param Peso Peso de la arista.
     */
    public void ActualizarArista(int idArista, int Peso){
        for (Arista ari : this.getAristas()) {
            if(ari.idArista == idArista)
                ari.setWeight(Peso);
        }
    }
    
    /**
     * Metodo para obtener la lista de aristas del grafo.
     * @return Retorna lista de aristas.
     */
    public ArrayList<Arista> getAristas() { // obtener aristas
        ArrayList<Arista> aristas = new ArrayList(); // array para almacenar las aristas del grafo
            for (Node nodeIndex : nodes) {  
                aristas.addAll(nodeIndex.getAristas());
            }
        return aristas;
    }
    
    /**
     * Metodo para eliminar todas las aristas del grafo.
     */
    public void borrarAristas(){
        this.getAristas().clear();
    }
    
    /**
     * Metodo para borrar una arista especifica.
     * @param idArista ID de la arista a eliminar.
     */
    public void borrarArista(int idArista){
        try{
            this.getAristas().remove(idArista-1);
            for (Node node : nodes) {
                for (Arista ari : node.getAristas()) {
                    if(ari.idArista == idArista)
                        node.getAristas().remove(ari);
                }
            }
        }
        catch(Exception e){}
    }
    
    /**
     * Metodo para obtener una lista de nodos de la ruta mas corta de un nodo a otro por el algoritmo de Dijkstra.
     * @param origen Nodo de salida.
     * @param destino Nodo de llegada.
     * @return Lista de nodos formando la ruta mas corta desde el nodo origen al nodo destino.
     */
    public ArrayList<Node> getShortestPath(Node origen, Node destino){
        Dijkstra d = new Dijkstra();
        d.findMinimunPath(this, origen);
        return d.getPathTo(destino);
    }
    
    /**
     * Ordenar grados de los vertices en orden ascendente o descendente.
     * @param Orden 0 si es orden descendente, 1 si es orden ascendente.
     * @return Array de grados de los vertices en orden ascendente o descendente.
     */
    public int[] getDegree(int Orden){
        BubbleSort ordenarGrado = new BubbleSort();
        int[] SortWeight = new int[nodes.size()];
        for (int i=0; i<nodes.size(); i++) {
            SortWeight[i] = nodes.get(i).getDegree(); // valor entero
            
            /*
            sacar el promedio de las aristas de cada nodo y luego ordenar los nodos de manera DESC(0) o ASC(1)
            buscar los nodos de entrada y sumarlo todo junto.
            */
            // sumar entradas con salidas
        }
        return ordenarGrado.bubble_srt(SortWeight, Orden);
    }
    
}