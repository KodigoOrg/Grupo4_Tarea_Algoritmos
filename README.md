# Implementación y Análisis de Algoritmos de Búsqueda y Ordenamiento en Java

## Introducción

Este informe detalla la implementación y el análisis de diversos algoritmos fundamentales en la ciencia de la computación: algoritmos de búsqueda (secuencial y binaria) y algoritmos de ordenamiento (burbuja, inserción y selección).

La elección del algoritmo correcto para una tarea específica es crucial para la eficiencia y escalabilidad de cualquier sistema de software. Un algoritmo ineficiente puede ralentizar drásticamente una aplicación, especialmente cuando se trabaja con grandes volúmenes de datos. A través de este proyecto, exploramos cómo los diferentes enfoques algorítmicos se comportan bajo distintas cargas de trabajo.

## Explicación detallada de cada algoritmo implementado

### Búsqueda Secuencial (Lineal)

Consiste en recorrer todos los elementos de un arreglo, uno por uno, desde el principio hasta el final, comparando cada elemento con el valor que se está buscando. Si se encuentra una coincidencia, se devuelve el índice del elemento; de lo contrario, si se llega al final del arreglo sin encontrar el valor, se indica que no está presente.

### Búsqueda Binaria

La búsqueda binaria es un algoritmo mucho más eficiente, pero tiene un requisito fundamental: el arreglo debe estar previamente ordenado. El algoritmo funciona dividiendo repetidamente por la mitad la porción del arreglo donde podría encontrarse el valor. Compara el valor buscado con el elemento central del segmento actual. Si coinciden, se encuentra el valor. Si el valor es menor que el elemento central, la búsqueda continúa en la mitad inferior; si es mayor, en la mitad superior. Este proceso se repite hasta encontrar el valor o hasta que el segmento de búsqueda se vacíe.

### Ordenamiento Burbuja (Bubble Sort)

El algoritmo de la burbuja es un método de ordenamiento simple que funciona comparando repetidamente pares de elementos adyacentes y los intercambia si están en el orden incorrecto. Las pasadas a través del arreglo se repiten hasta que no se necesiten más intercambios, lo que indica que el arreglo está completamente ordenado. Los elementos "más pesados" (los mayores, en el caso de orden ascendente) "burbujean" lentamente hacia su posición final al final del arreglo.

### Ordenamiento por Inserción (Insertion Sort)

El ordenamiento por inserción construye el arreglo ordenado final un elemento a la vez. Funciona tomando los elementos del arreglo uno por uno y "insertándolos" en su posición correcta dentro de la porción ya ordenada del arreglo. Es análogo a cómo se ordenaría una mano de cartas.

### Ordenamiento por Selección (Selection Sort)

El algoritmo de ordenamiento por selección divide el arreglo en dos partes: una sublista de elementos ya ordenados (construida de izquierda a derecha) y una sublista de elementos restantes sin ordenar. En cada paso, el algoritmo encuentra el elemento más pequeño (o más grande) en la sublista no ordenada y lo intercambia con el primer elemento de esa sublista, moviéndolo así a la parte ordenada.

## Análisis de la Complejidad Big O

La notación Big O (O) describe el rendimiento o la complejidad de un algoritmo. Específicamente, nos indica cómo el tiempo de ejecución (o el espacio de memoria) de un algoritmo crece a medida que el tamaño de la entrada (n) aumenta. Consideramos el mejor caso, el peor caso y el caso promedio.

### Búsqueda Secuencial

El algoritmo lo encuentra en una sola comparación.

### Búsqueda Binaria

El elemento buscado es el elemento central del arreglo en la primera comparación.

### Ordenamiento Burbuja (Bubble Sort)

La optimización de la bandera de intercambiado permite que el algoritmo detecte esto en una sola pasada (lineal) y termine.

### Ordenamiento por Inserción (Insertion Sort)

El bucle interno (while) se ejecuta un mínimo de veces (una comparación por elemento), lo que resulta en una complejidad lineal.

### Ordenamiento por Selección (Selection Sort)

Siempre busca el mínimo en la sublista no ordenada en cada pasada.

## Metodología de Pruebas

Pruebas Manuales: Se permitió la entrada manual de un arreglo pequeño de objetos Alumno (un conjunto predefinido) para visualizar el proceso de ordenamiento y el tiempo en una escala más pequeña. Las búsquedas no se incluyeron en el modo manual con Alumno para simplificar la interfaz, dado que la comparación con int[] ya es representativa.

## Conclusiones sobre el Rendimiento Relativo y Aplicaciones Prácticas

Los resultados de las pruebas confirman claramente que la Búsqueda Binaria es significativamente más eficiente que la Búsqueda Secuencial, para conjuntos de datos grandes.

## Recomendaciones para la Selección de Algoritmos

### Para Búsqueda

Si los datos están ordenados o pueden ser ordenados eficientemente: Siempre opte por la Búsqueda Binaria. Su eficiencia logarítmica es insuperable para grandes volúmenes de datos.

### Para Ordenamiento

Para conjuntos de datos muy pequeños (pocas decenas de elementos): Burbuja, Inserción o Selección pueden ser aceptables por su facilidad de implementación.
