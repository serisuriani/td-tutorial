
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class GameScreen extends JPanel {

    private Random random;
    private BufferedImage img;

    private int frames;
    private long lastTime;

    private ArrayList<BufferedImage> sprites = new ArrayList<>();

    public GameScreen(BufferedImage img) {
        this.img = img;
        loadSprites();
        random = new Random();

    }

    private void loadSprites() {

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                g.drawImage(sprites.get(getRndInt()), x * 32, y * 32, null);
            }
        }

        callFPS();

        // g.drawImage(sprites.get(8), 0, 0, null);

        // BufferedImage i = img.getSubimage(32*9,32,32,32);
        // g.drawImage(i,0,0,null);
    }

    private void callFPS() {
        frames++;
        if (System.currentTimeMillis() - lastTime >= 1000) {
            System.out.println("FPS : " + frames);
            frames = 0;
            lastTime = System.currentTimeMillis();
        }
    }

    private int getRndInt() {
        return random.nextInt(20);

    }

    private Color getRndColor() {
        int r = random.nextInt(256);

        int b = random.nextInt(256);

        int g = random.nextInt(256);

        return new Color(r, g, b);
    }
}
