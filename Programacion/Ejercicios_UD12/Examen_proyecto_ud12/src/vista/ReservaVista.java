package vista;

import controlador.ReservaController;
import modelo.Reserva;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ReservaVista extends JFrame {
    private ReservaController controller = new ReservaController();
    private JTable tablaReservas;
    private JComboBox<String> cmbFiltroEstado;

    public ReservaVista() {
        setTitle("Gestión de Reservas");
        setSize(1000, 600);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelFiltros = new JPanel();
        JPanel panelBotones = new JPanel();

        cmbFiltroEstado = new JComboBox<>(new String[]{"Todas", "pendientes", "activas", "devueltas", "canceladas"});
        cmbFiltroEstado.addActionListener(e -> filtrarReservas());
        
        JButton btnAtrasadas = new JButton("Ver Atrasadas");
        btnAtrasadas.addActionListener(e -> mostrarAtrasadas());

        panelFiltros.add(new JLabel("Filtrar por estado:"));
        panelFiltros.add(cmbFiltroEstado);
        panelFiltros.add(btnAtrasadas);

        JButton btnNueva = new JButton("Nueva Reserva");
        JButton btnDevolver = new JButton("Registrar Devolución");
        JButton btnCancelar = new JButton("Cancelar Reserva");
        JButton btnActualizar = new JButton("Actualizar");

        btnNueva.addActionListener(e -> mostrarFormularioReserva());
        btnDevolver.addActionListener(e -> registrarDevolucion());
        btnCancelar.addActionListener(e -> cancelarReserva());
        btnActualizar.addActionListener(e -> actualizarTabla());

        panelBotones.add(btnNueva);
        panelBotones.add(btnDevolver);
        panelBotones.add(btnCancelar);
        panelBotones.add(btnActualizar);

        tablaReservas = new JTable();
        actualizarTabla();

        panelPrincipal.add(panelFiltros, BorderLayout.NORTH);
        panelPrincipal.add(new JScrollPane(tablaReservas), BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);
        setVisible(true);
    }

    private void actualizarTabla() {
        List<Reserva> reservas = controller.obtenerTodasLasReservas();
        mostrarReservasEnTabla(reservas);
        tablaReservas.setAutoCreateRowSorter(true);
    }

    private void mostrarReservasEnTabla(List<Reserva> reservas) {
        String[] columnas = {"ID", "ISBN Libro", "NIE Cliente", "Fecha Inicio", "Fecha Fin", 
                           "Devuelto Tarde", "Fecha Real Fin", "Estado"};
        Object[][] datos = new Object[reservas.size()][columnas.length];

        for (int i = 0; i < reservas.size(); i++) {
            Reserva reserva = reservas.get(i);
            datos[i][0] = reserva.getId();
            datos[i][1] = reserva.getLibroISBN();
            datos[i][2] = reserva.getClienteNIE();
            datos[i][3] = reserva.getFechaInicio();
            datos[i][4] = reserva.getFechaFin();
            datos[i][5] = reserva.isDevueltoTarde() ? "Sí" : "No";
            datos[i][6] = reserva.getFechaRealFin() != null ? reserva.getFechaRealFin() : "N/A";
            datos[i][7] = reserva.getEstado();
        }

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
    }

    private void filtrarReservas() {
        String estado = (String) cmbFiltroEstado.getSelectedItem();
        List<Reserva> reservas;
        
        if (estado.equals("Todas")) {
            reservas = controller.obtenerTodasLasReservas();
        } else {
            reservas = controller.filtrarReservasPorEstado(estado);
        }
        
        mostrarReservasEnTabla(reservas);
    }

    private void mostrarAtrasadas() {
        List<Reserva> reservas = controller.obtenerReservasAtrasadas();
        mostrarReservasEnTabla(reservas);
    }

    private void mostrarFormularioReserva() {
        new ReservaFormulario(this);
    }

    private void registrarDevolucion() {
        int filaSeleccionada = tablaReservas.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int id = (int) tablaReservas.getValueAt(filaSeleccionada, 0);
            boolean devueltoTarde = JOptionPane.showConfirmDialog(this, 
                "¿El libro fue devuelto tarde?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            
            if (controller.registrarDevolucion(id, devueltoTarde)) {
                JOptionPane.showMessageDialog(this, "Devolución registrada");
                actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva");
        }
    }

    private void cancelarReserva() {
        int filaSeleccionada = tablaReservas.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int id = (int) tablaReservas.getValueAt(filaSeleccionada, 0);
            if (controller.cancelarReserva(id)) {
                JOptionPane.showMessageDialog(this, "Reserva cancelada");
                actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva");
        }
    }
}