/*
 * Paquete
 */
package Modelos;

import java.util.ArrayList;


/**
 * Clase principal del grafo.
 * @author alvgo
 */
public class GraphVisualizer {

    /**
     * @param args linea de comandos.
     */
    public static void main(String[] args) {
        
        Graphs graphlist = new Graphs();
        graphlist.CrearGrafo();
        
        graphlist.getGrafo(1).addNode(20);
        graphlist.getGrafo(1).addNode(10);
        graphlist.getGrafo(1).addNode(30);
        graphlist.getGrafo(1).addArista(graphlist.getGrafo(1).getNodo(1), graphlist.getGrafo(1).getNodo(2), 10);
        graphlist.getGrafo(1).addArista(graphlist.getGrafo(1).getNodo(2), graphlist.getGrafo(1).getNodo(3), 7);
        graphlist.getGrafo(1).addArista(graphlist.getGrafo(1).getNodo(4), graphlist.getGrafo(1).getNodo(2), 39);
        graphlist.getGrafo(1).addNode(24);
        graphlist.getGrafo(1).addNode(67);
        graphlist.getGrafo(1).addArista(graphlist.getGrafo(1).getNodo(4), graphlist.getGrafo(1).getNodo(1), 65);
        graphlist.getGrafo(1).addArista(graphlist.getGrafo(1).getNodo(5), graphlist.getGrafo(1).getNodo(4), 30);
        graphlist.getGrafo(1).addArista(graphlist.getGrafo(1).getNodo(1), graphlist.getGrafo(1).getNodo(5), 70);
        
        ArrayList<Integer> valuesN = new ArrayList<>();
        for (Node node : graphlist.getGrafo(1).getNodes()) {
            valuesN.add(node.getValue());
        }
        ArrayList<Integer> valuesA = new ArrayList<>();
        for (Arista ari : graphlist.getGrafo(1).getAristas()) {
            valuesA.add(ari.getWeight());
        }
        //System.out.println(valuesN);
        //System.out.println(valuesA);
        
        for (int i = 0; i < graphlist.getGrafo(1).getDegree(0).length; i++) {
            //System.out.println(graphlist.getGrafo(1).getDegree(0)[i]);
        }
        
        //graphlist.borrarGrafos();
        //System.out.println(graphlist.getGrafo(1).getNodes());
        //graphlist.borrarGrafo(1);
        //System.out.println(graphlist.getGrafos());
        //System.out.println(graphlist.getGrafo(1).getNodo(1).getValue());
        graphlist.getGrafo(1).actualizarEntidad(1, 100);
        //System.out.println(graphlist.getGrafo(1).getNodo(1).getValue());
        //graphlist.getGrafo(1).borrarNodos();
        //System.out.println(graphlist.getGrafo(1).getNodes());
        for (Arista ari : graphlist.getGrafo(1).getAristas()) {
            valuesA.add(ari.idArista);
        }
        //System.out.println(valuesA);
        graphlist.getGrafo(1).addArista(graphlist.getGrafo(1).getNodo(3), graphlist.getGrafo(1).getNodo(5), 4);
        valuesA.clear();
        //graphlist.getGrafo(1).borrarArista(1);
        for (Arista ari : graphlist.getGrafo(1).getAristas()) {
            valuesA.add(ari.getWeight());
        }
        //System.out.println(valuesA);
        
        for (Node shortpath : graphlist.getGrafo(1).getShortestPath(graphlist.getGrafo(1).getNodo(1), graphlist.getGrafo(1).getNodo(5))) {
            System.out.print(shortpath.idNodo + " ");
        }
        
        valuesA.clear();
        graphlist.getGrafo(1).borrarArista(2);
        for (Arista ari : graphlist.getGrafo(1).getAristas()) {
            valuesA.add(ari.getWeight());
        }
        //System.out.println(valuesA);
        
        int c = graphlist.getGrafo(1).getDegree(1).length;
        for (int i = 0; i < c; i++) {
            //System.out.println(graphlist.getGrafo(1).getDegree(1)[i]);
        }
    }
    
}
