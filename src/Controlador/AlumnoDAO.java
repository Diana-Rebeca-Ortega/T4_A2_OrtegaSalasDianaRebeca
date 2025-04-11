package Controlador;
//importar otros paquetes
import conexionBD.ConexionBD;
import modelo.Alumno;



//importar librerias
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//CLASE CONTROLADOERA DEL MODELO ALUMNO
//DAO - DATA ACCESSS OBJECT
public class AlumnoDAO {
    ConexionBD conexionBD = new ConexionBD();

    //MMMMMMMMMMMMMMMMMMMMMMETODOS ABCCccccccccccccccccccccccccccccccccc


    //***************************************ALTAS*******************************

    public boolean agregarAlumno(Alumno alumno){
        System.out.println("numcontrol"+alumno.getNumControl());
        String sql = "INSERT INTO alumnos VALUES('"+alumno.getNumControl()+"','"+alumno.getNombre()+
                "','"+alumno.getPrimerApellido()+"','"+alumno.getSegundoApellido()+"'," +
                ""+alumno.getEdad()+"  ,"+alumno.getSemestre()+" , '"+alumno.getCarrera()+"'  )";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }


    //*******************************BAJAS/*****************************
    public  boolean eliminarAlumnos (String numControl){
        String sql = "DELETE FROM alumnos WHERE Num_Control='"+numControl+"' ";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }


    //*******************************CAMBIOS*****************************
    public boolean cambiarAlumno( Alumno alumno){
        String sql = "UPDATE alumnos SET Nombre='" + alumno.getNombre() +"'," +
                " PrimerAP='" + alumno.getPrimerApellido() +"', SegundoAP='" + alumno.getSegundoApellido() +"'," +
                " Edad=0, Semestre=0, Carrera='' WHERE Num_Control='" + alumno.getNumControl() + "'";
        return  conexionBD.ejecutarInstruccionLMD(sql); //retorta 0, 1 o 2... false o true
    }


    //*******************************CONSULTAS/*****************************
    public Alumno mostrarAlumno(String filtro){
        String sql = "SELECT * FROM Alumnos WHERE Num_Control='"+filtro+"'";
        System.out.println(sql);

        ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);
        Alumno a = null;
        try {
            if(rs.next()) {
                String nc = rs.getString(1);
                String n = rs.getString("Nombre");
                String pa = rs.getString(3);
                String sa = rs.getString("Segundo_Ap");
                byte e = rs.getByte(5);
                byte s = rs.getByte(6);
                String c = rs.getString(7);
                a = new Alumno(nc, n, pa, sa, e, s, c);
            }else
                System.out.println("NO se encontró el registro"); //!!!!!

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public ArrayList mostrarAlumnos(String filtro){
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        String sql = "SELECT * FROM Alumnos";
        String sql4 = "SELECT * FROM Alumnos WHERE Semestre='"+filtro+"'";
        ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);
        try {
            rs.next();
            do {
                String nc = rs.getString(1);
                String n = rs.getString("Nombre");
                String pa = rs.getString(3);
                String sa = rs.getString("SegundoAP");
                byte e = rs.getByte(5);
                byte s = rs.getByte(6);
                String c = rs.getString(7);

                Alumno a = new Alumno(nc, n, pa, sa, e, s, c);
                listaAlumnos.add(a);
            }while (rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAlumnos;
    }


}
