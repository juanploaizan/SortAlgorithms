import java.util.ArrayList;
import java.util.List;

public class RadixSort {

    public static void radixSort(int[] array) {
        // Encontrar el máximo valor absoluto del array
        int max = Math.abs(array[0]);
        for (int num : array) {
            max = Math.max(max, Math.abs(num));
        }

        // Inicializar el número de dígitos del máximo valor absoluto
        int digits = 0;

        // Contar el número de dígitos del máximo valor absoluto
        while (max > 0) {
            digits++;
            max /= 10;
        }

        // Crear un array de listas para almacenar los elementos en los cubos según sus dígitos
        List<Integer>[] buckets = new List[19];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Recorrer cada dígito desde el menos significativo al más significativo
        for (int i = 0; i < digits; i++) {
            // Calcular el divisor para obtener el dígito actual
            int divisor = (int) Math.pow(10, i);

            // Asignar cada elemento del array a un cubo según su dígito actual
            for (int num : array) {
                int index = num / divisor % 10 + 9;
                buckets[index].add(num);
            }

            // Concatenar los elementos de los cubos ordenados al array original
            int j = 0;
            for (List<Integer> bucket : buckets) {
                for (int num : bucket) {
                    array[j++] = num;
                }
                // Vaciar el cubo para el siguiente dígito
                bucket.clear();
            }
        }
    }

}
