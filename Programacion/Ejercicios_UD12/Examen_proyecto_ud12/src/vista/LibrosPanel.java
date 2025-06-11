package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import controlador.LibroController;
import modelo.Libro;
import java.util.List;

public class LibrosPanel extends JPanel {
    private JTable tablaLibros;
    private DefaultTableModel modeloTabla;
    private LibroController libroController;

    public LibrosPanel() {
        libroController = new LibroController();
        initComponents();
        cargarDatos();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel superior con búsqueda
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField txtBusqueda = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        JButton btnMostrarTodos = new JButton("Mostrar Todos");

        panelSuperior.add(new JLabel("Buscar:"));
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
        modeloTabla.addColumn("ISBN");
        modeloTabla.addColumn("Título");
        modeloTabla.addColumn("Autor");
        modeloTabla.addColumn("Editorial");
        modeloTabla.addColumn("Páginas");
        modeloTabla.addColumn("Género");
        modeloTabla.addColumn("Año");
        modeloTabla.addColumn("Disponibilidad");

        // Tabla
        tablaLibros = new JTable(modeloTabla);
        tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tablaLibros);

        // Botones
        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar Libro");
        JButton btnEditar = new JButton("Editar Libro");
        JButton btnEliminar = new JButton("Eliminar Libro");

        btnAgregar.addActionListener(this::mostrarDialogoAgregar);
        btnEditar.addActionListener(this::mostrarDialogoEditar);
        btnEliminar.addActionListener(this::eliminarLibro);
        btnBuscar.addActionListener(e -> buscarLibros(txtBusqueda.getText()));
        btnMostrarTodos.addActionListener(e -> cargarDatos());

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);

        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void cargarDatos() {
        modeloTabla.setRowCount(0); // Limpiar tabla
        List<Libro> libros = libroController.obtenerTodosLosLibros();

        for (Libro libro : libros) {
            modeloTabla.addRow(new Object[]{
                    libro.getISBN(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getEditorial(),
                    libro.getPaginas(),
                    libro.getGenero(),
                    libro.getAñoPublicacion(),
                    libro.getDisponibilidad()
            });
        }
    }

    private void buscarLibros(String busqueda) {
        if (busqueda.trim().isEmpty()) {
            cargarDatos();
            return;
        }

        modeloTabla.setRowCount(0);
        List<Libro> libros = libroController.buscarLibros(busqueda);

        for (Libro libro : libros) {
            modeloTabla.addRow(new Object[]{
                    libro.getISBN(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getEditorial(),
                    libro.getPaginas(),
                    libro.getGenero(),
                    libro.getAñoPublicacion(),
                    libro.getDisponibilidad()
            });
        }
    }

    private void mostrarDialogoAgregar(ActionEvent e) {
        LibroDialog dialog = new LibroDialog((Frame) SwingUtilities.getWindowAncestor(this),
                "Agregar Libro", null);
        dialog.setVisible(true);

        if (dialog.isConfirmado()) {
            Libro nuevoLibro = dialog.getLibro();
            if (libroController.agregarLibro(nuevoLibro)) {
                JOptionPane.showMessageDialog(this, "Libro agregado exitosamente",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarDatos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar el libro",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrarDialogoEditar(ActionEvent e) {
        int filaSeleccionada = tablaLibros.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un libro para editar",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String isbn = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        Libro libro = libroController.obtenerLibroPorISBN(isbn);

        if (libro != null) {
            LibroDialog dialog = new LibroDialog((Frame) SwingUtilities.getWindowAncestor(this),
                    "Editar Libro", libro);
            dialog.setVisible(true);

            if (dialog.isConfirmado()) {
                if (libroController.actualizarLibro(dialog.getLibro())) {
                    JOptionPane.showMessageDialog(this, "Libro actualizado exitosamente",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    cargarDatos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el libro",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void eliminarLibro(ActionEvent e) {
        int filaSeleccionada = tablaLibros.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un libro para eliminar",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String isbn = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        String titulo = (String) modeloTabla.getValueAt(filaSeleccionada, 1);

        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de que desea eliminar el libro '" + titulo + "'?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (libroController.eliminarLibro(isbn)) {
                JOptionPane.showMessageDialog(this, "Libro eliminado exitosamente",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarDatos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el libro",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}