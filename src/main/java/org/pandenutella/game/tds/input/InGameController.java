package org.pandenutella.game.tds.input;

import org.pandenutella.game.framework.input.Input;
import org.pandenutella.game.framework.input.KeyboardController;

import java.awt.event.KeyEvent;
import java.util.Map;

public class InGameController extends KeyboardController<InGameInputs> {

    private final InGameInputs inputs = new InGameInputs();

    @Override
    public InGameInputs getInputs() {
        return inputs;
    }

    @Override
    protected Map<Integer, Input> getKeyInputMap() {
        return Map.of(KeyEvent.VK_ESCAPE, inputs.getTogglePause());
    }
}
