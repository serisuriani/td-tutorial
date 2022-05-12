import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame {

    private GameScreen gameScreen;

    private BufferedImage img;

    public Game() {

        importImg();

        setSize(640, 640);

        setLocationRelativeTo(null);
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

    public static void main(String[] args) {

        System.out.println("Test");
        Game game = new Game();
    }
}