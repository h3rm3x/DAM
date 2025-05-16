import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Fri May 16 17:11:05 CEST 2025
 */



/**
 * @author alanr
 */
public class Dades_Alumnes {
    public Dades_Alumnes() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Alan Rabinerson Aranda
        contentPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();

        //======== contentPanel ========
        {
            contentPanel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
            . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder
            . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .
            awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,contentPanel. getBorder () ) )
            ; contentPanel. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
            ;
            contentPanel.setLayout(null);

            //---- label1 ----
            label1.setText("DADES DE L'ALUMNE");
            contentPanel.add(label1);
            label1.setBounds(new Rectangle(new Point(125, 10), label1.getPreferredSize()));
            contentPanel.add(textField1);
            textField1.setBounds(125, 50, 140, 25);
            contentPanel.add(textField2);
            textField2.setBounds(125, 80, 140, 25);
            contentPanel.add(textField3);
            textField3.setBounds(125, 110, 140, 25);

            //---- label2 ----
            label2.setText("DNI");
            contentPanel.add(label2);
            label2.setBounds(new Rectangle(new Point(80, 55), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("NOMBRE");
            contentPanel.add(label3);
            label3.setBounds(new Rectangle(new Point(60, 85), label3.getPreferredSize()));

            //---- label4 ----
            label4.setText("EDAD");
            contentPanel.add(label4);
            label4.setBounds(new Rectangle(new Point(75, 115), label4.getPreferredSize()));

            //---- label5 ----
            label5.setText("NIVEL");
            contentPanel.add(label5);
            label5.setBounds(new Rectangle(new Point(55, 185), label5.getPreferredSize()));

            //---- radioButton1 ----
            radioButton1.setText("ESO");
            contentPanel.add(radioButton1);
            radioButton1.setBounds(new Rectangle(new Point(130, 155), radioButton1.getPreferredSize()));

            //---- radioButton2 ----
            radioButton2.setText("Bachillerato");
            contentPanel.add(radioButton2);
            radioButton2.setBounds(130, 185, 125, 25);

            //---- radioButton3 ----
            radioButton3.setText("Grado Medio");
            contentPanel.add(radioButton3);
            radioButton3.setBounds(130, 215, 145, 25);

            //---- radioButton4 ----
            radioButton4.setText("Grado Superior");
            contentPanel.add(radioButton4);
            radioButton4.setBounds(130, 245, 140, 25);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                    Rectangle bounds = contentPanel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = contentPanel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                contentPanel.setMinimumSize(preferredSize);
                contentPanel.setPreferredSize(preferredSize);
            }
        }

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        buttonGroup1.add(radioButton3);
        buttonGroup1.add(radioButton4);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Alan Rabinerson Aranda
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
