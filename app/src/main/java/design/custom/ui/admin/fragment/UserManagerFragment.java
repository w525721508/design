package design.custom.ui.admin.fragment;


import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import design.custom.R;
import design.custom.databinding.FragmentUserBinding;
import design.custom.ui.admin.adapter.UserFragmentAdapter;
import design.custom.ui.main.MainPresenter;
import design.root.base.api.ApiFactory;
import design.root.base.base.BaseActivity;
import design.root.base.base.BaseFragment;
import design.root.base.entity.UserEntity;
import design.root.base.ui.dialog.LoadingDialog;
import design.root.base.ui.dialog.SelectDialog;
import design.root.base.util.OnClickListener;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/1/26.
 */

public class UserManagerFragment extends BaseFragment<MainPresenter, FragmentUserBinding> {
    UserFragmentAdapter userAdapter;
    LoadingDialog loadingDialog = new LoadingDialog();
    List<UserEntity> list;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    public void initView() {
        mViewBinding.ic.tvTitle.setText(getActivity().getResources().getString(R.string
                .menu_user));
        list = new ArrayList<>();
        userAdapter = new UserFragmentAdapter(list);
        mViewBinding.rlTest.setAdapter(userAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mViewBinding.rlTest.setLayoutManager(linearLayoutManager);
        mViewBinding.rlTest.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
        userAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        userAdapter.isFirstOnly(false);
        userAdapter.setOnItemClickListener((adapter, view, position) -> {
        });
        userAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SelectDialog selectDialog = new SelectDialog();
                selectDialog.setContent("确定删除？");
                selectDialog.setBtnName("删除", "取消");
                selectDialog.setClick(new OnClickListener() {
                    @Override
                    protected void myOnClickListener(View v) {
                        ToastUtils.showShort("删除用户");
                        UserEntity userEntity = list.get(position);
                        userEntity.toDeleteData();
                        ApiFactory.UserApi.superUser(userEntity).subscribe(new Consumer<Object>() {
                            @Override
                            public void accept(Object o) throws Exception {
                                refresh();
                            }
                        }, throwable -> {
                            ToastUtils.showLong("删除失败");
                        });


                        selectDialog.dismiss();
                    }
                }, new OnClickListener() {
                    @Override
                    protected void myOnClickListener(View v) {
                        selectDialog.dismiss();
                    }
                });
                selectDialog.show((BaseActivity) getActivity());
            }
        });
        refresh();
    }

    private void refresh() {
//        ApiFactory.UserApi.getUsers(Global.userEntity).subscribe
//                (new Consumer<UserEntity[]>() {
//                    @Override
//                    public void accept(UserEntity[] userEntities) throws Exception {
//                        list.clear();
//                        for (int i = 0; i < userEntities.length; i++) {
//                            list.add(userEntities[i]);
//                        }
//                        userAdapter.setNewData(list);
//                    }
//                }, throwable -> {
//
//                });
    }

}
