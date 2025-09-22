import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // Configurar el Look and Feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Crear y mostrar la ventana en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            EX_11_9 ex = new EX_11_9();
            ex.ContentPanel.setVisible(true);
            ex.ContentPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });

    }
}
