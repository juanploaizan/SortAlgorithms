# Análisis Comparativo de Algoritmos de Ordenamiento

## Introducción
El propósito de esta actividad es analizar y comparar el desempeño de diferentes métodos de ordenamiento, considerando el tamaño de entrada.

A continuación, se presenta una tabla que muestra el tiempo de ejecución de varios algoritmos de ordenamiento para tres tamaños diferentes de arreglos de enteros.

Para el desarrollo de esta actividad se plantearon 3 tamaños para los arreglos de enteros, mediante archivos TXT, los cuales son cargados el instante previo a la ejecución del programa:

1. Array 1: Arreglo de cien mil (100.000) elementos aleatorios del 0 al 99999.
2. Array 2: Arreglo de quinientos mil (500.000) elementos aleatorios del 0 al 499999.
3. Array 3: Arreglo de un millón (1.000.000) de elementos aleatorios del 0 al 999999.

## Tabla de Desempeño de Algoritmos de Ordenamiento

| Algoritmo de ordenamiento | Complejidad Temporal | Tiempo de ejecución (Array 1) | Tiempo de ejecución (Array 2) | Tiempo de ejecución (Array 3) |
| -------------------------- | --------------------- | ---------------------------- | ---------------------------- | ---------------------------- |
| Pigeonhole Sort            | O(n+k)                | 0.005                        | 0.014                        | 0.025                        |
| Quick Sort                 | O(n log n)            | 0.011                        | 0.04                         | 0.079                        |
| Comb Sort                  | O(n log n)            | 0.012                        | 0.046                        | 0.095                        |
| Tim Sort                   | O(n log n)            | 0.018                        | 0.05                         | 0.101                        |
| Heap Sort                  | O(n log n)            | 0.012                        | 0.056                        | 0.116                        |
| Radix Sort                 | O(d * (n + k))        | 0.012                        | 0.077                        | 0.155                        |
| Bucket Sort                | O(n+k)                | 0.027                        | 0.114                        | 0.216                        |
| Bitonic Sort               | O(log^2 n)            | 0.023                        | 0.114                        | 0.223                        |
| Tree Sort                  | O(n log n)            | 0.094                        | 0.563                        | 1.23                         |
| Binary Insertion Sort      | O(n log n)            | 0.555                        | 4.489                        | 16.855                       |
| Selection Sort             | O(n^2)                | 2.543                        | 62.923                       | 256.089                      |
| Gnome Sort                 | O(n^2)                | 3.22                         | 95.847                       | 331.912                      |

*Run time*: Tiempo de ejecución.

## Conclusión
La tabla muestra claramente cómo el tiempo de ejecución varía según el algoritmo de ordenamiento y el tamaño del array. Los algoritmos con complejidad temporal menor muestran tiempos de ejecución más rápidos, mientras que aquellos con una mayor complejidad temporal son significativamente más lentos, especialmente para conjuntos de datos más grandes. Esta información puede ser útil al elegir un algoritmo de ordenamiento en función del tamaño de los conjuntos de datos que se van a ordenar.
