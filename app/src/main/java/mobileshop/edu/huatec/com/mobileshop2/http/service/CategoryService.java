package mobileshop.edu.huatec.com.mobileshop2.http.service;

import java.util.List;

import mobileshop.edu.huatec.com.mobileshop2.http.entity.CategoryEntity;
import mobileshop.edu.huatec.com.mobileshop2.http.entity.HttpResult;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface CategoryService {
    @GET("cat/show")
    Observable<HttpResult<List<CategoryEntity>>> getTopList();

    @GET("cat/show/{parentId}")
    Observable<HttpResult<List<CategoryEntity>>> getSecondList(
            @Path("parentId") int parentId
    );
}
