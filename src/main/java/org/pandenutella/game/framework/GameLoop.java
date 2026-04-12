package org.pandenutella.game.framework;

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

            update(deltaSeconds);
            render();

            lastNano = currentNano;
        }
    }

    private void update(double deltaSeconds) {
        System.out.println(deltaSeconds);
    }

    private void render() {
        Window.getInstance().repaint();
    }
}
