package org.pandenutella.game.tds.state;

import org.pandenutella.game.framework.Window;
import org.pandenutella.game.framework.input.KeyboardController;
import org.pandenutella.game.framework.state.GameState;
import org.pandenutella.game.tds.input.InGameController;
import org.pandenutella.game.tds.input.InGameInputs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class InGameState implements GameState {

    private final InGameController controller = new InGameController();

    private boolean paused = false;

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void update(double deltaSeconds) {
        updateInputs();
    }

    private void updateInputs() {
        controller.update();
        InGameInputs input = controller.getInputs();

        if (input.getTogglePause().isPressed()) {
            paused = !paused;
        }
    }

    @Override
    public void render(Graphics g) {
        Dimension dimension = Window.getInstance().getDimension();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dimension.width, dimension.height);

        if (paused) {
            g.setColor(Color.WHITE);
            String instruction = "Paused, press [Esc] to resume.";
            int instructionWidth = g.getFontMetrics().stringWidth(instruction);
            g.drawString(instruction, (dimension.width / 2) - (instructionWidth / 2), dimension.height / 2);
        }
    }

    @Override
    public KeyboardController<?> getKeyboardController() {
        return controller;
    }
}
