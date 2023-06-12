package org.will1184.model;

//Clase plantilla de un alumno
public class Alumno {

    //Atributos de la clase
    private static int count = -1;
    private Integer id;
    private String nombre;
    private String nacionalidad;

    //Constructor que pide como argumentos nombre y la nacionalidad
    public Alumno(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        count++;
        id = count;
    }

    //Getter y Setter de los atributos


    public Integer getId() {
        return id;
    }

    public void setId() {
        this.id++;
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
        return "Id: "+ id+" Nombre: " + nombre +
                ", Nacionalidad: " + nacionalidad;
    }
}
