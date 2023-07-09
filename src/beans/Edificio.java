/*@Programdor: Ing. Kevin Carlos López González,
 * @Fecha: 02/11/2023,
 * @Ejercicio: 2 Abstracción de problemas,
 * @Descripción: El usuario desea ingresar al edificio para poder realizar su examen, sólo modele un sistema mediante clases y objetos en un nuevo proyecto de java describiendo el conjunto de pasos como atributos y métodos desde el ingreso al establecimiento hasta el inicio del examen.
 * */
package beans;
import enums.Disponibilidad;
import enums.Facultad;
public final class Edificio {
    //ATRIBUTOS
    private Facultad facultad;
    private Integer pisos;
    private Disponibilidad disponibilidad;
    //MÉTODO IMPLEMENTADO
    @Override
    public String toString(){
        return "La facultad es "+facultad+", tiene "+pisos+" pisos y está "+disponibilidad+". \n";
    }
    //SETTERS
    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }
    public void setPisos(Integer pisos) {
        this.pisos = pisos;
    }
    public void setEstadoEdificio(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}