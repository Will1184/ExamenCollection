package org.will1184;

import org.will1184.model.Colegio;
//Github: Will1184
//Autor: Brandon William Gomez Monge
public class Main {
    public static void main(String[] args) {

        System.out.println("Autor: Brandon William Gomez Monge");
        System.out.println("Github: Will1184");
        Colegio c = new Colegio();
        c.setNombreColegio("Santa Teresa");
        c.addAlumno("Portuguesa");
        c.addAlumno("Portuguesa");
        c.addAlumno("Salvadorenia");
        c.addAlumno("alemana");
        c.ShowAll();
        c.showNacionalidad("SALVADORENIA");
        c.showNacionalidad("Griega");
        System.out.println("Cuantas naciones distintas hay? "+c.cuantos());
        c.borrar();
        c.borrarId(2);
        c.borrarRegistros();
        c.ShowAll();
        System.out.println("Cuantas naciones distintas hay? "+c.cuantos());
    }
}