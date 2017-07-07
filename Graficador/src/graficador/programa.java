package graficador;

/**
 * @author ema
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class programa extends JFrame {

    public static JButton grafbutton = new JButton("Graficar");
    public static JButton evalbutton = new JButton("Evaluar");
    public static graficador panel3 = new graficador();
    public static JTextField ecufield = new JTextField(), A_field = new JTextField(), B_field = new JTextField();
    public static JMenuBar barra_menu;
    public JMenu menu, submenu;
    public JMenuItem menu_item;
    ActListener actlistener = new ActListener();
    Wheellistener wlistener = new Wheellistener();
    Metodos metod = new Metodos(this, panel3);
    DefaultListModel model_raiz = new DefaultListModel();
    JList list_raiz = new JList(model_raiz);
    DefaultListModel model_ec = new DefaultListModel();
    JList list_ec = new JList(model_ec);
    public static JComboBox combometodo;

    public programa() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel panel2 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        Border border = BorderFactory.createLineBorder(Color.decode("#BEBEBE"));
        Border borde_ec = BorderFactory.createTitledBorder(border, " Ecuacion: ", 0, 0, Font.decode("BOLD"));

        panel2.setBackground(Color.decode("#DCDCDC"));
        panel2.setBorder(border);
        panel3.setBorder(border);
        panel3.addMouseWheelListener(wlistener);
        panel4.setBackground(Color.decode("#DCDCDC"));
        panel4.setBorder(border);
        panel5.setBackground(Color.decode("#DCDCDC"));
        panel5.setBorder(borde_ec);

////////////////////////////////////////Componentes////////////////////////////////////////////////////////////////////		 
        list_raiz.setVisible(true);
        list_ec.setVisible(true);

        evalbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (combometodo.getSelectedItem().equals("Biseccion")) {
                    metod.biseccion(Double.parseDouble(A_field.getText()), Double.parseDouble(B_field.getText()));
                } else {
                    metod.punto_fijo();
                }
            }
        });

        JScrollPane bardesp_raiz = new JScrollPane(list_raiz), bardesp_ec = new JScrollPane(list_ec);
        bardesp_raiz.setPreferredSize(new Dimension(150, 150));
        bardesp_ec.setPreferredSize(new Dimension(150, 150));

        JLabel B_Lab = new JLabel(" hasta "), A_Lab = new JLabel(" Desde ");

        combometodo = new JComboBox();
        combometodo.addItem("Biseccion");
        combometodo.addItem("Punto Fijo");

        ecufield.setPreferredSize(new Dimension(800, 30));
        A_field.setPreferredSize(new Dimension(20, 30));
        B_field.setPreferredSize(new Dimension(20, 30));

        grafbutton.addActionListener(actlistener);

        barra_menu = new JMenuBar();

        menu = new JMenu("Opciones");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("hola");

        menu_item = new JMenuItem("Ayuda", KeyEvent.VK_T);

        menu.add(menu_item);
        submenu = new JMenu("-----");
        menu_item = new JMenuItem("----");
        submenu.add(menu_item);
        menu.add(submenu);
        barra_menu.add(menu);

/////////////////////////////////////////////Contenedores//////////////////////////////////////////////////////////////////////////////	
        panel2.add(bardesp_ec, BorderLayout.CENTER);

        Box caja = Box.createVerticalBox(), caja2 = Box.createHorizontalBox();
        caja.add(bardesp_raiz);
        caja.add(combometodo);
        caja2.add(A_Lab);
        caja2.add(A_field, new FlowLayout());
        caja2.add(B_Lab);
        caja2.add(B_field, new FlowLayout());
        caja.add(caja2);
        caja.add(evalbutton);
        panel4.add(caja);

        panel5.add(ecufield, BorderLayout.WEST);
        panel5.add(grafbutton, BorderLayout.EAST);

        Container contentpane = this.getContentPane();
        contentpane.add(barra_menu, BorderLayout.PAGE_START);
        contentpane.add(panel2, BorderLayout.WEST);
        contentpane.add(panel3, BorderLayout.CENTER);
        contentpane.add(panel4, BorderLayout.EAST);
        contentpane.add(panel5, BorderLayout.PAGE_END);

        this.setVisible(true);
    }

    public static void MensajeError() {
        JOptionPane.showMessageDialog(panel3, "Sintaxis Incorrecta", "Error de Evaluacion", JOptionPane.CLOSED_OPTION);
    }

    public static void actualizargrafica() {
        if (ecufield.getText().length() == 0) {
            panel3.f = false;
        } else {
            panel3.f = true;
        }
        panel3.repaint();
    }

    public static void main(String[] args) {
        programa prog = new programa();
    }

}
