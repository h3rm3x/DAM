import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("BorderLayoutDemo");
        JPanel pane = (JPanel) frame.getContentPane();
        pane.setLayout(new BorderLayout());

        JButton button = new JButton("Button 1 (PAGE_START)");
        pane.add(button, BorderLayout.PAGE_START);

        //Make the center component big, since that's the
        //typical usage of BorderLayout.
        JPanel centerPanel = new JPanel();
        button = new JButton("Central 1");
        button.setPreferredSize(new Dimension(100, 20));
        centerPanel.add(button, BorderLayout.CENTER);
        button = new JButton("Central 2");
        button.setPreferredSize(new Dimension(100, 20));
        centerPanel.add(button, BorderLayout.CENTER);
        button = new JButton("Central 3");
        button.setPreferredSize(new Dimension(100, 20));
        centerPanel.add(button, BorderLayout.CENTER);
        button = new JButton("Central 4");
        button.setPreferredSize(new Dimension(100, 20));
        centerPanel.add(button, BorderLayout.CENTER);
        button = new JButton("Central 5");
        button.setPreferredSize(new Dimension(100, 20));
        centerPanel.add(button, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(5, 1));
        pane.add(centerPanel, BorderLayout.CENTER);

        button = new JButton("Button 3 (LINE_START)");
        pane.add(button, BorderLayout.LINE_START);

        button = new JButton("Long-Named Button 4 (PAGE_END)");
        pane.add(button, BorderLayout.PAGE_END);

        button = new JButton("5 (LINE_END)");
        pane.add(button, BorderLayout.LINE_END);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

