package algorithms;

public class QuickSort {

    // Método para realizar el Quick Sort en un array dado
    public static void quickSort(int[] arr, int low, int high) {
        // Verifica si el índice bajo es menor que el alto para continuar con la ordenación
        if (low < high) {
            int pi = partition(arr, low, high); // Obtener el índice de partición

            // Ordenar recursivamente los elementos antes y después del índice de partición
            quickSort(arr, low, pi - 1); // Ordena los elementos antes del índice de partición
            quickSort(arr, pi + 1, high); // Ordena los elementos después del índice de partición
        }
    }

    // Método para realizar la partición en el array según un pivote dado
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Selecciona el último elemento como pivote
        int i = (low - 1); // Inicializa el índice del elemento más pequeño

        // Itera a través de los elementos desde el índice bajo hasta el alto
        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor que el pivote, incrementa el índice del elemento más pequeño y realiza el intercambio
            if (arr[j] < pivot) {
                i++;

                // Intercambia arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambia arr[i+1] y arr[high] (o el pivote)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Devuelve el índice del elemento más pequeño más 1 (nuevo índice del pivote)
        return i + 1;
    }
}
