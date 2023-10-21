package algorithms;

import java.util.Arrays;

public class PigeonholeSort {

    // Método para ordenar el array utilizando Pigeonhole Sort
    public static void pigeonholeSort(int[] arr) {
        int min = arr[0];  // Almacena el valor mínimo del array
        int max = arr[0];  // Almacena el valor máximo del array
        int n = arr.length;  // Almacena la longitud del array

        // Encontrar los valores mínimo y máximo en el array
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Crear los "pigeonholes" (agujeros)
        int range = max - min + 1;
        int[] pigeonholes = new int[range];

        // Inicializar los "pigeonholes" con ceros
        Arrays.fill(pigeonholes, 0);

        // Llenar los "pigeonholes" con los elementos del array
        for (int i = 0; i < n; i++) {
            pigeonholes[arr[i] - min]++;
        }

        // Colocar los elementos de vuelta en el array original en orden ordenado
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (pigeonholes[i] > 0) {
                arr[index] = i + min;
                pigeonholes[i]--;
                index++;
            }
        }
    }
}
