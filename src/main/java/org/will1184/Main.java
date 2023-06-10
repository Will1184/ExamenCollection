package org.will1184;

import org.will1184.model.Colegio;

public class Main {
    public static void main(String[] args) {
        Colegio c = new Colegio();
        c.addAlumno("Portuges");
        c.addAlumno("Portuges");
        c.addAlumno("Salvadorenia");
        c.ShowAll();
        c.showNacionalidad("Salvadorenia");
        System.out.println("Cuantas naciones distintas hay? "+c.cuantos());
        c.borrar();
    }
}