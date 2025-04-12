package vista;

import Controlador.AlumnoDAO;
import modelo.Alumno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaConsultasAlumnos {
    //********************************************************************************************
    //**************************    CONSULTAS   *********************************************************
    class Consultas_Alumnos extends JFrame  implements  ActionListener{
        JPanel panelAzul, panelCian;
        JTable tablaAlumnosModificaiones;
       JLabel texCriterioBusqueda;
        JButton btnBuscar, btnBorrar,btnCancelar;
        JRadioButton radioTodos, radioNombre, radioAPpaterno, radioAPMaterno,radioEdad, radioSemestre, radioCarrera;
        JTextField cajaNombres, cajaApPaterno,  cajaApMaterno, cajaEdad, cajaSemestre, cajaCarrera  ;
        ButtonGroup grupo = new ButtonGroup();
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

            btnBuscar.addActionListener(this);
            btnBorrar.addActionListener(this);
            btnCancelar.addActionListener(this);


           ButtonGroup bg = new ButtonGroup();
            //radioTodos.setSelected(true);//preseleccionado
            radioNombre= new JRadioButton("Nombre:");
            radioAPpaterno= new JRadioButton("Apellido Paterno:");
            radioAPMaterno= new JRadioButton("Apellido Materno:");
            radioEdad = new JRadioButton("Edad:");
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
                        radioEdad.setSelected(true);
                        radioSemestre.setSelected(true);
                        radioCarrera.setSelected(true);

                        cajaNombres.setEditable(true);
                        cajaApPaterno.setEditable(true);
                        cajaApMaterno.setEditable(true);
                        cajaEdad.setEditable(true);
                        cajaSemestre.setEditable(true);
                        cajaCarrera.setEditable(true);
                    }else{
                        radioNombre.setSelected(false);
                        radioAPpaterno.setSelected(false);
                        radioAPMaterno.setSelected(false);
                        radioEdad.setSelected(false);
                        radioSemestre.setSelected(false);
                        radioCarrera.setSelected(false);

                        cajaNombres.setEditable(false);
                        cajaApPaterno.setEditable(false);
                        cajaApMaterno.setEditable(false);
                        cajaEdad.setEditable(false);
                        cajaSemestre.setEditable(false);
                        cajaCarrera.setEditable(false);
                    }
                }
            });

            radioTodos.setBounds(20, 60, 80,20);
            radioNombre.setBounds(100, 60, 80,20);
            radioAPpaterno.setBounds(100, 90, 130,20);
            radioAPMaterno.setBounds(100, 120, 130,20);
            radioEdad.setBounds(100, 150, 70,20);
            radioSemestre.setBounds(100, 180, 90,20);
            radioCarrera.setBounds(100, 210, 90,20);

            radioNombre.addActionListener(this);
            radioAPpaterno.addActionListener(this);
            radioAPMaterno.addActionListener(this);
            radioEdad.addActionListener(this);
            radioSemestre.addActionListener(this);
            radioCarrera.addActionListener(this);

            add(radioTodos);
            add(radioNombre);
            add(radioAPpaterno);
            add(radioAPMaterno);
            add(radioEdad);
            add(radioSemestre);
            add(radioCarrera);

        cajaNombres = new JTextField();
        cajaApPaterno = new JTextField();
        cajaApMaterno = new JTextField();
        cajaEdad = new JTextField();
        cajaSemestre = new JTextField();
        cajaCarrera = new JTextField();

            cajaNombres.setEditable(false);
            cajaApPaterno.setEditable(false);
            cajaApMaterno.setEditable(false);
            cajaEdad.setEditable(false);
            cajaSemestre.setEditable(false);
            cajaCarrera.setEditable(false);

        cajaNombres.setBounds(180, 60, 250, 20);
        cajaApPaterno.setBounds(230, 90, 220, 20);
        cajaApMaterno.setBounds(230, 120, 220, 20);
        cajaEdad.setBounds(170, 150, 260, 20);
        cajaSemestre.setBounds(210, 180, 240, 20);
        cajaCarrera.setBounds(200, 210, 250, 20);


        add(cajaNombres);
        add(cajaApPaterno);
        add(cajaApMaterno);
        add(cajaEdad);
        add(cajaSemestre);
        add(cajaCarrera);

        }//constructor
        public void SeleccionBotones (JRadioButton botonSeleccionado, JTextField a,  ActionEvent E,
                                      JTextField b, JTextField c, JTextField d, JTextField e, JTextField f,
                                      JRadioButton A,  JRadioButton B,  JRadioButton C, JRadioButton D,  JRadioButton F

        ){
            if(E.getSource()==botonSeleccionado){
                if (botonSeleccionado.isSelected()){
                    a.setEditable(true);
                    b.setEditable(false);
                    c.setEditable(false);
                    d.setEditable(false);
                    e.setEditable(false);
                    f.setEditable(false);

                    A.setSelected(false);
                    B.setSelected(false);
                    C.setSelected(false);
                    D.setSelected(false);
                    F.setSelected(false);



                }else{
                    a.setEditable(false);
                    b.setEditable(false);
                    c.setEditable(false);
                    d.setEditable(false);
                    e.setEditable(false);
                    f.setEditable(false);
                }
            }
        }

        public void actualizarTablaConsultas (JTable t, Alumno ob1){
            t.setValueAt(ob1.getNumControl(), 0,0);
            t.setValueAt(ob1.getNombre(), 0,1);
            t.setValueAt(ob1.getSegundoApellido(), 0,2);
            t.setValueAt(ob1.getPrimerApellido(), 0,3);
            t.setValueAt(ob1.getEdad(), 0,4);
            t.setValueAt(ob1.getSemestre(), 0,5);
            t.setValueAt(ob1.getCarrera(), 0,6);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==radioNombre){
                SeleccionBotones(radioNombre,cajaNombres,e, cajaApPaterno, cajaApMaterno,
                        cajaEdad, cajaSemestre, cajaCarrera,
                        radioAPpaterno, radioAPMaterno, radioEdad,radioSemestre,radioCarrera
                );
            }
            if(e.getSource()==radioAPpaterno){
                SeleccionBotones(radioAPpaterno,cajaApPaterno,e,cajaNombres , cajaApMaterno,
                        cajaEdad, cajaSemestre, cajaCarrera,
                        radioNombre, radioAPMaterno, radioEdad,radioSemestre,radioCarrera
                );
            }

            if(e.getSource()==radioAPMaterno){
                SeleccionBotones(radioAPMaterno,cajaApMaterno,e,cajaNombres , cajaApPaterno,
                        cajaEdad, cajaSemestre, cajaCarrera,
                        radioNombre, radioAPpaterno, radioEdad,radioSemestre,radioCarrera
                );
            }
            if(e.getSource()==radioEdad){
                SeleccionBotones(radioEdad,cajaEdad,e,cajaNombres , cajaApPaterno, cajaApMaterno,
                        cajaSemestre, cajaCarrera,
                        radioNombre, radioAPpaterno, radioAPMaterno,radioSemestre,radioCarrera
                        );
            }
            if(e.getSource()==radioSemestre){
                SeleccionBotones(radioSemestre,cajaSemestre,e,cajaNombres , cajaApMaterno,
                        cajaEdad, cajaEdad, cajaCarrera,
                        radioNombre, radioAPpaterno, radioAPMaterno,radioEdad,radioCarrera
                        );
            }
            if(e.getSource()==radioCarrera){
                SeleccionBotones(radioCarrera,cajaCarrera,e,cajaNombres , cajaApMaterno,
                        cajaEdad, cajaEdad, cajaSemestre,
                        radioNombre, radioAPpaterno, radioAPMaterno,radioEdad,radioSemestre
                        );
            }
            AlumnoDAO alumnoDAO = new AlumnoDAO();


            if(e.getSource()==btnBuscar){//*********************************************

                if(radioNombre.isSelected()){
                    if(alumnoDAO.mostrarAlumno(cajaNombres.getText(), "Nombre")==null){
                        JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                    }else{
                    Alumno ob1 = alumnoDAO.mostrarAlumno(cajaNombres.getText(), "Nombre");
                        actualizarTablaConsultas(tablaAlumnosModificaiones, ob1);
                    }//else
                }//********************************************************Nombre
                if(radioAPpaterno.isSelected()){
                    if(alumnoDAO.mostrarAlumno(cajaApPaterno.getText(), "PrimerAP")==null){
                        JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                    }else {
                        Alumno ob1 = alumnoDAO.mostrarAlumno(cajaNombres.getText(), "PrimerAP");
                        actualizarTablaConsultas(tablaAlumnosModificaiones, ob1);
                    }
                }//********************************************************APpATERNO
                if(radioAPMaterno.isSelected()){
                    if(alumnoDAO.mostrarAlumno(cajaApMaterno.getText(), "SegundoAP")==null){
                        JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                    }else {
                        Alumno ob1 = alumnoDAO.mostrarAlumno(cajaApMaterno.getText(), "SegundoAP");
                        actualizarTablaConsultas(tablaAlumnosModificaiones, ob1);
                    }
                }//********************************************************APMaterno
                if(radioEdad.isSelected()){
                    if(alumnoDAO.mostrarAlumno(cajaEdad.getText(), "Edad")==null){
                        JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                    }else {
                        Alumno ob1 = alumnoDAO.mostrarAlumno(cajaEdad.getText(), "Edad");
                        actualizarTablaConsultas(tablaAlumnosModificaiones, ob1);
                    }
                }//********************************************************EDAD
                if(radioSemestre.isSelected()){
                    if(alumnoDAO.mostrarAlumno(cajaSemestre.getText(), "Semestre")==null){
                        JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                    }else {
                        Alumno ob1 = alumnoDAO.mostrarAlumno(cajaSemestre.getText(), "Semestre");
                        actualizarTablaConsultas(tablaAlumnosModificaiones, ob1);
                    }
                }//********************************************************Semestre
                if(radioCarrera.isSelected()){
                    if(alumnoDAO.mostrarAlumno(cajaCarrera.getText(), "Carrera")==null){
                        JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                    }else {
                        Alumno ob1 = alumnoDAO.mostrarAlumno(cajaCarrera.getText(), "Carrera");
                        actualizarTablaConsultas(tablaAlumnosModificaiones, ob1);
                    }
                }//********************************************************Carrera
                if(radioTodos.isSelected()){
                    if(alumnoDAO.mostrarAlumno(cajaCarrera.getText(), "TODOS")==null
                            && alumnoDAO.mostrarAlumno(cajaSemestre.getText(), "Semestre")==null
                            && alumnoDAO.mostrarAlumno(cajaEdad.getText(), "Edad")==null
                            && alumnoDAO.mostrarAlumno(cajaApMaterno.getText(), "SegundoAP")==null
                            && alumnoDAO.mostrarAlumno(cajaApPaterno.getText(), "PrimerAP")==null
                            &&alumnoDAO.mostrarAlumno(cajaNombres.getText(), "Nombre")==null
                    ){
                        JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                    }else {
                        Alumno ob1 = alumnoDAO.mostrarAlumno(cajaNombres.getText(), "TODOS");
                        actualizarTablaConsultas(tablaAlumnosModificaiones, ob1);
                    }
                }//********************************************************TODOS



                //for ich,,, each
                /*
                for (Alumno alumno: lista)
                    System.out.println(alumno.getNumControl());
                */
            }//********************************************************************
            if(e.getSource()==btnBorrar){
                cajaNombres.setText("");
                cajaApPaterno.setText("");
                cajaApMaterno.setText("");
                cajaEdad.setText("");
                cajaSemestre.setText("");
                cajaCarrera.setText("");
                tablaAlumnosModificaiones.setValueAt(null, 0,0);
                tablaAlumnosModificaiones.setValueAt(null, 0,1);
                tablaAlumnosModificaiones.setValueAt(null, 0,2);
                tablaAlumnosModificaiones.setValueAt(null, 0,3);
                tablaAlumnosModificaiones.setValueAt(null, 0,4);
                tablaAlumnosModificaiones.setValueAt(null, 0,5);
                tablaAlumnosModificaiones.setValueAt(null, 0,6);

            }
            if( e.getSource().equals(btnCancelar)){
                setVisible(false);
                //aqui podriamos poner un historial q regrese los valores
            }
        }
    }//public class CAMBIOSalumnos

}//class Ventana
