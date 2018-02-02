package design.root.ui.main.fragment;


import com.blankj.utilcode.util.LogUtils;

import design.root.R;
import design.root.api.ApiFactory;
import design.root.base.BaseFragment;
import design.root.databinding.FragmentIndexBinding;
import design.root.entity.ApiDataEntity;
import design.root.ui.main.MainPresenter;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/1/26.
 */

public class IndexFragment extends BaseFragment<MainPresenter,
        FragmentIndexBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index;
    }

    @Override
    public void initView() {
//        ApiFactory.Test.getHotTop().subscribe(new Consumer<ApiDataEntity>() {
//            @Override
//            public void accept(ApiDataEntity apiData) throws Exception {
//                LogUtils.e("请求成功" + apiData.getData());
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                throwable.printStackTrace();
//                LogUtils.e(throwable);
//            }
//        });
    }
}
