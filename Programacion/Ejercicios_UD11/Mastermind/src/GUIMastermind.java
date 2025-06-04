import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Fri May 30 16:55:35 CEST 2025
 */



/**
 * @author alanr
 */
public class GUIMastermind {
    public GUIMastermind() {
        initComponents();
    }

    private void ComprobarTirada(ActionEvent e) {
        String textotirada = fieldTiradas.getText().trim();
        if (textotirada.length() != 4) {
            JOptionPane.showMessageDialog(ContentPanel, "La tirada debe tener exactamente 4 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        char[] combinacionIntentada = textotirada.toCharArray();
        Tirada tirada = new Tirada(combinacionIntentada);
        int[] resultado = Mastermind.partida.comprobar(tirada);



        areaListaTiradas.append("Tirada: " + tirada + "Resultado: [" + resultado[0] + ", " + resultado[1] + ", " + resultado[2] +"]\n");
        Mastermind.partida.getListaTiradas().add(tirada);
        fieldTiradas.setText("");
        if (Mastermind.partida.getEstadoFinal()) {
            JOptionPane.showMessageDialog(ContentPanel, "¡Felicidades! Has adivinado la combinación secreta.", "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
            fieldTiradas.setEnabled(false);
            btnComprobartirada.setEnabled(false);
        } else if (Mastermind.partida.getListaTiradas().size() >= 16) {
            JOptionPane.showMessageDialog(ContentPanel, "Has alcanzado el número máximo de tiradas. Fin del juego.", "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
            fieldTiradas.setEnabled(false);
            btnComprobartirada.setEnabled(false);
        }
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Alan Rabinerson Aranda
        ContentPanel = new JFrame();
        menuBar1 = new JMenuBar();
        menuPartidas = new JMenu();
        itemNuevaPartida = new JMenuItem();
        itemVerPartidas = new JMenuItem();
        panelPartida = new JPanel();
        lblTitulo = new JLabel();
        fieldTiradas = new JTextField();
        lblTirada = new JLabel();
        btnComprobartirada = new JButton();
        scrollListaTiradas = new JScrollPane();
        areaListaTiradas = new JTextArea();
        lblListaTiradas = new JLabel();

        //======== ContentPanel ========
        {
            var ContentPanelContentPane = ContentPanel.getContentPane();
            ContentPanelContentPane.setLayout(new CardLayout());

            //======== menuBar1 ========
            {

                //======== menuPartidas ========
                {
                    menuPartidas.setText("Partidas");

                    //---- itemNuevaPartida ----
                    itemNuevaPartida.setText("Nueva Partida");
                    menuPartidas.add(itemNuevaPartida);

                    //---- itemVerPartidas ----
                    itemVerPartidas.setText("Ver Partidas");
                    menuPartidas.add(itemVerPartidas);
                }
                menuBar1.add(menuPartidas);
            }
            ContentPanel.setJMenuBar(menuBar1);

            //======== panelPartida ========
            {
                panelPartida.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
                javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax
                .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
                .awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
                .Color.red),panelPartida. getBorder()));panelPartida. addPropertyChangeListener(new java.beans.
                PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".
                equals(e.getPropertyName()))throw new RuntimeException();}});

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

                GroupLayout panelPartidaLayout = new GroupLayout(panelPartida);
                panelPartida.setLayout(panelPartidaLayout);
                panelPartidaLayout.setHorizontalGroup(
                    panelPartidaLayout.createParallelGroup()
                        .addGroup(panelPartidaLayout.createSequentialGroup()
                            .addGap(184, 184, 184)
                            .addComponent(lblTitulo)
                            .addContainerGap(207, Short.MAX_VALUE))
                        .addGroup(panelPartidaLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(panelPartidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblTirada)
                                .addComponent(fieldTiradas, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                .addComponent(btnComprobartirada, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
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
                                    .addGap(18, 18, 18)
                                    .addComponent(btnComprobartirada))
                                .addComponent(scrollListaTiradas, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 72, Short.MAX_VALUE))
                );
            }
            ContentPanelContentPane.add(panelPartida, "card7");
            ContentPanel.pack();
            ContentPanel.setLocationRelativeTo(ContentPanel.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Alan Rabinerson Aranda
    private JFrame ContentPanel;
    private JMenuBar menuBar1;
    private JMenu menuPartidas;
    private JMenuItem itemNuevaPartida;
    private JMenuItem itemVerPartidas;
    private JPanel panelPartida;
    private JLabel lblTitulo;
    private JTextField fieldTiradas;
    private JLabel lblTirada;
    private JButton btnComprobartirada;
    private JScrollPane scrollListaTiradas;
    private JTextArea areaListaTiradas;
    private JLabel lblListaTiradas;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
