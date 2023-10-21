package algorithms;

// Java program to perform TimSort algorithm.
public class TimSort {

    // Tamaño de cada RUN, una porción del array que se ordena con insertion sort
    private static final int RUN = 32;

    // Implementación del algoritmo de ordenamiento por inserción
    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            // Mover los elementos del subarreglo que son mayores que el valor temporal
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // Función para combinar dos subarreglos ordenados
    public static void merge(int[] arr, int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        // Copiar los datos a los arreglos temporales
        for (int i = 0; i < len1; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < len2; i++) {
            right[i] = arr[m + 1 + i];
        }

        int i = 0, j = 0, k = l;
        // Combinar los dos arreglos ordenados en uno
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        // Copiar los elementos restantes si hay algún elemento restante
        while (i < len1) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < len2) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    // Implementación principal del algoritmo Tim Sort
    public static void timSort(int[] arr, int n) {
        // Ordenar los subarreglos de tamaño RUN utilizando insertion sort
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min((i + 31), (n - 1)));
        }
        // Combinar los RUNs de tamaño RUN utilizando merge
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                // Evitar que se realice un merge en caso de que mid sea igual a n-1
                if (mid < n - 1) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }
}
