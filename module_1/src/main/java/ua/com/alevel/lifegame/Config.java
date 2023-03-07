package ua.com.alevel.lifegame;


import java.awt.*;

public class Config {
    public static final int SIZE = 10;
    public static final int WIDTH = 60;
    public static final int HEIGHT = 70;
    public static final int SLEEPMS = 50;

    public static Color getColor(Status status) {
        switch (status) {
            default:
            case NONE:
                return Color.BLACK;
            case BORN:
                return Color.GRAY;
            case LIVE:
                return Color.WHITE;
            case DIED:
                return Color.GRAY;
        }

    }
}
