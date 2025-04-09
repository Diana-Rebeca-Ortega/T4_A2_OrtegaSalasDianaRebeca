package vista;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Controlador.AlumnoDAO;
import modelo.ResultSetTableModel;
import javax.swing.*;
import modelo.Alumno;

public class VentanaABCC {
    public JTextField  cajaApMaterno;
    public JTextField cajaNC;
    public JTextField cajaApPaterno;
    public JTextField cajaNombres;
    public  Boolean  sionoAgregarAlumno ;

    public class Altas_Alumnos extends JFrame implements ActionListener {

        public void actualizarTabla(JTable tabla){
            final String Driver_Controlador = "com.mysql.cj.jdbc.Driver";
            final String URL =  "jdbc:mysql://localhost:3306/BD_Topicos_2025";
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

        }


        public Altas_Alumnos() {
            getContentPane().setLayout(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);//para que no queden registros en la ram
            setTitle("Altas Alunos");
            setSize(630, 480);
            setLocationRelativeTo(null);//locacion en la ventana
            setVisible(true);

//Panel Verde NEON
            JPanel panelVerde = new JPanel();
            panelVerde.setLayout(null);
            panelVerde.setBackground(new Color(11, 178, 16 ));
            panelVerde.setBounds(0,0, 610, 30);

            JLabel texALTAS = new JLabel("    ALTAS ALUMNOS:");
            texALTAS.setBounds(10,00,300,20);
            texALTAS.setBackground(new Color(200, 201  , 241));
            texALTAS.setForeground(Color.WHITE);
            panelVerde.add(texALTAS);

            add(panelVerde);

//PANEL VERDE MENTA
            JPanel panelMENTA= new JPanel();
            panelMENTA.setLayout(null);
            panelMENTA.setBackground(new Color(173, 252, 186  ));
            panelMENTA.setBounds(10,190, 600, 240);

            // Crear un modelo de tabla
            String[] columnas = {"Num_Control", "Nombre", "1º Apellido", "2º Apellido", "Edad", "Semestre", "Carrera"};
            Object[][] datos = {
                    {"Dato 1", "Dato 2", "Dato 3", "Dato 4", "Dato 5", "Dato 6", "-"},
                    {"Dato 7", "Dato 8", "Dato 9", "Dato 10", "Dato 11", "Dato 12", "-"},
                    // Agrega más filas según sea necesario
            };

           // Crear la tabla
            JTable tabla = new JTable(datos, columnas);

// Agregar la tabla a un JScrollPane
            JScrollPane scrollPane = new JScrollPane(tabla);
            scrollPane.setBounds(10, 10, 580, 220); // Establecer los límites del JScrollPane

// Agregar el JScrollPane al panel
            panelMENTA.add(scrollPane);

            add(panelMENTA);


            JLabel texNumConTROL = new JLabel("NUMERO DE CONTROL:");
            texNumConTROL.setBounds(20,30,230,20);
            add(texNumConTROL);

             cajaNC =new JTextField("-");
            cajaNC.setBounds(160,33, 200, 15);
            add(cajaNC);

            JLabel texNombres = new JLabel("NOMBRES:");
            texNombres.setBounds(20,55,300,20);
            add(texNombres);

             cajaNombres =new JTextField("-");
            cajaNombres.setBounds(100,60, 200, 15);
            add(cajaNombres);

            JLabel texApPaterno = new JLabel("APELLIDO PATERNO:");
            texApPaterno.setBounds(20,80,300,20);
            add(texApPaterno);

             cajaApPaterno =new JTextField("-");
            cajaApPaterno.setBounds(150,85, 200, 15);
            add(cajaApPaterno);

            JLabel texApMaterno = new JLabel("APELLIDO MATERNO:");
            texApMaterno.setBounds(20,110,300,20);
            add(texApMaterno);

             cajaApMaterno  =new JTextField("-");
            cajaApMaterno.setBounds(150,115, 200, 15);
            add(cajaApMaterno);

            JLabel texSemestre = new JLabel("SEMESTRE:");
            texSemestre.setBounds(20,135,300,20);
            add(texSemestre);

            JLabel texCarrera = new JLabel("CARRERA:");
            texCarrera.setBounds(20,160,300,20);
            add(texCarrera);

            JComboBox comboSemestre = new JComboBox <String> ();
            comboSemestre.addItem("Elige Semestre...");
            comboSemestre.setBounds(100,135,300,20);
            comboSemestre.addItem("1º");
            comboSemestre.addItem("2º");
            comboSemestre.addItem("3º");
            comboSemestre.addItem("4º");
            comboSemestre.addItem("5º");
            comboSemestre.addItem("6º");
            add(comboSemestre);

            JComboBox comboCarrera = new JComboBox <String> ();
            comboCarrera.addItem("Elige Carrera...");
            comboCarrera.setBounds(100,160,300,20);
            comboCarrera.addItem("Ingenieria en Sistemas Computaconalesº");
            comboCarrera.addItem("Ingenieria Mecatronicaº");
            comboCarrera.addItem("Ingenieria en Industrias Alimentariasº");
            add(comboCarrera);


             btnCAceptar= new JButton("AGREGAR");
            btnCAceptar.setBounds(450,50,100,20);
            add(btnCAceptar);
            btnCAceptar.addActionListener(this);

             btnBorrar= new JButton("BORRAR");
            btnBorrar.setBounds(450,100,100,20);
            add(btnBorrar);

             btnCancelar= new JButton("CANCELAR");
            btnCancelar.setBounds(450,150,100,20);
            add(btnCancelar);

        }
        JButton btnCAceptar, btnBorrar, btnCancelar;

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnCAceptar){
                System.out.println("se uso el boton aceotar");
AlumnoDAO alumnoDAO = new AlumnoDAO();
alumnoDAO.agregarAlumno(sionoAgregarAlumno);
                sionoAgregarAlumno=true;

            }else {
                sionoAgregarAlumno=false;
            }

        }

    }//class altas_Alumnos

}//clas interfaz
