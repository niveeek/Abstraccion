/*@Programdor: Ing. Kevin Carlos López González,
 * @Fecha: 02/11/2023,
 * @Ejercicio: 2 Abstracción de problemas,
 * @Descripción: El usuario desea ingresar al edificio para poder realizar su examen, sólo modele un sistema mediante clases y objetos en un nuevo proyecto de java describiendo el conjunto de pasos como atributos y métodos desde el ingreso al establecimiento hasta el inicio del examen.
 * */
package enums;
public enum Profesion {
    //ENUMERADORES
    ING("Ingeniero"),
    DOC("Doctor");
    //ATRIBUTO
    private final String profesion;
    //CONSTRUCTOR
    Profesion(String profesion){
        this.profesion = profesion;
    }
    //GETTER
    public String getProfesion() {
        return profesion;
    }
}
