package BUSQUEDA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * clase principal para realizar busquedas de alumnos
 * proporciona opciones para buscar alumnos por nombre de manera secuencial o por ID de manera binaria.
 */
public class BusquedaAlumnos {

    /**
     * metodo principal que ejecuta el programa
     * @param args argumentos de la linea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Arreglo de alumnos predefinidos
        Alumno[] alumnos = {
                new Alumno(101, "Alejandro"),
                new Alumno(102, "Manuel"),
                new Alumno(103, "Vladimir"),
                new Alumno(104, "Diego"),
                new Alumno(105, "Fernando")
        };

        Scanner scanner = new Scanner(System.in);

        // Menú de opciones para el usuario
        System.out.println("¿Qué tipo de búsqueda deseas hacer?");
        System.out.println("1. Búsqueda por nombre (secuencial)");
        System.out.println("2. Búsqueda por ID (binaria)");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (opcion == 1) {
            System.out.print("Ingresa el nombre del alumno: ");
            String nombreBuscado = scanner.nextLine();
            int posicion = busquedaSecuencialPorNombre(alumnos, nombreBuscado);

            if (posicion != -1)
                System.out.println("Alumno encontrado: " + alumnos[posicion]);
            else
                System.out.println("Alumno no encontrado.");
        } else if (opcion == 2) {
            // Ordenar el arreglo por ID para la busqueda binaria
            Arrays.sort(alumnos, Comparator.comparingInt(Alumno::getId));
            System.out.print("Ingresa el ID del alumno: ");
            int idBuscado = scanner.nextInt();
            int posicion = busquedaBinariaPorId(alumnos, idBuscado);

            if (posicion != -1)
                System.out.println("Alumno encontrado: " + alumnos[posicion]);
            else
                System.out.println("Alumno no encontrado.");
        } else {
            System.out.println("Opción no válida.");
        }

        scanner.close();
    }

    /**
     * realiza una busqueda secuencial por nombre en un arreglo de alumnos
     * @param alumnos arreglo de alumnos donde se realizara la búsqueda
     * @param nombre nombre del alumno a buscar
     * @return la posicion del alumno en el arreglo si es encontrado, -1 en caso contrario
     */
    public static int busquedaSecuencialPorNombre(Alumno[] alumnos, String nombre) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i].getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * realiza una búsqueda binaria por ID en un arreglo de alumnos
     * requiere que el arreglo este ordenado por ID
     * @param alumnos arreglo de alumnos donde se realizara la búsqueda
     * @param id ID del alumno a buscar
     * @return la posicion del alumno en el arreglo si es encontrado, -1 en caso contrario
     */
    public static int busquedaBinariaPorId(Alumno[] alumnos, int id) {
        int izquierda = 0, derecha = alumnos.length - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int idMedio = alumnos[medio].getId();

            if (idMedio == id) {
                return medio;
            } else if (idMedio < id) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1;
    }
}
