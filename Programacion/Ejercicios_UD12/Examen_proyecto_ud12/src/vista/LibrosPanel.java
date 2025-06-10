package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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
        
        // Modelo de tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ISBN");
        modeloTabla.addColumn("Título");
        modeloTabla.addColumn("Autor");
        modeloTabla.addColumn("Editorial");
        modeloTabla.addColumn("Páginas");
        modeloTabla.addColumn("Género");
        
        // Tabla
        tablaLibros = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaLibros);
        
        // Botones
        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        
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
                libro.getGenero()
            });
        }
    }
}