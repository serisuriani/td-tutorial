
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class GameScreen extends JPanel {

    private Random random;
    private BufferedImage img;

    public GameScreen(BufferedImage img) {
        this.img = img;
        loadSprites();
        random = new Random();
    }

    private void loadSprites(){

    }     
       
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage i = img.getSubimage(32*9,32,32,32);
        g.drawImage(i,0,0,null);
    }

    private Color getRndColor() {
        int r = random.nextInt(256);

        int b = random.nextInt(256);

        int g = random.nextInt(256);

        return new Color(r, g, b);
    }
}
