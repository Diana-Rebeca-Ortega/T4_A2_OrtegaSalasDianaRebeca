package vista;

import Controlador.AlumnoDAO;
import modelo.Alumno;
import modelo.ResultSetTableModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VentanaBajasAlumnos {

    //********************************************************************************************
//**************************    BAJAS   *********************************************************
    class Bajas_Alumnos extends JFrame implements ActionListener {
        JTable tablaAlumnosBajas;
        JTextField cajaNC;
        JLabel cajaNombre, cajaApPaterno, cajaApMaterno, cajaSemestre, cajaCarrera, cajaEdad;
        JLabel texNumConTROL, txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtSemestre, txtCarrera, txtEdad;
        JPanel panelRojo, panelROSA;
        JButton btnBuscar, btnBorrar, btnEliminar, btnCancelar;
        public Bajas_Alumnos() {
            getContentPane().setLayout(null);
            setTitle("Bajas Alunos");
            setSize(630, 490);
            setLocationRelativeTo(null);//locacion en la ventana
            setVisible(true);

            tablaAlumnosBajas = new JTable();
            tablaAlumnosBajas.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null}
                    },
                    new String[]{
                            "NO. DE CONTROL", "NOMBRE", "AP. PATERNO", "AP. MATERNO", "EDAD", "SEMESTRE", "CARRERA"
                    }) {
                boolean[] canEdit = new boolean[]{
                        false, false, false, false, true, true
                };
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            //PANEL VERDE ROSA
            panelROSA = new JPanel();
            panelROSA.setLayout(null);
            panelROSA.setBackground(new Color(255, 46, 93 ));
            panelROSA.setBounds(10, 280, 600, 170);

// Agregar la tabla a un JScrollPane
            JScrollPane scrollPane = new JScrollPane(tablaAlumnosBajas);
            scrollPane.setBounds(10, 10, 580, 150);
            panelROSA.add(scrollPane);

            add(panelROSA);


//Panel ROJO TITULO
            panelRojo = new JPanel();
            panelRojo.setLayout(null);
            panelRojo.setBackground(new Color(237, 0, 0));
            panelRojo.setBounds(0, 0, 610, 30);
            JLabel texBAJAS = new JLabel("    BAJAS ALUMNOS:");
            texBAJAS.setBounds(10, 00, 300, 20);
            texBAJAS.setForeground(Color.WHITE);
            panelRojo.add(texBAJAS);
            add(panelRojo);

            texNumConTROL = new JLabel("NUMERO DE CONTROL:");
            texNumConTROL.setBounds(40, 40, 230, 20);
            texNumConTROL.setFont(new Font("Arial", Font.BOLD, 13));
            add(texNumConTROL);

            JLabel  linea = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------");
            linea.setBounds(3, 80, 700, 20);
            linea.setBackground(new Color(139, 166, 169 ));
            add(linea);

            cajaNC = new JTextField();
            cajaNC.setBounds(190, 40, 200, 20);
            add(cajaNC);

            btnBuscar = new JButton();
            ImageIcon  buscarRuta=  new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Proyecto_ABCD2025\\src\\vista\\ic_action_search.png");
            btnBuscar.setIcon(buscarRuta  );
            btnBuscar.setHorizontalTextPosition( SwingConstants.CENTER );
            btnBuscar.setVerticalTextPosition( SwingConstants.BOTTOM );
            btnBuscar.setBounds(420, 40, buscarRuta.getIconWidth(), buscarRuta.getIconHeight());
            add(btnBuscar);
            btnBuscar.addActionListener(this);

            btnBorrar = new JButton("BORRAR");
            btnEliminar = new JButton("ELIMINAR");
            btnCancelar = new JButton("CANCELAR");

            btnBorrar.addActionListener(this);
            btnEliminar.addActionListener(this);
            btnCancelar.addActionListener(this);

            btnBorrar.setBounds(490, 40, 100, 20);
            add(btnBorrar);
            btnEliminar.setBounds(460, 130, 100, 20);
            add(btnEliminar);
            btnCancelar.setBounds(460, 190, 100, 20);
            add(btnCancelar);

            txtNombre = new JLabel("NOMBRE:");
            txtApellidoPaterno= new JLabel("APELLIDO PATERNO:");
            txtApellidoMaterno = new JLabel("APELLIDO MATERNO:");
            txtEdad = new JLabel("EDAD:");
            txtSemestre = new JLabel("SEMESTRE:");
            txtCarrera = new JLabel("CARRERA:");

            txtNombre.setBounds( 40, 100, 300, 20);
            txtApellidoPaterno.setBounds( 40, 130, 300, 20);
            txtApellidoMaterno.setBounds( 40, 160, 300, 20);
            txtEdad.setBounds(40, 190, 300, 20);
            txtSemestre.setBounds( 40, 220, 300, 20);
            txtCarrera.setBounds( 40, 250, 300, 20);


            add(txtNombre);
            add(txtApellidoPaterno);
            add(txtApellidoMaterno);
            add(txtEdad);
            add(txtSemestre);
            add(txtCarrera);

            Border borde = BorderFactory.createLineBorder(   Color.BLACK);

            cajaNombre = new JLabel();

            cajaNombre.setBorder(borde);
            cajaNombre.setBackground(new Color(218, 230, 231 ));
            cajaNombre.setOpaque(true);
            cajaNombre.setBounds(110, 100, 270, 18);
            add(cajaNombre);

            cajaApPaterno = new JLabel();
            cajaApPaterno.setBorder(borde);
            cajaApPaterno.setBackground(new Color(218, 230, 231 ));
            cajaApPaterno.setOpaque(true);
            cajaApPaterno.setBounds(170, 130, 270, 18);
            add(cajaApPaterno);

            cajaApMaterno = new JLabel();
            cajaApMaterno.setBorder(borde);
            cajaApMaterno.setBackground(new Color(218, 230, 231 ));
            cajaApMaterno.setOpaque(true);
            cajaApMaterno.setBounds(185, 160, 270, 18);
            add(cajaApMaterno);

            cajaEdad= new JLabel();
            cajaEdad.setBorder(borde);
            cajaEdad.setBackground(new Color(218, 230, 231 ));
            cajaEdad.setOpaque(true);
            cajaEdad.setBounds(130, 190, 270, 18);
            add(cajaEdad);

            cajaSemestre= new JLabel();
            cajaSemestre.setBorder(borde);
            cajaSemestre.setBackground(new Color(218, 230, 231 ));
            cajaSemestre.setOpaque(true);
            cajaSemestre.setBounds(120, 220, 270, 18);
            add(cajaSemestre);

            cajaCarrera = new JLabel();
            cajaCarrera.setBorder(borde);
            cajaCarrera.setBackground(new Color(218, 230, 231 ));
            cajaCarrera.setOpaque(true);
            cajaCarrera.setBounds(120, 250, 270, 18);
            add(cajaCarrera);
            actualizarTabla(tablaAlumnosBajas);
        }//constructor
        public void actualizarTabla(JTable tabla) {
            final String Driver_Controlador = "com.mysql.cj.jdbc.Driver";
            final String URL = "jdbc:mysql://localhost:3306/BD_Topicos_2025";
            final String CONSULTA = " select * from alumnos;";
            //el final se refiere a que son constantes
            try {
                ResultSetTableModel modelo = new ResultSetTableModel(Driver_Controlador, URL, CONSULTA);
                tabla.setModel(modelo);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }//actualizarTabla

        @Override
        public void actionPerformed(ActionEvent e) {
        if( e.getSource().equals(btnBuscar)){//**************************************************************************
    System.out.println("buscar datos");
    System.out.println(cajaNC.getText());
        int registro= 1;
        for(int i =0; i < tablaAlumnosBajas.getRowCount(); i++){// muestra cuantas filas hay
            if (tablaAlumnosBajas.getValueAt(i,0).equals(cajaNC.getText())){///tablaAlumnosBajas.getValueAt(fila,columna)
                cajaNombre.setText(tablaAlumnosBajas.getValueAt(i,1)+"");
                cajaApPaterno.setText(tablaAlumnosBajas.getValueAt(i,2)+"");
                cajaApMaterno.setText(tablaAlumnosBajas.getValueAt(i,3)+"");
                cajaEdad.setText(  tablaAlumnosBajas.getValueAt(i,4)+"");
                cajaSemestre.setText(  tablaAlumnosBajas.getValueAt(i,5)+"");
                cajaCarrera.setText(tablaAlumnosBajas.getValueAt(i,6)+"");
                registro=registro*0;

            }
         }
            if (registro==1){
                JOptionPane.showMessageDialog(null,  "No se encontro registro");
            }
  //  AlumnoDAO alumnoDAO = new AlumnoDAO();

}
if (e.getSource().equals(btnBorrar)){//***************************************************************
    cajaNC.setText("");
    cajaApPaterno.setText("");
    cajaApMaterno.setText("");
    cajaNombre.setText("");
    cajaSemestre.setText("");
    cajaCarrera.setText("");
    cajaEdad.setText("");
}//*******************************************************************************************************
            if( e.getSource().equals(btnEliminar)){
                AlumnoDAO alumnoDAO = new AlumnoDAO();
                if (alumnoDAO.eliminarAlumnos(cajaNC.getText())) {
                    actualizarTabla(tablaAlumnosBajas);
                    System.out.println("FELICIDADES: se ha ELIMINADO correctamente desde la Ven_Inicio");
                }else
                    System.out.println("ERROR:  la ELIMINACION del registro lindo desde la Ven_Inicio no se consiguio");
            }//************************************************************************************
            if( e.getSource().equals(btnCancelar)){
                setVisible(false);
                //aqui podriamos poner un historial q regrese los valores
            }

        }//escuchador bajas

    }////class bajas_Alumnos
}//Ventana Bajas Alumnos