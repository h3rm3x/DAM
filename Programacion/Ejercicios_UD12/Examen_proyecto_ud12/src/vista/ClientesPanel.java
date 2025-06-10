package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;
import controlador.ClienteController;
import modelo.Cliente;
import java.util.List;

public class ClientesPanel extends JPanel {
    private JTable tablaClientes;
    private DefaultTableModel modeloTabla;
    private ClienteController clienteController;
    private JTextField txtBusqueda;
    
    public ClientesPanel() {
        clienteController = new ClienteController();
        initComponents();
        cargarDatos();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        
        // Panel superior con búsqueda
        JPanel panelSuperior = new JPanel(new FlowLayout());
        panelSuperior.add(new JLabel("Buscar:"));
        txtBusqueda = new JTextField(20);
        panelSuperior.add(txtBusqueda);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(this::buscarClientes);
        panelSuperior.add(btnBuscar);
        
        // Modelo de tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("NIE");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Fecha Nacimiento");
        modeloTabla.addColumn("Email");
        modeloTabla.addColumn("Red Flag");
        
        // Tabla
        tablaClientes = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaClientes);
        
        // Panel de botones
        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnRedFlag = new JButton("Marcar Red Flag");
        
        btnAgregar.addActionListener(this::mostrarDialogoAgregar);
        btnEditar.addActionListener(this::mostrarDialogoEditar);
        btnEliminar.addActionListener(this::eliminarCliente);
        btnRedFlag.addActionListener(this::marcarRedFlag);
        
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnRedFlag);
        
        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
    
    private void cargarDatos() {
        modeloTabla.setRowCount(0);
        List<Cliente> clientes = clienteController.obtenerTodosLosClientes();
        
        for (Cliente cliente : clientes) {
            modeloTabla.addRow(new Object[]{
                cliente.getNIE(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono(),
                cliente.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                cliente.getEmail(),
                cliente.isRedFlag() ? "Sí" : "No"
            });
        }
    }
    
    private void buscarClientes(ActionEvent e) {
        String busqueda = txtBusqueda.getText().trim();
        if (busqueda.isEmpty()) {
            cargarDatos();
            return;
        }
        
        modeloTabla.setRowCount(0);
        List<Cliente> clientes = clienteController.buscarClientes(busqueda);
        
        for (Cliente cliente : clientes) {
            modeloTabla.addRow(new Object[]{
                cliente.getNIE(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono(),
                cliente.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                cliente.getEmail(),
                cliente.isRedFlag() ? "Sí" : "No"
            });
        }
    }
    
    private void mostrarDialogoAgregar(ActionEvent e) {
        // Implementar diálogo para agregar cliente
        JOptionPane.showMessageDialog(this, "Funcionalidad por implementar");
    }
    
    private void mostrarDialogoEditar(ActionEvent e) {
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente para editar");
            return;
        }
        // Implementar diálogo para editar cliente
        JOptionPane.showMessageDialog(this, "Funcionalidad por implementar");
    }
    
    private void eliminarCliente(ActionEvent e) {
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente para eliminar");
            return;
        }
        
        String nie = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de eliminar el cliente?", 
            "Confirmar eliminación", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirmacion == JOptionPane.YES_OPTION) {
            if (clienteController.eliminarCliente(nie)) {
                cargarDatos();
                JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar cliente");
            }
        }
    }
    
    private void marcarRedFlag(ActionEvent e) {
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente");
            return;
        }
        
        String nie = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        boolean redFlagActual = "Sí".equals(modeloTabla.getValueAt(filaSeleccionada, 6));
        
        if (clienteController.cambiarRedFlag(nie, !redFlagActual)) {
            cargarDatos();
            JOptionPane.showMessageDialog(this, "Red Flag actualizado correctamente");
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar Red Flag");
        }
    }
}