package design.root.ui.dialog;

import android.view.View;

import design.root.R;
import design.root.base.BaseDialog;
import design.root.base.BasePresenter;
import design.root.databinding.DialogSelectBinding;


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
