package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        setTitle("Sistema de Biblioteca Pública");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnLibros = new JButton("Gestión de Libros");
        JButton btnClientes = new JButton("Gestión de Clientes");
        JButton btnReservas = new JButton("Gestión de Reservas");
        JButton btnSalir = new JButton("Salir");

        btnLibros.addActionListener(e -> new LibroVista());
        btnClientes.addActionListener(e -> new ClienteVista());
        btnReservas.addActionListener(e -> new ReservaVista());
        btnSalir.addActionListener(e -> System.exit(0));

        panel.add(btnLibros);
        panel.add(btnClientes);
        panel.add(btnReservas);
        panel.add(btnSalir);

        add(panel);
        setVisible(true);
    }


}