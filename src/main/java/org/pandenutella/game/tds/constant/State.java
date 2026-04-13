package org.pandenutella.game.tds.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum State {
    HOME("home"),
    LOADING("loading"),
    IN_GAME("in_game"),
    ;
    private final String name;
}
