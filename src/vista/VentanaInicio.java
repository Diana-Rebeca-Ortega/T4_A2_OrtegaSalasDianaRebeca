package vista;

import Controlador.AlumnoDAO;
import modelo.Alumno;

import java.util.ArrayList;

public class VentanaInicio {
    public static void main(String[] args) {

        //------------------------PRUEBA PROCESO ALTAS-------------------------------
        Alumno a = new Alumno("", "","", "",(byte)0, (byte)0,"");//Le tenemos que poner parametros vacios para poder hacer el objeto, pero los valores que entraran a la base de datos son los de la instruccion String sql = "INSERT INTO alumnos VALUES('6','86','86','86',86 ,86 , '86'  )";
        AlumnoDAO alumnoDAO = new AlumnoDAO();//AlumnoDao es el objeto del Packete CONTROLADOR que hace la conexion a la BDD
        if (alumnoDAO.agregarAlumno(a))
            System.out.println("FELICIDADES: se agrego un nuevo Alumno a la BDD (desde la ventanaInicio)");
        else
            System.out.println("ERROR: no se pudo agregar un nuevo Alumno a la BDD (desde la ventanaInicio)");



        //----------------PRUEBA PROCESO BAJAS*----------------------------
        if (alumnoDAO.eliminarAlumnos("2"))
            System.out.println("FELICIDADES: se ha ELIMINADO correctamente desde la Ven_Inicio");
        else
            System.out.println("ERROR:  la ELIMINACION del registro lindo desde la Ven_Inicio no se consiguio");



        //----------------PRUEBA PROCESO CAMBIOS*----------------------------
        Alumno a1 = new Alumno("1","Luke", "Slit", "-", (byte)10, (byte)10, "ISC");//el 1 es el parametro que se enviara para q todas las casillas sean cambiadas
        if (alumnoDAO.cambiarAlumno(a1))
            System.out.println("Registro modificado CORRECTAMENTE desde la Ven_Inicio");
        else
            System.out.println("ERROR en la modificacion del registro lindo desde la Ven_Inicio");


        //----------------PRUEBA PROCESO CONSULTAS*----------------------------

        ArrayList<Alumno> lista = alumnoDAO.mostrarAlumnos("");
        //for ich,,, each
        for (Alumno alumno: lista)
            System.out.println(alumno.getNumControl());

    }

}
