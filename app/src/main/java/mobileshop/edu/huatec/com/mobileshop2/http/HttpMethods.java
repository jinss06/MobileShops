package mobileshop.edu.huatec.com.mobileshop2.http;

import android.util.Log;
import java.util.concurrent.TimeUnit;

import mobileshop.edu.huatec.com.mobileshop2.common.Constants;
import mobileshop.edu.huatec.com.mobileshop2.http.entity.HttpResult;
import mobileshop.edu.huatec.com.mobileshop2.http.service.CategoryService;
import mobileshop.edu.huatec.com.mobileshop2.http.service.GoodsService;
import mobileshop.edu.huatec.com.mobileshop2.http.service.MemberService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class HttpMethods {
    private static final String TAG="HttpMethods";

    private static final String BASE_URL= Constants.BASE_URL;
    private static final long DEFAULT_TIMEOUT=5;
    private static HttpMethods sInstance;
    protected static GoodsService goodsService;
    protected static MemberService memberService;
    protected static CategoryService categoryService;
    private Retrofit retrofit;

    public HttpMethods(){
        if (sInstance==null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            goodsService = retrofit.create(GoodsService.class);
            categoryService= retrofit.create(CategoryService.class);
            memberService = retrofit.create(MemberService.class);
        }
    }
    public static HttpMethods getInstance(){
        if (sInstance==null){
            synchronized (HttpMethods.class){
                if (sInstance==null){
                    sInstance = new HttpMethods();
                }
            }
        }
        return sInstance;
    }
    public static class HttpResultFunc<T> implements Func1<HttpResult<T>,T> {
        @Override
        public T call(HttpResult<T> httpResult){
            Log.i(TAG,"status:"+httpResult.getStatus());
            Log.i(TAG,"msg"+httpResult.getMsg());
            Log.i(TAG,"data:"+httpResult.getData());
            return httpResult.getData();
        }
    }

    protected static <T> void toSubscribe(Observable<T> observable, Subscriber<T> subscriber){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
