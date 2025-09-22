package vista;

import modelo.Cliente;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class ClienteFormulario extends JDialog {
    private JTextField txtNIE, txtNombre, txtApellido, txtTelefono, txtEmail;
    private JComboBox<Integer> cmbDia, cmbMes, cmbAno;
    private JCheckBox chkRedFlag;
    private Cliente cliente;

    public ClienteFormulario(JFrame parent, Cliente cliente) {
        super(parent, cliente == null ? "Agregar Cliente" : "Editar Cliente", true);
        this.cliente = cliente;
        setSize(500, 400);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtNIE = new JTextField();
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtTelefono = new JTextField();
        txtEmail = new JTextField();
        chkRedFlag = new JCheckBox("Red Flag");

        // Configurar combobox para fecha
        JPanel panelFecha = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cmbDia = new JComboBox<>();
        cmbMes = new JComboBox<>();
        cmbAno = new JComboBox<>();
        
        for (int i = 1; i <= 31; i++) cmbDia.addItem(i);
        for (int i = 1; i <= 12; i++) cmbMes.addItem(i);
        for (int i = 1900; i <= LocalDate.now().getYear(); i++) cmbAno.addItem(i);
        
        panelFecha.add(cmbDia);
        panelFecha.add(new JLabel("/"));
        panelFecha.add(cmbMes);
        panelFecha.add(new JLabel("/"));
        panelFecha.add(cmbAno);

        panel.add(new JLabel("NIE:"));
        panel.add(txtNIE);
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Apellido:"));
        panel.add(txtApellido);
        panel.add(new JLabel("Teléfono:"));
        panel.add(txtTelefono);
        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);
        panel.add(new JLabel("Fecha Nacimiento:"));
        panel.add(panelFecha);
        panel.add(new JLabel("Red Flag:"));
        panel.add(chkRedFlag);

        if (cliente != null) {
            cargarDatosCliente();
        }

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarCliente());

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        add(panel, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void cargarDatosCliente() {
        txtNIE.setText(cliente.getNIE());
        txtNombre.setText(cliente.getNombre());
        txtApellido.setText(cliente.getApellido());
        txtTelefono.setText(cliente.getTelefono());
        txtEmail.setText(cliente.getEmail());
        chkRedFlag.setSelected(cliente.isRedFlag());

        LocalDate fecha = cliente.getFechaNacimiento();
        cmbDia.setSelectedItem(fecha.getDayOfMonth());
        cmbMes.setSelectedItem(fecha.getMonthValue());
        cmbAno.setSelectedItem(fecha.getYear());
    }

    private void guardarCliente() {
        // Implementar lógica para guardar/actualizar cliente
    }
}