package org.will1184.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.will1184.exception.VacioException;


import static org.junit.jupiter.api.Assertions.*;

class ColegioTest {

    Colegio colegio;
    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeEach
    void initMetodoTest(TestInfo testInfo, TestReporter testReporter){
        this.colegio =new Colegio();
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        System.out.println("Iniciando  metodo");
        testReporter.publishEntry("Ejecutando: "+ testInfo.getDisplayName()
                + " "+testInfo.getTestMethod().orElse(null).getName()
                +" con las etiquetas "+testInfo.getTags());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando Metodo");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("Test Finalizado");
    }
    @BeforeAll
    static void beforeAll(){
        System.out.println("Test Iniciado");
    }


    @Test
    @Tag("colegio")
    void testAddAlumno(){
        colegio.addAlumno("MEXICANA");
        colegio.addAlumno("ARGENTINA");
        long esperado=2;
        long actual= colegio.nacionalidades.size();
        assertEquals(esperado,actual);

    }

    @Test
    @Tag("colegio")
    void testShowAll() {


    }

    @Test
    @Tag("colegio")
    void testShowNacionalidad() {

    }

    @Test
    @Tag("colegio")
    void testCuantos() {
        colegio.addAlumno("MEXICANA");
        colegio.addAlumno("ARGENTINA");
        long esperados=2;
        long actual= colegio.cuantos();
        assertEquals(esperados,actual);
    }

    @Test
    @Tag("colegio")
    void testBorrar() {
        colegio.addAlumno("MEXICANA");
        colegio.addAlumno("ARGENTINA");
        colegio.borrar();
        assertTrue(colegio.nacionalidades.isEmpty());
    }


    @Test
    @Tag("colegio")
    @Tag("error")
    void testVacioException(){
        Exception exception = assertThrows(VacioException.class,() -> colegio.addAlumno(""));
        String actual = exception.getMessage();
        String esperado = "Nacionalidad no debe estar vacio";
        assertEquals(esperado,actual);
    }

    @Tag("param")
    @Nested
    class PruebasParameterizedTest{

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(strings = {"espaniol", "mexicano","hondurenio","",})
        @Tag("colegio")
        void testNacionalidadNotEmpty(String nacionalidad) {
            assertFalse(nacionalidad.isBlank(),"La nacionalidad no debe ser null ni estar vacio");
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(strings = {"espaniol", "mexicano","HONDURENIO"})
        @Tag("colegio")
        void testNacionalidadToUpperCase(String nacionalidad) {
            boolean upperCase=isUpperCase(nacionalidad);
            assertTrue(upperCase,"Nacionalidad debe estar en mayuscula");
        }
    }

    public static boolean isUpperCase(String nacionalidad){
        for (int i=0; i<nacionalidad.length();i++){
            if (Character.isUpperCase(nacionalidad.charAt(i))){
                return true;
            }
        }
        return false;

    }
}