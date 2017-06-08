package skns.com.mobile.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import skns.com.mobile.R;


/**
 * Created by jungbaepark on 2017. 4. 3..
 * 로딩뷰
 */


public class LoadingView extends RelativeLayout {

    Context c;
    RelativeLayout rl_loading;
    public LoadingView(Context context) {
        super(context);
        c = context;
        initUI();
    }

    public LoadingView(Context c, AttributeSet att) {
        super(c, att);
        this.c = c;
        initUI();
    }

    private void initUI() {
        inflate(getContext(), R.layout.view_loading, this);
        rl_loading = (RelativeLayout) findViewById(R.id.rl_loading);
        rl_loading.setVisibility(View.GONE);
    }


    public void showLoading() {
        rl_loading.setVisibility(View.VISIBLE);
    }

    public void goneLoading() {
        rl_loading.setVisibility(View.GONE);
    }
}
