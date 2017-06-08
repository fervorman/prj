package skns.com.mobile.Common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import skns.com.mobile.Common.GPS.GPSManager;

/**
 * Created by jungbaepark on 2017. 6. 2..
 */

public class SKApplication extends Application {


    public static boolean ISDEBUG = false;          // 디버그모드 확인
    public URLDefine urlDefine;                     // 앱에서 사용하는 url 저장
    public UserInfo userInfo;                       // 앱에서 사용하는 Data

    @Override
    public void onCreate() {
        super.onCreate();
        ISDEBUG = isDebuggable(this);
        urlDefine = new URLDefine();
        userInfo = new UserInfo(this);
    }



    private boolean isDebuggable(Context context) {
        boolean debuggable = false;
        PackageManager pm = context.getPackageManager();
        try {
            ApplicationInfo appinfo = pm.getApplicationInfo(context.getPackageName(), 0);
            debuggable = (0 != (appinfo.flags & ApplicationInfo.FLAG_DEBUGGABLE));
        } catch (PackageManager.NameNotFoundException e) {
        }
        return debuggable;
    }
}
