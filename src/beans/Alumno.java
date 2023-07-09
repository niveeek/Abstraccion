/*@Programdor: Ing. Kevin Carlos López González,
 * @Fecha: 02/11/2023,
 * @Ejercicio: 2 Abstracción de problemas,
 * @Descripción: El usuario desea ingresar al edificio para poder realizar su examen, sólo modele un sistema mediante clases y objetos en un nuevo proyecto de java describiendo el conjunto de pasos como atributos y métodos desde el ingreso al establecimiento hasta el inicio del examen.
 * */
package beans;
import enums.Estatus;
import interfaces.I_Persona;
public final class Alumno extends Persona implements I_Persona {
    //ATRIBUTOS
    private Estatus derechoExamen;
    private Integer semestre;
    private String nombreAlumno;
    //MÉTODOS DE ALUMNO
    public String realizarExamen(){
        return getNombre()+" realizará un examen. ";
    }
    //MÉTODOS IMPLEMENTADOS DE PERSONA
    @Override
    public String subirElevador() {
        return getNombre()+" utiliza el elevador. \n";
    }
    @Override
    public String tomarTaxi() {
        return getNombre()+" toma el taxi hacia la universidad. \n";
    }
    @Override
    public String toString(){
        return getNombre()+" tiene "+getEdad()+" años. Su derecho a examen es "+derechoExamen+" y está en el semestre "+semestre+". \n";
    }
    //CONSTRUCTOR CON ATRIBUTOS DE PERSONA
    public Alumno(final String nombre, final byte edad) {
        super(nombre, edad);
    }
    //GETTERS AND SETTERS
    public void setDerechoExamen(Estatus derechoExamen) {
        this.derechoExamen = derechoExamen;
    }
    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }
    public String getNombreAlumno(){
        return nombreAlumno = super.getNombre(); //ENLACE DINÁMICO
    }
    //MÉTODOS IMPLEMENTADOS INTERFAZ
    @Override
    public String desayunar() {
        return getNombre()+" desayuna antes del examen. \n";
    }
    @Override
    public String irBaño() {
        return getNombre()+ " va al baño durante el examen. \n";
    }
}