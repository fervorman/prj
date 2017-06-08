package skns.com.mobile.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import skns.com.mobile.Common.DebugLog;
import skns.com.mobile.R;

/**
 * Created by jungbaepark on 2017. 6. 5..
 * Login
 */

public class LoginActivity extends BaseActivity {

    Button btnLogin, btnExit;
    EditText etID, etPASS, etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
    }

    private void initUI() {
        etID = (EditText) findViewById(R.id.et_id);
        etPASS = (EditText) findViewById(R.id.et_pass);
        etPhone = (EditText) findViewById(R.id.et_phone);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnExit = (Button) findViewById(R.id.btn_exit);
        btnLogin.setOnClickListener(buttonListener);
        btnExit.setOnClickListener(buttonListener);
        setPhoneNumber();
    }

    private void setPhoneNumber() {
        TelephonyManager tMgr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String mPhoneNumber = tMgr.getLine1Number();
        if (mPhoneNumber != null)   etPhone.setText(mPhoneNumber);

    }

    // 시리얼 번호 확인
    private String getDeviceSerialNumber() {
        try {
            return (String) Build.class.getField("SERIAL").get(null);
        } catch (Exception ignored) {
            DebugLog.e(ignored.toString());
            return null;
        }
    }



    // buttonListener
    private View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ( v.getId() == R.id.btn_login ) {
                pressLogin();
            } else if ( v.getId() == R.id.btn_exit ) {
                pressExit();
            }
        }
    };

    // 로그인 선택
    private void pressLogin() {
        if ( etID.getText().toString().equals("") ) {
            Toast.makeText(this, getString(R.string.login_input_1), Toast.LENGTH_SHORT).show();
            return;
        } else if ( etPASS.getText().toString().equals("") ) {
            Toast.makeText(this, getString(R.string.login_input_2), Toast.LENGTH_SHORT).show();
            return;
        }  else if ( etPhone.getText().toString().equals("") ) {
            Toast.makeText(this, getString(R.string.login_input_3), Toast.LENGTH_SHORT).show();
            return;
        }
        String DRVNO = etID.getText().toString();
        String MOBILENO = etPhone.getText().toString().replace("-", "");
        String URPW = etPASS.getText().toString();

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    // 종료 선택
    private void pressExit() {
        final AlertDialog.Builder alert_confirm = new AlertDialog.Builder(LoginActivity.this);
        alert_confirm.setMessage(getText(R.string.login_text_2)).setCancelable(false).setPositiveButton(getText(R.string.common_text_1),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton(R.string.common_text_2,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       return;
                    }
                });
        AlertDialog alert = alert_confirm.create();
        alert.show();
    }

}
