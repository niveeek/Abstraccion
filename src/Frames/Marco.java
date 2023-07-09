package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class Marco extends JFrame implements ActionListener{
    private Toolkit screen = Toolkit.getDefaultToolkit();
    private String [] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    private final Image iconoPropio = screen.getImage(getClass().getResource("/images/carita.png"));
    private Panel panel = null;

    public Marco() {
        setVisible(true);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setTitle("Prueba Neto");
//        setBounds(700,300,500,300);
//        setLocationRelativeTo(null);
        setResizable(false);
        panel = new Panel();
        add(panel);
        (panel.getBoton1()).addActionListener(this);
        (panel.getBoton2()).addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == (panel.getBoton1())){
            setIconImage(iconoPropio);
            (panel.getBoton1()).setEnabled(false);
            (panel.getBoton2()).setEnabled(true);
            panel.setForeground(Color.GREEN);
            panel.setBackground(Color.BLACK);
        } else if(e.getSource() == (panel.getBoton2())){
            setIconImage(screen.getImage(getClass().getClass().getName()));
            (panel.getBoton1()).setEnabled(true);
            (panel.getBoton2()).setEnabled(false);
            panel.setForeground(Color.BLACK);
            panel.setBackground(Color.GREEN);
        }
    }
}
