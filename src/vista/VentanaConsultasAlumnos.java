package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConsultasAlumnos {
    //********************************************************************************************
    //**************************    CONSULTAS   *********************************************************
    class Consultas_Alumnos extends JFrame {
        JPanel panelAzul, panelCian;
        JTable tablaAlumnosModificaiones;
       JLabel texCriterioBusqueda;
        JButton btnBuscar, btnBorrar,btnCancelar;
        public Consultas_Alumnos() {
            getContentPane().setLayout(null);
            setTitle("Buscar Alunos");
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
            //PANEL VERDE MENTA
            panelCian = new JPanel();
            panelCian.setLayout(null);
            panelCian.setBackground(new Color(26, 221, 234  ));
            panelCian.setBounds(10, 240, 600, 200);

// Agregar la tabla a un JScrollPane
            JScrollPane scrollPane = new JScrollPane(tablaAlumnosModificaiones);
            scrollPane.setBounds(10, 10, 580, 180);
            panelCian.add(scrollPane);
            add(panelCian);



//Panel AZUL TITULO
            panelAzul = new JPanel();
            panelAzul.setLayout(null);
            panelAzul.setBackground(new Color(26, 32, 234  ));
            panelAzul.setBounds(0, 0, 610, 30);
            JLabel texBAJAS = new JLabel("    CONSULTAS ALUMNOS:");
            texBAJAS.setBounds(10, 00, 300, 20);
            texBAJAS.setForeground(Color.WHITE);
            panelAzul.add(texBAJAS);
            add(panelAzul);

            texCriterioBusqueda = new JLabel("Selecciona criterio de busqueda:");
            texCriterioBusqueda.setBounds(40, 40, 230, 20);
            texCriterioBusqueda.setFont(new Font("Arial", Font.BOLD, 13));
            add(texCriterioBusqueda);

            //Botones
            btnBuscar = new JButton();
            btnBorrar = new JButton("BORRAR");
            btnCancelar = new JButton("CANCELAR");
            ImageIcon  buscarRuta=  new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Proyecto_ABCD2025\\src\\vista\\ic_action_search.png");
            btnBuscar.setIcon(buscarRuta  );
            btnBuscar.setHorizontalTextPosition( SwingConstants.CENTER );
            btnBuscar.setVerticalTextPosition( SwingConstants.BOTTOM );
            btnBuscar.setBounds(490, 40, buscarRuta.getIconWidth(), buscarRuta.getIconHeight());
            btnBorrar.setBounds(460, 130, 100, 20);
            btnCancelar.setBounds(460, 190, 100, 20);
            add(btnBuscar);
            add(btnBorrar);
            add(btnCancelar);

            JRadioButton radioTodos, radioNombre, radioAPpaterno, radioAPMaterno, radioSemestre, radioCarrera;
            ButtonGroup bg = new ButtonGroup();
            //radioTodos.setSelected(true);//preseleccionado
            radioNombre= new JRadioButton("Nombre:");
            radioAPpaterno= new JRadioButton("Apellido Paterno:");
            radioAPMaterno= new JRadioButton("Apellido Materno:");
            radioSemestre= new JRadioButton("Semestre:");
            radioCarrera= new JRadioButton("Carrera:");


            radioTodos = new JRadioButton("TODOS");
            radioTodos.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (radioTodos.isSelected()){
                        radioNombre.setSelected(true);
                        radioAPpaterno.setSelected(true);
                        radioAPMaterno.setSelected(true);
                        radioSemestre.setSelected(true);
                        radioCarrera.setSelected(true);
                    }else{
                        radioNombre.setSelected(false);
                        radioAPpaterno.setSelected(false);
                        radioAPMaterno.setSelected(false);
                        radioSemestre.setSelected(false);
                        radioCarrera.setSelected(false);
                    }
                }
            });



            radioTodos.setBounds(20, 60, 70,20);
            radioNombre.setBounds(100, 60, 100,20);
            radioAPpaterno.setBounds(100, 90, 140,20);
            radioAPMaterno.setBounds(100, 120, 140,20);
            radioSemestre.setBounds(100, 150, 100,20);
            radioCarrera.setBounds(100, 180, 100,20);

            add(radioTodos);
            add(radioNombre);
            add(radioAPpaterno);
            add(radioAPMaterno);
            add(radioSemestre);
            add(radioCarrera);



            JRadioButton radioIM = new JRadioButton("IM");
            bg.add(radioIM);
            add(radioIM);
            JRadioButton radioIAA = new JRadioButton("IAA");
            bg.add(radioIAA);
            add(radioIAA);




        }//constructor
    }//public class CAMBIOSalumnos

}//class Ventana
