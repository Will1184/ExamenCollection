package org.will1184.repository;

public interface IColegio {
    void addAlumno(String nacionalidad);
    void ShowAll();
    void showNacionalidad(String nacionalidad);
    Long cuantos();
    void borrar();
}
