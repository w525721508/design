package design.root.base.base;

import java.util.concurrent.TimeUnit;

import design.root.base.Constant;
import design.root.base.util.ConverterFactray;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public abstract class BaseApi<T> {
    public BaseApi() {

    }

    public T init(Class<T> apiService) {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logInterceptor)
                .connectTimeout(Constant.API_BUILDER.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Constant.API_BUILDER.READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(Constant.API_BUILDER.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_HOST)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ConverterFactray.create())
                .build();
        return retrofit.create(apiService);
    }
}
