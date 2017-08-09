package com.hy.ioms.utils.log;

import android.util.Log;

import timber.log.Timber;

/**
 * Created by wsw on 2017/6/13.
 */
//
public class CrashReportingTree extends Timber.Tree {
    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return;
        }

        CrashLibrary.log(priority, tag, message);

        if (t != null) {
            if (priority == Log.ERROR) {
                CrashLibrary.logError(t);
            } else if (priority == Log.WARN) {
                CrashLibrary.logWarning(t);
            }
        }
    }
}
