package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import controlador.LibroController;
import controlador.ClienteController;
import modelo.Libro;
import modelo.Cliente;

public class NuevaReservaDialog extends JDialog {
    private JComboBox<String> comboLibros;
    private JComboBox<String> comboClientes;
    private JTextField txtFechaInicio;
    private JTextField txtFechaFin;
    
    private LibroController libroController;
    private ClienteController clienteController;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private boolean confirmado = false;
    private String isbnSeleccionado;
    private String nieSeleccionado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
    public NuevaReservaDialog(Frame parent) {
        super(parent, "Nueva Reserva", true);
        libroController = new LibroController();
        clienteController = new ClienteController();
        initComponents();
        cargarDatos();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        setSize(500, 350);
        setLocationRelativeTo(getParent());
        
        JPanel panelCampos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Libro
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        panelCampos.add(new JLabel("Libro:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        comboLibros = new JComboBox<>();
        panelCampos.add(comboLibros, gbc);
        
        // Cliente
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Cliente:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        comboClientes = new JComboBox<>();
        panelCampos.add(comboClientes, gbc);
        
        // Fecha inicio
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Fecha Inicio (dd/MM/yyyy):"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtFechaInicio = new JTextField(20);
        txtFechaInicio.setText(LocalDate.now().format(formatter));
        panelCampos.add(txtFechaInicio, gbc);
        
        // Fecha fin
        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Fecha Fin (dd/MM/yyyy):"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtFechaFin = new JTextField(20);
        txtFechaFin.setText(LocalDate.now().plusDays(14).format(formatter));
        panelCampos.add(txtFechaFin, gbc);
        
        // Botones
        JPanel panelBotones = new JPanel();
        JButton btnGuardar = new JButton("Crear Reserva");
        JButton btnCancelar = new JButton("Cancelar");
        
        btnGuardar.addActionListener(this::crearReserva);
        btnCancelar.addActionListener(e -> dispose());
        
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        
        add(panelCampos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
    
    private void cargarDatos() {
        // Cargar libros disponibles
        List<Libro> librosDisponibles = libroController.obtenerLibrosDisponibles();
        for (Libro libro : librosDisponibles) {
            comboLibros.addItem(libro.getISBN() + " - " + libro.getTitulo());
        }
        
        // Cargar clientes
        List<Cliente> clientes = clienteController.obtenerTodosLosClientes();
        for (Cliente cliente : clientes) {
            comboClientes.addItem(cliente.getNIE() + " - " + cliente.getNombre() + " " + cliente.getApellido());
        }
    }
    
    private void crearReserva(ActionEvent e) {
        try {
            // Validar selecciones
            if (comboLibros.getSelectedItem() == null || comboClientes.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un libro y un cliente", 
                                            "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Extraer ISBN y NIE
            String libroSeleccionado = (String) comboLibros.getSelectedItem();
            String clienteSeleccionado = (String) comboClientes.getSelectedItem();
            
            isbnSeleccionado = libroSeleccionado.split(" - ")[0];
            nieSeleccionado = clienteSeleccionado.split(" - ")[0];
            
            // Validar fechas
            try {
                fechaInicio = LocalDate.parse(txtFechaInicio.getText().trim(), formatter);
                fechaFin = LocalDate.parse(txtFechaFin.getText().trim(), formatter);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use dd/MM/yyyy", 
                                            "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Validar que la fecha de fin sea posterior a la de inicio
            if (fechaFin.isBefore(fechaInicio) || fechaFin.isEqual(fechaInicio)) {
                JOptionPane.showMessageDialog(this, "La fecha de fin debe ser posterior a la fecha de inicio", 
                                            "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            confirmado = true;
            dispose();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al procesar los datos: " + ex.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean isConfirmado() {
        return confirmado;
    }
    
    public String getIsbnSeleccionado() {
        return isbnSeleccionado;
    }
    
    public String getNieSeleccionado() {
        return nieSeleccionado;
    }
    
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    
    public LocalDate getFechaFin() {
        return fechaFin;
    }
}