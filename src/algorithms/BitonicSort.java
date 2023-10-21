package algorithms;

public class BitonicSort {

    /* El parámetro dir indica la dirección de ordenación,
       ASCENDENTE o DESCENDENTE; si (a[i] > a[j]) cumple
       con la dirección, entonces se intercambian a[i] y a[j]. */
    void compAndSwap(int[] a, int i, int j, int dir) {
        if ((a[i] > a[j] && dir == 1) || (a[i] < a[j] && dir == 0)) {
            // Intercambio de elementos
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /* Ordena recursivamente una secuencia bitónica en orden
       ascendente, si dir = 1, y en orden descendente de lo
       contrario (es decir, dir = 0). La secuencia a ordenar
       comienza en la posición de índice bajo, el parámetro
       cnt es el número de elementos a ordenar. */
    void bitonicMerge(int[] a, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++)
                compAndSwap(a, i, i + k, dir);
            bitonicMerge(a, low, k, dir);
            bitonicMerge(a, low + k, k, dir);
        }
    }

    /* Esta función primero produce una secuencia bitónica
       ordenando de forma recursiva sus dos mitades en órdenes
       de ordenación opuestos, y luego llama a bitonicMerge
       para ponerlos en el mismo orden. */
    void bitonicSort(int[] a, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;

            // Ordena en orden ascendente ya que dir aquí es 1
            bitonicSort(a, low, k, 1);

            // Ordena en orden descendente, ya que dir aquí es 0
            bitonicSort(a, low + k, k, 0);

            // Fusionará toda la secuencia en orden ascendente, ya que dir=1.
            bitonicMerge(a, low, cnt, dir);
        }
    }

    /* Llamada de bitonicSort para ordenar all el array
       de longitud N en orden ASCENDENTE. */
    public void sort(int[] a, int N) {
        bitonicSort(a, 0, N, 1);
    }
}
