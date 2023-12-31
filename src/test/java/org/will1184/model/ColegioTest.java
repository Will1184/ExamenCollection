package org.will1184.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.will1184.exception.VacioException;


import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

//Clase test de la clase Colegio
class ColegioTest {

    Colegio colegio;
    private TestInfo testInfo;
    private TestReporter testReporter;

    //Metodo que inicia  antes de cada test
    @BeforeEach
    void initMetodoTest(TestInfo testInfo, TestReporter testReporter){
        this.colegio =new Colegio();
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        System.out.println("Iniciando  metodo");
        testReporter.publishEntry("Ejecutando: "+ testInfo.getDisplayName()
                + " "+ Objects.requireNonNull(testInfo.getTestMethod().orElse(null)).getName()
                +" con las etiquetas "+testInfo.getTags());
    }

    //Metodo que inicia  despues de cada test
    @AfterEach
    void tearDown() {
        System.out.println("Finalizando Metodo");
    }
    //Metodo que inicia  despues de todos los test
    @AfterAll
    static void afterAll(){
        System.out.println("Test Finalizado");
    }
    //Metodo que inicia  antes de todos los test
    @BeforeAll
    static void beforeAll(){
        System.out.println("Test Iniciado");
    }


    //Test que prueba si se agrega alumnos y nacionalidad a alumnoList
    @Test
    @Tag("colegio")
    void testAddAlumno(){
        colegio.addAlumno("MEXICANA");
        colegio.addAlumno("ARGENTINA");
        long esperado=2;
        long actual= colegio.alumnosList.size();
        assertEquals(esperado,actual);
    }

    //Test que prueba si se lanza corectamente la excepcion VacioException
    @Test
    @Tag("colegio")
    @Tag("error")
    void testVacioExceptionAddAlumnoT(){
        Exception exception = assertThrows(VacioException.class,() -> colegio.addAlumno(""));
        String actual = exception.getMessage();
        String esperado = "Nacionalidad no debe estar vacio";
        assertEquals(esperado,actual);
    }

    @Test
    @Tag("colegio")
    void testShowAll() {
    }

    //Test que prueba si se lanza corectamente la excepcion VacioException en el metodo showNacionalidad
    @Test
    @Tag("colegio")
    @Tag("error")
    void testVacioExceptionShowNacionalidad() {
        Exception exception = assertThrows(VacioException.class,() -> colegio.showNacionalidad(""));
        String actual = exception.getMessage();
        String esperado = "Nacionalidad no debe estar vacio";
        assertEquals(esperado,actual);
    }

    //Test que prueba la cantidad de nacionalidades que hay
    @Test
    @Tag("colegio")
    void testCuantos() {
        colegio.addAlumno("MEXICANA");
        colegio.addAlumno("ARGENTINA");
        long esperados=2;
        long actual= colegio.cuantos();
        assertEquals(esperados,actual);
    }

    //Test que prueba si se borra correctamente el alumno de alumnosList en el metodo borrarId
    @Test
    @Tag("colegio")
    void testBorrarId() {
        colegio.addAlumno("MEXICANA");
        colegio.addAlumno("ARGENTINA");
        int id=1;
        colegio.borrarId(id);
        int alumnos= colegio.alumnosList.size();
        assertSame(1,id);
        assertEquals(1,alumnos);
    }

    //Test que prueba si el objeto recibido no es del mismo tipo de objeto que el esperado en el metodo borrarId
    @Test
    @Tag("colegio")
    void testBorrarIdNotSameObject() {
        colegio.addAlumno("MEXICANA");
        colegio.addAlumno("ARGENTINA");
        Long id=1L;
        colegio.borrarId(Math.toIntExact(id));
        assertSame(1,id,"No son el mismo tipo de datos");
    }

    //Test que prueba si se borra correctamente alumnosList en el metodoBorrar
    @Test
    @Tag("colegio")
    void testBorrar() {
        colegio.addAlumno("MEXICANA");
        colegio.addAlumno("ARGENTINA");
        colegio.borrar();
        assertTrue(colegio.alumnosList.isEmpty());
    }

    //Test Parametrizadas
    @Tag("param")
    @Nested
    class PruebasParameterizedTest{

        //Pruebas para verificar que no acepte datos vacios
        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(strings = {"espaniol", "mexicano","hondurenio","",})
        @Tag("colegio")
        @Tag("error")
        void testNacionalidadNotEmpty(String nacionalidad) {
            assertFalse(nacionalidad.isBlank(),"La nacionalidad no debe ser null ni estar vacio");
        }

        //Pruebas para verificar que la nacinalidad este en mayusculas
        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(strings = {"espaniol", "mexicano","HONDURENIO"})
        @Tag("colegio")
        @Tag("error")
        void testNacionalidadToUpperCase(String nacionalidad) {
            boolean upperCase=isUpperCase(nacionalidad);
            assertTrue(upperCase,"Nacionalidad debe estar en mayuscula");
        }
    }
//Metodo que permite verificar si un String esta en mayuscula
    public static boolean isUpperCase(String nacionalidad){
        for (int i=0; i<nacionalidad.length();i++){
            if (Character.isUpperCase(nacionalidad.charAt(i))){
                return true;
            }
        }
        return false;

    }
}