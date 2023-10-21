package algorithms;

import java.util.Arrays;

public class BinaryInsertionSort {
    // Método para ordenar un array utilizando Binary Insertion Sort
    public static void binaryInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];  // Almacena el valor actual a ser insertado
            int j = Math.abs(Arrays.binarySearch(arr, 0, i, x) + 1);  // Realiza una búsqueda binaria para encontrar la posición de inserción
            System.arraycopy(arr, j, arr, j + 1, i - j);  // Desplaza los elementos para hacer espacio para la inserción
            arr[j] = x;  // Inserta el elemento en la posición adecuada
        }
    }
}
