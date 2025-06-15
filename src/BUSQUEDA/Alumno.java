package BUSQUEDA;

public class Alumno {
    private int id;
    private String nombre;

    /**
     * construye un nuevo Alumno con el ID y el nombre especificados
     * @param id identificador unico para el alumno
     * @param nombre
     */
    public Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * obtiene el identificador unico del alumno
     * @return el ID del alumno.
     */
    public int getId() {
        return id;
    }

    /**
     * obtiene el nombre del alumno
     * @return El nombre del alumno
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * devuelve una representacion en cadena del alumno
     * @return una cadena que contiene el ID y el nombre del alumno
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre;
    }
}