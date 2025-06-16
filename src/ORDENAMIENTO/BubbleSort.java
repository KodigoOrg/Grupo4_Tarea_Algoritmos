package ORDENAMIENTO;

public class BubbleSort {
    /**
     * Implementa el algoritmo de ordenamiento burbuja para un arreglo de Alumnos.
     * Utiliza el metodo compareTo de la clase Alumno para las comparaciones.
     *
     * @param arr El arreglo de Alumnos a ordenar.
     */
    public static void ordenar(Alumno[] arr) {
        int n = arr.length;
        boolean intercambiado;
        for (int i = 0; i < n - 1; i++) {
            intercambiado = false;
            for (int j = 0; j < n - 1 - i; j++) {
                // Cambiamos arr[j] > arr[j+1] por arr[j].compareTo(arr[j+1]) > 0
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Intercambiar arr[j] y arr[j+1]
                    Alumno temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    intercambiado = true;
                }
            }
            if (!intercambiado) {
                break;
            }
        }
    }
}
