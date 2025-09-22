import javax.swing.*;
import java.awt.*;

public class DiseñoFlowlayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Diseño FlowLayout");
        JPanel panel = new JPanel();
        JLabel etiquetaContador = new JLabel("contador");
        JTextField contador = new JTextField(1);
        ButtonGroup UpDown = new ButtonGroup();
        JRadioButton Up = new JRadioButton("Up");
        JRadioButton Down = new JRadioButton("Down");
        JLabel etiquetaCombo = new JLabel("Step");
        JComboBox<String> comboBox = new JComboBox<>();
        JButton botonContar = new JButton("Count");
        UpDown.add(Up);
        UpDown.add(Down);
        panel.add(etiquetaContador);
        panel.add(contador);
        panel.add(Up);
        panel.add(Down);
        panel.add(etiquetaCombo);
        panel.add(comboBox);
        panel.add(botonContar);
        comboBox.addItem("1");
        comboBox.addItem("2");
        comboBox.addItem("3");

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        panel.setLayout(new FlowLayout());




    }

}