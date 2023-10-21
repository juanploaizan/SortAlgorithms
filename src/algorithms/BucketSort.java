package algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    // Método para ordenar el array utilizando Bucket Sort
    public static void bucketSort(int[] array, int numBuckets) {
        if (array.length == 0) {
            return;  // Si el array está vacío, se detiene la ejecución del algoritmo
        }

        // Encontrar el valor máximo y mínimo en el array
        int minValue = array[0];
        int maxValue = array[0];
        for (int value : array) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        // Crear los baldes como una lista de ArrayList
        ArrayList<Integer>[] buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();  // Inicializar cada balde como un ArrayList vacío
        }

        // Asignar elementos a los baldes según el rango de valores
        for (int value : array) {
            int bucketIndex = (int) ((value - minValue) * (numBuckets - 1) / (maxValue - minValue));
            buckets[bucketIndex].add(value);  // Agregar el valor al balde correspondiente
        }

        // Ordenar los baldes y reinsertar los elementos ordenados de vuelta en el array original
        int currentIndex = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);  // Ordenar cada balde
            for (int value : bucket) {
                array[currentIndex++] = value;  // Insertar los valores ordenados de vuelta en el array original
            }
        }
    }
}
