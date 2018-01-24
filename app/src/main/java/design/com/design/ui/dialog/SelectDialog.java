package design.com.design.ui.dialog;

import android.view.View;

import design.com.design.R;
import design.com.design.base.BaseDialog;
import design.com.design.base.BasePresenter;
import design.com.design.databinding.DialogSelectBinding;

/**
 * Created by Administrator on 2018/1/24.
 */

public class SelectDialog extends BaseDialog<BasePresenter, DialogSelectBinding> {
    String strContent;

    @Override
    public int getLayoutId() {
        return R.layout.dialog_select;
    }

    @Override
    public int getTitle() {
        return super.getTitle();
    }

    @Override
    public void onCancelClick(View view) {
        super.onCancelClick(view);
    }

    @Override
    public void onOkClick(View view) {
        this.dismiss();
        super.onOkClick(view);
    }

    public void setContent(String strContent) {
        this.strContent = strContent;
    }

    @Override
    public void initView() {
        mViewBinding.tvContent.setText(strContent);
    }

}
