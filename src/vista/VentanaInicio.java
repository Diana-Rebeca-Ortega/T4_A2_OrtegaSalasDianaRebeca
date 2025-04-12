package vista;
import Controlador.AlumnoDAO;
import modelo.Alumno;
import modelo.ResultSetTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;


class VentanaPantallaCompleta extends JFrame implements  ActionListener{
    JMenuBar menuBar;
    JMenu menuAlumnos, menuDocentes, menuMaterias;
    JMenuItem itemAltas, itemEliminar, itemModificaciones, itemConsultas;

    public VentanaPantallaCompleta() {
        ImageIcon imagenFondo = new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Proyecto_ABCD2025\\src\\vista\\BosqueOscuro.png");
        JLabel fondo = new JLabel(imagenFondo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//para que no queden registros en la ram
        setTitle("Proyecto ABCC");
        setSize(imagenFondo.getIconWidth(), imagenFondo.getIconHeight());
        setLocationRelativeTo(null);//locacion en la ventana
        setVisible(true);
        add(fondo);
        fondo.setLayout(null);


        menuBar = new JMenuBar();

        menuAlumnos = new JMenu ("Alumnos");
        menuDocentes = new JMenu ("Docentes");
        menuMaterias = new JMenu ("Materias");
        menuBar.add(menuAlumnos);
        menuBar.add(menuDocentes);
        menuBar.add(menuMaterias);

        itemAltas = new JMenuItem ("Agregar");
        itemEliminar = new JMenuItem ("Eliminar");
        itemModificaciones = new JMenuItem ("Modificaciones");
        itemConsultas = new JMenuItem ("Consultas");

        itemAltas.addActionListener(this);
        itemEliminar.addActionListener(this);
        itemModificaciones.addActionListener(this);
        itemConsultas.addActionListener(this);

        itemAltas.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK)//poner el ctrl a
        );
        itemEliminar.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK)//poner el ctrl e
        );
        itemModificaciones.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK)//poner el ctrl m
        );
        itemConsultas.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK)//poner el ctrl m
        );
        menuAlumnos.add(itemAltas);
        menuAlumnos.add(itemEliminar);
        menuAlumnos.add(itemModificaciones);
        menuAlumnos.add(itemConsultas);
        menuBar.setBackground(new Color(194, 210, 211));
        setJMenuBar(menuBar);//Añadir el menu a la pantalla, sin este paso no se ve nada
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==itemAltas){//IF ITEM ALTAS
            System.out.println("es para agregar ");
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run(){
                    new VentanaAltasAlumnos().new Altas_Alumnos();

                }
            });
        }//IF ITEM ALTAS
        if (e.getSource()==itemEliminar){//IF ITEM BAJAS
            System.out.println("es para eliminar");
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run(){
                    new VentanaBajasAlumnos().new Bajas_Alumnos();

                }
            });
        }//IF ITEM BAJAS
        if (e.getSource()==itemModificaciones){//IF ITEM MODIFICACIONES
            System.out.println("es para cambiar/ modificar");
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run(){
                    new VentanaModificacionesAlumnos().new Cambios_Alumnos();

                }
            });
        }//IF ITEM MODIFICACIONES
        if (e.getSource()==itemConsultas){//IF ITEM itemConsultas
            System.out.println("es para consultar/buscar");
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run(){
                    new VentanaConsultasAlumnos().new Consultas_Alumnos();
                }
            });
        }//IF ITEM itemConsultas

    }
}



public class VentanaInicio {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
               // new Altas_Alumnos();
                new VentanaPantallaCompleta();
            }
        });



/*





        //----------------PRUEBA PROCESO CONSULTAS*----------------------------

        ArrayList<Alumno> lista = alumnoDAO.mostrarAlumnos("");
        //for ich,,, each
        for (Alumno alumno: lista)
            System.out.println(alumno.getNumControl());
*/
    }

}
