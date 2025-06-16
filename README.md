# Implementación y Análisis de Algoritmos de Búsqueda y Ordenamiento en Java

## 1. Introducción

Este informe detalla la implementación y el análisis de diversos algoritmos fundamentales en la ciencia de la computación: algoritmos de búsqueda (secuencial y binaria) y algoritmos de ordenamiento (burbuja, inserción y selección).

La elección del algoritmo correcto para una tarea específica es crucial para la eficiencia y escalabilidad de cualquier sistema de software. Un algoritmo ineficiente puede ralentizar drásticamente una aplicación, especialmente cuando se trabaja con grandes volúmenes de datos. A través de este proyecto, exploramos cómo los diferentes enfoques algorítmicos se comportan bajo distintas cargas de trabajo.

## 2. Explicación detallada de cada algoritmo implementado

### 2.1 Búsqueda Secuencial (Lineal)

Consiste en recorrer todos los elementos de un arreglo, uno por uno, desde el principio hasta el final, comparando cada elemento con el valor que se está buscando. Si se encuentra una coincidencia, se devuelve el índice del elemento; de lo contrario, si se llega al final del arreglo sin encontrar el valor, se indica que no está presente.

Ejemplo de codigo:
 ```java
   public static int busquedaSecuencialPorNombre(Alumno[] alumnos, String nombre) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i].getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }
```

### 2.2 Búsqueda Binaria

La búsqueda binaria es un algoritmo mucho más eficiente, pero tiene un requisito fundamental: el arreglo debe estar previamente ordenado. El algoritmo funciona dividiendo repetidamente por la mitad la porción del arreglo donde podría encontrarse el valor. Compara el valor buscado con el elemento central del segmento actual. Si coinciden, se encuentra el valor. Si el valor es menor que el elemento central, la búsqueda continúa en la mitad inferior; si es mayor, en la mitad superior. Este proceso se repite hasta encontrar el valor o hasta que el segmento de búsqueda se vacíe.

Ejemplo de codigo:
```java
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
```
### 2.3 Ordenamiento Burbuja (Bubble Sort)

El algoritmo de la burbuja es un método de ordenamiento simple que funciona comparando repetidamente pares de elementos adyacentes y los intercambia si están en el orden incorrecto. Las pasadas a través del arreglo se repiten hasta que no se necesiten más intercambios, lo que indica que el arreglo está completamente ordenado. Los elementos "más pesados" (los mayores, en el caso de orden ascendente) "burbujean" lentamente hacia su posición final al final del arreglo.

Ejemplo de codigo:
```java
	public static void ordenar(Alumno[] arr) {
    	int n = arr.length;
    	boolean intercambiado;
    	for (int i = 0; i < n - 1; i++) {
        	intercambiado = false;
        	for (int j = 0; j < n - 1 - i; j++) {
            	if (arr[j].compareTo(arr[j + 1]) > 0) {
                	Alumno temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    intercambiado = true;
            	}
        	}
        	if (!intercambiado) break;
	    }
	}
```
### 2.4 Ordenamiento por Inserción (Insertion Sort)

El ordenamiento por inserción construye el arreglo ordenado final un elemento a la vez. Funciona tomando los elementos del arreglo uno por uno y "insertándolos" en su posición correcta dentro de la porción ya ordenada del arreglo. Es análogo a cómo se ordenaría una mano de cartas.

Ejemplo de codigo:
```java
	public static void ordenar(Alumno[] arr) {
    	int n = arr.length;
    	for (int i = 1; i < n; ++i) {
        	Alumno clave = arr[i];
        	int j = i - 1;
        	while (j >= 0 && arr[j].compareTo(clave) > 0) {
            	arr[j + 1] = arr[j];
            	j = j - 1;
        	}
        	arr[j + 1] = clave;
    	}
	}
```
### 2.5 Ordenamiento por Selección (Selection Sort)

El algoritmo de ordenamiento por selección divide el arreglo en dos partes: una sublista de elementos ya ordenados (construida de izquierda a derecha) y una sublista de elementos restantes sin ordenar. En cada paso, el algoritmo encuentra el elemento más pequeño (o más grande) en la sublista no ordenada y lo intercambia con el primer elemento de esa sublista, moviéndolo así a la parte ordenada.

Ejemplo de codigo:
```java
public static void ordenar(Alumno[] arr) {
    	int n = arr.length;
    	for (int i = 0; i < n - 1; i++) {
        	int indiceMinimo = i;
        	for (int j = i + 1; j < n; j++) {
            	if (arr[j].compareTo(arr[indiceMinimo]) < 0) {
                    indiceMinimo = j;
            	}
        	}
        	if (indiceMinimo != i) {
                Alumno temp = arr[indiceMinimo];
                arr[indiceMinimo] = arr[i];
                arr[i] = temp;
        	}
    	}
	}
```
## 3. Análisis de la Complejidad Big O

La notación Big O (O) describe el rendimiento o la complejidad de un algoritmo. Específicamente, nos indica cómo el tiempo de ejecución (o el espacio de memoria) de un algoritmo crece a medida que el tamaño de la entrada (n) aumenta. Consideramos el mejor caso, el peor caso y el caso promedio.

### 3.1 Búsqueda Secuencial

El algoritmo lo encuentra en una sola comparación.

### 3.2 Búsqueda Binaria

El elemento buscado es el elemento central del arreglo en la primera comparación.

### 3.3 Ordenamiento Burbuja (Bubble Sort)

La optimización de la bandera de intercambiado permite que el algoritmo detecte esto en una sola pasada (lineal) y termine.

### 3.4 Ordenamiento por Inserción (Insertion Sort)

El bucle interno (while) se ejecuta un mínimo de veces (una comparación por elemento), lo que resulta en una complejidad lineal.

### 3.5 Ordenamiento por Selección (Selection Sort)

Siempre busca el mínimo en la sublista no ordenada en cada pasada.

## 4. Metodología de Pruebas

Pruebas Manuales: Se permitió la entrada manual de un arreglo pequeño de objetos Alumno (un conjunto predefinido) para visualizar el proceso de ordenamiento y el tiempo en una escala más pequeña. Las búsquedas no se incluyeron en el modo manual con Alumno para simplificar la interfaz, dado que la comparación con int[] ya es representativa.

## 5. Conclusiones sobre el Rendimiento Relativo y Aplicaciones Prácticas

Los resultados de las pruebas confirman claramente que la Búsqueda Binaria es significativamente más eficiente que la Búsqueda Secuencial, para conjuntos de datos grandes.

## 6. Recomendaciones para la Selección de Algoritmos

### Para Búsqueda

Si los datos están ordenados o pueden ser ordenados eficientemente: Siempre opte por la Búsqueda Binaria. Su eficiencia logarítmica es insuperable para grandes volúmenes de datos.

### Para Ordenamiento

Para conjuntos de datos muy pequeños (pocas decenas de elementos): Burbuja, Inserción o Selección pueden ser aceptables por su facilidad de implementación.
