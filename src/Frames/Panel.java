package Frames;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public final class Panel extends JPanel {
    private Toolkit screen = Toolkit.getDefaultToolkit();
    private Dimension dimension = screen.getScreenSize();
    private int heightScreen = dimension.height;
    private int widthScreen = dimension.width;
    private int heightImage = 0;
    private int widthImage = 0;
    private Image image1 = null;
    private Image image2 = null;
    private File file1 = null;
    private File file2 = null;
    private Font font = null;
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
        file1 = new File("src/images/carita.png");
        file2 = new File("src/images/neto.jpeg");
        try {
            image1 = ImageIO.read(file1);
            image2 = ImageIO.read(file2);
        } catch (IOException e) {
            System.out.println("No existe la imagen: "+e.getMessage());
        }
        heightImage = image1.getHeight(this);
        widthImage = image1.getWidth(this);
        font = new Font("Times New Roman", Font.ITALIC, 30);
        g.setFont(font);
        g.drawImage(image1, 0, 0, null);
//        g.drawImage(image2, 200, 200, null);
//        g.setColor(new Color(2,212,56).brighter());
        g.drawString("Tiendas Neto", 50, 50);
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
