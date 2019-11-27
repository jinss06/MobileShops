package mobileshop.edu.huatec.com.mobileshop2.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import mobileshop.edu.huatec.com.mobileshop2.R;
import mobileshop.edu.huatec.com.mobileshop2.common.BaseActivity;
import mobileshop.edu.huatec.com.mobileshop2.common.MobileShopApp;

public class AdActivity extends BaseActivity{
    private TextView tv_skip;

    public int getContentViewId(){
        return R.layout.activity_ad;
    }

   protected void initView(){
        super.initView();
        tv_skip = (TextView) findViewById(R.id.tv_skip);
        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skip();
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.iv_image);
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571829792556&di=e043235d07b06b40e64b3cb9acd3fb2c&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201807%2F14%2F20180714145152_vrgdr.jpg";
        ImageLoader.getInstance().displayImage(url,imageView,new ImageLoadingListener(){
            public void onLoadingStarted(String imageUri,View view){

            }

            public void onLoadingFailed(String imageUri,View view,FailReason failReason){
                MobileShopApp.handler.post(jumpTread);
            }

            public void onLoadingComplete(String imageUri, View view, Bitmap loaderImage){
                MobileShopApp.handler.post(jumpTread);
            }

            public void onLoadingCancelled(String imageUri,View view){
                MobileShopApp.handler.post(jumpTread);
            }
        });
    }
    private void skip(){
        Intent intent = new Intent(AdActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
        //移除跳转操作
        c_count = COUNT;
        MobileShopApp.handler.removeCallbacks(jumpTread);
    }
    private static final String SKIP_TEXT="点击跳过 %d";
    private final static int COUNT=5;
    private final static int DELAYED=1000;
    private int c_count=COUNT;

    private Runnable jumpTread = new Runnable() {
        @Override
        public void run() {
            if (c_count<=0){
                skip();
            }else {
                tv_skip.setText(String.format(SKIP_TEXT,c_count));
                c_count--;
                MobileShopApp.handler.postDelayed(jumpTread,DELAYED);
            }
        }
    };
}

