package design.custom.ui.admin.adapter;

import android.support.annotation.Nullable;

import java.util.List;

import design.root.base.base.BaseAdapter;
import design.root.base.databinding.FragmentSignItemBinding;
import design.root.base.entity.UserEntity;

/**
 * Created by Administrator on 2018/2/7.
 */

public class UserFragmentAdapter extends BaseAdapter<UserEntity, FragmentSignItemBinding> {
    public UserFragmentAdapter(@Nullable List<UserEntity> data) {
        super(design.root.base.R.layout.fragment_sign_item, data);
    }


    @Override
    protected void convert(FragmentSignItemBinding mViewBinding, UserEntity item, int position) {
        mViewBinding.tx.setText(item.getUsername());
    }
}
