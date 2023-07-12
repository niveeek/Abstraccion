package Frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public final class Panel extends JPanel {
    private static final Toolkit screen = Toolkit.getDefaultToolkit();
    private static final Dimension dimension = screen.getScreenSize();
    private static final short heightScreen = (short) dimension.height;
    private static final short widthScreen = (short) dimension.width;
    private Image image1, image2;
    private JButton boton1, boton2, button1, button2;
    private final JTextField jTextField = new JTextField();
    private final JTextField jTextField2 = new JTextField();
    private final ActionButton actionButton1, actionButton2;
    private static final String pathImage1 = "src/images/carita.png";
    private static final String pathImage2 = "src/images/neto.jpeg";

    public Panel() {
        setLayout(null);
        boton1 = new JButton("Personalizado");
        boton1.setEnabled(true);
        boton1.setForeground(Color.RED);
        boton1.setBackground(Color.CYAN);
        boton1.setBounds(150, 20, 125, 20);
        add(boton1);

        boton2 = new JButton("Original");
        boton2.setEnabled(true);
        boton2.setForeground(Color.WHITE);
        boton2.setBackground(Color.MAGENTA);
        boton2.setBounds(300, 20, 85, 20);
        add(boton2);

        actionButton1 = new ActionButton("Personalizado", new ImageIcon(pathImage1), Color.BLUE);
        actionButton2 = new ActionButton("Original", new ImageIcon(pathImage1), Color.RED);

        button1 = new JButton(actionButton1);
        button1.setEnabled(true);
        button1.setForeground(Color.GRAY);
        button1.setBounds(150, 80, 140, 25);
        add(button1);

        button2 = new JButton(actionButton2);
        button2.setEnabled(true);
        button2.setForeground(Color.GRAY);
        button2.setBounds(300, 80, 100, 25);
        add(button2);

        jTextField.setBounds(150, 50, 100, 20);
        add(jTextField);

        jTextField2.setBounds(275, 50, 100, 20);
        add(jTextField2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            image1 = ImageIO.read(new File(pathImage1));
            image2 = ImageIO.read(new File(pathImage2));
        } catch (IOException e) {
            if(image1 == null) {
                System.out.println("No existe la imagen1: "+ e.getMessage());
            } else if (image2 == null) {
                System.out.println("No existe la imagen2: "+ e.getMessage());
            } else {
                System.out.println("No existen ambas imágenes: "+e.getMessage());
            }
        }
        short heightImage = (short) image1.getHeight(this);
        short widthImage = (short) image1.getWidth(this);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.drawImage(image1, 0, 0, null);
//        g.drawImage(image2, 200, 200, null);
        g.setColor(new Color(2,212,56).darker());
        g.drawString("Tiendas Neto", 20, 20);
//        for(short i = 0; i < heightScreen; i++){
//            for(short j = 0; j < widthScreen; j++){
//                if(i+j>0) {
//                    g.copyArea(0, 0, heightImage, widthImage, heightImage * i, widthImage * j);
//                }
//            }
//        }
        updateUI();
//        repaint();
    }

    public JButton getBoton1() {
        return boton1;
    }

    public JButton getBoton2() {
        return boton2;
    }

    public JTextField getjTextField() {
        return jTextField;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    private final class ActionButton extends AbstractAction /*implements Action*/ {
//        private String nombreBoton;
//        private ImageIcon iconoPropio;
//        private Color color, colorSelected;
        public ActionButton(String nombreBoton, ImageIcon iconoPropio, Color color) {
//            this.nombreBoton = nombreBoton;
//            this.iconoPropio = iconoPropio;
//            this.color = color;
            putValue(Action.NAME, nombreBoton);
            putValue(Action.SMALL_ICON, iconoPropio);
            putValue(Action.SHORT_DESCRIPTION, "Poner el Panel de color: "+nombreBoton);
            putValue("ColorBackground", color);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Color colorSelected = (Color) getValue("ColorBackground");
            setBackground(colorSelected);
        }
    }
}
