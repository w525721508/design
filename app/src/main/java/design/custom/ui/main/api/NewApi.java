package design.custom.ui.main.api;

import design.root.base.api.ApiService;
import design.root.base.base.BaseApi;

public class NewApi extends BaseApi<NewApiService> {
    private static NewApi instance;
    private static NewApiService apiService;

    public static NewApi getInstance() {
        if (instance == null) {
            instance = new NewApi();
        }
        return instance;
    }

    public NewApiService getApiService() {
        if (apiService == null) {
            apiService = instance.init(NewApiService.class);
        }
        return apiService;
    }

}
