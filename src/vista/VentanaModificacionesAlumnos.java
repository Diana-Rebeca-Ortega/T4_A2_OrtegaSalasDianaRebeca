package vista;

import Controlador.AlumnoDAO;
import modelo.Alumno;
import modelo.ResultSetTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VentanaModificacionesAlumnos {

 //********************************************************************************************
 //**************************    MODIFICACIONES   *********************************************************
 class Cambios_Alumnos extends JFrame  implements ActionListener {
     JPanel panelNaranja, panelAmarillo;
     JTable tablaAlumnosModificaiones;
     JTextField  cajaNC, cajaNombre, cajaApPaterno, cajaApMaterno;
     JLabel texNumConTROL, txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtSemestre, txtCarrera, txtEdad;
     JButton btnBuscar, btnBorrar, btnGuardarCambios, btnCancelar;
     JComboBox comboEDAD;
     JSpinner spinerSemestre;
     JComboBox<String> comboCarrera;
     public Cambios_Alumnos() {
         getContentPane().setLayout(null);
         setTitle("Modificar Alunos");
         setSize(630, 480);
         setLocationRelativeTo(null);//locacion en la ventana
         setVisible(true);

         tablaAlumnosModificaiones = new JTable();
         tablaAlumnosModificaiones.setModel(new javax.swing.table.DefaultTableModel(
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
         //PANEL  Amarillo
         panelAmarillo = new JPanel();
         panelAmarillo.setLayout(null);
         panelAmarillo.setBackground(new Color(234, 146, 26 ));
         panelAmarillo.setBounds(10, 280, 600, 170);

// Agregar la tabla a un JScrollPane
         JScrollPane scrollPane = new JScrollPane(tablaAlumnosModificaiones);
         scrollPane.setBounds(10, 10, 580, 150);
         panelAmarillo.add(scrollPane);

         add(panelAmarillo);



//Panel NARANJA TITULO
         panelNaranja = new JPanel();
         panelNaranja.setLayout(null);
         panelNaranja.setBackground(new Color(255, 97, 0 ));
         panelNaranja.setBounds(0, 0, 610, 30);
         JLabel texBAJAS = new JLabel("    MODIFICACIONES ALUMNOS:");
         texBAJAS.setBounds(10, 00, 300, 20);
         texBAJAS.setForeground(Color.WHITE);
         panelNaranja.add(texBAJAS);
         add(panelNaranja);

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
         btnBuscar.addActionListener(this);
         ImageIcon  buscarRuta=  new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Proyecto_ABCD2025\\src\\vista\\ic_action_search.png");
         btnBuscar.setIcon(buscarRuta  );
         btnBuscar.setHorizontalTextPosition( SwingConstants.CENTER );
         btnBuscar.setVerticalTextPosition( SwingConstants.BOTTOM );
         btnBuscar.setBounds(420, 40, buscarRuta.getIconWidth(), buscarRuta.getIconHeight());
         add(btnBuscar);

         btnBorrar = new JButton("BORRAR");
         btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
         btnCancelar = new JButton("CANCELAR");

         btnBorrar .addActionListener(this);
         btnGuardarCambios.addActionListener(this);
         btnCancelar.addActionListener(this);



         btnBorrar.setBounds(490, 40, 100, 20);
         add(btnBorrar);
         btnGuardarCambios.setBounds(410, 130, 200, 20);
         add(btnGuardarCambios);
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

         cajaNombre = new JTextField();
         cajaNombre.setBounds(110, 100, 200, 18);
         add(cajaNombre);

         cajaApPaterno = new JTextField();
         cajaApPaterno.setBounds(170, 130, 200, 18);
         add(cajaApPaterno);

         cajaApMaterno = new JTextField();
         cajaApMaterno.setBounds(185, 160, 200, 18);
         add(cajaApMaterno);

         comboEDAD = new JComboBox<String>();
         comboEDAD.addItem("0");
         for(int i =1; i <99;i++){
             comboEDAD.addItem(i);
         }
         comboEDAD.setBounds(130, 190, 270, 18);
         add(comboEDAD);

         String numeros[] = {		"1","2","3", "4","5","6","7","8","9"	};
         SpinnerListModel modeloDatos = new SpinnerListModel(numeros);
          spinerSemestre = new JSpinner(modeloDatos);
         //spinnerSemestre.setEnable(false);
         spinerSemestre.setBounds(130, 220, 200, 18);
         add(spinerSemestre);

          comboCarrera = new JComboBox<String>();
         comboCarrera.addItem("Elige Carrera...");
         comboCarrera.setBounds(120, 250, 200, 18);
         comboCarrera.addItem("Ingenieria en Sistemas Computaconalesº");
         comboCarrera.addItem("Ingenieria Mecatronicaº");
         comboCarrera.addItem("Ingenieria en Industrias Alimentariasº");
         add(comboCarrera);

         actualizarTabla(tablaAlumnosModificaiones);
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
         if (e.getSource().equals(btnBorrar)) {//***************************************************************
             cajaNC.setText("");
             cajaApPaterno.setText("");
             cajaApMaterno.setText("");
             cajaNombre.setText("");
             comboEDAD.setSelectedIndex(0);
             spinerSemestre.setValue("1");
             comboCarrera.setSelectedIndex(0);
         }
         AlumnoDAO alumnoDAO = new AlumnoDAO();
         if (e.getSource().equals(btnGuardarCambios)) {
             Alumno a1 = new Alumno(cajaNC.getText(), cajaNombre.getText(),cajaApPaterno.getText(),
                     cajaApMaterno.getText(), Byte.parseByte(String.valueOf(comboEDAD.getSelectedItem()))  ,
                     Byte.parseByte(String.valueOf(spinerSemestre.getValue())), String.valueOf(comboCarrera.getSelectedItem()));
             if (alumnoDAO.cambiarAlumno(a1)) {
                 actualizarTabla(tablaAlumnosModificaiones);
                 System.out.println("Registro modificado CORRECTAMENTE desde la Ven_Inicio");
             }else
                 System.out.println("ERROR en la modificacion del registro lindo desde la Ven_Inicio");
         }

         if (e.getSource().equals(btnBuscar)) {//**************************************************************************
             System.out.println("buscar datos");
             System.out.println(cajaNC.getText());
             int registro = 1;
             for (int i = 0; i < tablaAlumnosModificaiones.getRowCount(); i++) {// muestra cuantas filas hay
                 if (tablaAlumnosModificaiones.getValueAt(i, 0).equals(cajaNC.getText())) {///tablaAlumnosBajas.getValueAt(fila,columna)
                     cajaNombre.setText(tablaAlumnosModificaiones.getValueAt(i, 1) + "");
                     cajaApPaterno.setText(tablaAlumnosModificaiones.getValueAt(i, 2) + "");
                     cajaApMaterno.setText(tablaAlumnosModificaiones.getValueAt(i, 3) + "");
                     comboEDAD.setSelectedItem(tablaAlumnosModificaiones.getValueAt(i, 4) + "");
                     spinerSemestre.setValue(tablaAlumnosModificaiones.getValueAt(i, 5) + "");
                     comboCarrera.setSelectedItem(tablaAlumnosModificaiones.getValueAt(i, 6) + "");
                     registro = registro * 0;

                 }
             }
             if (registro == 1) {
                 JOptionPane.showMessageDialog(null, "No se encontro registro");
             }
         }
         if( e.getSource().equals(btnCancelar)){//******************************************************************
             setVisible(false);
             //aqui podriamos poner un historial q regrese los valores
         }
     }
 }//public class CAMBIOSalumnos

 }//class Ventana
