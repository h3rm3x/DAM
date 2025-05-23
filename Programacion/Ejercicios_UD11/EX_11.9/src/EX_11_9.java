import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class EX_11_9 {
    private ArrayList<Persona> personas = new ArrayList<>();

    public EX_11_9() {
        initComponents();
    }

    private void abrirCardProfesor(ActionEvent e) {
        panelNuevoAlumno.setVisible(false);
        panelNuevoProfesor.setVisible(false);
        panelLeerFichero.setVisible(false);
        cardInicial.setVisible(false);

        // Mostrar solo el panel del profesor
        panelNuevoProfesor.setVisible(true);
    }

    private void abrirCardAlumno(ActionEvent e) {
        panelNuevoAlumno.setVisible(false);
        panelNuevoProfesor.setVisible(false);
        panelLeerFichero.setVisible(false);
        cardInicial.setVisible(false);

        // Mostrar solo el panel del profesor
        panelNuevoAlumno.setVisible(true);
    }

    private void leerFichero(ActionEvent e) {
        panelNuevoAlumno.setVisible(false);
        panelNuevoProfesor.setVisible(false);
        panelLeerFichero.setVisible(false);
        cardInicial.setVisible(false);

        panelLeerFichero.setVisible(true);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Fichero.dat"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals("Alumno")) {
                    sb.append(new Alumno(datos[1], datos[2], Integer.parseInt(datos[3]), datos[4]));
                } else if (datos[0].equals("Profesor")) {
                    sb.append(new Profesor(datos[1], datos[2], Integer.parseInt(datos[3]), datos[4]));
                }
            }
            br.close();
        } catch (Exception e1) {
            sb.append("Error al leer el fichero: " + e1.getMessage());
        }

        ObjetosLeidos.setText(sb.toString());


        // Si la longitud de la cadena es mayor que la longitud máxima, se añade un scroll
        if (sb.length() > 1000) {
            JScrollPane scroll = new JScrollPane(ObjetosLeidos);
            scroll.setPreferredSize(new Dimension(400, 200));
            panelLeerFichero.add(scroll);
        } else {
            panelLeerFichero.add(ObjetosLeidos);
        }
    }

    private void escribirFichero(ActionEvent e) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Fichero.dat"));
            for (Persona p : personas) {
                if (p instanceof Alumno) {
                    bw.write("Alumno," + p.getNombre() + "," + p.getDni() + "," + p.getEdad() + "," + ((Alumno) p).getNivel());
                } else if (p instanceof Profesor) {
                    bw.write("Profesor," + p.getNombre() + "," + p.getDni() + "," + p.getEdad() + "," + ((Profesor) p).getAsignatura());
                }
                bw.newLine();
            }
            bw.close();
            JOptionPane.showMessageDialog(ContentPanel, "Fichero guardado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(ContentPanel, "Error al escribir el fichero: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cerrar(ActionEvent e) {
        int respuesta = JOptionPane.showConfirmDialog(ContentPanel,
                "¿Está seguro de que desea cerrar la aplicación?",
                "Confirmar cierre",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void CrearAlumno(ActionEvent e) {
        try {
            String nombre = textNombreAlumno.getText().trim();
            String dni = textDNI.getText().trim();
            String edadText = textEdad.getText().trim();
            String nivel = (String) Nivel.getSelectedItem();

            // Validaciones
            if (nombre.isEmpty() || dni.isEmpty() || edadText.isEmpty()) {
                JOptionPane.showMessageDialog(ContentPanel, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int edad = Integer.parseInt(edadText);

            Alumno a = new Alumno(nombre, dni, edad, nivel);
            personas.add(a);

            // Limpiar campos
            textNombreAlumno.setText("");
            textDNI.setText("");
            textEdad.setText("");
            Nivel.setSelectedIndex(0);

            JOptionPane.showMessageDialog(ContentPanel, "Alumno creado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ContentPanel, "La edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        panelLeerFichero.setVisible(false);
        panelNuevoAlumno.setVisible(false);
        panelNuevoProfesor.setVisible(false);
        cardInicial.setVisible(true);
    }

    private void CrearProfesor(ActionEvent e) {
        try {
            String nombre = textNombreProfesor.getText().trim();
            String dni = textDNIProfesor.getText().trim();
            String edadText = textEdadProfesor.getText().trim();
            String asignatura = textAsignatura.getText().trim();

            // Validaciones
            if (nombre.isEmpty() || dni.isEmpty() || edadText.isEmpty() || asignatura.isEmpty()) {
                JOptionPane.showMessageDialog(ContentPanel, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int edad = Integer.parseInt(edadText);

            Profesor p = new Profesor(nombre, dni, edad, asignatura);
            personas.add(p);

            // Limpiar campos
            textNombreProfesor.setText("");
            textDNIProfesor.setText("");
            textEdadProfesor.setText("");
            textAsignatura.setText("");

            JOptionPane.showMessageDialog(ContentPanel, "Profesor creado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ContentPanel, "La edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        panelLeerFichero.setVisible(false);
        panelNuevoAlumno.setVisible(false);
        panelNuevoProfesor.setVisible(false);
        // Mostrar solo el panel del inicial
        cardInicial.setVisible(true);
    }

    private void volverPaginaInicial(ActionEvent e) {
        // TODO add your code here
        panelNuevoAlumno.setVisible(false);
        panelNuevoProfesor.setVisible(false);
        panelLeerFichero.setVisible(false);

        // Mostrar solo el panel del inicial
        cardInicial.setVisible(true);


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Alan Rabinerson Aranda
        ContentPanel = new JFrame();
        menuBar1 = new JMenuBar();
        menuFichero = new JMenu();
        itemLeerFichero = new JMenuItem();
        itemEscribirFichero = new JMenuItem();
        menuProfesor = new JMenu();
        itemProfesor = new JMenuItem();
        menuAlumno = new JMenu();
        itemAlumno = new JMenuItem();
        itemCerrar = new JMenuItem();
        cardInicial = new JPanel();
        panelNuevoAlumno = new JPanel();
        lblTituloAlumno = new JLabel();
        lblNombreAlumno = new JLabel();
        textNombreAlumno = new JTextField();
        lblDNIAlumno = new JLabel();
        textDNI = new JTextField();
        lblEdad = new JLabel();
        textEdad = new JTextField();
        lblNivel = new JLabel();
        Nivel = new JComboBox<>();
        btnCrearAlumno = new JButton();
        panelNuevoProfesor = new JPanel();
        lblTituloProfesor = new JLabel();
        lblNombreProfesor = new JLabel();
        textNombreProfesor = new JTextField();
        lblDNIProfesor = new JLabel();
        textDNIProfesor = new JTextField();
        lblEdadProfesor = new JLabel();
        textEdadProfesor = new JTextField();
        lblAsignatura = new JLabel();
        textAsignatura = new JTextField();
        btnCrearProfesor = new JButton();
        panelLeerFichero = new JPanel();
        ObjetosLeidos = new JTextArea();
        button1 = new JButton();

        //======== ContentPanel ========
        {
            var ContentPanelContentPane = ContentPanel.getContentPane();
            ContentPanelContentPane.setLayout(new CardLayout());

            //======== menuBar1 ========
            {
                menuBar1.setPreferredSize(null);

                //======== menuFichero ========
                {
                    menuFichero.setText("      Fichero      ");

                    //---- itemLeerFichero ----
                    itemLeerFichero.setText("Leer fichero");
                    itemLeerFichero.addActionListener(e -> leerFichero(e));
                    menuFichero.add(itemLeerFichero);

                    //---- itemEscribirFichero ----
                    itemEscribirFichero.setText("Escribir fichero");
                    itemEscribirFichero.addActionListener(e -> escribirFichero(e));
                    menuFichero.add(itemEscribirFichero);
                }
                menuBar1.add(menuFichero);

                //======== menuProfesor ========
                {
                    menuProfesor.setText("   Profesor  ");

                    //---- itemProfesor ----
                    itemProfesor.setText("Nuevo Profesor");
                    itemProfesor.addActionListener(e -> abrirCardProfesor(e));
                    menuProfesor.add(itemProfesor);
                }
                menuBar1.add(menuProfesor);

                //======== menuAlumno ========
                {
                    menuAlumno.setText("    Alumno    ");

                    //---- itemAlumno ----
                    itemAlumno.setText("Nuevo alumno");
                    itemAlumno.addActionListener(e -> abrirCardAlumno(e));
                    menuAlumno.add(itemAlumno);
                }
                menuBar1.add(menuAlumno);

                //---- itemCerrar ----
                itemCerrar.setText("Cerrar");
                itemCerrar.addActionListener(e -> cerrar(e));
                menuBar1.add(itemCerrar);
            }
            ContentPanel.setJMenuBar(menuBar1);

            //======== cardInicial ========
            {
                cardInicial.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
                border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER
                , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font
                .BOLD ,12 ), java. awt. Color. red) ,cardInicial. getBorder( )) ); cardInicial. addPropertyChangeListener (
                new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072"
                .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
                cardInicial.setLayout(new GridBagLayout());
                ((GridBagLayout)cardInicial.getLayout()).columnWidths = new int[] {0, 0};
                ((GridBagLayout)cardInicial.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)cardInicial.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)cardInicial.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
            }
            ContentPanelContentPane.add(cardInicial, "cardInicial");

            //======== panelNuevoAlumno ========
            {
                panelNuevoAlumno.setLayout(new GridBagLayout());
                ((GridBagLayout)panelNuevoAlumno.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)panelNuevoAlumno.getLayout()).rowHeights = new int[] {61, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)panelNuevoAlumno.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panelNuevoAlumno.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- lblTituloAlumno ----
                lblTituloAlumno.setText("CREAR NUEVO ALUMNO");
                lblTituloAlumno.setFont(new Font("Inter", Font.BOLD, 16));
                panelNuevoAlumno.add(lblTituloAlumno, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblNombreAlumno ----
                lblNombreAlumno.setText("Nombre");
                panelNuevoAlumno.add(lblNombreAlumno, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));
                panelNuevoAlumno.add(textNombreAlumno, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblDNIAlumno ----
                lblDNIAlumno.setText("DNI");
                panelNuevoAlumno.add(lblDNIAlumno, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));
                panelNuevoAlumno.add(textDNI, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblEdad ----
                lblEdad.setText("Edad");
                panelNuevoAlumno.add(lblEdad, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));
                panelNuevoAlumno.add(textEdad, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblNivel ----
                lblNivel.setText("Nivel");
                panelNuevoAlumno.add(lblNivel, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- Nivel ----
                Nivel.setModel(new DefaultComboBoxModel<>(new String[] {
                    "ESO",
                    "Bachillerato",
                    "Grado Medio",
                    "Grado Superior"
                }));
                panelNuevoAlumno.add(Nivel, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- btnCrearAlumno ----
                btnCrearAlumno.setText("Crear Alumno");
                btnCrearAlumno.addActionListener(e -> CrearAlumno(e));
                panelNuevoAlumno.add(btnCrearAlumno, new GridBagConstraints(4, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));
            }
            ContentPanelContentPane.add(panelNuevoAlumno, "cardAlumno");

            //======== panelNuevoProfesor ========
            {
                panelNuevoProfesor.setLayout(new GridBagLayout());
                ((GridBagLayout)panelNuevoProfesor.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)panelNuevoProfesor.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- lblTituloProfesor ----
                lblTituloProfesor.setText("CREAR NUEVO PROFESOR");
                lblTituloProfesor.setFont(new Font("Inter", Font.BOLD, 16));
                panelNuevoProfesor.add(lblTituloProfesor, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblNombreProfesor ----
                lblNombreProfesor.setText("Nombre");
                panelNuevoProfesor.add(lblNombreProfesor, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));
                panelNuevoProfesor.add(textNombreProfesor, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblDNIProfesor ----
                lblDNIProfesor.setText("DNI");
                panelNuevoProfesor.add(lblDNIProfesor, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));
                panelNuevoProfesor.add(textDNIProfesor, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblEdadProfesor ----
                lblEdadProfesor.setText("Edad");
                panelNuevoProfesor.add(lblEdadProfesor, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));
                panelNuevoProfesor.add(textEdadProfesor, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblAsignatura ----
                lblAsignatura.setText("Asignatura");
                panelNuevoProfesor.add(lblAsignatura, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));
                panelNuevoProfesor.add(textAsignatura, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- btnCrearProfesor ----
                btnCrearProfesor.setText("Crear Profesor");
                btnCrearProfesor.addActionListener(e -> CrearProfesor(e));
                panelNuevoProfesor.add(btnCrearProfesor, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));
            }
            ContentPanelContentPane.add(panelNuevoProfesor, "cardProfesor");

            //======== panelLeerFichero ========
            {

                //---- ObjetosLeidos ----
                ObjetosLeidos.setEditable(false);
                ObjetosLeidos.setText(" ");

                //---- button1 ----
                button1.setText("Volver a la pagina inicial");
                button1.addActionListener(e -> volverPaginaInicial(e));

                GroupLayout panelLeerFicheroLayout = new GroupLayout(panelLeerFichero);
                panelLeerFichero.setLayout(panelLeerFicheroLayout);
                panelLeerFicheroLayout.setHorizontalGroup(
                    panelLeerFicheroLayout.createParallelGroup()
                        .addComponent(ObjetosLeidos, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, panelLeerFicheroLayout.createSequentialGroup()
                            .addContainerGap(114, Short.MAX_VALUE)
                            .addComponent(button1)
                            .addGap(105, 105, 105))
                );
                panelLeerFicheroLayout.setVerticalGroup(
                    panelLeerFicheroLayout.createParallelGroup()
                        .addGroup(panelLeerFicheroLayout.createSequentialGroup()
                            .addComponent(ObjetosLeidos, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button1)
                            .addGap(0, 6, Short.MAX_VALUE))
                );
            }
            ContentPanelContentPane.add(panelLeerFichero, "cardLeerFichero");
            ContentPanel.pack();
            ContentPanel.setLocationRelativeTo(ContentPanel.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Alan Rabinerson Aranda
    public JFrame ContentPanel;
    private JMenuBar menuBar1;
    private JMenu menuFichero;
    private JMenuItem itemLeerFichero;
    private JMenuItem itemEscribirFichero;
    private JMenu menuProfesor;
    private JMenuItem itemProfesor;
    private JMenu menuAlumno;
    private JMenuItem itemAlumno;
    private JMenuItem itemCerrar;
    private JPanel cardInicial;
    private JPanel panelNuevoAlumno;
    private JLabel lblTituloAlumno;
    private JLabel lblNombreAlumno;
    private JTextField textNombreAlumno;
    private JLabel lblDNIAlumno;
    private JTextField textDNI;
    private JLabel lblEdad;
    private JTextField textEdad;
    private JLabel lblNivel;
    private JComboBox<String> Nivel;
    private JButton btnCrearAlumno;
    private JPanel panelNuevoProfesor;
    private JLabel lblTituloProfesor;
    private JLabel lblNombreProfesor;
    private JTextField textNombreProfesor;
    private JLabel lblDNIProfesor;
    private JTextField textDNIProfesor;
    private JLabel lblEdadProfesor;
    private JTextField textEdadProfesor;
    private JLabel lblAsignatura;
    private JTextField textAsignatura;
    private JButton btnCrearProfesor;
    private JPanel panelLeerFichero;
    private JTextArea ObjetosLeidos;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}