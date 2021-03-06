package scene;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

import java.util.ArrayList;
//import java.util.Random;

import main.Game;
import userInterface.MyButton;
import static main.GameStates.*;

public class Menu extends GameScene implements SceneMethods {

    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    // private Random random;

    private MyButton bPlay, bSettings, bQuit;
    public Object mouseClicked;

    public Menu(Game game) {
        super(game);
        // random = new Random();
        importImg();
        loadSprites();
        initButton();

    }

    private void initButton() {

        bPlay = new MyButton("Play", 100, 100, 100, 30);
        bSettings = new MyButton("Settings", 100, 150, 100, 30);
        bQuit = new MyButton("Quit", 100, 200, 100, 30);

    }

    @Override
    public void render(Graphics g) {

        drawButtons(g);

    }

    private void drawButtons(Graphics g) {
        bPlay.draw(g);
        bSettings.draw(g);
        bQuit.draw(g);

    }

    private void importImg() {

        InputStream is = getClass().getResourceAsStream("/spriteatlas.png");

        try {
            img = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadSprites() {

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
            }
        }
    }

    /*
     * private int getRndInt() {
     * return random.nextInt(20);
     * 
     * }
     */

    @Override
    public void mouseClicked(int x, int y) {
        if (bPlay.getBounds().contains(x, y)) {
            setGameStates(PLAY);

        }

        else if (bSettings.getBounds().contains(x, y)) {
            setGameStates(SETTINGS);
        } else
            System.exit(0);

    }

    @Override
    public void mouseMoved(int x, int y) {
        bPlay.setMouseOver(false);
        bSettings.setMouseOver(false);
        bQuit.setMouseOver(false);
        if (bPlay.getBounds().contains(x, y)) {
            bPlay.setMouseOver(true);

        }

        else if (bSettings.getBounds().contains(x, y)) {
            bSettings.setMouseOver(true);
        }

        else if (bQuit.getBounds().contains(x, y)) {
            bQuit.setMouseOver(true);
        }

    }

}
