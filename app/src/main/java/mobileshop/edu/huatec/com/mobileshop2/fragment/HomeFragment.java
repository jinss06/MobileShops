package mobileshop.edu.huatec.com.mobileshop2.fragment;

import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.OnClick;
import mobileshop.edu.huatec.com.mobileshop2.R;
import mobileshop.edu.huatec.com.mobileshop2.common.BaseActivity;
import mobileshop.edu.huatec.com.mobileshop2.common.BaseFragment;
import mobileshop.edu.huatec.com.mobileshop2.view.MyWebView;

public class HomeFragment extends BaseFragment{
    private static final String TAG="HomeFragment";
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwiperRefreshLayout;

    @BindView(R.id.webView)
    MyWebView myWebView;

    @OnClick(R.id.home_title_search)
    void search(){
        toastShort("开发中...");
    }
    @Override
    public int getContentViewId(){
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view){
        super.initView(view);
        initWebView();
        initSwiperRefreshLayout();
    }

    private void initSwiperRefreshLayout(){
        mSwiperRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,android.R.color.holo_blue_light,
                android.R.color.holo_orange_light,android.R.color.holo_red_light);

        mSwiperRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                myWebView.reload();
            }
        });
    }

    private void initWebView(){
        myWebView.setVerticalScrollBarEnabled(false);
        myWebView.setHorizontalScrollBarEnabled(false);

        WebSettings settings = myWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);

        myWebView.setOnCustomScrollChanged(new MyWebView.IWebViewScroll() {
            @Override
            public void onTop() {
                mSwiperRefreshLayout.setEnabled(true);
            }

            @Override
            public void notOnTop() {
                mSwiperRefreshLayout.setEnabled(false);
            }
        });
        //点击后退按钮
        myWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()==KeyEvent.ACTION_DOWN){
                    if (keyCode==KeyEvent.KEYCODE_BACK && myWebView.canGoBack()){
                        myWebView.goBack();
                        return true;
                    }
                }
                return false;
            }
        });
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                mSwiperRefreshLayout.setRefreshing(false);
                Log.e(TAG,"onPageFinished");
            }
        });
        //加载url
        myWebView.loadUrl("http://www.apple.com/cn-k12/shop");
    }
}
