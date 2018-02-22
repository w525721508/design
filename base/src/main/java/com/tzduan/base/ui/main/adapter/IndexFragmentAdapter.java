package com.tzduan.base.ui.main.adapter;

import android.support.annotation.Nullable;

import java.util.List;

import com.tzduan.base.R;
import com.tzduan.base.base.BaseAdapter;
import com.tzduan.base.databinding.FragmentSignItemBinding;

/**
 * Created by Administrator on 2018/2/7.
 */

public class IndexFragmentAdapter extends BaseAdapter<String, FragmentSignItemBinding> {
    public IndexFragmentAdapter(@Nullable List<String> data) {
        super(R.layout.fragment_sign_item, data);
    }


    @Override
    protected void convert(FragmentSignItemBinding mViewBinding, String item, int position) {
        mViewBinding.tx.setText(item);
    }
}
