package design.custom.ui.admin.adapter;

import android.support.annotation.Nullable;

import java.util.List;

import design.custom.ui.main.entity.DataEntity;
import design.root.base.base.BaseAdapter;
import design.root.base.databinding.FragmentDataItemBinding;

/**
 * Created by Administrator on 2018/2/7.
 */

public class DataFragmentAdapter extends BaseAdapter<DataEntity, FragmentDataItemBinding> {
    public DataFragmentAdapter(@Nullable List<DataEntity> data) {
        super(design.root.base.R.layout.fragment_data_item, data);
    }


    @Override
    protected void convert(FragmentDataItemBinding mViewBinding, DataEntity item, int position) {
        mViewBinding.tx.setText(item.getName());
    }
}
