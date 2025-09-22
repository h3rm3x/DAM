import javax.swing.*;

public class DemoMenu {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu EditMenu = new JMenu("Edit");
        JMenu SourceMenu = new JMenu("Source");


        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");

        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        fileMenu.add(newItem);
        fileMenu.add(openItem);

        EditMenu.add(copyItem);
        EditMenu.add(pasteItem);


        menuBar.add(fileMenu);
        menuBar.add(EditMenu);
        menuBar.add(SourceMenu);

        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);

    }
}
