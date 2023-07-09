/*@Programdor: Ing. Kevin Carlos López González,
 * @Fecha: 02/11/2023,
 * @Ejercicio: 2 Abstracción de problemas,
 * @Descripción: El usuario desea ingresar al edificio para poder realizar su examen, sólo modele un sistema mediante clases y objetos en un nuevo proyecto de java describiendo el conjunto de pasos como atributos y métodos desde el ingreso al establecimiento hasta el inicio del examen.
 * */
package enums;
public enum Materias {
    //ENUMERADORES
    POO("Programación Orientada a Objetos"),
    MATH("Matemáticas"),
    ENG("Inglés");
    //ATRIBUTO
    private final String materia;
    //CONSTRUCTOR
    Materias(String materia) {
        this.materia=materia;
    }
    //GETTER
    public String getMateria() {
        return materia;
    }
}
