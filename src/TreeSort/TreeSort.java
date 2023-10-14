package TreeSort;

public class TreeSort {
    // Método para insertar un valor en el árbol binario de búsqueda
    public static Node insert(Node root, int data) {
        // Si el árbol está vacío, se crea un nuevo nodo con el valor dado
        if (root == null) {
            return new Node(data);
        }
        // Si el valor es menor que el del nodo actual, se inserta en el subárbol izquierdo
        if (data < root.data) {
            root.left = insert(root.left, data);
        }
        // Si el valor es mayor que el del nodo actual, se inserta en el subárbol derecho
        else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        // Se devuelve la raíz del árbol modificado
        return root;
    }

    // Método para recorrer el árbol en orden y almacenar los elementos en un array
    public static void inOrder(Node root, int[] array, int index) {
        // Si el árbol no está vacío, se recorre en orden
        if (root != null) {
            // Se visita el subárbol izquierdo
            inOrder(root.left, array, index);
            // Se almacena el valor del nodo actual en el array
            array[index] = root.data;
            // Se incrementa el índice del array
            index++;
            // Se visita el subárbol derecho
            inOrder(root.right, array, index);
        }
    }

    // Método para ordenar un array usando TreeSort
    public static void treeSort(int[] array) {
        // Se crea un árbol binario de búsqueda vacío
        Node root = null;
        // Se insertan los elementos del array en el árbol
        for (int data : array) {
            root = insert(root, data);
        }
        // Se recorre el árbol en orden y se almacenan los elementos ordenados en el mismo array
        inOrder(root, array, 0);
    }
}
