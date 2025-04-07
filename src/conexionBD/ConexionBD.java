package conexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class ConexionBD {
    private Connection conexion;
    private Statement stm; //Es mejor ya que evita SQL Injection //la vamos a utiloizar en nuestro proyecto
    private ResultSet rs;

    public ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //el localhost es el 127.0.0.1
            String URL = "jdbc:mysql://localhost:3306/BD_Topicos_2025";

            conexion = DriverManager.getConnection(URL, "root", "1819diana");
            System.out.println("YEIII CASI SOY ING INMORTAL, se conecto el programa a la base de datos");

        } catch (ClassNotFoundException e) {
            System.out.println("ERROR en el conector driver ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR EN LA CONECCION DE BASE DE DATOS");
        }
    }

    // CRUD- Create Read Update Delete
    //Metodo para los procesos de ABC (altas, bajas y cambios)
    //Lenguaje de manipulacion de datos
    public boolean ejecutarInstruccionLMD(String sql) {
        boolean resultado = false;
        try {
            stm = conexion.createStatement();
            if (stm.executeUpdate(sql)>=1)
                resultado =true;

        } catch (SQLException e) {
            System.out.println("Error en la ejecucion de la instruccion SQL");
        }

        return resultado;
    }

    public ResultSet ejecutarInstruccionSQL(String sql) {
        rs = null;
        try {
            stm = conexion.createStatement();
            rs = stm.executeQuery(sql); //ejecuta la consulta
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion de la instruccion SQL");
        }//try-catch
        return rs; //retorna los resultados
    }//ejecutarInstruccionesSQL

    public static void main(String[] args) {
        System.out.println("Magia magia para hacer magia");
        new ConexionBD();
    }

}
