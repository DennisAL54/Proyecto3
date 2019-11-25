import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    /**
     * Clase Main con su respectivo metodo
     * @param args
     */
    public static void main(String[] args){
        ServerSocket server;
        Socket client;
        /**
         * Metodo main que une el rest api con el grafo mediante sockets
         */
        Graphs g = new Graphs();
        /**
         * Cada try/catch se conecta con el rest api mediante sockets y permite que este le envie ordenes a java
         */
        try {
            server = new ServerSocket(1010);
            client = server.accept();
            g.CrearGrafo();
            System.out.println("Grafo Creado");

            client.close();
            server.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            server = new ServerSocket(1000);
            client = server.accept();
            g.getGrafos();
            System.out.println("Grafo Obtenido");

            client.close();
            server.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            server = new ServerSocket(1001);
            client = server.accept();
            g.getGrafos();
            System.out.println("Grafos Borrados");

            client.close();
            server.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
