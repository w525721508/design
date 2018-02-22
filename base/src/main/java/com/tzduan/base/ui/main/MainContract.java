package com.tzduan.base.ui.main;

import com.tzduan.base.base.BaseModel;
import com.tzduan.base.base.BasePresenter;
import com.tzduan.base.base.BaseView;

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
