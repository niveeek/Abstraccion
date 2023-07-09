/*@Programdor: Ing. Kevin Carlos López González,
 * @Fecha: 02/11/2023,
 * @Ejercicio: 2 Abstracción de problemas,
 * @Descripción: El usuario desea ingresar al edificio para poder realizar su examen, sólo modele un sistema mediante clases y objetos en un nuevo proyecto de java describiendo el conjunto de pasos como atributos y métodos desde el ingreso al establecimiento hasta el inicio del examen.
 * */
package beans;
import abstractas.A_Persona;
public class Persona extends A_Persona {
    //ATRIBUTOS
    private final String nombre;
    private final byte edad;
    //CONSTRUCTOR PRINCIPAL CON ARGUMENTOS
    public Persona(final String nombre, final byte edad) {
        this.nombre=nombre;
        this.edad = edad;
    }
    //GETTERS
    public final byte getEdad() {
        return edad;
    }
    public final String getNombre() {
        return nombre;
    }
    //MÉTODO IMPLEMENTADO
    @Override
    public String subirElevador() {
        return null;
    }
    @Override
    public String tomarTaxi() {
        return null;
    }
    @Override
    public String toString(){
        return "La persona "+nombre+" tiene "+edad+" años.";
    }
}