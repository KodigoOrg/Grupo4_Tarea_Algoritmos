package ORDENAMIENTO;

public class BubbleSort {
    /**
     * Implementa el algoritmo de ordenamiento burbuja.
     * Recorre repetidamente la lista, compara elementos adyacentes y los intercambia
     * si están en el orden incorrecto. Las pasadas a través de la lista se repiten
     * hasta que no se necesiten más intercambios, lo que indica que la lista está ordenada.
     *
     * @param arr El arreglo a ordenar.
     */
    public static void ordenar(int[] arr) {
        int n = arr.length;
        boolean intercambiado;
        for (int i = 0; i < n - 1; i++) {
            intercambiado = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambiar arr[j] y arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    intercambiado = true;
                }
            }
            // Si no hubo dos elementos intercambiados por la pasada interna, entonces está ordenado
            if (!intercambiado) {
                break;
            }
        }
    }
}