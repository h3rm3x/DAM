import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

public class Contador {
    private JButton button1;
    private JButton button2;
    private JTextField textField1;

    public Contador() {
        initComponents();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Alan Rabinerson Aranda
        panel1 = new JPanel();
        lblContador = new JLabel();
        txtFldContador = new JTextField();
        var panel2 = new JPanel();
        btnCount = new JButton();
        btnReset = new JButton();

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setForeground(new Color(0xff000a));
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
            EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER ,javax . swing
            . border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,
            java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
            { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )
            throw new RuntimeException( ) ;} } );
            panel1.setLayout(new FormLayout(
                "421px:grow",
                "23px, 32px, default, top:4dlu, [4px,default]"));

            //---- lblContador ----
            lblContador.setFont(lblContador.getFont().deriveFont(Font.BOLD, 20f));
            lblContador.setForeground(Color.black);
            lblContador.setText("Label");
            panel1.add(lblContador, CC.xy(1, 1, CC.CENTER, CC.DEFAULT));
            panel1.add(txtFldContador, new CellConstraints(1, 3, 1, 1, CC.FILL, CC.DEFAULT, new Insets(0, 20, 0, 20)));

            //======== panel2 ========
            {
                panel2.setBackground(Color.white);
                panel2.setLayout(new FlowLayout());

                //---- btnCount ----
                btnCount.setText("Counter");
                panel2.add(btnCount);

                //---- btnReset ----
                btnReset.setText("Reset");
                panel2.add(btnReset);
            }
            panel1.add(panel2, CC.xy(1, 5));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Alan Rabinerson Aranda
    private JPanel panel1;
    private JLabel lblContador;
    private JTextField txtFldContador;
    private JButton btnCount;
    private JButton btnReset;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
