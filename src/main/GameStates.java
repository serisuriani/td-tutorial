package main;

public enum GameStates {

    PLAY, MENU, SETTINGS;

    public static GameStates gameStates = MENU;

    public static void setGameStates(GameStates states) {
        gameStates = states;

    }

}
