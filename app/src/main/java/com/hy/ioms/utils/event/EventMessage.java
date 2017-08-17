package com.hy.ioms.utils.event;

/**
 * ${description}
 * Created by wsw on 2017/8/16.
 */

public class EventMessage {

    public final String message;
    public final int type;

    public EventMessage(String message, int type) {
        this.message = message;
        this.type = type;
    }

}
