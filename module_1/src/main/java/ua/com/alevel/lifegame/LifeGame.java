package ua.com.alevel.lifegame;

import ua.com.alevel.EventProcessor;

import java.io.PrintStream;
import java.io.Reader;

public class LifeGame implements EventProcessor {

    @Override
    public void process(final Reader reader, final PrintStream writer) {
        Window window = new Window();
        javax.swing.SwingUtilities.invokeLater(window);
    }
}
