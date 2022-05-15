package scene;

//import java.awt.Color;

import helper.LevelBuild;
import main.Game;
import managers.TileManager;
import userInterface.MyButton;

import java.awt.Graphics;
import static main.GameStates.*;

public class Play extends GameScene implements SceneMethods {

    private int[][] lvl;
    private TileManager tileManager;

    private MyButton bQuit;
    public Object mouseClicked;

    public Play(Game game) {
        super(game);

        lvl = LevelBuild.getLevelData();
        tileManager = new TileManager();

        initButton();

        // lvl
        // tilemanager

    }

    private void initButton() {
        bQuit = new MyButton("Quit", 30, 30, 100, 30);

    }

    private void drawButtons(Graphics g) {
        bQuit.draw(g);

    }

    @Override
    public void render(Graphics g) {

        for (int y = 0; y < lvl.length; y++) {
            for (int x = 0; x < lvl[y].length; x++) {

                int id = lvl[y][x];
                g.drawImage(tileManager.getSprite(id), x * 32, y * 32, null);

            }

        }

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
