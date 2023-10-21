package algorithms;

public class CombSort {
    // Implementación del algoritmo Comb Sort
    public static void combSort(int[] array) {
        int n = array.length;  // Almacena la longitud del arreglo de entrada
        int gap = n;  // Inicializa el espacio inicial entre elementos a comparar
        boolean swapped = true;  // Indica si se ha realizado un intercambio en la iteración actual

        // El bucle se ejecuta hasta que el espacio entre elementos a comparar sea 1 y no haya más intercambios
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);  // Obtiene el siguiente espacio entre elementos a comparar
            swapped = false;  // Reinicia la bandera de intercambio

            // Itera sobre el arreglo para comparar los elementos con el espacio dado
            for (int i = 0; i < n - gap; i++) {
                if (array[i] > array[i + gap]) {
                    // Intercambia los elementos array[i] y array[i+gap] si el elemento actual es mayor que el elemento con el espacio dado
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                    swapped = true;  // Indica que se ha realizado al menos un intercambio en esta iteración
                }
            }
        }
    }

    // Calcula el siguiente espacio entre elementos a comparar utilizando la secuencia de reducción 1.3
    private static int getNextGap(int gap) {
        // Reducir el espacio por un factor de 1.3
        gap = (gap * 10) / 13;
        if (gap < 1) {
            return 1;  // Si el espacio se vuelve menor que 1, se establece en 1
        }
        return gap;  // Devuelve el espacio calculado
    }
}
