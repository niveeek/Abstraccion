/*@Programdor: Ing. Kevin Carlos López González,
 * @Fecha: 02/11/2023,
 * @Ejercicio: 2 Abstracción de problemas,
 * @Descripción: El usuario desea ingresar al edificio para poder realizar su examen, sólo modele un sistema mediante clases y objetos en un nuevo proyecto de java describiendo el conjunto de pasos como atributos y métodos desde el ingreso al establecimiento hasta el inicio del examen.
 * */
package beans;
import enums.Disponibilidad;
public final class Salon {
    //ATRIBUTOS
    private final Disponibilidad estadoSalon;
    private final byte id;
    private static byte id2=1;
    //MÉTODO IMPLEMENTADO
    @Override
    public String toString(){
        return "El salón "+id+" está "+estadoSalon+". ";
    }
    //CONSTRUCTOR
    public Salon(final Disponibilidad estadoSalon) {
        id=id2;
        id2++;
        this.estadoSalon = estadoSalon;
    }
    //MÉTODO ESTÁTICO
    public static byte getId2(){
        return id2;
    }
}