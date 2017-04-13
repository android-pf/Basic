package com.futurenavi.libbasic.utils;

import android.util.Log;

/**
 * Created by pf on 17/1/6.
 */

public class MLog {
    boolean isLog = true;
    private Class mC;

    public MLog(Class c) {
        this.mC = c;
        init();
    }
    public void init( ) {
        if (isLog) {
            Log.i("WZK", "-------------------------------------->");
            Log.i("WZK", "---" + mC + "     ---->");
        }

    }

    public void i(String msg) {
        if (isLog)
            Log.i("WZK", "---" + mC + "---------------->\n" + msg);
    }

    public void e(String msg) {
        if (isLog)
            Log.e("WZK", "---" + mC + "---------------->\n" + msg);
    }
}
