package com.hy.ioms.utils.log;

/**
 * Created by wsw on 2017/6/13.
 */

public final class CrashLibrary {
    public static void log(int priority, String tag, String message) {
        // TODO add log entry to circular buffer.
    }

    public static void logWarning(Throwable t) {
        // TODO report non-fatal warning.
    }

    public static void logError(Throwable t) {
        // TODO report non-fatal error.
    }

    private CrashLibrary() {
        throw new AssertionError("No instances.");
    }
}