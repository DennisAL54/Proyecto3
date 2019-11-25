import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Graphs {
    
    private final ArrayList<Graph> grafos = new ArrayList<>();
    private int idGrafo = 1;
    
    //Metodo para crear un grafo y ser agregado a la lista.
    public void CrearGrafo(){
        ServerSocket server1;
        Socket client1;
        try {
            server1 = new ServerSocket(1000);
            client1 = server1.accept();
            System.out.println("Grafo creado");
            Graph newGraph = new Graph(idGrafo++);
            grafos.add(newGraph);
            client1.close();
            server1.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //Graph newGraph = new Graph(idGrafo++);
        //grafos.add(newGraph);
    }
    
    /**
     * Metodo para obtener un grafo especifico.
     * @param idGrafo ID del grafo a obtener.
     * @return Grafo requerido.
     */
    public Graph getGrafo(int idGrafo){
        ServerSocket server1;
        Socket client1;
        try {
            server1 = new ServerSocket(1010);
            client1 = server1.accept();
            for (Graph grafo : grafos) {
                if(grafo.idGrafo == idGrafo)
                    return grafo;
            }
            System.out.println("Grafos Obtenidos");
            client1.close();
            server1.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        /*for (Graph grafo : grafos) {
            if(grafo.idGrafo == idGrafo)
                return grafo;*/
        return new Graph(0);
        }
        //return new Graph(0);
    //}
    
    /**
     * Metodo para obtener todos los grafos guardados en memoria.
     * @return Lista de grafos creados.
     */
    public ArrayList<Graph> getGrafos(){
        if (grafos.isEmpty())
            return null;
        return grafos;
    }
    
    /**
     * Metodo para borrar todos los grafos creados.
     */
    public void borrarGrafos(){
        grafos.clear();
    }
    
    /**
     * Metodo para borrar un grafo especifico.
     * @param idGrafo ID del grafo a borrar.
     */
    public void borrarGrafo(int idGrafo){
        grafos.remove(idGrafo-1);
    }
    
}
