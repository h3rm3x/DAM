package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import controlador.ClienteController;
import modelo.Cliente;
import org.mariadb.jdbc.Connection;

import java.util.List;

public class ClientesPanel extends JPanel {
    private JTable tablaClientes;
    private DefaultTableModel modeloTabla;
    private ClienteController clienteController;
    private JTextField txtBusqueda;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ClientesPanel() {
        clienteController = new ClienteController();
        initComponents();
        cargarDatos();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel superior con búsqueda
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtBusqueda = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        JButton btnMostrarTodos = new JButton("Mostrar Todos");

        panelSuperior.add(new JLabel("Buscar Cliente:"));
        panelSuperior.add(txtBusqueda);
        panelSuperior.add(btnBuscar);
        panelSuperior.add(btnMostrarTodos);

        // Modelo de tabla
        modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla no editable
            }
        };
        modeloTabla.addColumn("NIE");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Fecha Nacimiento");
        modeloTabla.addColumn("Email");
        modeloTabla.addColumn("Red Flag");

        // Tabla
        tablaClientes = new JTable(modeloTabla);
        tablaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tablaClientes);

        // Botones
        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar Cliente");
        JButton btnEditar = new JButton("Editar Cliente");
        JButton btnEliminar = new JButton("Eliminar Cliente");
        JButton btnRedFlag = new JButton("Cambiar Red Flag");

        btnAgregar.addActionListener(this::mostrarDialogoAgregar);
        btnEditar.addActionListener(this::mostrarDialogoEditar);
        btnEliminar.addActionListener(this::eliminarCliente);
        btnRedFlag.addActionListener(this::marcarRedFlag);
        btnBuscar.addActionListener(this::buscarClientes);
        btnMostrarTodos.addActionListener(e -> cargarDatos());

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnRedFlag);

        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void cargarDatos() {
        modeloTabla.setRowCount(0); // Limpiar tabla
        List<Cliente> clientes = clienteController.obtenerTodosLosClientes();

        for (Cliente cliente : clientes) {
            modeloTabla.addRow(new Object[]{
                    cliente.getNIE(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getTelefono(),
                    cliente.getFechaNacimiento().format(formatter),
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
                    cliente.getFechaNacimiento().format(formatter),
                    cliente.getEmail(),
                    cliente.isRedFlag() ? "Sí" : "No"
            });
        }
    }

    private void mostrarDialogoAgregar(ActionEvent e) {
        ClienteDialog dialog = new ClienteDialog(
                (Frame) SwingUtilities.getWindowAncestor(this),
                "Agregar Cliente",
                null
        );
        dialog.setVisible(true);

        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, seleccione un cliente para editar",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (dialog.isConfirmado()) {
            Cliente nuevoCliente = dialog.getCliente();
            if (clienteController.agregarCliente(nuevoCliente)) {
                JOptionPane.showMessageDialog(this,
                        "Cliente agregado exitosamente",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                cargarDatos();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Error al agregar el cliente. Verifique que el NIE no esté duplicado.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrarDialogoEditar(ActionEvent e) {
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, seleccione un cliente para editar",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String nie = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        Cliente cliente = clienteController.obtenerClientePorNIE(nie);

        if (cliente != null) {
            ClienteDialog dialog = new ClienteDialog(
                    (Frame) SwingUtilities.getWindowAncestor(this),
                    "Editar Cliente",
                    cliente
            );
            dialog.setVisible(true);

            if (dialog.isConfirmado()) {
                Cliente clienteEditado = dialog.getCliente();
                if (clienteController.actualizarCliente(clienteEditado)) {
                    JOptionPane.showMessageDialog(this,
                            "Cliente actualizado exitosamente",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                    cargarDatos();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Error al actualizar el cliente",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "No se pudo cargar la información del cliente",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarCliente(ActionEvent e) {
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, seleccione un cliente para eliminar",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String nie = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        String nombre = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
        String apellido = (String) modeloTabla.getValueAt(filaSeleccionada, 2);

        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de que desea eliminar el cliente '" + nombre + " " + apellido + "'?\n" +
                        "Esta acción no se puede deshacer.",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (clienteController.eliminarCliente(nie)) {
                JOptionPane.showMessageDialog(this,
                        "Cliente eliminado exitosamente",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                cargarDatos();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Error al eliminar el cliente. Es posible que tenga reservas activas.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void marcarRedFlag(ActionEvent e) {
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, seleccione un cliente para cambiar el Red Flag",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String nie = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        String nombre = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
        String apellido = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
        String redFlagActual = (String) modeloTabla.getValueAt(filaSeleccionada, 6);

        boolean redFlagNuevo = !redFlagActual.equals("Sí");
        String mensaje = redFlagNuevo ?
                "¿Desea marcar al cliente '" + nombre + " " + apellido + "' con Red Flag?" :
                "¿Desea quitar el Red Flag del cliente '" + nombre + " " + apellido + "'?";

        int confirmacion = JOptionPane.showConfirmDialog(this,
                mensaje,
                "Confirmar cambio de Red Flag",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (clienteController.cambiarRedFlag(nie, redFlagNuevo)) {
                String mensajeExito = redFlagNuevo ?
                        "Red Flag activado exitosamente" :
                        "Red Flag desactivado exitosamente";
                JOptionPane.showMessageDialog(this,
                        mensajeExito,
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                cargarDatos();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Error al cambiar el Red Flag",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void closeResources(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar ResultSet: " + e.getMessage());
        }
        
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar Statement: " + e.getMessage());
        }
        
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar Connection: " + e.getMessage());
        }
    }
}