package design.custom.ui.main.fragment;


import android.view.View;

import com.blankj.utilcode.util.AppUtils;

import design.custom.R;
import design.custom.databinding.FragmentMyBinding;
import design.custom.ui.main.MainPresenter;
import design.root.base.base.BaseFragment;
import design.root.base.util.Global;
import design.root.base.util.OnClickListener;

/**
 * Created by Administrator on 2018/1/26.
 */

public class MyFragment extends BaseFragment<MainPresenter, FragmentMyBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    public void initView() {
        mViewBinding.ic.tvTitle.setText(getActivity().getResources().getText(R.string.menu_myself));
        mViewBinding.txUsername.setText(Global.userEntity.getUsername());
        mViewBinding.txEmail.setText(Global.userEntity.getEmail());
        mViewBinding.txSex.setText(Global.userEntity.getSex());
        mViewBinding.setOnClickListener(new OnClickListener() {
            @Override
            protected void myOnClickListener(View v) {
                switch (v.getId()) {
                    case R.id.tx_out: {
                        AppUtils.exitApp();
                    }
                    break;
                    default: {

                    }
                    break;
                }
            }
        });
    }
}
