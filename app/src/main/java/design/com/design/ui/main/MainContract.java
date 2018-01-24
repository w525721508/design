package design.com.design.ui.main;

import design.com.design.base.BaseModel;
import design.com.design.base.BasePresenter;
import design.com.design.base.BaseView;

/**
 * Created by Administrator on 2018/1/22.
 */

public interface MainContract {
    interface View extends BaseView {

    }

    abstract class Model extends BaseModel {

    }

    abstract class PreSenter extends BasePresenter<View, Model> {
        abstract void submit();
    }
}
