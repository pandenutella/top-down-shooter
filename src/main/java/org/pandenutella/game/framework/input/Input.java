package org.pandenutella.game.framework.input;

import lombok.Data;

@Data
public class Input {
    private boolean pressNext;
    private boolean releaseNext;

    private boolean pressed;
    private boolean down;
}
