package design.root.api;

import design.root.entity.ApiDataEntity;
import design.root.entity.HttpMessage;
import design.root.entity.UserEntity;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2018/1/31.
 */

public interface ApiService {
    @GET("topic")
    Observable<HttpMessage<ApiDataEntity>> getHotTopic();

    @POST("index.php?c=Index&a=login")
    Observable<HttpMessage<UserEntity>> login(@Body UserEntity userEntity);
}
