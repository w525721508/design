package design.root.base.api;

import design.root.base.base.BaseApi;


/**
 * Created by Administrator on 2018/1/31.
 */

public class Api extends BaseApi<ApiService> {
    private static Api instance;
    private static ApiService apiService;

    public static Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }
        return instance;
    }

    public ApiService getApiService() {
        if (apiService == null) {
            apiService = instance.init(ApiService.class);
        }
        return apiService;
    }


}
