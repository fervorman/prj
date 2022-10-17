package skns.com.mobile.Activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import skns.com.mobile.Common.DebugLog;
import skns.com.mobile.Common.GPS.GPSManager;
import skns.com.mobile.View.LoadingView;
import skns.com.mobile.Common.SKApplication;
import skns.com.mobile.Common.UserInfo;
import skns.com.mobile.R;
import skns.com.mobile.View.MenuView;



/**
 * Created by jungbaepark on 2017. 6. 2..
 * 紐⑤뱺 Activity�뒗 BaseActivity瑜� �긽�냽諛쏅뒗�떎
 */

public class BaseActivity extends AppCompatActivity {
    //주석을 달아봅시다. 이제정말로 달라봅시다
    GPSManager gpsManager;
    Handler gpsHandler;

    public static int RENEW_GPS = 1;
    public static int SEND_PRINT = 2;
    public LoadingView loadingView;
    public SKApplication skApplication;
    public UserInfo userInfo;
    public ImageButton btnHome, btnMenu, btnBack;           // 怨듯넻 硫붾돱 踰꾪듉�뱾
    public MenuView rlMenu;                                 // 硫붾돱 酉�

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        skApplication = (SKApplication) getApplicationContext();
        userInfo = skApplication.userInfo;
    }


    // 濡쒕뵫酉� show
    public void showLoading() {
        if (loadingView != null) loadingView.showLoading();
    }

    // 濡쒕뵫酉� gone
    public void goneLoading() {
        if (loadingView != null) loadingView.goneLoading();
    }

    // api , �꽕�듃�썙�겕 �삤瑜섏떆
    public void showErrorAPI(String s) {
        AlertDialog.Builder alert = new AlertDialog.Builder(BaseActivity.this);
        alert.setPositiveButton(getText(R.string.common_text_1), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.setMessage(s);
        alert.show();
    }


    // GPS Handler
    public void initGPSHandler() {
        if (gpsHandler == null) {
            gpsHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == RENEW_GPS) {
//                        if (gpsManager == null) {
//                            gpsManager = new GPSManager(BaseActivity.this, gpsHandler);
//                        } else {
//                            gpsManager.update();
//                        }
//                        DebugLog.e((String) msg.obj);
                    }
                    if (msg.what == SEND_PRINT) {
                        DebugLog.e((String) msg.obj);
                    }
                }
            };
        }
    }

    // GPSManager �깮�꽦
    public void initGPSManager() {
        if (gpsManager == null) {
            gpsManager = new GPSManager(BaseActivity.this, gpsHandler);
        } else {
            gpsManager.update();
        }
    }


    // GPS 沅뚰븳 �슂泥�
    public void regGPSPermisson(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            DebugLog.e("GPS requestPermission");
        } else {
            initGPSHandler();
            initGPSManager();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 0:
                for (int i = 0; i < permissions.length; i++) {
                    String permission = permissions[i];
                    int grantResult = grantResults[i];
                    if (permission.equals(Manifest.permission.ACCESS_FINE_LOCATION)) {
                        if (grantResult == PackageManager.PERMISSION_GRANTED) {
                            DebugLog.e("PERMISSION_GRANTED");
                            initGPSHandler();
                            initGPSManager();
                        } else {
                            DebugLog.e("PERMISSION_DENIED");

                        }
                    }
                }
                break;
        }
    }


    public void pressShowMenu() {
        if ( rlMenu != null ) {
            rlMenu.setVisibility(View.VISIBLE);
            rlMenu.showMenu();
        }
    }


}






