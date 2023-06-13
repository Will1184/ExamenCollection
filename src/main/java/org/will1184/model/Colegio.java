package org.will1184.model;


import org.will1184.exception.VacioException;
import org.will1184.repository.IColegio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Clase plantilla que contiene alumnos
public class Colegio implements IColegio {
    private String nombreColegio;
    private int id;
    private static int count=0;

    //Lista de tipo  Alumno
    protected List<Alumno> alumnosList;

    //Constructor que no pide argumentos e inicializa alumnosList como ArrayList
    public Colegio() {
        alumnosList= new ArrayList<>();
        count++;
        id = count;
    }

    public String getNombreColegio() {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    //Metodo que pide un objeto de tipo String, da la nacionalidad un alumno y lo almacena en alumnosList
    //La nacionalidad no debe ser vacia ni null sino lanzara una exception de tipo VacioException
    public void addAlumno(String nacionalidad){
        if (nacionalidad.isEmpty()){
            throw new VacioException("Nacionalidad no debe estar vacio");
        }
        String[]nombres= {"Juan","Maria","Pedro"};
        String nombre=nombres[(int)(Math.random()*3+0)];

        Alumno alumno= new Alumno(nombre,nacionalidad.toUpperCase());
        alumnosList.add(alumno);
    }

    //Metodo que muestra cuales son las nacionalidades que existen y cauntos alumnos tienen  la misma nacionalidad
    public void ShowAll(){
        System.out.println("========Metodo ShowAll========");
        if (alumnosList.isEmpty()){
            System.out.println("No existen datos");
        }else {
            System.out.println("El colegio "+nombreColegio+" tiene en el registro a estos alumnos");
            alumnosList.forEach(System.out::println);
            System.out.println("\nCuales son las naciones que existen " +
                    "y cuantos alumnos hay de cada nacionalidad? ");
            Map <String,Integer> naciones = new HashMap<>();
            alumnosList.forEach(alumno -> naciones.put(alumno.getNacionalidad()
                    ,naciones.getOrDefault(alumno.getNacionalidad(),0)+1)
            );
            for (Object k:naciones.keySet()) {
                System.out.println("Cantidad de alumnos con la nacionalidad: "
                        +k+" es de: "+ naciones.get(k.toString()));
            }
        }

    }
        //Metodo que pide un objeto de tipo String y busca en la
        // lista alumnosList la cantidad de alumnos que contenga esa nacionalida nacionalidad
    public void showNacionalidad(String nacionalidad){
        System.out.println("\n===========Metodo ShowNacionalidad========");
        if (nacionalidad.isEmpty()){
            throw new VacioException("Nacionalidad no debe estar vacio");
        }
        Map<String,Integer> busquedaNacion= new HashMap<>();
        alumnosList.forEach(alumno -> busquedaNacion.put(alumno.getNacionalidad(),
                busquedaNacion.getOrDefault(alumno.getNacionalidad(),0)+1));

        System.out.println("Cantidad de los Alumnos con la nacionalidad: "
                +nacionalidad+" es de: "+busquedaNacion.get(nacionalidad.toUpperCase()));

        if (busquedaNacion.get(nacionalidad)== null){
            System.out.println("No existe alumno con esa nacionalidad");
        }
    }

    //Metodo que devuelve la cantidad de nacionalidades diferentes entre los alumnos
    public Long cuantos(){
        System.out.println("\n=======Metodo cuantos========");
        long naciones= alumnosList.
                stream()
                .map(Alumno::getNacionalidad)
                .distinct()
                .count();
        if (naciones == 0){
            System.out.println("No existen naciones en el sistema");
        }
        return naciones;
    }
    //Metodo que borra los datos de alumnosList
    public void borrar(){
        System.out.println("\n==========Metodo borrar===========");
        alumnosList.forEach(System.out::println);
        int id=1;
        if (id<0){
            throw new RuntimeException("Id deber ser igual o mayor a cero");
        }

        alumnosList.remove(id);
        System.out.println("\nId: "+ id+" Eliminado \n");
        alumnosList.forEach(System.out::println);

    }

    //Metodo que borra los datos de alumnosList
    public void borrarId(int id){
        System.out.println("\n==========Metodo borrar Por id===========");
        alumnosList.forEach(System.out::println);

        if (id<0){
                throw new RuntimeException("Id deber ser igual o mayor a cero");
        }

        alumnosList.remove(id);
        System.out.println("\nId: "+ id+" Eliminado \n");
        alumnosList.forEach(System.out::println);

    }
    //Metodo que borra los datos de alumnosList
    public void borrarRegistros(){
        System.out.println("\n======Metodo borrar Toda la lista==========");
        System.out.println("Las nacionalidades esta vacio?: "+alumnosList.isEmpty());
        alumnosList.clear();
        System.out.println("Las nacionalidades esta vacio?: "+alumnosList.isEmpty());
    }
}
