package org.will1184.model;

//Clase plantilla de un alumno
public class Alumno {

    //Atributos de la clase
    private static int id;
    private String nombre;
    private String nacionalidad;

    //Constructor que pide como argumentos nombre y la nacionalidad
    public Alumno(String nombre, String nacionalidad) {
        id++;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    //Getter y Setter de los atributos
    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        Alumno.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre +
                ", nacionalidad: " + nacionalidad;
    }
}
