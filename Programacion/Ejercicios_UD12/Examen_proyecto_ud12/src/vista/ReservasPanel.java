package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import controlador.ReservaController;
import controlador.LibroController;
import controlador.ClienteController;
import modelo.Reserva;

public class ReservasPanel extends JPanel {
    private JTable tablaReservas;
    private DefaultTableModel modeloTabla;
    private ReservaController reservaController;
    private LibroController libroController;
    private ClienteController clienteController;
    private JComboBox<String> comboEstado;
    
    public ReservasPanel() {
        reservaController = new ReservaController();
        libroController = new LibroController();
        clienteController = new ClienteController();
        initComponents();
        cargarDatos();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        
        // Modelo de tabla
        modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Libro (ISBN)");
        modeloTabla.addColumn("Cliente (NIE)");
        modeloTabla.addColumn("Fecha Inicio");
        modeloTabla.addColumn("Fecha Fin");
        modeloTabla.addColumn("Devuelto");
        modeloTabla.addColumn("Estado");
        
        // Tabla
        tablaReservas = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaReservas);
        
        // Panel de filtros
        JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT));
        comboEstado = new JComboBox<>(new String[]{"Todas", "Pendientes", "Recogidas", "Devueltas"});
        comboEstado.addActionListener(this::filtrarReservas);
        
        JButton btnHoy = new JButton("Reservas de Hoy");
        btnHoy.addActionListener(this::filtrarReservasHoy);
        
        JButton btnAtrasadas = new JButton("Reservas Atrasadas");
        btnAtrasadas.addActionListener(this::filtrarReservasAtrasadas);
        
        panelFiltros.add(new JLabel("Filtrar por estado:"));
        panelFiltros.add(comboEstado);
        panelFiltros.add(btnHoy);
        panelFiltros.add(btnAtrasadas);
        
        // Panel de botones
        JPanel panelBotones = new JPanel();
        JButton btnNueva = new JButton("Nueva Reserva");
        btnNueva.addActionListener(this::mostrarDialogoNuevaReserva);
        
        JButton btnRegistrarDevolucion = new JButton("Registrar Devolución");
        btnRegistrarDevolucion.addActionListener(this::registrarDevolucion);
        
        JButton btnCancelar = new JButton("Cancelar Reserva");
        btnCancelar.addActionListener(this::cancelarReserva);
        
        panelBotones.add(btnNueva);
        panelBotones.add(btnRegistrarDevolucion);
        panelBotones.add(btnCancelar);
        
        add(panelFiltros, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
    
    private void cargarDatos() {
        modeloTabla.setRowCount(0);
        reservaController.obtenerTodasLasReservas().forEach(reserva -> {
            modeloTabla.addRow(new Object[]{
                reserva.getId(),
                reserva.getLibroISBN(),
                reserva.getClienteNIE(),
                reserva.getFechaInicio().format(DateTimeFormatter.ISO_LOCAL_DATE),
                reserva.getFechaFin().format(DateTimeFormatter.ISO_LOCAL_DATE),
                reserva.isDevueltoTarde() ? "Sí" : "No",
                reserva.getEstado()
            });
        });
    }
    
    private void filtrarReservas(ActionEvent e) {
        String estado = (String) comboEstado.getSelectedItem();
        if (estado.equals("Todas")) {
            cargarDatos();
            return;
        }
        
        modeloTabla.setRowCount(0);
        reservaController.filtrarReservasPorEstado(estado.toLowerCase()).forEach(reserva -> {
            modeloTabla.addRow(new Object[]{
                reserva.getId(),
                reserva.getLibroISBN(),
                reserva.getClienteNIE(),
                reserva.getFechaInicio().format(DateTimeFormatter.ISO_LOCAL_DATE),
                reserva.getFechaFin().format(DateTimeFormatter.ISO_LOCAL_DATE),
                reserva.isDevueltoTarde() ? "Sí" : "No",
                reserva.getEstado()
            });
        });
    }
    
    private void filtrarReservasHoy(ActionEvent e) {
        modeloTabla.setRowCount(0);
        reservaController.obtenerReservasDeHoy().forEach(reserva -> {
            modeloTabla.addRow(new Object[]{
                reserva.getId(),
                reserva.getLibroISBN(),
                reserva.getClienteNIE(),
                reserva.getFechaInicio().format(DateTimeFormatter.ISO_LOCAL_DATE),
                reserva.getFechaFin().format(DateTimeFormatter.ISO_LOCAL_DATE),
                reserva.isDevueltoTarde() ? "Sí" : "No",
                reserva.getEstado()
            });
        });
    }
    
    private void filtrarReservasAtrasadas(ActionEvent e) {
        modeloTabla.setRowCount(0);
        reservaController.obtenerReservasAtrasadas().forEach(reserva -> {
            modeloTabla.addRow(new Object[]{
                reserva.getId(),
                reserva.getLibroISBN(),
                reserva.getClienteNIE(),
                reserva.getFechaInicio().format(DateTimeFormatter.ISO_LOCAL_DATE),
                reserva.getFechaFin().format(DateTimeFormatter.ISO_LOCAL_DATE),
                "Sí", // Todas están atrasadas
                reserva.getEstado()
            });
        });
    }
    
    private void mostrarDialogoNuevaReserva(ActionEvent e) {
        JDialog dialogo = new JDialog();
        dialogo.setTitle("Nueva Reserva");
        dialogo.setModal(true);
        dialogo.setSize(500, 300);
        dialogo.setLayout(new GridLayout(0, 2, 5, 5));
        
        // ComboBox para libros disponibles
        JComboBox<String> comboLibros = new JComboBox<>();
        libroController.obtenerLibrosDisponibles().forEach(libro -> {
            comboLibros.addItem(libro.getISBN() + " - " + libro.getTitulo());
        });
        
        // ComboBox para clientes
        JComboBox<String> comboClientes = new JComboBox<>();
        clienteController.obtenerTodosLosClientes().forEach(cliente -> {
            comboClientes.addItem(cliente.getNIE() + " - " + cliente.getNombre() + " " + cliente.getApellido());
        });
        
        JTextField txtFechaInicio = new JTextField(LocalDate.now().toString());
        JTextField txtFechaFin = new JTextField(LocalDate.now().plusDays(7).toString());
        
        dialogo.add(new JLabel("Libro:"));
        dialogo.add(comboLibros);
        dialogo.add(new JLabel("Cliente:"));
        dialogo.add(comboClientes);
        dialogo.add(new JLabel("Fecha Inicio (YYYY-MM-DD):"));
        dialogo.add(txtFechaInicio);
        dialogo.add(new JLabel("Fecha Fin (YYYY-MM-DD):"));
        dialogo.add(txtFechaFin);
        
        JButton btnGuardar = new JButton("Guardar Reserva");
        btnGuardar.addActionListener(ev -> {
            try {
                String libroSeleccionado = (String) comboLibros.getSelectedItem();
                String isbn = libroSeleccionado.split(" - ")[0];
                
                String clienteSeleccionado = (String) comboClientes.getSelectedItem();
                String nie = clienteSeleccionado.split(" - ")[0];
                
                LocalDate fechaInicio = LocalDate.parse(txtFechaInicio.getText());
                LocalDate fechaFin = LocalDate.parse(txtFechaFin.getText());
                
                if (reservaController.crearReserva(isbn, nie, fechaInicio, fechaFin)) {
                    JOptionPane.showMessageDialog(dialogo, "Reserva creada con éxito");
                    dialogo.dispose();
                    cargarDatos();
                } else {
                    JOptionPane.showMessageDialog(dialogo, "Error al crear reserva", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialogo, "Error en los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        dialogo.add(new JLabel());
        dialogo.add(btnGuardar);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }
    
    private void registrarDevolucion(ActionEvent e) {
        int filaSeleccionada = tablaReservas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int idReserva = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
        
        // Preguntar si se devolvió tarde
        int opcion = JOptionPane.showConfirmDialog(
            this, 
            "¿El libro fue devuelto tarde?", 
            "Registrar Devolución", 
            JOptionPane.YES_NO_OPTION
        );
        
        boolean devueltoTarde = (opcion == JOptionPane.YES_OPTION);
        
        if (reservaController.registrarDevolucion(idReserva, devueltoTarde)) {
            JOptionPane.showMessageDialog(this, "Devolución registrada con éxito");
            cargarDatos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar devolución", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cancelarReserva(ActionEvent e) {
        int filaSeleccionada = tablaReservas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int idReserva = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
        int confirmacion = JOptionPane.showConfirmDialog(
            this, 
            "¿Está seguro de cancelar esta reserva?", 
            "Confirmar Cancelación", 
            JOptionPane.YES_NO_OPTION
        );
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            if (reservaController.cancelarReserva(idReserva)) {
                JOptionPane.showMessageDialog(this, "Reserva cancelada con éxito");
                cargarDatos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al cancelar reserva", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}