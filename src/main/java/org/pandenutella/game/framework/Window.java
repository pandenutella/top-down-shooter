package org.pandenutella.game.framework;

import lombok.Getter;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window {

    private static Window INSTANCE;

    public static void initialize(String title, Dimension dimension) {
        INSTANCE = new Window(title, dimension);
        INSTANCE.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                GameLoop.stop();
            }
        });
    }

    public static Window getInstance() {
        return INSTANCE;
    }

    public static void display() {
        INSTANCE.frame.setVisible(true);
        INSTANCE.frame.pack();
        INSTANCE.frame.setLocationRelativeTo(null);
    }

    @Getter
    private final Dimension dimension;

    private final JFrame frame = new JFrame();

    public Window(String title, Dimension dimension) {
        this.dimension = dimension;

        Panel panel = new Panel(dimension);
        this.setup(title, panel);
    }

    private void setup(String title, Panel panel) {
        frame.setTitle(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(panel);
    }

    public void addKeyListener(KeyListener keyListener) {
        frame.addKeyListener(keyListener);
    }

    public void repaint() {
        frame.repaint();
    }
}
