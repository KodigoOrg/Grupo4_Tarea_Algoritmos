package ORDENAMIENTO;

public class InsertionSort {
    /**
     * Implementa el algoritmo de ordenamiento por inserción.
     * Construye la lista final ordenada un elemento a la vez. Itera a través del arreglo,
     * y para cada elemento, lo "inserta" en su posición correcta dentro de la porción
     * ya ordenada del arreglo.
     *
     * @param arr El arreglo a ordenar.
     */
    public static void ordenar(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int clave = arr[i];
            int j = i - 1;

            /* Mueve los elementos de arr[0..i-1], que son mayores que clave,
               una posición adelante de su posición actual */
            while (j >= 0 && arr[j] > clave) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = clave;
        }
    }
}