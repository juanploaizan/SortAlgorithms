public class BinaryInsertionSort {
    public static void binaryInsertionSort(int[] array) {
        // Recorrer el array desde el segundo elemento
        for (int i = 1; i < array.length; i++) {
            // Guardar el elemento actual y su posición
            int key = array[i];
            int j = i - 1;

            // Buscar la posición correcta para insertar el elemento usando una búsqueda binaria
            int low = 0;
            int high = j;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (key < array[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Desplazar los elementos mayores que el elemento actual una posición a la derecha
            while (j >= low) {
                array[j + 1] = array[j];
                j--;
            }

            // Insertar el elemento actual en la posición encontrada
            array[j + 1] = key;
        }
    }

}
