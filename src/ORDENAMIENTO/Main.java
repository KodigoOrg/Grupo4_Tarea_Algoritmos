package ORDENAMIENTO;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Ejecutando Pruebas Manuales de Ordenamiento con Alumnos ---");

        // Arreglo de alumnos predefinidos como base
        Alumno[] alumnosBase = {
                new Alumno(101, "Alejandro"),
                new Alumno(102, "Manuel"),
                new Alumno(103, "Vladimir"),
                new Alumno(104, "Diego"),
                new Alumno(105, "Fernando"),
                new Alumno(100, "Zoe"),
                new Alumno(106, "Carlos"),
                new Alumno(99, "Ana")
        };

        System.out.println("Utilizando el siguiente arreglo de Alumnos predefinido:");
        System.out.println(Arrays.toString(alumnosBase));

        // Copias para cada algoritmo para asegurar que operan sobre los datos originales
        Alumno[] datosParaBurbuja = Arrays.copyOf(alumnosBase, alumnosBase.length);
        Alumno[] datosParaInsercion = Arrays.copyOf(alumnosBase, alumnosBase.length);
        Alumno[] datosParaSeleccion = Arrays.copyOf(alumnosBase, alumnosBase.length);

        int opcionAlgoritmo;
        do {
            System.out.println("\n--- Seleccione un Algoritmo de Ordenamiento para Probar ---");
            System.out.println("1. Ordenamiento Burbuja");
            System.out.println("2. Ordenamiento por Inserción");
            System.out.println("3. Ordenamiento por Selección");
            System.out.println("4. Salir");
            System.out.print("Elija una opción de algoritmo: ");

            try {
                opcionAlgoritmo = scanner.nextInt();
                long inicio, fin;
                switch (opcionAlgoritmo) {
                    case 1: // Ordenamiento Burbuja
                        System.out.println("Ordenando con Burbuja...");
                        inicio = System.nanoTime();
                        BubbleSort.ordenar(datosParaBurbuja);
                        fin = System.nanoTime();
                        System.out.printf("Ordenamiento Burbuja (tiempo: %.4f ms). Vector ordenado: %s%n",
                                (fin - inicio) / 1_000_000.0, Arrays.toString(datosParaBurbuja));
                        break;
                    case 2: // Ordenamiento por Inserción
                        System.out.println("Ordenando con Inserción...");
                        inicio = System.nanoTime();
                        InsertionSort.ordenar(datosParaInsercion);
                        fin = System.nanoTime();
                        System.out.printf("Ordenamiento por Inserción (tiempo: %.4f ms). Vector ordenado: %s%n",
                                (fin - inicio) / 1_000_000.0, Arrays.toString(datosParaInsercion));
                        break;
                    case 3: // Ordenamiento por Selección
                        System.out.println("Ordenando con Selección...");
                        inicio = System.nanoTime();
                        SelectionSort.ordenar(datosParaSeleccion);
                        fin = System.nanoTime();
                        System.out.printf("Ordenamiento por Selección (tiempo: %.4f ms). Vector ordenado: %s%n",
                                (fin - inicio) / 1_000_000.0, Arrays.toString(datosParaSeleccion));
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer
                opcionAlgoritmo = 0; // Para mantener el bucle
            }
            // Recargar copias de los datos originales para la siguiente prueba
            datosParaBurbuja = Arrays.copyOf(alumnosBase, alumnosBase.length);
            datosParaInsercion = Arrays.copyOf(alumnosBase, alumnosBase.length);
            datosParaSeleccion = Arrays.copyOf(alumnosBase, alumnosBase.length);

        } while (opcionAlgoritmo != 4);

        scanner.close();
    }

    /**
     * Genera un arreglo de enteros con números aleatorios.
     * @param tamano El tamaño del arreglo.
     * @return Un arreglo de enteros aleatorios.
     */
    private static int[] generarDatosAleatoriosInt(int tamano) {
        int[] arr = new int[tamano];
        Random rand = new Random();
        for (int i = 0; i < tamano; i++) {
            arr[i] = rand.nextInt(tamano * 10); // Valores entre 0 y (tamano * 10 - 1)
        }
        return arr;
    }

    /**
     * Genera un arreglo de objetos Alumno con IDs aleatorios y nombres genéricos.
     * @param tamano El tamaño del arreglo.
     * @return Un arreglo de objetos Alumno aleatorios.
     */
    private static Alumno[] generarDatosAlumnosAleatorios(int tamano) {
        Alumno[] arr = new Alumno[tamano];
        Random rand = new Random();
        for (int i = 0; i < tamano; i++) {
            arr[i] = new Alumno(rand.nextInt(tamano * 2) + 1, "Alumno_" + i); // IDs y nombres aleatorios/genéricos
        }
        return arr;
    }
}