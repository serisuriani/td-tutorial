package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Game;
import main.GameStates;

public class MyMouseListener implements MouseListener, MouseMotionListener {

    private Game game;

    public MyMouseListener(Game game) {
        this.game = game;

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        switch (GameStates.gameStates) {

            case MENU:
                game.getMenu().mouseMoved(e.getX(), e.getY());
                break;
            case PLAY:
                game.getPlay().mouseMoved(e.getX(), e.getY());
                break;
            case SETTINGS:
                game.getSettings().mouseMoved(e.getX(), e.getY());
                break;

            default:
                break;

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON1) {

            switch (GameStates.gameStates) {

                case MENU:
                    game.getMenu().mouseClicked(e.getX(), e.getY());
                    break;
                case PLAY:
                    game.getPlay().mouseClicked(e.getX(), e.getY());
                    break;
                case SETTINGS:
                    game.getSettings().mouseClicked(e.getX(), e.getY());
                    break;

                default:
                    break;

            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
