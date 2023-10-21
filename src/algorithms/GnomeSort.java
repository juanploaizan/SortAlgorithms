package algorithms;

public class GnomeSort {

    // Método para ordenar un array utilizando Gnome Sort
    public static void gnomeSort(int[] arr, int n) {
        int index = 0;  // Inicializa el índice en 0

        // Itera hasta que el índice sea menor que la longitud del array
        while (index < n) {
            // Si el índice es 0, incrementa el índice
            if (index == 0)
                index++;
            // Si el elemento actual es mayor o igual que el anterior, incrementa el índice
            if (arr[index] >= arr[index - 1])
                index++;
                // Si el elemento actual es menor que el anterior, intercambia los elementos y decrementa el índice
            else {
                int temp;
                temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
}
