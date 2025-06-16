package ORDENAMIENTO;

public class InsertionSort {

    /**
     * Implementa el algoritmo de ordenamiento por inserción para un arreglo de Alumnos.
     * Utiliza el metodo compareTo de la clase Alumno para las comparaciones.
     *
     * @param arr El arreglo de Alumnos a ordenar.
     */
    public static void ordenar(Alumno[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Alumno clave = arr[i]; // La clave ahora es un objeto Alumno
            int j = i - 1;

            /* Mueve los elementos de arr[0..i-1], que son mayores que clave,
               una posición adelante de su posición actual */
            // Cambiamos arr[j] > clave por arr[j].compareTo(clave) > 0
            while (j >= 0 && arr[j].compareTo(clave) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = clave;
        }
    }
}
