package userInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MyButton {

    private int x, y, width, height;
    private String text;
    private Rectangle bounds;
    private boolean mouseOver;

    public MyButton(String text, int x, int y, int width, int height) {

        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        initBounds();

    }

    private void initBounds() {
        this.bounds = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {

        // Body
        drawBody(g);

        // Border
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);

        // Text
        drawText(g);

    }

    private void drawBody(Graphics g) {
        if (mouseOver)
            g.setColor(Color.GRAY);
        else
            g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }

    private void drawText(Graphics g) {

        int w = g.getFontMetrics().stringWidth(text);
        int h = g.getFontMetrics().getHeight();

        g.drawString(text, x - w / 2 + width / 2, y + h / 2 + height / 2);
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;

    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void getMouseOver(boolean b) {
    }
}
