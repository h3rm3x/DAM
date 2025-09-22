import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinestraCaotica extends JFrame {


    private JTextArea outputArea;
    private JTextField inputTextField;



    public FinestraCaotica() {
        initComponents();
        setLocationRelativeTo(null); // Centrar la finestra a la pantalla
    }

    private static void LimpiarCampos(JTextField Campotexto, JTextArea AreaTexto) {
        Campotexto.setText("");
        AreaTexto.setText("");
    }

    private static void procesarTexto(JTextField Campotexto, JTextArea AreaTexto) {
        String textoConsulta = Campotexto.getText();
        if (textoConsulta != null && !textoConsulta.trim().isEmpty()) {
            String respuesta = textoConsulta.toUpperCase() + " - " + textoConsulta.length();
            AreaTexto.append(respuesta + "\n");
        } else {
            JOptionPane.showMessageDialog(null, "Camp buit!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new FinestraCaotica();
    }

    private static class MyActionListener implements ActionListener {

        private final JTextField campotexto;
        private final JTextArea areaTexto;

        public MyActionListener(JTextField campotexto, JTextArea areaTexto) {
            this.campotexto = campotexto;
            this.areaTexto = areaTexto;
        }

        public void actionPerformed(ActionEvent e) {
            LimpiarCampos(campotexto, areaTexto);
        }
    }

    private static class ActionListenerLimpiarCampos implements ActionListener {

        private final JTextField campotexto;
        private final JTextArea areaTexto;

        public ActionListenerLimpiarCampos(JTextField campotexto, JTextArea areaTexto) {
            this.campotexto = campotexto;
            this.areaTexto = areaTexto;
        }

        public void actionPerformed(ActionEvent e) {
            procesarTexto(campotexto, areaTexto);
        }
    }

    public void initComponents() {
        setTitle("Aplicació");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        inputTextField = new JTextField();
        inputTextField.setText("Escriu aquí...");
        panelPrincipal.add(inputTextField, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        JScrollPane Scroll = new JScrollPane(outputArea);
        panelPrincipal.add(Scroll, BorderLayout.CENTER);

        JButton btnProcesar = new JButton("Processar");
        btnProcesar.addActionListener(new ActionListenerLimpiarCampos(inputTextField, outputArea));

        JButton btnLimpiar = new JButton("Netejar");
        btnLimpiar.addActionListener(new MyActionListener(inputTextField, outputArea));

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnProcesar);
        panelBoton.add(btnLimpiar);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        add(panelPrincipal);
        setVisible(true);
    }
}