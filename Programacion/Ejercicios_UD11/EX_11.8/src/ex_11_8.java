import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * @author alanr
 */
public class ex_11_8 extends JFrame {
    public ex_11_8() {
        initComponents();
    }

    private void calcularTemperatura(ActionEvent e) {
        double Celsius = Double.parseDouble(textCelcius.getText());
        double fahrenheit = (Celsius * 9 / 5) + 32;
        textFarenheit.setText(String.valueOf(fahrenheit));
    }


    private  void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Alan Rabinerson Aranda
        label1 = new JLabel();
        textCelcius = new JTextField();
        lblCelcius = new JLabel();
        label3 = new JLabel();
        textFarenheit = new JTextField();
        lblFarenheit = new JLabel();
        btnCalcular = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label1 ----
        label1.setText("Cambiar de Celcius  a Farenheit");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));
        contentPane.add(label1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 10), 0, 0));
        contentPane.add(textCelcius, new GridBagConstraints(1, 1, 1, 1, -1.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 10), 0, 0));

        //---- lblCelcius ----
        lblCelcius.setText("\u00baC");
        contentPane.add(lblCelcius, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- label3 ----
        label3.setText("Son");
        contentPane.add(label3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 10), 0, 0));

        //---- textFarenheit ----
        textFarenheit.setEditable(false);
        textFarenheit.setEnabled(false);
        contentPane.add(textFarenheit, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 10), 0, 0));

        //---- lblFarenheit ----
        lblFarenheit.setText("\u00baF");
        contentPane.add(lblFarenheit, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- btnCalcular ----
        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(e -> calcularTemperatura(e));
        contentPane.add(btnCalcular, new GridBagConstraints(1, 4, 1, 1, -0.5, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 10), 0, 0));
        setSize(295, 215);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        btnCalcular.addActionListener(e -> calcularTemperatura(e));


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Alan Rabinerson Aranda
    private JLabel label1;
    private JTextField textCelcius;
    private JLabel lblCelcius;
    private JLabel label3;
    private JTextField textFarenheit;
    private JLabel lblFarenheit;
    private JButton btnCalcular;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
