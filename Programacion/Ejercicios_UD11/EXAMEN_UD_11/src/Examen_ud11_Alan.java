import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/*
 * Created by JFormDesigner on Thu May 29 16:24:29 CEST 2025
 */



/**
 * @author Alan Rabinerson
 */
public class Examen_ud11_Alan {
    public Examen_ud11_Alan() {
        initComponents();
    }

    private void ActionVerCarrito(ActionEvent e) { // al pulsar el item de ver carrito se muestra el panel correspondiente

        panelCarrito.setVisible(true);
        panelAnadirProducto.setVisible(false);
    }

    private void actionAñadirProducto(ActionEvent e) {// al pulsar el item de añadir producto se muestra el panel correspondiente

        panelAnadirProducto.setVisible(true);
        panelCarrito.setVisible(false);
    }

    private void GuardarProducto(ActionEvent e) {// al pulsar el boton se guarda el producto

        try {
            //se comprueba si los campos no estan vacios y si el numero del precio es valido
            if (!(nombreProducto.getText().equals("") && Precio.getText().equals(""))) {
                String nuevoProducto = nombreProducto.getText() + " - " + Double.parseDouble( Precio.getText()) + "€";
                sleccionProductos.addItem(nuevoProducto);
                lblMensajeError.setText("Producto creado correctamente");
                lblMensajeError.setForeground(Color.GREEN);
                nombreProducto.setText("");
                Precio.setText("");
                // si los campos son validos es correcto se muestra un mensaje de confirmacion en verde y se resetean los valores de los campos
            } else { // si hay algun error se muestra el mensaje correspondiente en rojo
                lblMensajeError.setText("ERROR, ingrese un nombre del producto y un precio"); //
                lblMensajeError.setForeground(Color.RED);
            }
        } catch (Exception ex) {
            lblMensajeError.setText("ERROR, introduce un numero valido para el precio");
            lblMensajeError.setForeground(Color.RED);
        }


    }

