package skns.com.mobile.View;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;

import skns.com.mobile.R;

/**
 * Created by jungbaepark on 2017. 6. 7..
 * 전체 메뉴뷰
 */

public class MenuView extends RelativeLayout {

    private Context c;
    final int nAnitime = 300;

    public MenuView(Context context) {
        super(context);
        c = context;
        initUI();
    }

    public MenuView(Context c, AttributeSet att) {
        super(c, att);
        this.c = c;
        initUI();
    }

    private void initUI() {
        inflate(getContext(), R.layout.view_common_menu, this);

    }


    public void showMenu() {

        DisplayMetrics dm = c.getResources().getDisplayMetrics();
        float hpx = Math.round(dm.heightPixels * dm.density);
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(rlMenu, "translationY", hpx, 0);
        scaleDownX.setDuration(nAnitime);
        scaleDownX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }
            @Override
            public void onAnimationCancel(Animator animator) {
            }
            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
        scaleDownX.start();

    }

}
