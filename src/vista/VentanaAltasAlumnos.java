package vista;

import Controlador.AlumnoDAO;
import modelo.Alumno;
import modelo.ResultSetTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class VentanaAltasAlumnos {

    //********************************************************************************************
//**************************    ALTAS   *********************************************************
    class Altas_Alumnos extends JFrame implements ActionListener {

        JTextField cajaApMaterno, cajaNC, cajaApPaterno,  cajaNombres, cajaEdad  ;
        JComboBox comboEDAD, comboSemestre, comboCarrera ;
        JTable tablaAlumnosAltas;
        JButton btnCAceptar, btnBorrar, btnCancelar;
        JPanel panelVerde, panelMENTA;

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

        public Altas_Alumnos() {
            getContentPane().setLayout(null);

            setTitle("Altas Alunos");
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
            actualizarTabla(tablaAlumnosAltas);

//Panel Verde NEON
            panelVerde = new JPanel();
            panelVerde.setLayout(null);
            panelVerde.setBackground(new Color(11, 178, 16));
            panelVerde.setBounds(0, 0, 610, 30);

            JLabel texALTAS = new JLabel("    ALTAS ALUMNOS:");
            texALTAS.setBounds(10, 00, 300, 20);
            texALTAS.setBackground(new Color(200, 201, 241));
            texALTAS.setForeground(Color.WHITE);
            panelVerde.add(texALTAS);

            add(panelVerde);

//PANEL VERDE MENTA
            panelMENTA = new JPanel();
            panelMENTA.setLayout(null);
            panelMENTA.setBackground(new Color(173, 252, 186));
            panelMENTA.setBounds(10, 240, 600, 200);

// Agregar la tabla a un JScrollPane
            JScrollPane scrollPane = new JScrollPane(tablaAlumnosAltas);
            scrollPane.setBounds(10, 10, 580, 180);
            panelMENTA.add(scrollPane);

            add(panelMENTA);

            JLabel texNumConTROL = new JLabel("NUMERO DE CONTROL:");
            texNumConTROL.setBounds(20, 30, 230, 20);
            add(texNumConTROL);

            cajaNC = new JTextField("-");
            cajaNC.setBounds(160, 33, 200, 15);
            add(cajaNC);

            JLabel texNombres = new JLabel("NOMBRES:");
            texNombres.setBounds(20, 55, 300, 20);
            add(texNombres);

            cajaNombres = new JTextField("-");
            cajaNombres.setBounds(100, 60, 200, 15);
            add(cajaNombres);

            JLabel texApPaterno = new JLabel("APELLIDO PATERNO:");
            texApPaterno.setBounds(20, 80, 300, 20);
            add(texApPaterno);

            cajaApPaterno = new JTextField("-");
            cajaApPaterno.setBounds(150, 85, 200, 15);
            add(cajaApPaterno);

            JLabel texApMaterno = new JLabel("APELLIDO MATERNO:");
            texApMaterno.setBounds(20, 110, 300, 20);
            add(texApMaterno);

            cajaApMaterno = new JTextField("-");
            cajaApMaterno.setBounds(150, 115, 200, 15);
            add(cajaApMaterno);

            JLabel texEdad = new JLabel("EDAD:");
            texEdad.setBounds(20, 135, 300, 20);
            add(texEdad);

            comboEDAD = new JComboBox<String>();
            comboEDAD.addItem("Elige EDAD...");
            for(int i =1; i <99;i++){
                comboEDAD.addItem(i);
            }
            comboEDAD.setBounds(100, 135,300,20);
            add(comboEDAD);

            JLabel texSemestre = new JLabel("SEMESTRE:");
            texSemestre.setBounds(20, 160, 300, 20);
            add(texSemestre);


            comboSemestre = new JComboBox<String>();
            comboSemestre.addItem("Elige Semestre...");
            comboSemestre.setBounds(100, 160, 300, 20);
            comboSemestre.addItem("1");
            comboSemestre.addItem("2");
            comboSemestre.addItem("3");
            comboSemestre.addItem("4");
            comboSemestre.addItem("5");
            comboSemestre.addItem("6");
            add(comboSemestre);

            JLabel texCarrera = new JLabel("CARRERA:");
            texCarrera.setBounds(20, 185, 300, 20);
            add(texCarrera);

            comboCarrera = new JComboBox<String>();
            comboCarrera.addItem("Elige Carrera...");
            comboCarrera.setBounds(100, 185, 300, 20);
            comboCarrera.addItem("Ingenieria en Sistemas Computaconalesº");
            comboCarrera.addItem("Ingenieria Mecatronicaº");
            comboCarrera.addItem("Ingenieria en Industrias Alimentariasº");
            add(comboCarrera);

            btnCAceptar = new JButton("AGREGAR");
            btnCAceptar.setBounds(450, 50, 100, 20);
            add(btnCAceptar);
            btnCAceptar.addActionListener(this);

            btnBorrar = new JButton("BORRAR");
            btnBorrar.setBounds(450, 100, 100, 20);
            add(btnBorrar);

            btnCancelar = new JButton("CANCELAR");
            btnCancelar.setBounds(450, 150, 100, 20);
            add(btnCancelar);

        }//Altas_Alumnos JFrame

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnCAceptar) {
                System.out.println("se uso el boton aceptar");
//------------------------PRUEBA PROCESO ALTAS-------------------------------
                Alumno a = new Alumno(cajaNC.getText(), cajaNombres.getText(),cajaApPaterno.getText(),
                        cajaApMaterno.getText(), Byte.parseByte(String.valueOf(comboEDAD.getSelectedItem()))  ,
                        Byte.parseByte(String.valueOf(comboSemestre.getSelectedItem())), String.valueOf(comboCarrera.getSelectedItem()));
                //Le tenemos que poner parametros vacios para poder hacer el objeto, pero los valores que entraran a la base de datos son los de la instruccion String sql = "INSERT INTO alumnos VALUES('6','86','86','86',86 ,86 , '86'  )";
                AlumnoDAO alumnoDAO = new AlumnoDAO();//AlumnoDao es el objeto del Packete CONTROLADOR que hace la conexion a la BDD
                actualizarTabla(tablaAlumnosAltas);

                //Aqui tenemos acceso a cualquier elemento de la tabla
                ArrayList<Alumno> lista = alumnoDAO.mostrarAlumnos("");
                for(Alumno alumno : lista)
                    System.out.println(alumno.getNumControl()+"quesito");

                if (alumnoDAO.agregarAlumno(a))
                    System.out.println("FELICIDADES: se agrego un nuevo Alumno a la BDD (desde la ventanaInicio)");
                else
                    System.out.println("ERROR: no se pudo agregar un nuevo Alumno a la BDD (desde la ventanaInicio)");
            }//cuando el escuchador detecte a btn_ACEPTAR
            if (e.getSource() == btnBorrar) {

            }
            if (e.getSource() == btnCancelar) {

            }

        }//Escuchador de botones ACEPTAR, CANCELAR, BORRAR

    }//class altas_Alumnos
}
