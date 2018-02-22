package com.tzduan.base.ui.dialog;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;

import com.tzduan.base.R;
import com.tzduan.base.base.BaseActivity;
import com.tzduan.base.base.BaseDialog;
import com.tzduan.base.base.BasePresenter;
import com.tzduan.base.databinding.DialogLoadingBinding;


public class LoadingDialog extends BaseDialog<BasePresenter, DialogLoadingBinding> {
    //    Disposable disp;
    boolean isClose = true;

    @Override
    public int getLayoutId() {
        return R.layout.dialog_loading;
    }

    @Override
    protected boolean isEasy() {
        return true;
    }

    @Override
    public void initView() {
        this.setCancelable(false);
        this.getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == keyEvent.KEYCODE_BACK) {
                    toughDismiss();
                }
                return true;
            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().setBackgroundDrawableResource(R.color.all_transparent);
    }

    public void show(BaseActivity activity, boolean isClose) {
        super.show(activity);
    }

    @Override
    public void show(BaseActivity activity) {
        super.show(activity, 20);
    }

    public void show(BaseActivity activity, int s) {
        super.show(activity, s);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

}
