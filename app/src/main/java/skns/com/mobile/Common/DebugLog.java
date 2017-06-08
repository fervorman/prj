package skns.com.mobile.Common;

import android.util.Log;

import static android.R.id.message;

/**
 * Created by jungbaepark on 2017. 6. 2..
 * Log
 */

public class DebugLog {

    static final String TAG = "JB";

    public static void e(String s) {
        if (SKApplication.ISDEBUG) Log.e(TAG, log(s));
    }


    public static String log(String message) {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[4];
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(ste.getFileName().replace(".java", ""));
        sb.append(" - ");
        sb.append(ste.getMethodName());
        sb.append(" ]  ");
        sb.append(message);
        return sb.toString();
   }
}
