/*
 * Paquete e importaciones
 */
package Modelos;
import java.util.ArrayList;

/**
 * Clase para la creación de grafos.
 * @author alvgo
 */
public class Graphs {
    
    private final ArrayList<Graph> grafos = new ArrayList<>();
    private int idGrafo = 1;
    /**
     * Metodo para la creacion de grafos
     */
    public void CrearGrafo(){
        Graph newGraph = new Graph(idGrafo++);
        grafos.add(newGraph);
    }
    /**
     * Metodo para obtener un grafo por medio de su id.
     * @param idGrafo idetificacion del grafo.
     * @return retorna el grafo encontrado
     */
    public Graph getGrafo(int idGrafo){
        for (Graph grafo : grafos) {
            if(grafo.idGrafo == idGrafo)
                return grafo;
        }
        return new Graph(0);
    }
    /**
     * Metodo que obtiene la lista de grafos creados.
     * @return lista de gorafos creados.
     */
    public ArrayList<Graph> getGrafos(){
        if (grafos.isEmpty())
            return null;
        return grafos;
    }
    /**
     * Metodo para borrar todo los grafos
     */
    public void borrarGrafos(){
        grafos.clear();
    }
    /**
     * Metodo para borrar grafo identificado por id.
     * @param idGrafo id del grafo.
     */
    public void borrarGrafo(int idGrafo){
        grafos.remove(idGrafo-1);
    }
    
}
