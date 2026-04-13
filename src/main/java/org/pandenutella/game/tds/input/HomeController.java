package org.pandenutella.game.tds.input;

import org.pandenutella.game.framework.input.Input;
import org.pandenutella.game.framework.input.KeyboardController;

import java.awt.event.KeyEvent;
import java.util.Map;

public class HomeController extends KeyboardController<HomeInputs> {

    private final HomeInputs inputs = new HomeInputs();

    @Override
    public HomeInputs getInputs() {
        return inputs;
    }

    @Override
    protected Map<Integer, Input> getKeyInputMap() {
        return Map.of(KeyEvent.VK_SPACE, inputs.getPlay());
    }
}
