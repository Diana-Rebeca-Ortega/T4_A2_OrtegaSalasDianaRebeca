package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaModificacionesAlumnos {

 //********************************************************************************************
 //**************************    MODIFICACIONES   *********************************************************
 class Cambios_Alumnos extends JFrame {
     JPanel panelNaranja, panelAmarillo;
     JTable tablaAlumnosModificaiones;
     JTextField  cajaNC, cajaNombre, cajaApPaterno, cajaApMaterno, cajaSemestre, cajaCarrera;
     JLabel texNumConTROL, txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtSemestre, txtCarrera;
     JButton btnBuscar, btnBorrar, btnGuardarCambios, btnCancelar;
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
         panelAmarillo.setBounds(10, 240, 600, 200);

// Agregar la tabla a un JScrollPane
         JScrollPane scrollPane = new JScrollPane(tablaAlumnosModificaiones);
         scrollPane.setBounds(10, 10, 580, 180);
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
         ImageIcon  buscarRuta=  new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Proyecto_ABCD2025\\src\\vista\\ic_action_search.png");
         btnBuscar.setIcon(buscarRuta  );
         btnBuscar.setHorizontalTextPosition( SwingConstants.CENTER );
         btnBuscar.setVerticalTextPosition( SwingConstants.BOTTOM );
         btnBuscar.setBounds(420, 40, buscarRuta.getIconWidth(), buscarRuta.getIconHeight());
         add(btnBuscar);

         btnBorrar = new JButton("BORRAR");
         btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
         btnCancelar = new JButton("CANCELAR");

         btnBorrar.setBounds(490, 40, 100, 20);
         add(btnBorrar);
         btnGuardarCambios.setBounds(410, 130, 200, 20);
         add(btnGuardarCambios);
         btnCancelar.setBounds(460, 190, 100, 20);
         add(btnCancelar);

         txtNombre = new JLabel("NOMBRE:");
         txtApellidoPaterno= new JLabel("APELLIDO PATERNO:");
         txtApellidoMaterno = new JLabel("APELLIDO MATERNO:");
         txtSemestre = new JLabel("SEMESTRE:");
         txtCarrera = new JLabel("CARRERA:");

         txtNombre.setBounds( 40, 100, 300, 20);
         txtApellidoPaterno.setBounds( 40, 130, 300, 20);
         txtApellidoMaterno.setBounds( 40, 160, 300, 20);
         txtSemestre.setBounds( 40, 190, 300, 20);
         txtCarrera.setBounds( 40, 220, 300, 20);

         add(txtNombre);
         add(txtApellidoPaterno);
         add(txtApellidoMaterno);
         add(txtSemestre);
         add(txtCarrera);

         cajaNombre = new JTextField("-******-");
         cajaNombre.setBounds(110, 100, 200, 18);
         add(cajaNombre);

         cajaApPaterno = new JTextField("w");
         cajaApPaterno.setBounds(170, 130, 200, 18);
         add(cajaApPaterno);

         cajaApMaterno = new JTextField("E");
         cajaApMaterno.setBounds(185, 160, 200, 18);
         add(cajaApMaterno);

         String numeros[] = {		"1","2","3", "4","5","6","7","8","9"	};
         SpinnerListModel modeloDatos = new SpinnerListModel(numeros);
         JSpinner spinerSemestre = new JSpinner(modeloDatos);
         //spinnerSemestre.setEnable(false);
         spinerSemestre.setBounds(130, 190, 200, 18);
         add(spinerSemestre);

         JComboBox<String> comboCarrera = new JComboBox<String>();
         comboCarrera.addItem("Elige Carrera...");
         comboCarrera.setBounds(120, 220, 200, 18);
         comboCarrera.addItem("Ingenieria en Sistemas Computaconalesº");
         comboCarrera.addItem("Ingenieria Mecatronicaº");
         comboCarrera.addItem("Ingenieria en Industrias Alimentariasº");
         add(comboCarrera);




     }//constructor
 }//public class CAMBIOSalumnos

 }//class Ventana
