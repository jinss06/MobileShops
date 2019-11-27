package mobileshop.edu.huatec.com.mobileshop2.http.presenter;

import java.util.List;

import mobileshop.edu.huatec.com.mobileshop2.http.HttpMethods;
import mobileshop.edu.huatec.com.mobileshop2.http.entity.CategoryEntity;

import rx.Observable;
import rx.Subscriber;

public class CategoryPresenter extends HttpMethods {
    //一级分类
    public static void getTopList(Subscriber<List<CategoryEntity>> subscriber) {
        Observable<List<CategoryEntity>> observable = categoryService.getTopList()
                .map(new HttpResultFunc<List<CategoryEntity>>());
        toSubscribe(observable, subscriber);
    }
    //二级分类
    public static void getSecondList(Subscriber<List<CategoryEntity>> subscriber, int parentId) {
        Observable<List<CategoryEntity>> observable = categoryService.getSecondList(parentId)
                .map(new HttpResultFunc<List<CategoryEntity>>());
        toSubscribe(observable, subscriber);
    }
}
