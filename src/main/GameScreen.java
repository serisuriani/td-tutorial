package main;

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GameScreen extends JPanel {

    private Game game;
    private Dimension size;

    public GameScreen(Game game) {
        this.game = game;

        size = new Dimension(640, 640);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        game.getRender().render(g);

    }

    // g.drawImage(sprites.get(8), 0, 0, null);

    // BufferedImage i = img.getSubimage(32*9,32,32,32);
    // g.drawImage(i,0,0,null);
}
