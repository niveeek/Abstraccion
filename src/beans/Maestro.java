/*@Programdor: Ing. Kevin Carlos López González,
 * @Fecha: 02/11/2023,
 * @Ejercicio: 2 Abstracción de problemas,
 * @Descripción: El usuario desea ingresar al edificio para poder realizar su examen, sólo modele un sistema mediante clases y objetos en un nuevo proyecto de java describiendo el conjunto de pasos como atributos y métodos desde el ingreso al establecimiento hasta el inicio del examen.
 * */
package beans;
import enums.Profesion;
import interfaces.I_Director;
import interfaces.I_Maestro;

public final class Maestro extends Persona implements Comparable, I_Maestro, I_Director {
    private final Profesion profesion;
    private final String alumno;

    //CONSTRUCTOR CON ATRIBUTOS DE PERSONA
    public Maestro(final String nombre, final byte edad, final Profesion profesion, final String alumno) {
        super(nombre, edad);
        this.profesion = profesion;
        this.alumno = alumno;
    }

    //MÉTODOS DE MAESTRO
    public String aplicaExamen() {
        return getNombre() + " aplicará un examen a " + alumno + ". \n";
    }

    //MÉTODOS IMPLEMENTADOS
    @Override
    public String toString() {
        return "El maestro " + getNombre() + " tiene " + getEdad() + " años y es " + profesion + ".";
    }

    @Override
    public String subirElevador() {
        return null;
    }

    @Override
    public String tomarTaxi() {
        return null;
    }

    //JAVA 14: pattern matching for instanceof
    @Override
    public int compareTo(Object o) {
//        if (o instanceof Persona persona) {
//            //INVERTIR LOS PARÁMETROS SI SE BUSCA EL RESULTADO INVERSO
//            return Byte.compare(persona.getEdad(), getEdad());
//        } else {
//            return 0;
//        }
        return 0;
    }

    //MÉTODOS IMPLEMENTADOS DE I_MAESTRO
    @Override
    public String calificarExamen() {
        return getNombre() + " calificará el examen de " + alumno + ". \n";
    }

    @Override
    public String desayunar() {
        return getNombre() + " desayuna en la cafetería. \n";
    }

    @Override
    public String irBaño() {
        return getNombre() + " va al baño después de su aplicación. \n";
    }

    //MÉTODO IMPLEMENTADO DE I_DIRECTOR
    @Override
    public String tomarDecisiones() {
        return "El maestro decidió cancelar el examen. ";
    }
}
