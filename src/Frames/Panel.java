package Frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public final class Panel extends JPanel {
    private final Toolkit screen = Toolkit.getDefaultToolkit();
    private final Dimension dimension = screen.getScreenSize();
    private final short heightScreen = (short) dimension.height;
    private final short widthScreen = (short) dimension.width;
    private Image image1;
    private Image image2;
    private final JButton boton1 = new JButton("Personalizado");
    private final JButton boton2 = new JButton("Original");

    public Panel() {
        boton1.setEnabled(true);
        boton1.setForeground(Color.RED);
        boton1.setBackground(Color.CYAN);
        add(boton1);

        boton2.setEnabled(true);
        boton2.setForeground(Color.WHITE);
        boton2.setBackground(Color.MAGENTA);
        add(boton2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            image1 = ImageIO.read(new File("src/images/carita.png"));
            image2 = ImageIO.read(new File("src/images/neto.jpeg"));
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
//        g.setColor(new Color(2,212,56).brighter());
        g.drawString("Tiendas Neto", 20, 20);
//        for(short i = 0; i < heightScreen; i++){
//            for(short j = 0; j < widthScreen; j++){
//                if(i+j>0) {
//                    g.copyArea(0, 0, heightImage, widthImage, heightImage * i, widthImage * j);
//                }
//            }
//        }
    }

    public JButton getBoton1() {
        return boton1;
    }

    public JButton getBoton2() {
        return boton2;
    }
}
