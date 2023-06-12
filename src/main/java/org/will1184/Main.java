package org.will1184;

import org.will1184.model.Colegio;
//Github: Will184
//Autor: Brandon William Gomez Monge
public class Main {
    public static void main(String[] args) {

        System.out.println("Autor: Brandon William Gomez Monge");
        System.out.println("Github: Will184");
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