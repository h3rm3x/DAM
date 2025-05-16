
import java.awt.*;
import javax.swing.*;
class Ventana extends JFrame {
    public Ventana(){
        super ("Ejemplo 1");        // El título
        this.getContentPane().setLayout (new GridBagLayout()); // Le ponemos el GridBagLayout

        GridBagConstraints constraints = new GridBagConstraints();
        JTextArea cajaTexto = new JTextArea("Area texto");
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        // El area de texto debe estirarse en ambos sentidos. Ponemos el campo fill.
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1.0;
        this.getContentPane().add (cajaTexto, constraints);
        constraints.weighty = 0.0;

        JButton boton1 = new JButton ("Boton 1");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        // El botón 1 debe ocupar la posición NORTH de su celda
        constraints.anchor = GridBagConstraints.NORTH;
        // El botón 1 no debe estirarse. Habíamos cambiado este valor en el
        // area de texto, asi que lo restauramos.
        constraints.fill = GridBagConstraints.NONE;
        this.getContentPane().add (boton1, constraints);
        // Restauramos valores por defecto
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weighty = 0.0;

        JButton boton2 = new JButton ("Boton 2");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        // El boton 2 debe ocupar la posición NORTH de su celda.
        constraints.anchor = GridBagConstraints.CENTER;
        this.getContentPane().add (boton2, constraints);
        // Restauramos valores por defecto.
        constraints.weighty = 0.0;
        constraints.anchor = GridBagConstraints.CENTER;

        JButton boton3 = new JButton ("Boton 3");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.getContentPane().add (boton3, constraints);

        JButton boton4 = new JButton ("Boton 4");
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.NORTH;
        this.getContentPane().add (boton4, constraints);

        JTextField campoTexto = new JTextField ("Campo texto");
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.insets = new Insets(0, 0, 10, 0);
        // El campo de texto debe estirarse sólo en horizontal.
        constraints.fill = GridBagConstraints.BOTH;
        this.getContentPane().add (campoTexto, constraints);
    }
}