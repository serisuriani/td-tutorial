
package main;

import java.awt.Graphics;

public class Render {

    private Game game;

    public Render(Game game) {
        this.game = game;

    }

    public void render(Graphics g) {

        switch (GameStates.gameStates) {

            case MENU:
                game.getMenu().render(g);
                break;

            case PLAY:
                game.getPlay().render(g);
                break;

            case SETTINGS:
                game.getSettings().render(g);
                break;

        }

    }

}
