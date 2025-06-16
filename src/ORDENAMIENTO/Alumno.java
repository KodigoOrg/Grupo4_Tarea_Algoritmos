package ORDENAMIENTO;

public class Alumno implements Comparable<Alumno> {
    private int id;
    private String nombre;

    public Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "(" + id + ", " + nombre + ")";
    }

    /**
     * Compara este Alumno con el objeto Alumno especificado para el orden.
     * Basamos la comparación en el ID del alumno.
     *
     * @param otroAlumno el Alumno a comparar.
     * @return un entero negativo, cero, o un entero positivo si este objeto
     * es menor, igual, o mayor que el objeto especificado.
     */
    @Override
    public int compareTo(Alumno otroAlumno) {
        // Para ordenar por ID
        return Integer.compare(this.id, otroAlumno.id);
    }
}
