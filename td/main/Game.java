package main;

import javax.swing.JFrame;

import inputs.KeyboardListener;
import inputs.MyMouseListener;
import scene.Menu;
import scene.Play;
import scene.Settings;

public class Game extends JFrame implements Runnable {

    private GameScreen gameScreen;
    private Thread gameThread;

    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    private MyMouseListener myMouseListener;
    private KeyboardListener keyboardListener;

    // Classes

    private Render render;
    private Menu menu;
    private Play play;
    private Settings settings;

    public Game() {

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initClasses();
        add(gameScreen);
        pack();
        setVisible(true);

    }

    private void initClasses() {
        render = new Render(this);
        gameScreen = new GameScreen(this);
        menu = new Menu(this);
        play = new Play(this);
        settings = new Settings(this);
    }

    private void initInput() {
        myMouseListener = new MyMouseListener();
        keyboardListener = new KeyboardListener();

        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        addKeyListener(keyboardListener);

        requestFocus();

    }

    private void start() {
        gameThread = new Thread(this) {
        };

        gameThread.start();
    }

    public static void main(String[] args) {

        Game game = new Game();
        game.initInput();
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

        long now;

        while (true) {

            now = System.nanoTime();
            // Render
            if (now - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = now;
                frames++;
            }
            // updates
            if (now - lastUpdate >= timePerUpdate) {
                lastUpdate = now;
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
    // Getter and setters

    public Render getRender() {
        return render;
    }

    public Menu getMenu() {
        return menu;
    }

    public Play getPlay() {
        return play;
    }

    public Settings getSettings() {
        return settings;
    }

}