import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable {

    private GameScreen gameScreen;

    private BufferedImage img;

    private int updates;
    private long lastTimeUPS;

    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    private Thread gameThread;

    public Game() {

        importImg();

        setSize(640, 640);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameScreen = new GameScreen(img);
        add(gameScreen);
        setVisible(true);

    }

    private void importImg() {

        InputStream is = getClass().getResourceAsStream("/spriteatlas.png");

        try {
            img = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start() {
        gameThread = new Thread(this) {
        };

        gameThread.start();
    }

    private void callUPS() {

        if (System.currentTimeMillis() - lastTimeUPS >= 1000) {
            System.out.println("UPS :" + updates);
            updates = 0;
            lastTimeUPS = System.currentTimeMillis();
        }
    }

    private void updateGame() {
        updates++;
        // System.out.println("Game Updated:)");
    }

    public static void main(String[] args) {

        Game game = new Game();
        game.start();

    }

    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastUpdate = System.nanoTime();
        long lastFrame = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        while (true) {
            // Render
            if (System.nanoTime() - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = System.nanoTime();
                frames++;
            }
            // updates
            if (System.nanoTime() - lastUpdate >= timePerUpdate) {
                updateGame();
                lastUpdate = System.nanoTime();
                updates++;
            }
            // check for stats
            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS : " + frames + " | UPS : " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }

        }

    }

}