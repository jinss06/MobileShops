package mobileshop.edu.huatec.com.mobileshop2.http.presenter;

import java.util.List;

import mobileshop.edu.huatec.com.mobileshop2.http.HttpMethods;
import mobileshop.edu.huatec.com.mobileshop2.http.entity.GoodsEntity;
import rx.Observable;
import rx.Subscriber;

public class GoodsPresenter extends HttpMethods {
    public static void listByKeywords(Subscriber<List<GoodsEntity>> subscriber,String keywords){

        Observable<List<GoodsEntity>> observable = goodsService.listByKeywords(keywords)
                .map(new HttpResultFunc<List<GoodsEntity>>());
        toSubscribe(observable,subscriber);
    }
    //获取商品列表
    public static void list(Subscriber<List<GoodsEntity>> subscriber,int catId){
        Observable<List<GoodsEntity>> observable = goodsService.list(catId)
                .map(new HttpResultFunc<List<GoodsEntity>>());
        toSubscribe(observable,subscriber);
    }
}
