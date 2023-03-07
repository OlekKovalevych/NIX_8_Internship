package ua.com.alevel;

import java.io.PrintStream;
import java.io.Reader;

public interface EventProcessor {

    void process(Reader reader, PrintStream writer);
}