/*
 * Paquete e importaciones
 */
package Modelos;


/**
 * Algoritmo para el ordenamiento del grado de los nodos
 * @author Mario
 */
public class BubbleSort {
    /**
     * Metodo que ordena el array de los promedios de aristas de entrada o salida.
     * @param array array con los valores promedio de aristas (entradas/salidas)
     * @param Orden manera o secuencia en la que se debe ordenar el array.
     * @return array ordenado
     */
    public int[] bubble_srt(int array[], int Orden) {
        int n = array.length; // longitud del array
        int k; // indice para la comparacion.
        for (int m = 0; m < n; m++) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                switch(Orden){
                    /**
                     * Caso 1: Si el orden del array es de la forma descendente. 
                     */
                    case 1: default: 
                        if (array[i] < array[k]) {
                            int temp;
                            temp = array[i];
                            array[i] = array[k];
                            array[k] = temp;
                        }
                        break;
                    /**
                     * Caso 2: Si el orden del array es de forma ascendente.
                     */
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
