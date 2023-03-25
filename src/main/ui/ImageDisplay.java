package ui;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ImageDisplay extends JFrame {
    private BufferedImage image;
    private JLabel label;


    public ImageDisplay(BufferedImage image) {
        this.image = image;
        label = new JLabel(new ImageIcon(image));
        add(label);
        setSize(image.getWidth(), image.getHeight());
        setLocationRelativeTo(null);
    }

    public void showImage(int delay) {
        setVisible(true);
        try {
            Thread.sleep(delay * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setVisible(false);
    }
}
