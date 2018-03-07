package design.custom.ui.main.api;

import design.root.base.api.ApiFactory;
import io.reactivex.Observable;

public class NewApiFactory extends ApiFactory {
    public static class Test {
        /**
         * 根据种类查询商品
         */
        public static Observable<design.custom.ui.main.entity.Test> query_goods(String find) {
            return obFactory(NewApi.getInstance().getApiService().query_goods(find));
        }
    }

}
