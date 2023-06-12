package org.will1184.model;

import org.will1184.exception.VacioException;
import org.will1184.repository.IColegio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Clase plantilla que contiene alumnos
public class Colegio implements IColegio {
    //Lista de tipo  Alumno
    List<Alumno> alumnosList;

    //Constructor que no pide argumentos e inicializa alumnosList como ArrayList
    public Colegio() {
        alumnosList= new ArrayList<>();
    }

    //Metodo que pide un objeto de tipo String, da la nacionalidad un alumno y lo almacena en alumnosList
    //La nacionalidad no debe ser vacia ni null sino lanzara una exception de tipo VacioException
    public void addAlumno(String nacionalidad){
        if (nacionalidad.isEmpty()){
            throw new VacioException("Nacionalidad no debe estar vacio");
        }
        Alumno alumno= new Alumno("Alumno",nacionalidad.toUpperCase());
        alumnosList.add(alumno);
    }

    //Metodo que muestra cuales son las nacionalidades que existen y cauntos alumnos tienen  la misma nacionalidad
    public void ShowAll(){
        System.out.println("Metodo ShowAll");
        Map<Object, Object> naciones = new HashMap<>();
        alumnosList.forEach(alumno -> naciones.
                put(alumno.getNacionalidad(),alumno.getNombre())
        );
        System.out.println("Cuales son las naciones que existen ");
        for (Object k:naciones.keySet()) {
            System.out.println("Nacionalidad: "+k);
        }

        Map <String,Integer> map = new HashMap<>();
        alumnosList.forEach(alumno -> map.put(alumno.getNacionalidad()
                ,map.getOrDefault(alumno.getNacionalidad(),0)+1)
                );
        System.out.println("Cuantos alumnos tienen la misma nacionalidad "+ map);

    }

        //Metodo que pide un objeto de tipo String y busca en la
        // lista alumnosList la cantidad de alumnos que contenga esa nacionalida nacionalidad
    public void showNacionalidad(String nacionalidad){
        System.out.println("\nMetodo ShowNacionalidad");
        Map<String,Integer> busquedaNacion= new HashMap<>();
        alumnosList.forEach(alumno -> busquedaNacion.put(alumno.getNacionalidad(),
                busquedaNacion.getOrDefault(alumno.getNacionalidad(),0)+1));

        System.out.println("Cantidad de los Alumnos con la nacionalidad: "
                +nacionalidad+" es de: "+busquedaNacion.get(nacionalidad));
    }

    //Metodo que devuelve la cantidad de nacionalidades diferentes entre los alumnos
    public Long cuantos(){
        System.out.println("\nMetodo cuantos");
        return alumnosList.
                stream()
                .map(Alumno::getNacionalidad)
                .distinct()
                .count();
    }

    //Metodo que borra los datos de alumnosList
    public void borrar(){
        System.out.println("\nMetodo borrar");
        alumnosList.clear();
        System.out.println("Las nacionalidades esta vacio?: "+alumnosList.isEmpty());
    }
}
