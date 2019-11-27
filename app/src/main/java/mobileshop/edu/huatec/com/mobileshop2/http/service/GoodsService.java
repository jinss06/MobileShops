package mobileshop.edu.huatec.com.mobileshop2.http.service;

import java.util.List;


import mobileshop.edu.huatec.com.mobileshop2.http.entity.GoodsEntity;
import mobileshop.edu.huatec.com.mobileshop2.http.entity.HttpResult;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface GoodsService {

    @FormUrlEncoded
    @POST("goods/find")
    Observable<HttpResult<List<GoodsEntity>>> listByKeywords(
            @Field("input")String keywords
    );
    //二级分类获取商品列表
    @GET("goods/cat/{catId}")
    Observable<HttpResult<List<GoodsEntity>>> list(
            @Path("catId") int catId
    );
}
