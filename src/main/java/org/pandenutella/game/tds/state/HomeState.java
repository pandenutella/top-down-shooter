package org.pandenutella.game.tds.state;

import org.pandenutella.game.framework.Window;
import org.pandenutella.game.framework.input.KeyboardController;
import org.pandenutella.game.framework.state.GameState;
import org.pandenutella.game.framework.state.GameStateManager;
import org.pandenutella.game.tds.constant.State;
import org.pandenutella.game.tds.input.HomeController;
import org.pandenutella.game.tds.input.HomeInputs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class HomeState implements GameState {

    private final HomeController controller = new HomeController();

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
        HomeInputs inputs = controller.getInputs();

        if (inputs.getPlay().isPressed()) {
            GameStateManager.getInstance().changeState(State.LOADING.getName());
        }
    }

    @Override
    public void render(Graphics g) {
        Dimension dimension = Window.getInstance().getDimension();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dimension.width, dimension.height);

        g.setColor(Color.WHITE);

        String instruction = "Press [Space] to play";
        int instructionWidth = g.getFontMetrics().stringWidth(instruction);
        g.drawString(instruction, (dimension.width / 2) - (instructionWidth / 2), dimension.height / 2);
    }

    @Override
    public KeyboardController<?> getKeyboardController() {
        return controller;
    }
}
