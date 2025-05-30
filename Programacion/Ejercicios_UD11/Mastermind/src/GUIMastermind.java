import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Fri May 30 16:55:35 CEST 2025
 */



/**
 * @author alanr
 */
public class GUIMastermind extends JFrame {
    public GUIMastermind() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Alan Rabinerson Aranda
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label3 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("Partidas");

                //---- menuItem1 ----
                menuItem1.setText("Ver Partidas");
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("Guardar Partidas");
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText("MASTERMIND");
        label1.setFont(new Font("Inter", Font.BOLD, 20));

        //---- label2 ----
        label2.setText("Nueva Tirada");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD));

        //---- button1 ----
        button1.setText("Comprobar");

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setLineWrap(true);
            scrollPane1.setViewportView(textArea1);
        }

        //---- label3 ----
        label3.setText("Lista Tiradas");
        label3.setFont(new Font("Inter", Font.BOLD, 13));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(195, 195, 195)
                    .addComponent(label1)
                    .addContainerGap(196, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
                    .addGap(32, 32, 32))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addGap(62, 62, 62)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(label3))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button1))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Alan Rabinerson Aranda
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
