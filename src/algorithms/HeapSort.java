package algorithms;

public class HeapSort {

    // Método principal para ordenar un array utilizando Heap Sort
    public static void sort(int[] arr) {
        int N = arr.length;  // Almacena la longitud del array

        // Construye el heap (reorganiza el array)
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(arr, N, i);  // Aplica la función heapify en el array
        }

        // Extrae uno por uno un elemento del heap
        for (int i = N - 1; i > 0; i--) {
            // Mueve la raíz actual al final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llama a heapify en el heap reducido
            heapify(arr, i, 0);
        }
    }

    // Función para convertir un subárbol con raíz en el índice i en un heap máximo
    static void heapify(int[] arr, int N, int i) {
        int largest = i;  // Inicializa el más grande como la raíz
        int l = 2 * i + 1;  // izquierda = 2*i + 1
        int r = 2 * i + 2;  // derecha = 2*i + 2

        // Si el hijo izquierdo es mayor que la raíz
        if (l < N && arr[l] > arr[largest]) {
            largest = l;
        }

        // Si el hijo derecho es mayor que el más grande hasta ahora
        if (r < N && arr[r] > arr[largest]) {
            largest = r;
        }

        // Si el más grande no es la raíz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursivamente heapify en el subárbol afectado
            heapify(arr, N, largest);
        }
    }
}
