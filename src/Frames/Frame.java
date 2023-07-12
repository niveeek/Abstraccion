package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public final class Frame extends JFrame {
    private final Toolkit screen = Toolkit.getDefaultToolkit();
    private final String [] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    private final Image iconoPropio = screen.getImage(getClass().getResource("/images/carita.png"));
    private Panel panel;
    private Frame frame1, frame2;
    private static int counter = 0;

    public void start() {
        frame1 = new Frame();
        frame2 = new Frame();
        panel = new Panel();
//        marco1.setExtendedState(Frame.MAXIMIZED_BOTH);
//        marco1.setResizable(false);
        frame1.setBounds(700,300,500,300);
        frame1.setLocationRelativeTo(null);
        frame1.add(panel);
        frame1.setVisible(true);
        (panel.getBoton1()).addActionListener(new IconWindow());
        (panel.getBoton2()).addActionListener(new IconWindow());
        frame1.addWindowListener(new Window());
        frame1.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                System.out.println("Viejo estado: " + e.getOldState());
                System.out.println("Nuevo estado: " + e.getNewState());
                if (e.getNewState() == java.awt.Frame.MAXIMIZED_BOTH) System.out.println("Ventana maximizada ambos lados");
            }
        });
        frame1.addKeyListener(new Keys());
        frame1.addMouseListener(new Mouse());
        frame1.addMouseMotionListener(new MouseMotion());
        frame1.addWindowFocusListener(new WindowsFocus());
        (panel.getjTextField()).addFocusListener(new Focus());
        (panel.getjTextField2()).addFocusListener(new Focus());
//        setLayout(new FlowLayout());
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
///////////////////////// M A R C O  2 ///////////////////////////////
        frame2.setBounds(0,0,400,150);
        frame2.setVisible(false);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.addWindowFocusListener(new WindowsFocus());
    }

    public void getFonts(){
        for(String name : fonts){
            System.out.println(name);
        }
    }

    private final class IconWindow implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == (panel.getBoton1())){
                frame1.setIconImage(iconoPropio);
                (panel.getBoton1()).setEnabled(false);
                (panel.getBoton2()).setEnabled(true);
            } else if(e.getSource() == (panel.getBoton2())){
                frame1.setIconImage(screen.getImage(getClass().getName()));
                (panel.getBoton1()).setEnabled(true);
                (panel.getBoton2()).setEnabled(false);
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
//        private boolean aprobacionEmail;
        @Override
        public void focusGained(FocusEvent e) {
//            if(e.getSource() == panel.getjTextField()){
//                System.out.println("Has ganado el foco en jTextField");
//            } else {
//                System.out.println("Has ganado el foco en jTextField2");
//            }
        }

        @Override
        public void focusLost(FocusEvent e) {
//            if(e.getSource() == panel.getjTextField()){
//                System.out.println("Has perdido el foco en jTextField");
//            } else {
//                System.out.println("Has perdido el foco en jTextField2");
//            }

//            if(panel.getjTextField().getText().contains("@")){
//                aprobacionEmail = true;
//                System.out.println("Email correcto");
//            } else {
//                aprobacionEmail = false;
//                System.out.println("Email incorrecto");
//            }
        }
    }

    private final class WindowsFocus implements WindowFocusListener{
        @Override
        public void windowGainedFocus(WindowEvent e) {
            if(e.getSource() == frame1){
                frame1.setTitle("Tengo el foco");
            } else {
                frame2.setTitle("Tengo el foco");
            }
        }

        @Override
        public void windowLostFocus(WindowEvent e) {
            if(e.getSource() == frame1){
                frame1.setTitle("");
            } else {
                frame2.setTitle("");
            }
        }
    }

    final class CreateNewWindow {
        public CreateNewWindow(JButton btn2) {
            counter++;
            setTitle("Ventana: " + counter);
            setBounds(30 * counter, 30 * counter, 300, 150);
            setVisible(true);
            btn2.addActionListener(new DeleteNewWidows());
        }
        private final class DeleteNewWidows implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }
    }
}
