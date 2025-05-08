import javax.swing.*;
import java.awt.*;

public class Calculadora {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        JPanel panel = new JPanel();
        JPanel panelBotones = new JPanel();
        JLabel display = new JLabel("0");

        JButton boton1 = new JButton("1");
        JButton boton2 = new JButton("2");
        JButton boton3 = new JButton("3");
        JButton boton4 = new JButton("4");
        JButton boton5 = new JButton("5");
        JButton boton6 = new JButton("6");
        JButton boton7 = new JButton("7");
        JButton boton8 = new JButton("8");
        JButton boton9 = new JButton("9");
        JButton boton0 = new JButton("0");
        JButton botonSuma = new JButton("+");
        JButton botonResta = new JButton("-");
        JButton botonMultiplicacion = new JButton("x");
        JButton botonDivision = new JButton("/");
        JButton botonIgual = new JButton("=");
        JButton botonLimpiar = new JButton("C");

        panel.add(display);
        panel.add(panelBotones);

        display.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.setLayout(new GridLayout(2, 1));
        panelBotones.setLayout(new GridLayout(4, 4));

        panelBotones.add(boton7);
        panelBotones.add(boton8);
        panelBotones.add(boton9);
        panelBotones.add(botonSuma);
        panelBotones.add(boton4);
        panelBotones.add(boton5);
        panelBotones.add(boton6);
        panelBotones.add(botonResta);
        panelBotones.add(boton3);
        panelBotones.add(boton2);
        panelBotones.add(boton1);
        panelBotones.add(botonMultiplicacion);
        panelBotones.add(boton0);
        panelBotones.add(botonLimpiar);
        panelBotones.add(botonIgual);
        panelBotones.add(botonDivision);



        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);


    }
}