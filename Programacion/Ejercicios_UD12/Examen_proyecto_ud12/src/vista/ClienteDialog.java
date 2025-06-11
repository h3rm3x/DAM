package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import modelo.Cliente;

public class ClienteDialog extends JDialog {
    private JTextField txtNIE;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JTextField txtFechaNacimiento;
    private JTextField txtEmail;
    private JCheckBox chkRedFlag;

    private boolean confirmado = false;
    private Cliente cliente;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ClienteDialog(Frame parent, String title, Cliente cliente) {
        super(parent, title, true);
        this.cliente = cliente;
        initComponents();
        if (cliente != null) {
            cargarDatos();
        }
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setSize(400, 400);
        setLocationRelativeTo(getParent());

        JPanel panelCampos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // NIE
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        panelCampos.add(new JLabel("NIE:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtNIE = new JTextField(20);
        panelCampos.add(txtNIE, gbc);

        // Nombre
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtNombre = new JTextField(20);
        panelCampos.add(txtNombre, gbc);

        // Apellido
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Apellido:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtApellido = new JTextField(20);
        panelCampos.add(txtApellido, gbc);

        // Teléfono
        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Teléfono:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtTelefono = new JTextField(20);
        panelCampos.add(txtTelefono, gbc);

        // Fecha de nacimiento
        gbc.gridx = 0; gbc.gridy = 4; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Fecha Nacimiento (dd/MM/yyyy):"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtFechaNacimiento = new JTextField(20);
        panelCampos.add(txtFechaNacimiento, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy = 5; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtEmail = new JTextField(20);
        panelCampos.add(txtEmail, gbc);

        // Red Flag
        gbc.gridx = 0; gbc.gridy = 6; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Red Flag:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        chkRedFlag = new JCheckBox();
        panelCampos.add(chkRedFlag, gbc);

        // Botones
        JPanel panelBotones = new JPanel();
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        btnGuardar.addActionListener(this::guardar);
        btnCancelar.addActionListener(e -> dispose());

        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        add(panelCampos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void cargarDatos() {
        txtNIE.setText(cliente.getNIE());
        txtNombre.setText(cliente.getNombre());
        txtApellido.setText(cliente.getApellido());
        txtTelefono.setText(cliente.getTelefono());
        txtFechaNacimiento.setText(cliente.getFechaNacimiento().format(formatter));
        txtEmail.setText(cliente.getEmail());
        chkRedFlag.setSelected(cliente.isRedFlag());
    }

    private void guardar(ActionEvent e) {
        try {
            // Validaciones básicas
            if (txtNIE.getText().trim().isEmpty() || txtNombre.getText().trim().isEmpty() ||
                    txtApellido.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "NIE, Nombre y Apellido son campos obligatorios",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar formato NIE (ejemplo básico)
            if (!txtNIE.getText().trim().matches("[0-9]{7,8}[A-Z]")) {
                JOptionPane.showMessageDialog(this, "Formato de NIE inválido",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar fecha
            LocalDate fechaNacimiento;
            try {
                fechaNacimiento = LocalDate.parse(txtFechaNacimiento.getText().trim(), formatter);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use dd/MM/yyyy",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear o actualizar cliente
            if (cliente == null) {
                cliente = new Cliente(
                        txtNIE.getText().trim(),
                        txtNombre.getText().trim(),
                        txtApellido.getText().trim(),
                        txtTelefono.getText().trim(),
                        fechaNacimiento,
                        txtEmail.getText().trim(),
                        chkRedFlag.isSelected()
                );
            } else {
                cliente.setNIE(txtNIE.getText().trim());
                cliente.setNombre(txtNombre.getText().trim());
                cliente.setApellido(txtApellido.getText().trim());
                cliente.setTelefono(txtTelefono.getText().trim());
                cliente.setFechaNacimiento(fechaNacimiento);
                cliente.setEmail(txtEmail.getText().trim());
                cliente.setRedFlag(chkRedFlag.isSelected());
            }

            confirmado = true;
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public Cliente getCliente() {
        return cliente;
    }
}