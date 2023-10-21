package algorithms;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {

    public static void radixSort(int[] array) {
        // Encontrar el valor máximo del array
        int max = getMax(array);

        // Realizar el sorting según cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    // Función para obtener el valor máximo en el array
    private static int getMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            max = Math.max(max, num);
        }
        return max;
    }

    // Función auxiliar que realiza el sorting según el dígito actual
    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        List<Integer>[] buckets = new List[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int j : array) {
            buckets[(j / exp) % 10].add(j);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                array[index++] = num;
            }
            bucket.clear();
        }
    }
}
