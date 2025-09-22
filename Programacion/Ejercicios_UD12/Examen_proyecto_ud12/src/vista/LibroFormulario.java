package vista;

import modelo.Libro;
import javax.swing.*;
import java.awt.*;

public class LibroFormulario extends JDialog {
    private JTextField txtISBN, txtTitulo, txtAutor, txtEditorial, txtPaginas, txtEdicion, txtGenero, txtAño;
    private JComboBox<String> cmbDisponibilidad;
    private Libro libro;

    public LibroFormulario(JFrame parent, Libro libro) {
        super(parent, libro == null ? "Agregar Libro" : "Editar Libro", true);
        this.libro = libro;
        setSize(400, 400);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridLayout(9, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtISBN = new JTextField();
        txtTitulo = new JTextField();
        txtAutor = new JTextField();
        txtEditorial = new JTextField();
        txtPaginas = new JTextField();
        txtEdicion = new JTextField();
        txtGenero = new JTextField();
        txtAño = new JTextField();
        cmbDisponibilidad = new JComboBox<>(new String[]{"available", "unavailable"});

        panel.add(new JLabel("ISBN:"));
        panel.add(txtISBN);
        panel.add(new JLabel("Título:"));
        panel.add(txtTitulo);
        panel.add(new JLabel("Autor:"));
        panel.add(txtAutor);
        panel.add(new JLabel("Editorial:"));
        panel.add(txtEditorial);
        panel.add(new JLabel("Páginas:"));
        panel.add(txtPaginas);
        panel.add(new JLabel("Edición:"));
        panel.add(txtEdicion);
        panel.add(new JLabel("Género:"));
        panel.add(txtGenero);
        panel.add(new JLabel("Año Publicación:"));
        panel.add(txtAño);
        panel.add(new JLabel("Disponibilidad:"));
        panel.add(cmbDisponibilidad);

        if (libro != null) {
            cargarDatosLibro();
        }

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarLibro());

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        add(panel, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void cargarDatosLibro() {
        txtISBN.setText(libro.getISBN());
        txtTitulo.setText(libro.getTitulo());
        txtAutor.setText(libro.getAutor());
        txtEditorial.setText(libro.getEditorial());
        txtPaginas.setText(String.valueOf(libro.getPaginas()));
        txtEdicion.setText(String.valueOf(libro.getEdicion()));
        txtGenero.setText(libro.getGenero());
        txtAño.setText(String.valueOf(libro.getAñoPublicacion()));
        cmbDisponibilidad.setSelectedItem(libro.getDisponibilidad());
    }

    private void guardarLibro() {
        // Implementar lógica para guardar/actualizar libro
    }
}