package org.pandenutella.game.framework;

import org.pandenutella.game.framework.state.GameStateManager;

public class GameLoop implements Runnable {

    private static GameLoop INSTANCE;

    public static void initialize() {
        INSTANCE = new GameLoop();
    }

    public static void start() {
        if (INSTANCE.running) {
            return;
        }

        INSTANCE.running = true;
        INSTANCE.thread = new Thread(INSTANCE);
        INSTANCE.thread.start();
    }

    public static void stop() {
        INSTANCE.running = false;

        if (Thread.currentThread() != INSTANCE.thread) {
            try {
                INSTANCE.thread.join();
            } catch (InterruptedException ignored) {
            }
        }
    }

    private boolean running;
    private Thread thread;

    @Override
    public void run() {
        long lastNano = System.nanoTime();
        while (running) {
            long currentNano = System.nanoTime();
            double deltaSeconds = (currentNano - lastNano) / 1000000000.0;

            GameStateManager.getInstance().update(deltaSeconds);
            Window.getInstance().repaint();

            lastNano = currentNano;
        }
    }
}
