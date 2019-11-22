
/*
La aplicación debe permitir visualizar el grado entrante y
saliente de cada nodo tanto en la visualización como en una tabla rankeada
de menor a mayor (promediar grado entrante y saliente).
*/


/**
 * Algoritmo para el ordenamiento del grado de los nodos
 * @author Mario
 */
public class BubbleSort {
    /**
     * Metodo que ordena el array de los promedios de aristas de entrada o salida.
     * @param array array con los valores promedio de aristas (entradas/salidas)
     * @param Orden
     * @return array ordenado
     */
    public int[] bubble_srt(int array[], int Orden) {
        int n = array.length;
        int k;
        for (int m = 0; m < n; m++) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                switch(Orden){
                    case 1: default:
                        if (array[i] < array[k]) {
                            int temp;
                            temp = array[i];
                            array[i] = array[k];
                            array[k] = temp;
                        }
                        break;
                    case 0:
                        if (array[i] > array[k]) {
                            int temp;
                            temp = array[i];
                            array[i] = array[k];
                            array[k] = temp;
                        }
                        break;
                }
            }
        }
        return array;
    }
}