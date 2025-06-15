package ORDENAMIENTO;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****** Análisis de Algoritmos de Búsqueda y Ordenamiento ******");

        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Pruebas con datos automáticos");
            System.out.println("2. Pruebas manuales de datos");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        ejecutarAutomaticos(); //Ejecutamos con datos automaticos
                        break;
                    case 2:
                        ejecutarPruebasManuales(scanner); // Ejecuta los Algoritmos con datos manuales.
                        break;
                    case 3:
                        System.out.println("Cerrando consola.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número valido.");
                scanner.next(); // Limpiar el scanner
                opcion = 0; // Para mantener el ciclo (bucle)
            }
        } while (opcion != 3);

        scanner.close();
    }

    /**
     * Ejecuta pruebas de rendimiento con conjuntos de datos automáticos (benchmarks).
     */
    private static void ejecutarAutomaticos() {
        System.out.println("\n--- Ejecutando Automáticamente ---");
        int[] tamanos = {1000, 10000, 50000}; // Pequeño, Mediano, Grande

        for (int tamano : tamanos) {
            System.out.println("\n--- Probando con N = " + tamano + " elementos ---");

            // Generar conjuntos de datos aleatorios
            int[] datosOriginal = generarDatosAleatorios(tamano);
            int[] datosCopia; // Para no modificar el original en cada prueba de ordenamiento

            // Elegir un valor existente y uno no existente para las búsquedas
            int valorABuscar = datosOriginal[new Random().nextInt(tamano)];
            int valorNoExistente = -1; // Un valor que asumimos no existirá en datos aleatorios positivos

            long inicio = System.nanoTime();
            long fin = System.nanoTime();


            // --- Pruebas de Ordenamiento ---
            System.out.println("\n--- Algoritmos de Ordenamiento ---");

            // Ordenamiento BubbleSort
            datosCopia = Arrays.copyOf(datosOriginal, datosOriginal.length);
            inicio = System.nanoTime();
            BubbleSort.ordenar(datosCopia);
            fin = System.nanoTime();
            System.out.printf("Ordenamiento BubbleSort: %.4f ms%n", (fin - inicio) / 1_000_000.0);
            // System.out.println("Ordenado BubbleSort (primeros 10): " + Arrays.toString(Arrays.copyOfRange(datosCopia, 0, Math.min(10, tamano))));

            // Ordenamiento InsertionSort
            datosCopia = Arrays.copyOf(datosOriginal, datosOriginal.length);
            inicio = System.nanoTime();
            InsertionSort.ordenar(datosCopia);
            fin = System.nanoTime();
            System.out.printf("Ordenamiento InsertionSort: %.4f ms%n", (fin - inicio) / 1_000_000.0);
            // System.out.println("Ordenado InsertionSort (primeros 10): " + Arrays.toString(Arrays.copyOfRange(datosCopia, 0, Math.min(10, tamano))));

            // Ordenamiento por SelectionSort
            datosCopia = Arrays.copyOf(datosOriginal, datosOriginal.length);
            inicio = System.nanoTime();
            SelectionSort.ordenar(datosCopia);
            fin = System.nanoTime();
            System.out.printf("Ordenamiento SelectionSort: %.4f ms%n", (fin - inicio) / 1_000_000.0);
            // System.out.println("Ordenado SelectionSort (primeros 10): " + Arrays.toString(Arrays.copyOfRange(datosCopia, 0, Math.min(10, tamano))));
        }
    }

    /**
     * Permite al usuario ingresar datos manualmente y probar algoritmos.
     * @param scanner El objeto Scanner para la entrada del usuario.
     */
    private static void ejecutarPruebasManuales(Scanner scanner) {
        System.out.println("\n--- Ejecutando Pruebas Manuales ---");
        System.out.print("Ingrese la cantidad de elementos para el vector: ");
        int tamano = 0;
        try {
            tamano = scanner.nextInt();
            if (tamano <= 0) {
                System.out.println("El tamaño del vector debe ser mayor que cero.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero para el tamaño del vector.");
            scanner.next(); // Limpiar el buffer
            return;
        }

        int[] datosManual = new int[tamano];
        System.out.println("Ingrese los " + tamano + " elementos del vector uno por uno:");
        for (int i = 0; i < tamano; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            try {
                datosManual[i] = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.next(); // Limpiar el buffer
                i--; // Para que el usuario reingrese el elemento actual
            }
        }
        System.out.println("Vector ingresado: " + Arrays.toString(datosManual));

        // Copias para cada algoritmo para asegurar que operan sobre los datos originales
        int[] datosParaBurbuja = Arrays.copyOf(datosManual, datosManual.length);
        int[] datosParaInsercion = Arrays.copyOf(datosManual, datosManual.length);
        int[] datosParaSeleccion = Arrays.copyOf(datosManual, datosManual.length);

        int opcionAlgoritmo;
        do {
            System.out.println("\n--- Seleccione un Algoritmo para Probar ---");
            System.out.println("1. Ordenamiento Burbuja");
            System.out.println("2. Ordenamiento por Inserción");
            System.out.println("3. Ordenamiento por Selección");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Elija una opción de algoritmo: ");

            try {
                opcionAlgoritmo = scanner.nextInt();
                switch (opcionAlgoritmo) {
                    case 1: // Ordenamiento Burbuja
                        System.out.println("Ordenando con Burbuja...");
                        long inicioBurbuja = System.nanoTime();
                        BubbleSort.ordenar(datosParaBurbuja);
                        long finBurbuja = System.nanoTime();
                        System.out.printf("Ordenamiento Burbuja (tiempo: %.4f ms). Vector ordenado: %s%n",
                                (finBurbuja - inicioBurbuja) / 1_000_000.0, Arrays.toString(datosParaBurbuja));
                        break;
                    case 2: // Ordenamiento por Inserción
                        System.out.println("Ordenando con Inserción...");
                        long inicioInsercion = System.nanoTime();
                        InsertionSort.ordenar(datosParaInsercion);
                        long finInsercion = System.nanoTime();
                        System.out.printf("Ordenamiento por Inserción (tiempo: %.4f ms). Vector ordenado: %s%n",
                                (finInsercion - inicioInsercion) / 1_000_000.0, Arrays.toString(datosParaInsercion));
                        break;
                    case 3: // Ordenamiento por Selección
                        System.out.println("Ordenando con Selección...");
                        long inicioSeleccion = System.nanoTime();
                        SelectionSort.ordenar(datosParaSeleccion);
                        long finSeleccion = System.nanoTime();
                        System.out.printf("Ordenamiento por Selección (tiempo: %.4f ms). Vector ordenado: %s%n",
                                (finSeleccion - inicioSeleccion) / 1_000_000.0, Arrays.toString(datosParaSeleccion));
                        break;
                    case 4:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer
                opcionAlgoritmo = 0; // Para mantener el bucle
            }
            // Recargar copias de los datos originales para la siguiente prueba si es de ordenamiento o busqueda que modifique el array
            datosParaBurbuja = Arrays.copyOf(datosManual, datosManual.length);
            datosParaInsercion = Arrays.copyOf(datosManual, datosManual.length);
            datosParaSeleccion = Arrays.copyOf(datosManual, datosManual.length);

        } while (opcionAlgoritmo != 6);
    }

    /**
     * Genera un arreglo de enteros con números aleatorios.
     *
     * @param tamano El tamaño del arreglo.
     * @return Un arreglo de enteros aleatorios.
     */
    private static int[] generarDatosAleatorios(int tamano) {
        int[] arr = new int[tamano];
        Random rand = new Random();
        for (int i = 0; i < tamano; i++) {
            arr[i] = rand.nextInt(tamano * 10); // Valores entre 0 y (tamano * 10 - 1)
        }
        return arr;
    }
}