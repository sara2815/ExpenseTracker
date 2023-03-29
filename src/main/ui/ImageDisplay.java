package ui;

import javax.swing.*;
import java.awt.image.BufferedImage;

//used to display whatever image given for a short amount of time.

public class ImageDisplay extends JFrame {
    private BufferedImage image;
    private JLabel label;

//constructor
    public ImageDisplay(BufferedImage image) {
        this.image = image;
        label = new JLabel(new ImageIcon(image));
        add(label);
        setSize(image.getWidth(), image.getHeight());
        setLocationRelativeTo(null);
    }

    //EFFECTS:shows image for given number of milli-seconds
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
