package Controlador;
//importar otros paquetes
import conexionBD.ConexionBD;
import modelo.Alumno;
import vista.VentanaABCC;


//importar librerias
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//CLASE CONTROLADOERA DEL MODELO ALUMNO
//DAO - DATA ACCESSS OBJECT
public class AlumnoDAO {
    ConexionBD conexionBD = new ConexionBD();
    public VentanaABCC abcc_datos_pantalla = new VentanaABCC();
    //MMMMMMMMMMMMMMMMMMMMMMETODOS ABCCccccccccccccccccccccccccccccccccc


    //***************************************ALTAS*******************************


    public void agregarAlumno(Boolean sionoAgregarAlumno) {
        System.out.println(sionoAgregarAlumno);
    }

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
    public  Alumno mostrarAlumno(String filtro){
        return null;//retorna si existe o no
    }
    public ArrayList<Alumno> mostrarAlumnos(String filtro){
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        String sql = "SELECT * FROM Alumnos";
        ResultSet rs= conexionBD.ejecutarInstruccionSQL(sql);

//rs.next() avanza al siguiente registro

        try {
            if (rs!=null&& rs.next()) {
                do {
                    String nc = rs.getString(1);
                    String n = rs.getString("Nombre");
                    String pa = rs.getString(3);
                    String sa = rs.getString("SegundoAP");
                    byte e = rs.getByte(5);
                    byte s = rs.getByte(6);
                    String c = rs.getString(7);
                    Alumno alumno = new Alumno(nc, n, pa, sa, e, s, c);
                    listaAlumnos.add(alumno);

                } while (rs.next());
            }//if
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAlumnos;
    }


}
