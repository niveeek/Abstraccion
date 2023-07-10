package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public final class Marco extends JFrame {
    private Toolkit screen = Toolkit.getDefaultToolkit();
    private String [] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    private final Image iconoPropio = screen.getImage(getClass().getResource("/images/carita.png"));
    private Panel panel = null;
    private ColorFondo colorFondo1 = null;
    private ColorFondo colorFondo2 = null;
    private Window window = null;

    public Marco() {
        setVisible(true);
//        setExtendedState(Frame.MAXIMIZED_BOTH);
//        setResizable(false);
        setBounds(700,300,500,300);
        setLocationRelativeTo(null);
        setTitle("Prueba Neto");
        panel = new Panel();
        add(panel);
        (panel.getBoton1()).addActionListener(new ColorFondo(Color.PINK));
        (panel.getBoton2()).addActionListener(new ColorFondo(Color.YELLOW));
        addWindowListener(new Window());
        addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                System.out.println("Viejo estado: " + e.getOldState());
                System.out.println("Nuevo estado: " + e.getNewState());
                if (e.getNewState() == Frame.MAXIMIZED_BOTH) System.out.println("Ventana maximizada ambos lados");
            }
        });
//        setLayout(new FlowLayout());
        setIconImage(getIconImage());
        setIconImage(iconoPropio);
        setDefaultCloseOperation(Marco.EXIT_ON_CLOSE);
    }

    public void getFonts(){
        for(String name : fonts){
            System.out.println(name);
        }
    }

    private final class ColorFondo implements ActionListener {
        private Color color = null;

        public ColorFondo(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == (panel.getBoton1())){
                setIconImage(iconoPropio);
                (panel.getBoton1()).setEnabled(false);
                (panel.getBoton2()).setEnabled(true);
                panel.setForeground(Color.WHITE);
                panel.setBackground(color);
            } else if(e.getSource() == (panel.getBoton2())){
                setIconImage(screen.getImage(getClass().getClass().getName()));
                (panel.getBoton1()).setEnabled(true);
                (panel.getBoton2()).setEnabled(false);
                panel.setForeground(Color.GRAY);
                panel.setBackground(color);
            }
        }
    }

    private final class Window extends WindowAdapter {
        @Override
        public void windowIconified(WindowEvent e) {
            System.out.println("Ventana minimizada");
        }
    }
}
