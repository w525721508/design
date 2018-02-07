package design.root.base;

import android.databinding.ViewDataBinding;
import android.view.View;

import design.root.R;


/**
 * BaseViewHolder,集成了ViewDataBinding
 */
public class BaseViewHolder extends com.chad.library.adapter.base.BaseViewHolder {
    public ViewDataBinding mViewBinding;

    public BaseViewHolder(View view) {
        super(view);
        mViewBinding = (ViewDataBinding) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
    }
}
