/*@Programdor: Ing. Kevin Carlos López González,
* @Fecha: 02/11/2023,
* @Ejercicio: 2 Abstracción de problemas,
* @Descripción: El usuario desea ingresar al edificio para poder realizar su examen, sólo modele un sistema mediante clases y objetos en un nuevo proyecto de java describiendo el conjunto de pasos como atributos y métodos desde el ingreso al establecimiento hasta el inicio del examen.
* */
import Frames.Frame;
import Timer.Temporizador;
import beans.Persona;
import enums.*;
import beans.*;
import java.time.LocalDate;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        /***************************** A L U M N O S **********************/
        Alumno[] alumnos = new Alumno[2];
        alumnos[0] = new Alumno("Kevin", (byte) 25);
        alumnos[0].setSemestre(4);
        alumnos[0].setDerechoExamen(Estatus.VALIDO);
        alumnos[1] = new Alumno("Liam", (byte) 23);
        alumnos[1].setSemestre(2);
        alumnos[1].setDerechoExamen(Estatus.INVALIDO);

        /***************************** M A E S T R O S **********************/
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Estos son los maestros: \n");
        Maestro[] maestros = new Maestro[2];
        maestros[0] = new Maestro("Everardo", (byte) 40, Profesion.ING, alumnos[0].getNombreAlumno());
        maestros[1] = new Maestro("Nivek", (byte) 52, Profesion.ING, alumnos[1].getNombreAlumno());
        Arrays.sort(maestros);
        for (Maestro m : maestros) {
            sb1.append(m).append("\n");
        }

        /***************************** E X Á M E N E S **********************/
        Examen[] examenes = new Examen[5];
        examenes[0] = new Examen(Materias.POO,LocalDate.of(2023, 2,11),3,20);
        examenes[1] = new Examen(Materias.MATH,LocalDate.of(2024, 4,9),1);
        examenes[2] = new Examen(2,40);
        examenes[3] = new Examen(1);

        /***************************** E D F I C I O **********************/
        Edificio ed1 = new Edificio();
        ed1.setFacultad(Facultad.ING);
        ed1.setPisos(3);
        ed1.setEstadoEdificio(Disponibilidad.DISPONIBLE);

        /***************************** S A L Ó N E S *************************/
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Estos son los salones: \n");
        Salon[] salones = new Salon[2];
        salones[0] = new Salon(Disponibilidad.DISPONIBLE);
        salones[1] = new Salon(Disponibilidad.OCUPADO);
        for(Salon s : salones){
            sb2.append(s).append("\n");
        }

        /************************** P E R S O N A S ***********************/
        Persona[] personas = new Persona[5];
        personas[0] = new Persona("Charly", (byte) 52);
        personas[1] = alumnos[0]; //POLIMORFISMO, PRINCIPIO DE SUSTITUCIÓN

        /************************** M A T E R I A S ***********************/
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Estas son las materias: \n");
        for (Materias materias : Materias.values()){
            sb4.append(materias).append("\n");
        }
        ///////////////////////////// T E X T O ////////////////////////////
        StringBuilder sb3 = new StringBuilder();
        sb3.append(alumnos[0]).append(alumnos[0].realizarExamen()).append(alumnos[0].tomarTaxi());
        sb3.append(ed1).append(alumnos[0].subirElevador()).append(alumnos[0].desayunar());
        sb3.append(sb2).append(examenes[0]).append(sb1).append(maestros[0].desayunar());
        sb3.append(maestros[0].aplicaExamen()).append(alumnos[0].irBaño());
        sb3.append(maestros[0].irBaño()).append(maestros[0].calificarExamen()).append(sb4);
//        System.out.println(sb3);
        Temporizador temporizador = new Temporizador((short) 3000, true, personas[0]);
//        temporizador.proceso();
        Frame marcos = new Frame();
        marcos.start();
    }
}
