package vista;

import controlador.LibroController;
import modelo.Libro;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LibroVista extends JFrame {
    private LibroController controller = new LibroController();
    private JTable tablaLibros;
    private JTextField txtBusqueda;

    public LibroVista() {
        setTitle("Gestión de Libros");
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelBusqueda = new JPanel();
        JPanel panelBotones = new JPanel();

        txtBusqueda = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> buscarLibros());

        panelBusqueda.add(new JLabel("Buscar:"));
        panelBusqueda.add(txtBusqueda);
        panelBusqueda.add(btnBuscar);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnActualizar = new JButton("Actualizar");

        btnAgregar.addActionListener(e -> mostrarFormularioLibro(null));
        btnEditar.addActionListener(e -> editarLibro());
        btnEliminar.addActionListener(e -> eliminarLibro());
        btnActualizar.addActionListener(e -> actualizarTabla());

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnActualizar);

        tablaLibros = new JTable();
        actualizarTabla();

        panelPrincipal.add(panelBusqueda, BorderLayout.NORTH);
        panelPrincipal.add(new JScrollPane(tablaLibros), BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);
        setVisible(true);
    }

    private void actualizarTabla() {
        List<Libro> libros = controller.obtenerTodosLosLibros();
        String[] columnas = {"ISBN", "Título", "Autor", "Editorial", "Páginas", "Edición", "Género", "Año", "Disponibilidad"};
        Object[][] datos = new Object[libros.size()][columnas.length];

        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            datos[i][0] = libro.getISBN();
            datos[i][1] = libro.getTitulo();
            datos[i][2] = libro.getAutor();
            datos[i][3] = libro.getEditorial();
            datos[i][4] = libro.getPaginas();
            datos[i][5] = libro.getEdicion();
            datos[i][6] = libro.getGenero();
            datos[i][7] = libro.getAñoPublicacion();
            datos[i][8] = libro.getDisponibilidad();
        }

        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
        tablaLibros.setAutoCreateRowSorter(true);
    }

    private void buscarLibros() {
        String busqueda = txtBusqueda.getText();
        List<Libro> libros = controller.buscarLibros(busqueda);
        // Actualizar tabla con resultados...
    }

    private void mostrarFormularioLibro(Libro libro) {
        new LibroFormulario(this, libro);
    }

    private void editarLibro() {
        int filaSeleccionada = tablaLibros.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String isbn = (String) tablaLibros.getValueAt(filaSeleccionada, 0);
            Libro libro = controller.obtenerLibroPorISBN(isbn);
            mostrarFormularioLibro(libro);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para editar");
        }
    }

    private void eliminarLibro() {
        int filaSeleccionada = tablaLibros.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String isbn = (String) tablaLibros.getValueAt(filaSeleccionada, 0);
            if (controller.eliminarLibro(isbn)) {
                JOptionPane.showMessageDialog(this, "Libro eliminado correctamente");
                actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para eliminar");
        }
    }
}