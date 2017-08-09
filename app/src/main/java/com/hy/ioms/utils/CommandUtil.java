package com.hy.ioms.utils;

import java.util.UUID;

/**
 * ${description}
 * Created by wsw on 2017/5/10.
 */

public class CommandUtil {
    public static String getCommandId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }
}
