package com.tzduan.base.ui.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tzduan.base.R;
import com.tzduan.base.util.FragmentHelper;

/**
 * Created by tzduan on 18/2/6.
 */

public class LoadingFragment extends DialogFragment {
    public final static String TAG = "LoadingFragment";

    private TextView mDlgContent;
    protected CharSequence mContentTxt = "";// 内容


    public boolean bIsBackable;// 是否back取消
    public boolean bIsSpaceable;// 是否空白取消
    public boolean bIsCancelable;

    public View.OnClickListener mSpaceClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (bIsSpaceable) {
                dismissSelf();
            }
        }
    };

    public static LoadingFragment newInstants(String contentText, boolean bIsBackable, boolean bIsSpaceable, boolean bIsCancelable){
        LoadingFragment fragment = new LoadingFragment();
        fragment.bIsBackable = bIsBackable;
        fragment.bIsSpaceable = bIsSpaceable;
        fragment.bIsCancelable = bIsCancelable;
        fragment.mContentTxt = contentText;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.ThemeHolo);
        setCancelable(bIsBackable);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layoutView = inflater.inflate(R.layout.dialog_loadings, container, false);
        layoutView.setOnClickListener(mSpaceClickListener);
        mDlgContent = layoutView.findViewById(R.id.tip);
        if (!TextUtils.isEmpty(mContentTxt.toString())) {
            mDlgContent.setText(mContentTxt);
        }

        View mDlgButton = layoutView.findViewById(R.id.btn_cancel);
        mDlgButton.setOnClickListener(v -> {
                dismissSelf();
        });
        if (!bIsCancelable) {
            mDlgButton.setVisibility(View.GONE);
        } else {
            mDlgButton.setVisibility(View.VISIBLE);
        }

        return layoutView;
    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        return show(transaction, tag, true);
    }

    public int show(FragmentTransaction transaction, String tag, boolean allowStateLoss) {
        transaction.add(this, tag);
        int mBackStackId = allowStateLoss ? transaction.commitAllowingStateLoss() : transaction.commit();
        return mBackStackId;
    }

    public void dismissSelf() {
        FragmentHelper.removeFragment(getFragmentManager(), this);
    }

    public void setContentText(String content) {
        this.mContentTxt = content;
        if (mDlgContent != null) {
            mDlgContent.setText(this.mContentTxt);
        }
    }
}
