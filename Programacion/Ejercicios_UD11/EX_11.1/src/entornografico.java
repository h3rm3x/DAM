import javax.swing.*;
import java.awt.*;

public class entornografico {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel =(JPanel) frame.getContentPane();
        JLabel etiqueta = new JLabel("Texto de la etiqueta");
        JButton boton = new JButton("Boton");
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);

        panel.add(etiqueta);
        panel.add(boton);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}