import javax.swing.*;

public class GUIMastermind_main {
    public static void  main(String[] args) {
        GUIMastermind_diseño mastermind = new GUIMastermind_diseño();
        mastermind.ContentPanel.setVisible(true);
        mastermind.ContentPanel.setSize(800, 500);
        mastermind.ContentPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mastermind.ContentPanel.setTitle("Mastermind");
        mastermind.ContentPanel.setLocationRelativeTo(null);
    }
}
