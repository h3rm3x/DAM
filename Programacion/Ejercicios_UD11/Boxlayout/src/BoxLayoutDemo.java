import java.awt.Component;
import javax.swing.*;
public class BoxLayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BoxLayoutDemo");
        JPanel pane = (JPanel) frame.getContentPane();
        Box boxContainer = Box.createVerticalBox();
        JButton button = new JButton("Button 1");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        boxContainer.add(button);
        button = new JButton("Button 2");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        boxContainer.add(button);
        boxContainer.add(Box.createVerticalGlue());
        button = new JButton("Button 3");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        boxContainer.add(button);
        button = new JButton("Longer Button 4");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        boxContainer.add(Box.createVerticalStrut(20));
        boxContainer.add(button);
        button = new JButton("Button 5");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        boxContainer.add(button);
        pane.add(boxContainer);
        frame.pack();
        frame.setVisible(true);
    }
}