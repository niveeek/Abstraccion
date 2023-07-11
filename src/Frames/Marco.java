package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public final class Marco extends JFrame {
    private final Toolkit screen = Toolkit.getDefaultToolkit();
    private final String [] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    private final Image iconoPropio = screen.getImage(getClass().getResource("/images/carita.png"));
    private Panel panel;
//    private ColorFondo colorFondo1;
//    private ColorFondo colorFondo2;
    private boolean aprobacionEmail;
    private Marco marco1;
    private Marco marco2;

    public void start() {
        marco1 = new Marco();
        marco2 = new Marco();
        panel = new Panel();
//        setExtendedState(Frame.MAXIMIZED_BOTH);
//        setResizable(false);
        marco1.setBounds(700,300,500,300);
        marco1.setLocationRelativeTo(null);
//        setTitle("Prueba Neto");
        marco1.add(panel);
        marco1.setVisible(true);
        (panel.getBoton1()).addActionListener(new ColorFondo(Color.PINK));
        (panel.getBoton2()).addActionListener(new ColorFondo(Color.YELLOW));
        marco1.addWindowListener(new Window());
        marco1.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                System.out.println("Viejo estado: " + e.getOldState());
                System.out.println("Nuevo estado: " + e.getNewState());
                if (e.getNewState() == Frame.MAXIMIZED_BOTH) System.out.println("Ventana maximizada ambos lados");
            }
        });
        marco1.addKeyListener(new Keys());
        marco1.addMouseListener(new Mouse());
        marco1.addMouseMotionListener(new MouseMotion());
        marco1.addWindowFocusListener(new WindowsFocus());
        (panel.getjTextField()).addFocusListener(new Focus());
        (panel.getjTextField2()).addFocusListener(new Focus());
//        setLayout(new FlowLayout());
        marco1.setIconImage(getIconImage());
        marco1.setIconImage(iconoPropio);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
///////////////////////// M A R C O  2 ///////////////////////////////
        marco2.setBounds(0,0,400,150);
        marco2.setVisible(true);
        marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco2.addWindowFocusListener(new WindowsFocus());
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
//            System.out.println(e.getClickCount());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            short left = InputEvent.BUTTON1_DOWN_MASK;
            short middle = InputEvent.BUTTON2_DOWN_MASK;
            short right = InputEvent.BUTTON3_DOWN_MASK;
//            System.out.println(e.getModifiersEx());
//            System.out.println(left + " " + middle + " " + right);
        }
    }

    private static final class MouseMotion implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
//            System.out.println("Estás arrastrando el mouse");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
//            System.out.println("Has movido el mouse");
        }
    }

    private final class Focus implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("Has perdido el foco");
        }

        @Override
        public void focusLost(FocusEvent e) {
            if(panel.getjTextField().getText().contains("@")){
                aprobacionEmail = true;
                System.out.println("Email correcto");
            } else {
                aprobacionEmail = false;
                System.out.println("Email incorrecto");
            }
        }
    }

    private final class WindowsFocus implements WindowFocusListener{
        @Override
        public void windowGainedFocus(WindowEvent e) {
            if(e.getSource() == marco1){
                marco1.setTitle("Tengo el foco");
            } else {
                marco2.setTitle("Tengo el foco");
            }
        }

        @Override
        public void windowLostFocus(WindowEvent e) {
            if(e.getSource() == marco1){
                marco1.setTitle("");
            } else {
                marco2.setTitle("");
            }
        }
    }
}
