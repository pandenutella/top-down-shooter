package org.pandenutella.game;

import org.pandenutella.game.framework.GameLoop;
import org.pandenutella.game.framework.Window;

import java.awt.Dimension;

public class Main {
    public static void main(String[] args) {
        Window.initialize("Top-down shooter", new Dimension(800, 600));
        Window.display();

        GameLoop.initialize();
        GameLoop.start();
    }
}