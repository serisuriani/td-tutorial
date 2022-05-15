package scene;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;
import userInterface.MyButton;
import static main.GameStates.*;

public class Settings extends GameScene implements SceneMethods {

    private MyButton bQuit;
    public Object mouseClicked;

    public Settings(Game game) {
        super(game);

        initButton();

    }

    private void initButton() {
        bQuit = new MyButton("Quit", 30, 30, 100, 30);

    }

    private void drawButtons(Graphics g) {
        bQuit.draw(g);

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 640, 640);

        drawButtons(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bQuit.getBounds().contains(x, y)) {
            setGameStates(MENU);

        }

    }

    @Override
    public void mouseMoved(int x, int y) {
        bQuit.setMouseOver(false);
        if (bQuit.getBounds().contains(x, y)) {
            bQuit.setMouseOver(true);
        }

    }

}
