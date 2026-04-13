package org.pandenutella.game.tds.state;

import org.pandenutella.game.framework.Window;
import org.pandenutella.game.framework.input.KeyboardController;
import org.pandenutella.game.framework.state.GameState;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class LoadingState implements GameState {

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void update(double deltaSeconds) {

    }

    @Override
    public void render(Graphics g) {
        Dimension dimension = Window.getInstance().getDimension();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dimension.width, dimension.height);

        g.setColor(Color.WHITE);

        int boxSize = 50;
        int margin = 5;
        int gap = 5;

        renderKey(g, "Esc", margin, margin, boxSize);

        renderKey(g, "W",
                margin + boxSize + gap,
                dimension.height - margin - (boxSize * 2) - gap,
                boxSize);
        renderKey(g, "A",
                margin,
                dimension.height - margin - boxSize,
                boxSize);
        renderKey(g, "S",
                margin + boxSize + gap,
                dimension.height - margin - boxSize,
                boxSize);
        renderKey(g, "D",
                margin + (boxSize * 2) + (gap * 2),
                dimension.height - margin - boxSize,
                boxSize);

        renderKey(g, "J",
                dimension.width - margin - (boxSize * 3) - (gap * 2),
                dimension.height - margin - boxSize,
                boxSize);
        renderKey(g, "K",
                dimension.width - margin - (boxSize * 2) - gap,
                dimension.height - margin - boxSize,
                boxSize);
        renderKey(g, "L",
                dimension.width - margin - boxSize,
                dimension.height - margin - boxSize,
                boxSize);

        String instruction = "Loading...";
        int instructionWidth = g.getFontMetrics().stringWidth(instruction);
        g.drawString(instruction, (dimension.width / 2) - (instructionWidth / 2), dimension.height / 2);
    }

    private static void renderKey(Graphics g, String key, int x, int y, int boxSize) {
        g.drawRect(x, y, boxSize, boxSize);
        g.drawString(key, x + 5, y + 15);
    }

    @Override
    public KeyboardController<?> getKeyboardController() {
        return null;
    }
}
