import javax.swing.*;
import java.awt.*;

public class Ventana {

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setTitle("GridBagLayoutDemo");
        JPanel panel = new JPanel();
        ventana.setSize(400, 300);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Configuración común para todos los componentes
        c.fill = GridBagConstraints.BOTH;

        // Boton 1 (arriba a la izquierda)
        JButton boton1 = new JButton("Boton 1");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.2;
        panel.add(boton1, c);

        // Campo de texto (centro superior)
        JTextField campoTexto = new JTextField();
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;  // Ocupa solo 1 columna (antes era 2)

        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(campoTexto, c);

        // Boton 4 (a la derecha del campo de texto)
        JButton boton4 = new JButton("Boton 4");
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.2;

         // Menos espacio para el botón
        panel.add(boton4, c);

        // Boton 2 (debajo de Boton 1)
        JButton boton2 = new JButton("Boton 2");
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.2;
        c.weighty = 0.5;
        panel.add(boton2, c);

        // Area texto (grande, a la derecha de Boton 2 y 3)
        JTextArea areaTexto = new JTextArea();
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 23;  // Ocupa 2 columnas (debajo del campo y botón 4)
        c.gridheight = 2;
        c.weightx = 0.8;
        c.weighty = 1.0;
        panel.add(scrollPane, c);

        // Boton 3 (debajo de Boton 2)
        JButton boton3 = new JButton("Boton 3");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.weightx = 0.2;
        c.weighty = 0.5;
        panel.add(boton3, c);

        ventana.add(panel);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}