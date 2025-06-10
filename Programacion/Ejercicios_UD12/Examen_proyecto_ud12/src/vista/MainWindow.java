package vista;

import javax.swing.*;

public class MainWindow extends JFrame {
    private JTabbedPane tabbedPane;
    
    public MainWindow() {
        setTitle("Sistema de Gestión de Biblioteca");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Libros", new LibrosPanel());
        tabbedPane.addTab("Clientes", new ClientesPanel());
        tabbedPane.addTab("Reservas", new ReservasPanel());
        
        add(tabbedPane);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow();
            window.setVisible(true);
        });
    }
}