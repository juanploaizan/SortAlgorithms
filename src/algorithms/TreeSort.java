package algorithms;

public class TreeSort {

    // Clase que contiene los hijos izquierdo y derecho del nodo actual y el valor clave
    static class Node {
        int key;
        Node left, right;

        // Constructor de la clase Node
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Raíz del árbol BST
    public Node root;

    // Constructor de la clase TreeSort
    public TreeSort() {
        root = null;  // Inicializa la raíz como nula al crear una instancia de TreeSort
    }

    // Este método llama principalmente a insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Una función recursiva para insertar una nueva clave en el BST
    Node insertRec(Node root, int key) {
        // Si el árbol está vacío, devuelve un nuevo nodo con la clave dada
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Si no está vacío, inserta la clave en el lugar correspondiente del árbol
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Devuelve el nodo raíz actualizado
        return root;
    }

    // Una función para realizar el recorrido en orden del BST
    public void inorderRec(Node root) {
        if (root != null) {
            // Realiza el recorrido en orden del subárbol izquierdo
            inorderRec(root.left);
            // Imprime el valor clave del nodo actual
            System.out.print(root.key + " ");
            // Realiza el recorrido en orden del subárbol derecho
            inorderRec(root.right);
        }
    }

    // Método para insertar elementos de un array en el árbol
    public void treeins(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);  // Inserta cada elemento del array en el árbol
        }
    }
}
