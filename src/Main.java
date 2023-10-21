import algorithms.*;
import array.ArrayGenerator;
import utils.Utils;

import javax.swing.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {

    /**
     * Este programa ejecuta diferentes algoritmos de ordenamiento en un arreglo cargado desde un archivo.
     * El usuario puede seleccionar el algoritmo de ordenamiento a utilizar en un menú de opciones.
     * El programa muestra el tiempo de ejecución de cada algoritmo de ordenamiento seleccionado por el usuario.
     */

    private static final Map<Integer, String> sortingAlgorithms = new HashMap<>();

    static {
        sortingAlgorithms.put(1, "Tim Sort");
        sortingAlgorithms.put(2, "Comb Sort");
        sortingAlgorithms.put(3, "Selection Sort");
        sortingAlgorithms.put(4, "Tree Sort");
        sortingAlgorithms.put(5, "Pigeonhole Sort");
        sortingAlgorithms.put(6, "Bucket Sort");
        sortingAlgorithms.put(7, "Quick Sort");
        sortingAlgorithms.put(8, "Heap Sort");
        sortingAlgorithms.put(9, "Bitonic Sort");
        sortingAlgorithms.put(10, "Gnome Sort");
        sortingAlgorithms.put(11, "Binary Insertion Sort");
        sortingAlgorithms.put(12, "Radix Sort");
    }

    public static void main(String[] args) {
        while (true) {
            String fileName = "array3.txt"; // Reemplazar con el nombre del archivo deseado
            int[] array = ArrayGenerator.loadArrayFromFile(new File(fileName));
            int n = array.length;
            int option;

            try {
                option = Integer.parseInt(JOptionPane.showInputDialog(getMenu()));

                if (option == 13) {
                    break;
                }

                long before, after;
                String chosenOption;

                if (sortingAlgorithms.containsKey(option)) {
                    before = System.currentTimeMillis();
                    chosenOption = sortingAlgorithms.get(option);
                    switch (option) {
                        case 1:
                            TimSort.timSort(array, n);
                            break;
                        case 2:
                            CombSort.combSort(array);
                            break;
                        case 3:
                            SelectionSort.selectionSort(array);
                            break;
                        case 4:
                            TreeSort tree = new TreeSort();
                            tree.treeins(array);
                            tree.inorderRec(tree.root);
                            break;
                        case 5:
                            PigeonholeSort.pigeonholeSort(array);
                            break;
                        case 6:
                            int bucketCount = getBucketCount(fileName);
                            BucketSort.bucketSort(array, bucketCount);
                            break;
                        case 7:
                            QuickSort.quickSort(array, 0, n - 1);
                            break;
                        case 8:
                            HeapSort.sort(array);
                            break;
                        case 9:
                            BitonicSort sort = new BitonicSort();
                            sort.sort(array, n);
                            break;
                        case 10:
                            GnomeSort.gnomeSort(array, n);
                            break;
                        case 11:
                            BinaryInsertionSort.binaryInsertionSort(array);
                            break;
                        case 12:
                            RadixSort.radixSort(array);
                            break;
                        default:
                            break;
                    }
                    after = System.currentTimeMillis();

                    if (option != 4) {
                        double seconds = (after - before) / 1000.0;
                        Utils.printArray(array, n);
                        System.out.println("Después de ordenar, utilizando " + chosenOption + ", el tiempo de ejecución fue de " + seconds + " segundos");
                    } else {
                        System.out.println();
                        double seconds = (after - before) / 1000.0;
                        System.out.println("Después de ordenar, utilizando " + chosenOption + ", el tiempo de ejecución fue de " + seconds + " segundos");
                    }
                } else {
                    System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Opción inválida.");
            }
        }
    }

    private static String getMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("1. Tim Sort\n");
        menu.append("2. Comb Sort\n");
        menu.append("3. Selection Sort\n");
        menu.append("4. Tree Sort\n");
        menu.append("5. Pigeonhole Sort\n");
        menu.append("6. Bucket Sort\n");
        menu.append("7. Quick Sort\n");
        menu.append("8. Heap Sort\n");
        menu.append("9. Bitonic Sort\n");
        menu.append("10. Gnome Sort\n");
        menu.append("11. Binary Insertion Sort\n");
        menu.append("12. Radix Sort\n");
        menu.append("13. Exit\n");
        menu.append("Choose an option:\n");
        return menu.toString();
    }

    private static int getBucketCount(String fileName) {
        if (fileName.equals("array1.txt")) {
            return 200;
        } else if (fileName.equals("array2.txt")) {
            return 1000;
        } else {
            return 2000;
        }
    }
}
