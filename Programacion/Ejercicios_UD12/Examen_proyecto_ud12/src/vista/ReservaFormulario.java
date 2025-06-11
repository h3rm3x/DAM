package vista;

import controlador.LibroController;
import controlador.ClienteController;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class ReservaFormulario extends JDialog {
    private JComboBox<String> cmbLibros, cmbClientes;
    private JSpinner spnFechaInicio, spnFechaFin;

    public ReservaFormulario(JFrame parent) {
        super(parent, "Nueva Reserva", true);
        setSize(500, 300);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Obtener libros disponibles y clientes
        LibroController libroController = new LibroController();
        ClienteController clienteController = new ClienteController();

        cmbLibros = new JComboBox<>();
        libroController.obtenerLibrosDisponibles().forEach(libro -> 
            cmbLibros.addItem(libro.getISBN() + " - " + libro.getTitulo()));

        cmbClientes = new JComboBox<>();
        clienteController.obtenerTodosLosClientes().forEach(cliente -> 
            cmbClientes.addItem(cliente.getNIE() + " - " + cliente.getNombre() + " " + cliente.getApellido()));

        spnFechaInicio = new JSpinner(new SpinnerDateModel());
        spnFechaInicio.setEditor(new JSpinner.DateEditor(spnFechaInicio, "dd/MM/yyyy"));
        
        spnFechaFin = new JSpinner(new SpinnerDateModel());
        spnFechaFin.setEditor(new JSpinner.DateEditor(spnFechaFin, "dd/MM/yyyy"));

        panel.add(new JLabel("Libro:"));
        panel.add(cmbLibros);
        panel.add(new JLabel("Cliente:"));
        panel.add(cmbClientes);
        panel.add(new JLabel("Fecha Inicio:"));
        panel.add(spnFechaInicio);
        panel.add(new JLabel("Fecha Fin:"));
        panel.add(spnFechaFin);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarReserva());

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        add(panel, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void guardarReserva() {
        // Implementar lógica para guardar reserva
    }
}