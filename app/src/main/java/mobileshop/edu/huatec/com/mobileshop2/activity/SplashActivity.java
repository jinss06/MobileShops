package mobileshop.edu.huatec.com.mobileshop2.activity;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import mobileshop.edu.huatec.com.mobileshop2.R;
import mobileshop.edu.huatec.com.mobileshop2.common.BaseActivity;

public class SplashActivity extends BaseActivity{
    ImageView splash_loading_item;
    public int getContentViewId(){
        return R.layout.activity_splash;
    }
    protected void initView(){
        super.initView();
        splash_loading_item = (ImageView) findViewById(R.id.splash_loading_item);
        //导入动画
        Animation translate = AnimationUtils.loadAnimation(this,R.anim.splash_loading);
        translate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                //添加Activity转场动画
                startActivity(new Intent(SplashActivity.this,AdActivity.class));
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                finish();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //启动动画
        splash_loading_item.setAnimation(translate);
    }
}
