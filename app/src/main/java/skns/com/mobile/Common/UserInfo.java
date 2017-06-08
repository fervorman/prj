package skns.com.mobile.Common;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by jungbaepark on 2017. 6. 7..
 * 앱에서 사용하는 user 정보를 저장
 */

public class UserInfo {

    Context context;

    public UserInfo (Context c) {
        context = c;
    }

    // 저장여부
    public void setSave(String s) {
        SharedPreferences pref = context.getSharedPreferences("mobile", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("save", s);
        editor.commit();
     }

    public String getSave() {
        SharedPreferences pref = context.getSharedPreferences("mobile", MODE_PRIVATE);
        return pref.getString("save", "");
    }

    // 사번
    public void setID(String s) {
        SharedPreferences pref = context.getSharedPreferences("mobile", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("id", s);
        editor.commit();
    }

    public String getID() {
        SharedPreferences pref = context.getSharedPreferences("mobile", MODE_PRIVATE);
        return pref.getString("id", "");
    }

    // 비밀번호
    public void setPASS(String s) {
        SharedPreferences pref = context.getSharedPreferences("mobile", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("pass", s);
        editor.commit();
    }

    public String getPASS() {
        SharedPreferences pref = context.getSharedPreferences("mobile", MODE_PRIVATE);
        return pref.getString("pass", "");
    }


}
