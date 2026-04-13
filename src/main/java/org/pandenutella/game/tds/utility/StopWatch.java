package org.pandenutella.game.tds.utility;

public class StopWatch {
    private double targetSeconds;
    private double currentSeconds;
    private boolean running;

    public void start(double seconds) {
        targetSeconds = seconds;
        currentSeconds = 0.0;
        running = true;
    }

    public void update(double deltaSeconds) {
        if (!running) {
            return;
        }

        currentSeconds = Math.min(currentSeconds + deltaSeconds, targetSeconds);
    }

    public boolean hasElapsed() {
        return running && currentSeconds >= targetSeconds;
    }
}
