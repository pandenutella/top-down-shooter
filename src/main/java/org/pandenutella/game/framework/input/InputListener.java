package org.pandenutella.game.framework.input;

import org.pandenutella.game.framework.state.GameStateManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyboardController<?> keyboardController = GameStateManager.getInstance().getKeyboardController();
        if (keyboardController == null) {
            return;
        }

        keyboardController.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        KeyboardController<?> keyboardController = GameStateManager.getInstance().getKeyboardController();
        if (keyboardController == null) {
            return;
        }

        keyboardController.keyReleased(e);
    }
}
