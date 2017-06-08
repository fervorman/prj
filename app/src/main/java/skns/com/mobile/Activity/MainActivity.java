package skns.com.mobile.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import skns.com.mobile.View.LoadingView;
import skns.com.mobile.R;
import skns.com.mobile.View.MenuView;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        regGPSPermisson(this);
    }


    private void initUI() {
        // 공통레이아웃
        loadingView = (LoadingView) findViewById(R.id.lv_loading);
        btnMenu = (ImageButton) findViewById(R.id.btn_menu);
        btnBack = (ImageButton) findViewById(R.id.btn_back);
        btnHome = (ImageButton) findViewById(R.id.btn_home);
        rlMenu = (MenuView) findViewById(R.id.rl_menu);
        btnMenu.setOnClickListener(commonButtonListener);
        btnBack.setOnClickListener(commonButtonListener);
        btnHome.setOnClickListener(commonButtonListener);

    }


    // 공통 메뉴 리스너
    public View.OnClickListener commonButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ( v.getId() == R.id.btn_menu ) {
                pressShowMenu();
            }
        }
    };

}
