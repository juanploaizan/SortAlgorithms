import TreeSort.TreeSort;

import javax.swing.*;
import java.util.Arrays;

public class Main {
    // Método principal
    public static void main(String[] args) {
        int option;
        while (true) {
            // Copiar el arreglo original
            int[] arr = Arrays.copyOf(Utils.ARRAY, Utils.ARRAY.length);
            int n = arr.length;
            try {
                // Mostrar menú y obtener la opción del usuario
                option = Integer.parseInt(JOptionPane.showInputDialog(
                        """
                                Menu:
                                1. Tim Sort
                                2. Comb Sort
                                3. Selection Sort
                                4. Tree Sort
                                5. Pigeonhole Sort
                                6. Bucket Sort
                                7. Quick Sort
                                8. Heap Sort
                                9. Bitonic Sort
                                10. Gnome Sort
                                11. Binary Insertion Sort
                                12. Radix Sort
                                13. Exit
                        """
                ));

                // Salir si la opción es 13
                if (option == 13) {
                    break;
                }

                // Imprimir el arreglo original
                System.out.println("Given Array is");
                Utils.printArray(arr, n);

                // Seleccionar el algoritmo de ordenamiento según la opción
                switch (option) {
                    case 1:
                        TimSort.timSort(arr, n);
                        break;
                    case 2:
                        CombSort.sort(arr);
                        break;
                    case 3:
                        SelectionSort.sort(arr);
                        break;
                    case 4:
                        TreeSort.treeSort(arr); // TODO fix tree sort
                        break;
                    case 5:
                        PigeonholeSort.pigeonhole_sort(arr, n);
                        break;
                    case 6:
                        BucketSort.bucketSort(arr);
                        break;
                    case 7:
                        QuickSort.quickSort(arr, 0, n - 1);
                        break;
                    case 8:
                        HeapSort.sort(arr);
                        break;
                    case 9:
                        // TODO fix bitonic sort
                        BitonicSort sort = new BitonicSort();
                        sort.sort(arr, n);
                        break;
                    case 10:
                        GnomeSort.gnomeSort(arr, n);
                        break;
                    case 11:
                        BinaryInsertionSort.binaryInsertionSort(arr);
                        break;
                    case 12:
                        RadixSort.radixSort(arr);
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }

                // Imprimir el arreglo después de ordenarlo
                System.out.println("After Sorting Array is");
                Utils.printArray(arr, n);

            } catch (Exception e) {
                System.out.println("Invalid option");
            }
        }


    }
}
