package vista;

import controlador.ClienteController;
import modelo.Cliente;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class ClienteVista extends JFrame {
    private ClienteController controller = new ClienteController();
    private JTable tablaClientes;
    private JTextField txtBusqueda;

    public ClienteVista() {
        setTitle("Gestión de Clientes");
        setSize(900, 600);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelBusqueda = new JPanel();
        JPanel panelBotones = new JPanel();

        txtBusqueda = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> buscarClientes());

        panelBusqueda.add(new JLabel("Buscar:"));
        panelBusqueda.add(txtBusqueda);
        panelBusqueda.add(btnBuscar);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnRedFlag = new JButton("Marcar/Desmarcar Red Flag");

        btnAgregar.addActionListener(e -> mostrarFormularioCliente(null));
        btnEditar.addActionListener(e -> editarCliente());
        btnEliminar.addActionListener(e -> eliminarCliente());
        btnActualizar.addActionListener(e -> actualizarTabla());
        btnRedFlag.addActionListener(e -> toggleRedFlag());

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnRedFlag);

        tablaClientes = new JTable();
        actualizarTabla();

        panelPrincipal.add(panelBusqueda, BorderLayout.NORTH);
        panelPrincipal.add(new JScrollPane(tablaClientes), BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);
        setVisible(true);
    }

    private void actualizarTabla() {
        List<Cliente> clientes = controller.obtenerTodosLosClientes();
        String[] columnas = {"NIE", "Nombre", "Apellido", "Teléfono", "Fecha Nacimiento", "Email", "Red Flag"};
        Object[][] datos = new Object[clientes.size()][columnas.length];

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            datos[i][0] = cliente.getNIE();
            datos[i][1] = cliente.getNombre();
            datos[i][2] = cliente.getApellido();
            datos[i][3] = cliente.getTelefono();
            datos[i][4] = cliente.getFechaNacimiento().toString();
            datos[i][5] = cliente.getEmail();
            datos[i][6] = cliente.isRedFlag() ? "Sí" : "No";
        }

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
        tablaClientes.setAutoCreateRowSorter(true);
    }

    private void buscarClientes() {
        String busqueda = txtBusqueda.getText();
        List<Cliente> clientes = controller.obtenerTodosLosClientesPorNombre(busqueda);
        // Implementar búsqueda en el controlador
    }

    private void mostrarFormularioCliente(Cliente cliente) {
        new ClienteFormulario(this, cliente);
    }

    private void editarCliente() {
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String nie = (String) tablaClientes.getValueAt(filaSeleccionada, 0);
            Cliente cliente = controller.obtenerClientePorNIE(nie);
            mostrarFormularioCliente(cliente);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente para editar");
        }
    }

    private void eliminarCliente() {
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String nie = (String) tablaClientes.getValueAt(filaSeleccionada, 0);
            if (controller.eliminarCliente(nie)) {
                JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente");
                actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente para eliminar");
        }
    }

    private void toggleRedFlag() {
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String nie = (String) tablaClientes.getValueAt(filaSeleccionada, 0);
            Cliente cliente = controller.obtenerClientePorNIE(nie);
            cliente.setRedFlag(!cliente.isRedFlag());
            if (controller.actualizarCliente(cliente)) {
                JOptionPane.showMessageDialog(this, "Red Flag actualizado");
                actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente");
        }
    }

}