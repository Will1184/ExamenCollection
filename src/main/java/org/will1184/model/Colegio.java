package org.will1184.model;

import org.will1184.exception.VacioException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Colegio{
    ArrayList<Alumno> nacionalidades;

    public Colegio() {
        nacionalidades= new ArrayList<>();
    }

    public void addAlumno(String nacionalidad){
        if (nacionalidad.isEmpty()){
            throw new VacioException("Nacionalidad no debe estar vacio");
        }
        Alumno alumno= new Alumno("Alumno",nacionalidad.toUpperCase());
        nacionalidades.add(alumno);
    }
    public void ShowAll(){
        System.out.println("Metodo ShowAll");
        Map<Object, Object> naciones = new HashMap<>();
        nacionalidades.forEach(alumno -> naciones.
                put(alumno.getNacionalidad(),alumno.getNombre())
        );
        System.out.println("Cuales son las naciones que existen ");
        for (Object k:naciones.keySet()) {
            System.out.println("Nacionalidad: "+k);
        }

        Map <String,Integer> map = new HashMap<>();
        nacionalidades.forEach(alumno -> map.put(alumno.getNacionalidad()
                ,map.getOrDefault(alumno.getNacionalidad(),0)+1)
                );
        System.out.println("Cuantos alumnos tienen la misma nacionalidad "+ map);

    }

    public void showNacionalidad(String nacionalidad){
        System.out.println("\nMetodo ShowNacionalidad");
        Map<String,Integer> busquedaNacion= new HashMap<>();
        nacionalidades.forEach(alumno -> busquedaNacion.put(alumno.getNacionalidad(),
                busquedaNacion.getOrDefault(alumno.getNacionalidad(),0)+1));

        System.out.println("Cantidad de los Alumnos con la nacionalidad: "
                +nacionalidad+" es de: "+busquedaNacion.get(nacionalidad));
    }

    public Long cuantos(){
        System.out.println("\nMetodo cuantos");
        return nacionalidades.
                stream()
                .map(Alumno::getNacionalidad)
                .distinct()
                .count();
    }

    public void borrar(){
        System.out.println("\nMetodo borrar");
        nacionalidades.clear();
        System.out.println("Las nacionalidades esta vacio?: "+nacionalidades.isEmpty());
    }
}