    private void AnadiraCarrito(ActionEvent e) { // añadimos ele elemnto sleccionado al carrito en cuando se pulsa el boton
        try {
            String productoSeleccionado = sleccionProductos.getSelectedItem().toString().replace(',','.');
            String EtiquetaTotal = lbltotal.getText().replace(',','.');
            // variables que contienen el texto de lblbtotal y el producto seleccionado para evitar repeticion de codigo
            if (contenidoCarrito.getText().isEmpty()) { // comprobamos si el textarea esta vacio para introducir el producto con el formato correcto
                contenidoCarrito.setText(productoSeleccionado);
            }else {
                contenidoCarrito.setText(contenidoCarrito.getText() + "\n" + productoSeleccionado);
            }


            // calculamos el nuevo precio total
            float precioTotal = Float.parseFloat(EtiquetaTotal.substring(EtiquetaTotal.indexOf(": ")+1, EtiquetaTotal.length()-1));
            float precioProducto = Float.parseFloat( productoSeleccionado.substring(productoSeleccionado.indexOf("- ")+2, productoSeleccionado.length()-1));
            precioTotal += precioProducto;

            lbltotal.setText(String.format("%.2f", precioTotal) + "€");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void VaciarCarrito(ActionEvent e) {
        // al pulsar el boton de vaciar el carrito se elimina el contido del textarea y se resetea el valor de la etiqueta total
        contenidoCarrito.setText("");
        lbltotal.setText("0.00€");
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panelPrincipal = new JFrame();
        menuBar1 = new JMenuBar();
        menuGestion = new JMenu();
        itemVerCarrito = new JMenuItem();
        itemAñadirProducto = new JMenuItem();
        panelCarrito = new JPanel();
        sleccionProductos = new JComboBox<>();
        btnAnadiraCarrito = new JButton();
        scrollContenidoCarrito = new JScrollPane();
        contenidoCarrito = new JTextArea();
        lbltotal = new JLabel();
        btnVaciarCarrito = new JButton();
        panelAnadirProducto = new JPanel();
        lblNombreProducto = new JLabel();
        nombreProducto = new JTextField();
        lblPrecio = new JLabel();
        Precio = new JTextField();
        btnGuardarProducto = new JButton();
        lblMensajeError = new JLabel();

        //======== panelPrincipal ========
        {
            var panelPrincipalContentPane = panelPrincipal.getContentPane();
            panelPrincipalContentPane.setLayout(new CardLayout());

            //======== menuBar1 ========
            {

                //======== menuGestion ========
                {
                    menuGestion.setText("Gesti\u00f3n");

                    //---- itemVerCarrito ----
                    itemVerCarrito.setText("Ver Carrito");
                    itemVerCarrito.addActionListener(e -> ActionVerCarrito(e));
                    menuGestion.add(itemVerCarrito);

                    //---- itemAñadirProducto ----
                    itemAñadirProducto.setText("A\u00f1adir Producto");
                    itemAñadirProducto.addActionListener(e -> actionAñadirProducto(e));
                    menuGestion.add(itemAñadirProducto);
                }
                menuBar1.add(menuGestion);
            }
            panelPrincipal.setJMenuBar(menuBar1);

            //======== panelCarrito ========
            {

                //---- sleccionProductos ----
                sleccionProductos.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Pantal\u00f3n - 25,00\u20ac",
                    "Camisa - 35,00\u20ac",
                    "Zapatos - 47,50\u20ac",
                    "Camiseta - 16,00\u20ac"
                }));

                //---- btnAnadiraCarrito ----
                btnAnadiraCarrito.setText("A\u00f1adir al Carrito");
                btnAnadiraCarrito.addActionListener(e -> AnadiraCarrito(e));

                //======== scrollContenidoCarrito ========
                {
                    scrollContenidoCarrito.setViewportView(contenidoCarrito);
                }

                //---- lbltotal ----
                lbltotal.setText("Total: 0.00\u20ac");

                //---- btnVaciarCarrito ----
                btnVaciarCarrito.setText("Vaciar Carrito");
                btnVaciarCarrito.addActionListener(e -> VaciarCarrito(e));

                GroupLayout panelCarritoLayout = new GroupLayout(panelCarrito);
                panelCarrito.setLayout(panelCarritoLayout);
                panelCarritoLayout.setHorizontalGroup(
                    panelCarritoLayout.createParallelGroup()
                        .addGroup(panelCarritoLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(panelCarritoLayout.createParallelGroup()
                                .addComponent(scrollContenidoCarrito)
                                .addGroup(panelCarritoLayout.createSequentialGroup()
                                    .addComponent(sleccionProductos, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAnadiraCarrito, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(20, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, panelCarritoLayout.createSequentialGroup()
                            .addContainerGap(207, Short.MAX_VALUE)
                            .addComponent(lbltotal)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnVaciarCarrito, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
                panelCarritoLayout.setVerticalGroup(
                    panelCarritoLayout.createParallelGroup()
                        .addGroup(panelCarritoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelCarritoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAnadiraCarrito)
                                .addComponent(sleccionProductos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(scrollContenidoCarrito, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelCarritoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbltotal)
                                .addComponent(btnVaciarCarrito))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }
            panelPrincipalContentPane.add(panelCarrito, "card1");

            //======== panelAnadirProducto ========
            {

                //---- lblNombreProducto ----
                lblNombreProducto.setText("Nombre del producto:");

                //---- lblPrecio ----
                lblPrecio.setText("Precio (\u20ac)");

                //---- btnGuardarProducto ----
                btnGuardarProducto.setText("Guardar producto");
                btnGuardarProducto.addActionListener(e -> GuardarProducto(e));

                //---- lblMensajeError ----
                lblMensajeError.setForeground(Color.red);
                lblMensajeError.setText("    ");

                GroupLayout panelAnadirProductoLayout = new GroupLayout(panelAnadirProducto);
                panelAnadirProducto.setLayout(panelAnadirProductoLayout);
                panelAnadirProductoLayout.setHorizontalGroup(
                    panelAnadirProductoLayout.createParallelGroup()
                        .addGroup(panelAnadirProductoLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(panelAnadirProductoLayout.createParallelGroup()
                                .addGroup(panelAnadirProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblPrecio)
                                    .addComponent(lblNombreProducto)
                                    .addComponent(nombreProducto, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(Precio, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                .addComponent(btnGuardarProducto, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelAnadirProductoLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(lblMensajeError, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(17, Short.MAX_VALUE))
                );
                panelAnadirProductoLayout.setVerticalGroup(
                    panelAnadirProductoLayout.createParallelGroup()
                        .addGroup(panelAnadirProductoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblNombreProducto)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nombreProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblPrecio)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Precio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnGuardarProducto)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblMensajeError, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(31, Short.MAX_VALUE))
                );
            }
            panelPrincipalContentPane.add(panelAnadirProducto, "card2");
            panelPrincipal.pack();
            panelPrincipal.setLocationRelativeTo(panelPrincipal.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    public JFrame panelPrincipal;
    private JMenuBar menuBar1;
    private JMenu menuGestion;
    private JMenuItem itemVerCarrito;
    private JMenuItem itemAñadirProducto;
    public JPanel panelCarrito;
    private JComboBox<String> sleccionProductos;
    private JButton btnAnadiraCarrito;
    private JScrollPane scrollContenidoCarrito;
    private JTextArea contenidoCarrito;
    private JLabel lbltotal;
    private JButton btnVaciarCarrito;
    public JPanel panelAnadirProducto;
    private JLabel lblNombreProducto;
    private JTextField nombreProducto;
    private JLabel lblPrecio;
    private JTextField Precio;
    private JButton btnGuardarProducto;
    private JLabel lblMensajeError;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
