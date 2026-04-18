package org.pandenutella.game.tds;

import org.pandenutella.game.framework.GameLoop;
import org.pandenutella.game.framework.Window;
import org.pandenutella.game.framework.state.GameStateManager;
import org.pandenutella.game.tds.constant.State;
import org.pandenutella.game.tds.state.HomeState;
import org.pandenutella.game.tds.state.InGameState;
import org.pandenutella.game.tds.state.LoadingState;

import java.awt.Dimension;

public class Main {
    public static void main(String[] args) {
        Window.initialize("Top-down shooter", new Dimension(800, 600));

        GameStateManager.initialize();
        GameStateManager.addState(State.HOME.getName(), new HomeState());
        GameStateManager.addState(State.LOADING.getName(), new LoadingState());
        GameStateManager.addState(State.IN_GAME.getName(), new InGameState());

        GameLoop.initialize();
        GameLoop.start();

        Window.display();
    }
}