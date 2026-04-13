package org.pandenutella.game.framework;

import lombok.Getter;
import org.pandenutella.game.framework.state.GameStateManager;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Panel extends JPanel {

    private static final Color BACKGROUND_COLOR = Color.WHITE;

    @Getter
    private final Dimension dimension;

    public Panel(Dimension dimension) {
        this.dimension = dimension;

        this.setPreferredSize(dimension);
        this.setBackground(BACKGROUND_COLOR);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        GameStateManager.getInstance().render(g);
    }
}
