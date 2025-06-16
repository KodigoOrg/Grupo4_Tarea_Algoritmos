package ORDENAMIENTO;

public class SelectionSort {

    /**
     * Implementa el algoritmo de ordenamiento por selección para un arreglo de Alumnos.
     * Utiliza el metodo compareTo de la clase Alumno para las comparaciones.
     *
     * @param arr El arreglo de Alumnos a ordenar.
     */
    public static void ordenar(Alumno[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                // Cambiamos arr[j] < arr[indiceMinimo] por arr[j].compareTo(arr[indiceMinimo]) < 0
                if (arr[j].compareTo(arr[indiceMinimo]) < 0) {
                    indiceMinimo = j;
                }
            }

            // Intercambia el elemento mínimo encontrado con el primer elemento
            Alumno temp = arr[indiceMinimo];
            arr[indiceMinimo] = arr[i];
            arr[i] = temp;
        }
    }
}