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
        Graphs g = new Graphs();
        g.CrearGrafo();
        g.getGrafos();

        /*ServerSocket server1;
        Socket client1;
        InputStream input1;
        Graphs g = new Graphs();
        try {
            server1 = new ServerSocket(1010);
            client1 = server1.accept();
            g.CrearGrafo();
            System.out.println("A-ok");
            client1.close();
            server1.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
