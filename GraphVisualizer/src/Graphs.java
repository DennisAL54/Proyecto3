
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvgo
 */
public class Graphs {
    
    private final ArrayList<Graph> grafos = new ArrayList<>();
    private int idGrafo = 1;
    
    public void CrearGrafo(){
        Graph newGraph = new Graph(idGrafo++);
        grafos.add(newGraph);
    }
    
    public Graph getGrafo(int idGrafo){
        for (Graph grafo : grafos) {
            if(grafo.idGrafo == idGrafo)
                return grafo;
        }
        return new Graph(0);
    }
    
    public ArrayList<Graph> getGrafos(){
        if (grafos.isEmpty())
            return null;
        return grafos;
    }
    
    public void borrarGrafos(){
        grafos.clear();
    }
    
    public void borrarGrafo(int idGrafo){
        grafos.remove(idGrafo-1);
    }
    
}
