package org.pandenutella.game.framework.state;

import org.pandenutella.game.framework.input.KeyboardController;

import java.awt.Graphics;

public interface GameState {
    void enter();

    void exit();

    void update(double deltaSeconds);

    void render(Graphics g);

    KeyboardController<?> getKeyboardController();
}
