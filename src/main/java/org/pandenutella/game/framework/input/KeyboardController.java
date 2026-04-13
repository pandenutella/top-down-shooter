package org.pandenutella.game.framework.input;

import java.awt.event.KeyEvent;
import java.util.Map;

public abstract class KeyboardController<T> {

    protected final void keyPressed(KeyEvent e) {
        Input input = getKeyInputMap().get(e.getKeyCode());
        if (input == null) {
            return;
        }

        input.setPressNext(true);
    }

    protected final void keyReleased(KeyEvent e) {
        Input input = getKeyInputMap().get(e.getKeyCode());
        if (input == null) {
            return;
        }

        input.setReleaseNext(true);
    }

    public void update() {
        getKeyInputMap().forEach((key, input) -> {
            if (input.isPressNext() && !input.isDown()) {
                input.setPressNext(false);
                input.setPressed(true);
                input.setDown(true);
            } else if (input.isDown() && input.isPressed()) {
                input.setPressNext(false);
                input.setPressed(false);
            } else if (input.isReleaseNext()) {
                input.setPressNext(false);
                input.setReleaseNext(false);
                input.setPressed(false);
                input.setDown(false);
            }
        });
    }

    protected abstract T getInputs();

    protected abstract Map<Integer, Input> getKeyInputMap();
}
