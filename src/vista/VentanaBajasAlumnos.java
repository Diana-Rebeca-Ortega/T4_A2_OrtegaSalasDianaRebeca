package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBajasAlumnos {

    //********************************************************************************************
//**************************    BAJAS   *********************************************************
    class Bajas_Alumnos extends JFrame implements ActionListener {
        JTable tablaAlumnosAltas;
        JTextField  cajaNC, cajaNombre, cajaApPaterno, cajaApMaterno, cajaSemestre, cajaCarrera;
        JLabel texNumConTROL, txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtSemestre, txtCarrera;
        JPanel panelRojo, panelROSA;
        JButton btnBuscar, btnBorrar, btnEliminar, btnCancelar;
        public Bajas_Alumnos() {
            getContentPane().setLayout(null);
            setTitle("Bajas Alunos");
            setSize(630, 480);
            setLocationRelativeTo(null);//locacion en la ventana
            setVisible(true);

            tablaAlumnosAltas = new JTable();
            tablaAlumnosAltas.setModel(new javax.swing.table.DefaultTableModel(
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
            panelROSA.setBounds(10, 240, 600, 200);

// Agregar la tabla a un JScrollPane
            JScrollPane scrollPane = new JScrollPane(tablaAlumnosAltas);
            scrollPane.setBounds(10, 10, 580, 180);
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

            btnBorrar = new JButton("BORRAR");
            btnEliminar = new JButton("ELIMINAR");
            btnCancelar = new JButton("CANCELAR");

            btnBorrar.setBounds(490, 40, 100, 20);
            add(btnBorrar);
            btnEliminar.setBounds(460, 130, 100, 20);
            add(btnEliminar);
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

            cajaSemestre= new JTextField("E");
            cajaSemestre.setBounds(130, 190, 200, 18);
            add(cajaSemestre);

            cajaCarrera = new JTextField("E");
            cajaCarrera.setBounds(120, 220, 200, 18);
            add(cajaCarrera);

        }//constructor

        @Override
        public void actionPerformed(ActionEvent e) {

        }//escuchador bajas

    }////class bajas_Alumnos
}//Ventana Bajas Alumnos