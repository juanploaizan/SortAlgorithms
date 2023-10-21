package algorithms;

// Java program for implementation of Selection Sort
public class SelectionSort {
    // Implementación del algoritmo Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;  // Almacena la longitud del arreglo de entrada
        for (int i = 0; i < n - 1; i++) {
            // Encontrar el elemento mínimo en el array sin ordenar
            int minIndex = i;  // Establece el índice inicial del elemento mínimo como i
            for (int j = i + 1; j < n; j++) {
                // Itera sobre los elementos restantes para encontrar el elemento mínimo
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;  // Actualiza el índice del elemento mínimo si se encuentra uno más pequeño
                }
            }
            // Intercambia el elemento mínimo con el primer elemento sin ordenar
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
