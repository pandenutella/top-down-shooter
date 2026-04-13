package org.pandenutella.game.framework.state;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pandenutella.game.framework.input.KeyboardController;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GameStateManager {
    private static GameStateManager INSTANCE;

    public static void initialize() {
        INSTANCE = new GameStateManager();
    }

    public static GameStateManager getInstance() {
        return INSTANCE;
    }

    public static void addState(String stateName, GameState gameState) {
        INSTANCE.gameStateMap.put(stateName, gameState);

        if (INSTANCE.currentStateName == null) {
            INSTANCE.currentStateName = stateName;
        }
    }

    private final Map<String, GameState> gameStateMap = new HashMap<>();
    private String currentStateName;

    public void changeState(String stateName) {
        gameStateMap.get(currentStateName).exit();
        gameStateMap.get(stateName).enter();

        currentStateName = stateName;
    }

    public void update(double deltaSeconds) {
        GameState gameState = gameStateMap.get(currentStateName);
        if (gameState == null) {
            return;
        }

        gameState.update(deltaSeconds);
    }

    public void render(Graphics g) {
        GameState gameState = gameStateMap.get(currentStateName);
        if (gameState == null) {
            return;
        }

        gameState.render(g);
    }

    public KeyboardController<?> getKeyboardController() {
        GameState gameState = gameStateMap.get(currentStateName);
        if (gameState == null) {
            return null;
        }

        return gameState.getKeyboardController();
    }
}
