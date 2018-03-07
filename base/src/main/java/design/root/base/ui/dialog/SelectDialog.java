package design.root.base.ui.dialog;

import android.view.View;

import design.root.base.R;
import design.root.base.base.BaseDialog;
import design.root.base.base.BasePresenter;
import design.root.base.databinding.DialogSelectBinding;
import design.root.base.util.OnClickListener;


/**
 * Created by Administrator on 2018/1/24.
 */

public class SelectDialog extends BaseDialog<BasePresenter, DialogSelectBinding> {
    String strContent;
    //自定义按钮点击事件
    private View.OnClickListener customOnClick;
    //确定按钮点击事件
    private View.OnClickListener okClick;

    @Override
    public int getLayoutId() {
        return R.layout.dialog_select;
    }

    @Override
    public int getTitle() {
        return super.getTitle();
    }

    @Override
    protected boolean isEasy() {
        return true;
    }

    public SelectDialog setContent(String strContent) {
        this.strContent = strContent;
        return this;
    }

    @Override
    public void initView() {
        mViewBinding.tvContent.setText(strContent);
        setBtn();
    }

    public SelectDialog setClick(OnClickListener okClick, OnClickListener customOnClick) {
        this.customOnClick = customOnClick;
        this.okClick = okClick;
        return this;
    }

    private void setBtn() {
        mViewBinding.btnCancel.setOnClickListener(customOnClick);
        mViewBinding.btnOk.setOnClickListener(okClick);
    }
}
