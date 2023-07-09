/*@Programdor: Ing. Kevin Carlos López González,
 * @Fecha: 02/11/2023,
 * @Ejercicio: 2 Abstracción de problemas,
 * @Descripción: El usuario desea ingresar al edificio para poder realizar su examen, sólo modele un sistema mediante clases y objetos en un nuevo proyecto de java describiendo el conjunto de pasos como atributos y métodos desde el ingreso al establecimiento hasta el inicio del examen.
 * */
package beans;
import enums.Materias;
import java.time.LocalDate;
public final class Examen {
    //ATRIBUTOS
    private Materias asignatura;
    private LocalDate fechaExamen;
    private final Integer duracion;
    private final Integer numeroReactivos;
    @Override
    public String toString(){
        return "El exámen de "+asignatura+" tiene "+numeroReactivos+
                " reactivos, durará "+duracion+" horas y se aplicará el día "+fechaExamen+". \n";
    }
    //CONSTRUCTOR PRINCIPAL
    public Examen(Materias asignatura, LocalDate fechaExamen, final Integer duracion, final Integer numeroReactivos) {
        this.asignatura = asignatura;
        this.fechaExamen = fechaExamen;
        this.duracion = duracion;
        this.numeroReactivos = numeroReactivos;
    }
    //CONSTRUCTOR SECUNDARIO
    public Examen(Materias asignatura, LocalDate fechaExamen, final Integer numeroReactivos){
        this(asignatura, fechaExamen, 1, numeroReactivos);
    }
    //CONSTRUCTOR TERCIARIO
    public Examen(final Integer duracion, final Integer numeroReactivos){
        this.duracion = duracion;
        this.numeroReactivos = numeroReactivos;
    }
    //CONSTRUCTOR CUARTENARIO
    public Examen(final Integer duracion){
        this(duracion, 5);
    }

}