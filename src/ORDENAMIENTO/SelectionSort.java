package ORDENAMIENTO;

public class SelectionSort {
    /**
     * Implementa el algoritmo de ordenamiento por selección.
     * Divide la lista en dos partes: una sublista de elementos ya ordenados,
     * que se construye de izquierda a derecha en la parte delantera del arreglo,
     * y una sublista de los elementos restantes sin ordenar que ocupa el resto del arreglo.
     * El algoritmo encuentra el elemento más pequeño (o más grande) de la sublista no ordenada,
     * y lo intercambia con el elemento más a la izquierda (o más a la derecha) no ordenado,
     * moviendo ese elemento a la sublista ordenada.
     *
     * @param arr El arreglo a ordenar.
     */
    public static void ordenar(int[] arr) {
        int n = arr.length;

        // Uno por uno, mueve el límite de la sublista no ordenada
        for (int i = 0; i < n - 1; i++) {
            // Encuentra el elemento mínimo en el arreglo no ordenado
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            // Intercambia el elemento mínimo encontrado con el primer elemento
            // de la parte no ordenada
            int temp = arr[indiceMinimo];
            arr[indiceMinimo] = arr[i];
            arr[i] = temp;
        }
    }
}