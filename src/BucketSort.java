import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void bucketSort(int[] array) {
        // Crear un array de listas para almacenar los elementos en los cubos
        List<Integer>[] buckets = new List[array.length];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Calcular el rango de los elementos del array
        int min = array[0];
        int max = array[0];
        for (int num : array) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int range = max - min + 1;

        // Asignar cada elemento del array a un cubo según su valor
        for (int num : array) {
            int index = (num - min) * array.length / range;
            buckets[index].add(num);
        }

        // Ordenar cada cubo usando cualquier algoritmo de ordenación
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Concatenar los elementos de los cubos ordenados al array original
        int i = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                array[i++] = num;
            }
        }
    }

}
