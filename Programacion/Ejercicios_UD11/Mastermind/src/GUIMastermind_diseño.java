import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Fri May 30 16:55:35 CEST 2025
 */



/**
 * @author alanr
 */
public class GUIMastermind_diseño {
    private static HashMap<String, Partida> partidas = new HashMap<>();
    private static String nombreJugador;
    private static Partida partida;
    public GUIMastermind_diseño() {
        initComponents();
        leerFicheroPartidas();
    }

    private void ComprobarTirada(ActionEvent e) {
        String textotirada = fieldTiradas.getText().replaceAll(" ",""); // Eliminar espacios en blanco
        textotirada = textotirada.toUpperCase(); // Convertir a mayúsculas para evitar problemas de coincidencia
        if (textotirada.length() != 4) {
            JOptionPane.showMessageDialog(ContentPanel, "La tirada debe tener exactamente 4 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        char[] combinacionIntentada = textotirada.toCharArray();
        Tirada tirada = new Tirada(combinacionIntentada);
        int[] resultado = partida.comprobar(tirada);



        areaListaTiradas.append("Tirada: " + tirada + " resultado: ["+ resultado[0] + ","+ resultado[1] +"]\n");
        fieldTiradas.setText("");
        if (partida.getEstadoFinal()) {
            JOptionPane.showMessageDialog(ContentPanel, "¡Felicidades! Has adivinado la combinación secreta.", "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
            fieldTiradas.setEnabled(false);
            btnComprobartirada.setEnabled(false);
            partidas.put(nombreJugador, partida);
        } else if (partida.getListaTiradas().size() >= 16) {
            JOptionPane.showMessageDialog(ContentPanel, "Has alcanzado el número máximo de tiradas. La combinación " +
                            "correcta es: " + Arrays.toString(partida.getCombinacionSecreta()) + "\n" +
                            " Fin del juego.",
                    "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
            fieldTiradas.setEnabled(false);
            btnComprobartirada.setEnabled(false);
            partidas.put(generarClavePartida(nombreJugador), partida);
        }
    }

    private void VerPartidas(ActionEvent e) {
        panelPrincipal.setVisible(false);
        panelPartida.setVisible(false);
        panelListaPartidas.setVisible(true);
        areaListaPartidas.setText(""); // Limpiar el área de texto antes de mostrar las partidas
        GuardarPartidas();
        for (String key : partidas.keySet()) {
            Partida partida = partidas.get(key);
            areaListaPartidas.append(partida + "\n");
        }
        
    }

    private void GuardarPartidas() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\alanr\\Documents\\DAM" +
                    "\\Programacion\\Ejercicios_UD11\\Mastermind\\src\\partidas.dat"));
            oos.writeInt(partidas.size()); // Escribir el número de partidas primero
            for (Partida partida : partidas.values()) {
                oos.writeObject(partida);
            }
            oos.close(); // Guardar las partidas en el fichero
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(ContentPanel, "Error al cargar las partidas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void JugarPartida(ActionEvent e) {
        panelPrincipal.setVisible(false);
        panelListaPartidas.setVisible(false);
        panelPartida.setVisible(true);
        nombreJugador = fieldNombre.getText().trim();
        if (nombreJugador.isEmpty()) {
            JOptionPane.showMessageDialog(ContentPanel, "Por favor, introduce tu nombre.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            
        }
        partida = new Partida(nombreJugador);
        
        
    }

    private String generarClavePartida(String nombreJugador) {
        return "Partida_" + nombreJugador + "_" + System.currentTimeMillis();
    }

    private void NuevaPartida(ActionEvent e) {
        panelPrincipal.setVisible(true);
        panelPartida.setVisible(false);
        panelListaPartidas.setVisible(false);
        fieldNombre.setText("");
        fieldTiradas.setText("");
        areaListaTiradas.setText("");
        areaListaPartidas.setText("");
        fieldTiradas.setEnabled(true);
        btnComprobartirada.setEnabled(true);
        partida = null;
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Alan Rabinerson Aranda
        ContentPanel = new JFrame();
        barraPartidas = new JMenuBar();
        menuPartidas = new JMenu();
        itemNuevaPartida = new JMenuItem();
        itemVerPartidas = new JMenuItem();
        panelPrincipal = new JPanel();
        lblTituloPrincipal = new JLabel();
        panelNombre = new JPanel();
        lblNombre = new JLabel();
        fieldNombre = new JTextField();
        btnJugarPartida = new JButton();
        panelPartida = new JPanel();
        lblTitulo = new JLabel();
        fieldTiradas = new JTextField();
        lblTirada = new JLabel();
        btnComprobartirada = new JButton();
        scrollListaTiradas = new JScrollPane();
        areaListaTiradas = new JTextArea();
        lblListaTiradas = new JLabel();
        lblColores = new JLabel();
        panelListaPartidas = new JPanel();
        lblListaPartidas = new JLabel();
        scrollListaPartidas = new JScrollPane();
        areaListaPartidas = new JTextArea();

        //======== ContentPanel ========
        {
            var ContentPanelContentPane = ContentPanel.getContentPane();
            ContentPanelContentPane.setLayout(new CardLayout());

            //======== barraPartidas ========
            {

                //======== menuPartidas ========
                {
                    menuPartidas.setText("Partidas");

                    //---- itemNuevaPartida ----
                    itemNuevaPartida.setText("Nueva Partida");
                    itemNuevaPartida.addActionListener(e -> NuevaPartida(e));
                    menuPartidas.add(itemNuevaPartida);

                    //---- itemVerPartidas ----
                    itemVerPartidas.setText("Ver Partidas");
                    itemVerPartidas.addActionListener(e -> VerPartidas(e));
                    menuPartidas.add(itemVerPartidas);
                }
                barraPartidas.add(menuPartidas);
            }
            ContentPanel.setJMenuBar(barraPartidas);

            //======== panelPrincipal ========
            {
                panelPrincipal.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
                border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER
                ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font
                .BOLD,12),java.awt.Color.red),panelPrincipal. getBorder()));panelPrincipal. addPropertyChangeListener(
                new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order"
                .equals(e.getPropertyName()))throw new RuntimeException();}});
                panelPrincipal.setLayout(new BorderLayout());

                //---- lblTituloPrincipal ----
                lblTituloPrincipal.setText("MASTERMIND");
                lblTituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
                lblTituloPrincipal.setFont(new Font("Inter", Font.BOLD, 20));
                panelPrincipal.add(lblTituloPrincipal, BorderLayout.NORTH);

                //======== panelNombre ========
                {

                    //---- lblNombre ----
                    lblNombre.setText("INTRODUCE TU NOMBRE");

                    //---- btnJugarPartida ----
                    btnJugarPartida.setText("Jugar Partida");
                    btnJugarPartida.addActionListener(e -> JugarPartida(e));

                    GroupLayout panelNombreLayout = new GroupLayout(panelNombre);
                    panelNombre.setLayout(panelNombreLayout);
                    panelNombreLayout.setHorizontalGroup(
                        panelNombreLayout.createParallelGroup()
                            .addGroup(panelNombreLayout.createSequentialGroup()
                                .addContainerGap(193, Short.MAX_VALUE)
                                .addGroup(panelNombreLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panelNombreLayout.createSequentialGroup()
                                        .addGroup(panelNombreLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldNombre))
                                        .addGap(184, 184, 184))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panelNombreLayout.createSequentialGroup()
                                        .addComponent(btnJugarPartida)
                                        .addGap(205, 205, 205))))
                    );
                    panelNombreLayout.setVerticalGroup(
                        panelNombreLayout.createParallelGroup()
                            .addGroup(panelNombreLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(lblNombre)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnJugarPartida)
                                .addContainerGap(141, Short.MAX_VALUE))
                    );
                }
                panelPrincipal.add(panelNombre, BorderLayout.CENTER);
            }
            ContentPanelContentPane.add(panelPrincipal, "card2");

            //======== panelPartida ========
            {

                //---- lblTitulo ----
                lblTitulo.setText("MASTERMIND");
                lblTitulo.setFont(new Font("Inter", Font.BOLD, 20));

                //---- lblTirada ----
                lblTirada.setText("Nueva Tirada");
                lblTirada.setFont(new Font("Inter", Font.BOLD, 14));
                lblTirada.setLabelFor(fieldTiradas);

                //---- btnComprobartirada ----
                btnComprobartirada.setText("Comprobar");
                btnComprobartirada.addActionListener(e -> ComprobarTirada(e));

                //======== scrollListaTiradas ========
                {
                    scrollListaTiradas.setViewportView(areaListaTiradas);
                }

                //---- lblListaTiradas ----
                lblListaTiradas.setText("Lista Tiradas ");
                lblListaTiradas.setFont(new Font("Inter", Font.BOLD, 14));

                //---- lblColores ----
                lblColores.setText("<html>Colores:<br>" +
                        "<span style='color: red;'>R (Red)</span>, " +
                        "<span style='color: blue;'>B (Blue)</span>,<br>" +
                        "<span style='color: #ff00ff;'>M (Magenta)</span>, " +
                        "<span style='color: #00ffff;'>C (Cyan)</span>,<br>" +
                        "<span style='color: #FFD700;'>Y (Yellow)</span>, " +
                        "<span style='color: green;'>G (Green)</span></html>");
                GroupLayout panelPartidaLayout = new GroupLayout(panelPartida);
                panelPartida.setLayout(panelPartidaLayout);
                panelPartidaLayout.setHorizontalGroup(
                    panelPartidaLayout.createParallelGroup()
                        .addGroup(panelPartidaLayout.createSequentialGroup()
                            .addGap(184, 184, 184)
                            .addComponent(lblTitulo)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelPartidaLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(panelPartidaLayout.createParallelGroup()
                                .addComponent(fieldTiradas)
                                .addGroup(panelPartidaLayout.createSequentialGroup()
                                    .addGroup(panelPartidaLayout.createParallelGroup()
                                        .addComponent(lblTirada)
                                        .addComponent(lblColores, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnComprobartirada, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)

                                    .addGap(0, 113, Short.MAX_VALUE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panelPartidaLayout.createParallelGroup()
                                .addComponent(scrollListaTiradas, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblListaTiradas))
                            .addGap(20, 20, 20))
                );
                panelPartidaLayout.setVerticalGroup(
                    panelPartidaLayout.createParallelGroup()
                        .addGroup(panelPartidaLayout.createSequentialGroup()
                            .addComponent(lblTitulo)
                            .addGap(34, 34, 34)
                            .addGroup(panelPartidaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTirada)
                                .addComponent(lblListaTiradas))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelPartidaLayout.createParallelGroup()
                                .addGroup(panelPartidaLayout.createSequentialGroup()
                                    .addComponent(fieldTiradas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblColores, GroupLayout.PREFERRED_SIZE, 80,
                                            GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnComprobartirada))
                                .addComponent(scrollListaTiradas, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 72, Short.MAX_VALUE))
                );
            }
            ContentPanelContentPane.add(panelPartida, "card7");

            //======== panelListaPartidas ========
            {

                //---- lblListaPartidas ----
                lblListaPartidas.setText("LISTA PARTIDAS");
                lblListaPartidas.setFont(new Font("Inter", Font.BOLD, 16));

                //======== scrollListaPartidas ========
                {
                    scrollListaPartidas.setViewportView(areaListaPartidas);
                }

                GroupLayout panelListaPartidasLayout = new GroupLayout(panelListaPartidas);
                panelListaPartidas.setLayout(panelListaPartidasLayout);
                panelListaPartidasLayout.setHorizontalGroup(
                    panelListaPartidasLayout.createParallelGroup()
                        .addGroup(panelListaPartidasLayout.createSequentialGroup()
                            .addGap(193, 193, 193)
                            .addComponent(lblListaPartidas)
                            .addContainerGap(201, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, panelListaPartidasLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollListaPartidas, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                            .addContainerGap())
                );
                panelListaPartidasLayout.setVerticalGroup(
                    panelListaPartidasLayout.createParallelGroup()
                        .addGroup(panelListaPartidasLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblListaPartidas)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollListaPartidas, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }
            ContentPanelContentPane.add(panelListaPartidas, "card3");
            ContentPanel.pack();
            ContentPanel.setLocationRelativeTo(ContentPanel.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    private void leerFicheroPartidas() {
        try (
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\alanr\\Documents\\DAM" +
                    "\\Programacion\\Ejercicios_UD11\\Mastermind\\src\\partidas.dat"))) {
            int numPartidas = ois.readInt(); // Leer el número de partidas
            for (int i = 0; i < numPartidas; i++) {
                Partida partidaLeida = (Partida) ois.readObject();
                partidas.put(partidaLeida.getNombreJugador(), partidaLeida);
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Alan Rabinerson Aranda
    public JFrame ContentPanel;
    public JMenuBar barraPartidas;
    private JMenu menuPartidas;
    private JMenuItem itemNuevaPartida;
    private JMenuItem itemVerPartidas;
    public JPanel panelPrincipal;
    private JLabel lblTituloPrincipal;
    private JPanel panelNombre;
    private JLabel lblNombre;
    private JTextField fieldNombre;
    private JButton btnJugarPartida;
    public JPanel panelPartida;
    private JLabel lblTitulo;
    private JTextField fieldTiradas;
    private JLabel lblTirada;
    private JButton btnComprobartirada;
    private JScrollPane scrollListaTiradas;
    private JTextArea areaListaTiradas;
    private JLabel lblListaTiradas;
    private JLabel lblColores;
    public JPanel panelListaPartidas;
    private JLabel lblListaPartidas;
    private JScrollPane scrollListaPartidas;
    private JTextArea areaListaPartidas;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
