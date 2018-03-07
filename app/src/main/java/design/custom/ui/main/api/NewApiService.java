package design.custom.ui.main.api;

import design.custom.ui.main.entity.Test;
import design.root.base.entity.HttpMessage;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewApiService {
    /**
     * 测试
     */
    @GET("index.php?c=XianYu&a=all_goods")
    Observable<HttpMessage<Test>> query_goods(@Query("find") String find);
}
