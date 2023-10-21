package array;

import java.io.*;
import java.util.*;

public class ArrayGenerator {

    public static void main(String[] args) {
        // Crear un array de int
        int[] array = new int[1000000];
        // Llenar el array con números aleatorios
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(999999);
        }
        // Crear un archivo txt para guardar el array
        File file = new File("array3.txt");
        try {
            // Crear un objeto PrintWriter para escribir en el archivo
            PrintWriter pw = new PrintWriter(file);
            // Recorrer el array y escribir cada elemento en una línea separada
            for (int num : array) {
                pw.println(num);
            }
            // Cerrar el PrintWriter
            pw.close();
            // Mostrar un mensaje de éxito
            System.out.println("El array se ha guardado en el archivo " + file.getName());
        } catch (FileNotFoundException e) {
            // Mostrar un mensaje de error si ocurre una excepción
            System.out.println("No se pudo crear el archivo " + file.getName());
        }
    }

    // Un método que permite cargar en un int[] los valores desde el archivo generado
    public static int[] loadArrayFromFile(File file) {
        // Crear un ArrayList para almacenar los valores leídos del archivo
        ArrayList<Integer> list = new ArrayList<>();
        try {
            // Crear un objeto Scanner para leer del archivo
            Scanner sc = new Scanner(file);
            // Mientras haya una línea siguiente en el archivo
            while (sc.hasNextLine()) {
                // Leer la línea como un entero y agregarlo al ArrayList
                int num = Integer.parseInt(sc.nextLine());
                list.add(num);
            }
            // Cerrar el Scanner
            sc.close();
        } catch (FileNotFoundException e) {
            // Mostrar un mensaje de error si ocurre una excepción
            System.out.println("No se pudo encontrar el archivo " + file.getName());
        }
        // Convertir el ArrayList en un int[]
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        // Devolver el int[]
        return array;
    }
}

