package org.will1184.exception;

public class VacioException extends RuntimeException{
    //Clase que lanza una excepcion y devuelve un mensaje
    public VacioException(String message){
        super(message);
    }
}
