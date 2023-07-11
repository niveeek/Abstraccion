package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public final class Marco extends JFrame {
    private final Toolkit screen = Toolkit.getDefaultToolkit();
    private final String [] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    private final Image iconoPropio = screen.getImage(getClass().getResource("/images/carita.png"));
    private final Panel panel;
//    private ColorFondo colorFondo1;
//    private ColorFondo colorFondo2;

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
        addKeyListener(new Keys());
        addMouseListener(new Mouse());
        addMouseMotionListener(new MouseMotion());
//        setLayout(new FlowLayout());
        setIconImage(getIconImage());
        setIconImage(iconoPropio);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void getFonts(){
        for(String name : fonts){
            System.out.println(name);
        }
    }

    private final class ColorFondo implements ActionListener {
        private final Color color;

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
                setIconImage(screen.getImage(getClass().getName()));
                (panel.getBoton1()).setEnabled(true);
                (panel.getBoton2()).setEnabled(false);
                panel.setForeground(Color.GRAY);
                panel.setBackground(color);
            }
        }
    }

    private static final class Window extends WindowAdapter {
        @Override
        public void windowIconified(WindowEvent e) {
            System.out.println("Ventana minimizada");
        }
    }
    private static final class Keys implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            char keyLetter = e.getKeyChar();
            System.out.println(keyLetter);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            short keyCode = (short) e.getKeyCode();
            System.out.println(keyCode);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO document why this method is empty
        }
    }

    private static final class Mouse extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
//            System.out.println("X: " + e.getX() + " Y: " + e.getY());
            System.out.println(e.getClickCount());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            short left = InputEvent.BUTTON1_DOWN_MASK;
            short middle = InputEvent.BUTTON2_DOWN_MASK;
            short right = InputEvent.BUTTON3_DOWN_MASK;
//            System.out.println(e.getModifiersEx());
            System.out.println(left + " " + middle + " " + right);
        }
    }

    private static final class MouseMotion implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            System.out.println("Estás arrastrando el mouse");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            System.out.println("Has movido el mouse");
        }
    }
}
