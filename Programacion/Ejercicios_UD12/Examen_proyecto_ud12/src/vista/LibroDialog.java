package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Libro;

public class LibroDialog extends JDialog {
    private JTextField txtISBN;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtEditorial;
    private JTextField txtPaginas;
    private JTextField txtEdicion;
    private JTextField txtGenero;
    private JTextField txtAñoPublicacion;
    private JComboBox<String> comboDisponibilidad;

    private boolean confirmado = false;
    private Libro libro;

    public LibroDialog(Frame parent, String title, Libro libro) {
        super(parent, title, true);
        this.libro = libro;
        initComponents();
        if (libro != null) {
            cargarDatos();
        }
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setSize(400, 500);
        setLocationRelativeTo(getParent());

        JPanel panelCampos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // ISBN
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        panelCampos.add(new JLabel("ISBN:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtISBN = new JTextField(20);
        panelCampos.add(txtISBN, gbc);

        // Título
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Título:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtTitulo = new JTextField(20);
        panelCampos.add(txtTitulo, gbc);

        // Autor
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Autor:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtAutor = new JTextField(20);
        panelCampos.add(txtAutor, gbc);

        // Editorial
        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Editorial:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtEditorial = new JTextField(20);
        panelCampos.add(txtEditorial, gbc);

        // Páginas
        gbc.gridx = 0; gbc.gridy = 4; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Páginas:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtPaginas = new JTextField(20);
        panelCampos.add(txtPaginas, gbc);

        // Edición
        gbc.gridx = 0; gbc.gridy = 5; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Edición:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtEdicion = new JTextField(20);
        panelCampos.add(txtEdicion, gbc);

        // Género
        gbc.gridx = 0; gbc.gridy = 6; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Género:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtGenero = new JTextField(20);
        panelCampos.add(txtGenero, gbc);

        // Año de publicación
        gbc.gridx = 0; gbc.gridy = 7; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Año de Publicación:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtAñoPublicacion = new JTextField(20);
        panelCampos.add(txtAñoPublicacion, gbc);

        // Disponibilidad
        gbc.gridx = 0; gbc.gridy = 8; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        panelCampos.add(new JLabel("Disponibilidad:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        comboDisponibilidad = new JComboBox<>(new String[]{"available", "borrowed", "reserved"});
        panelCampos.add(comboDisponibilidad, gbc);

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
        txtISBN.setText(libro.getISBN());
        txtTitulo.setText(libro.getTitulo());
        txtAutor.setText(libro.getAutor());
        txtEditorial.setText(libro.getEditorial());
        txtPaginas.setText(String.valueOf(libro.getPaginas()));
        txtEdicion.setText(String.valueOf(libro.getEdicion()));
        txtGenero.setText(libro.getGenero());
        txtAñoPublicacion.setText(String.valueOf(libro.getAñoPublicacion()));
        comboDisponibilidad.setSelectedItem(libro.getDisponibilidad());
    }

    private void guardar(ActionEvent e) {
        try {
            // Validaciones básicas
            if (txtISBN.getText().trim().isEmpty() || txtTitulo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ISBN y Título son campos obligatorios",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear o actualizar libro
            if (libro == null) {
                libro = new Libro(
                        txtISBN.getText().trim(),
                        txtTitulo.getText().trim(),
                        txtAutor.getText().trim(),
                        txtEditorial.getText().trim(),
                        Integer.parseInt(txtPaginas.getText().trim()),
                        Integer.parseInt(txtEdicion.getText().trim()),
                        txtGenero.getText().trim(),
                        Integer.parseInt(txtAñoPublicacion.getText().trim()),
                        (String) comboDisponibilidad.getSelectedItem()
                );
            } else {
                libro.setISBN(txtISBN.getText().trim());
                libro.setTitulo(txtTitulo.getText().trim());
                libro.setAutor(txtAutor.getText().trim());
                libro.setEditorial(txtEditorial.getText().trim());
                libro.setPaginas(Integer.parseInt(txtPaginas.getText().trim()));
                libro.setEdicion(Integer.parseInt(txtEdicion.getText().trim()));
                libro.setGenero(txtGenero.getText().trim());
                libro.setAñoPublicacion(Integer.parseInt(txtAñoPublicacion.getText().trim()));
                libro.setDisponibilidad((String) comboDisponibilidad.getSelectedItem());
            }

            confirmado = true;
            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public Libro getLibro() {
        return libro;
    }
}